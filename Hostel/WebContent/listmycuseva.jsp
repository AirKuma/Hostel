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
<title>查看客戶評價</title>
<%@include file="navbar.jspf" %>
<%@include file="navbarpersonal.jspf" %>
</head>
<body>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
<div class="panel-heading">
<h4><span class="glyphicon glyphicon-star"></span> 客戶評價</h4>
</div>
<div class="panel-body">
    	<table class="table table-hover">
    	<thead>
            <tr>
			<% for (int i=0; i<DBevaluate_cus.TITLES2.length; i++){ %>
			<th><%=DBevaluate_cus.TITLES2[i]%></th>
			<%} %>
			</tr>
            </thead>
            <tbody>
            <%
           		DBevaluate_cus db = new DBevaluate_cus();
				List<Evaluate_cus> evacus = db.getAllEvaluateCus(request.getParameter("PNO3"));
				for (Evaluate_cus allevacus: evacus){
			%>
			<tr>
				<% for (int i=0; i<DBevaluate_cus.TITLES2.length; i++){%>
				     <td><%=allevacus.get(i)%></td>
				<%  } }%>
			</tr>
            </tbody>
          </table>
   	</div>
   	</div>
   	</div>
   	</div>
<%@include file="footer.jspf" %>

</body>
</html>