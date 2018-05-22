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
<title>訊息通知</title>
<%@include file="navbar.jspf" %>
<%@include file="navbarpersonal.jspf" %>
</head>
<body>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
<div class="panel-heading">
<h4><span class="glyphicon glyphicon-envelope"></span> 訊息通知</h4>
</div>
<div class="panel-body">
    	<table class="table table-hover">
            <thead>
            <tr>
			<% for (int i=0; i<DBmessage.TITLES.length; i++){ %>
			<th><%=DBmessage.TITLES[i]%></th>
			<%} %>
			</tr>
            </thead>
            <tbody>
            <%
            	DBmessage db = new DBmessage();
				List<Message> messages = db.getAllMessage((String)session.getAttribute("user"));
				for (Message mes: messages){
			%>
			<tr>
				<% for (int i=0; i<DBmessage.TITLES.length; i++){ %>
					<td><%=mes.get(i)%></td>
				<%  } %>
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