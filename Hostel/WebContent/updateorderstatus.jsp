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
<title>更新出租狀況</title>
<%@include file="navbar.jspf" %>
<%@include file="navbarpersonal.jspf" %>
</head>
<body>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
<div class="panel-heading">
<h4><span class="glyphicon glyphicon-home"></span> 更新出租狀況</h4>
</div>
<div class="panel-body">
<form action="UpdateOrderServlet" method="GET" class="smart-green">
<table class="table table-hover">
	<% for (int i=0; i<DBorder.TITLES2.length; i++){ %>
			<th><%=DBorder.TITLES2[i]%></th>
			<%} %>
			</tr>
            </thead>
            <tbody>
            <%
            	DBorder db = new DBorder();
				List<Order> orders = db.getAllOrderstatus2((String)session.getAttribute("hostelid"),request.getParameter("PNO"));
				session.setAttribute("ordergroupid",request.getParameter("PNO"));
				for (Order or: orders){
			%>
			<tr>
					<td><%=or.get1(0)%></td>
					<td><%=or.get1(1)%></td>
					<td><%=or.get1(2)%></td>
					<td>
					<% if(or.getorder_paid()==true){%>
			 			<input type="radio" name="paid" value="true" checked/> 已付款
		     			<input type="radio" name="paid" value="false" /> 未付款
		     		<% }else{%>
		     			<input type="radio" name="paid" value="true"/> 已付款
		    		 	<input type="radio" name="paid" value="false" checked/> 未付款
		     		<% }%>
		    		</td>
		    		<td>
			 		<% if(or.getorder_check_in()==true){%>
			 			<input type="radio" name="check" value="true" checked/> 已入住
		     			<input type="radio" name="check" value="false" /> 未入住
		     		<% }else{%>
		     			<input type="radio" name="check" value="true"/> 已入住
		    		 	<input type="radio" name="check" value="false" checked/> 未入住
		     		<% }%>
		    		</td>
				<td><input type="submit" name="updateorder" value="更新" class="btn-style"></td>
			</tr>
			<%	} %>
            </tbody>
          </table>
</form>
</div>
</div>
</div>
</div>
<%@include file="footer.jspf" %>
</body>
</html>