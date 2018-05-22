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
<title>預約清單</title>
<%@include file="navbar.jspf" %>
<%@include file="navbarpersonal.jspf" %>
</head>
<body>
<%
session.setAttribute("cus",1);
%>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
<div class="panel-heading">
<h4><span class="glyphicon glyphicon-list-alt"></span> 遊客預約清單</h4>
</div>
<div class="panel-body">
    	<table class="table table-hover">
            <thead>
            <tr>
			<% for (int i=0; i<DBorder.TITLES3.length; i++){ %>
			<th><%=DBorder.TITLES3[i]%></th>
			<%} %>
			</tr>
            </thead>
            <tbody>
            <%
            	DBorder db = new DBorder();
				List<Order> orders = db.getAllCusOrder(request.getParameter("PNO7"));
				for (Order or: orders){
			%>
			<tr>
				<% for (int i=1; i<4; i++){ %>
					<td><%=or.get(i)%></td>
				<% }%>
				<td><%=or.getowner()%></td>
				<td><a href="/Hostel/CancelOrderServlet?PNO=<%=or.getorder_group_id()%>&PNO2=<%=or.get(0)%>&PNO3=<%=or.getowner()%>&PNO4=<%=or.get(3)%>&PNO5=<%=or.get(1)%>&PNO6=<%=or.get(2)%>">取消預約</a></td>
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