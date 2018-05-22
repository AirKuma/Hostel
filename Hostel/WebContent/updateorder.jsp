<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.List" %>
<%@ page import="Hostel.*" %>   
<%@ page import="DBHostel.*" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jspf" %>
<title>選擇出租狀況</title>
<%@include file="navbar.jspf" %>
<%@include file="navbarpersonal.jspf" %>
</head>
<body>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
<div class="panel-heading">
<h4><span class="glyphicon glyphicon-home"></span> 出租狀況</h4>
</div>
<div class="panel-body">
    	<table class="table table-hover">
            <thead>
            <tr>
			<% for (int i=0; i<DBorder.TITLES2.length; i++){ %>
			<th><%=DBorder.TITLES2[i]%></th>
			<%} %>
			</tr>
            </thead>
            <tbody>
            <%
            	DBorder db = new DBorder();
				List<Order> orders = db.getAllOrderstatus(request.getParameter("PNO5"));
				session.setAttribute("hostelid",request.getParameter("PNO5"));
				for (Order or: orders){
			%>
			<tr>
					<td><%=or.get1(0)%></td>
					<td><%=or.get1(1)%></td>
					<td><%=or.get1(2)%></td>
					<td>
					<% if(or.getorder_paid()==true){
			 			out.println("已付款");
		     		}else{
		     			out.println("未付款");
		     		}%>
		    		</td>
		    		<td>
			 		<% if(or.getorder_check_in()==true){
			 			out.println("已入住");
		     		}else{
		     			out.println("未入住");
		     		}%>
		    		</td>
				<td><a href="updateorderstatus.jsp?PNO=<%=or.get1(0)%>">更新</a></td>
			</tr>
			<%	} %>
            </tbody>
          </table>
   	</div>
   	</div>
   	</div>
   	</div>
<%@include file="footer.jspf" %>
</body>
</html>