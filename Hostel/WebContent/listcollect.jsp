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
<title>我的收藏</title>
<%@include file="navbar.jspf" %>
<%@include file="navbarpersonal.jspf" %>
</head>
<body>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
<div class="panel-heading">
<h4><span class="glyphicon glyphicon-heart"></span> 我的收藏</h4>
</div>
<div class="panel-body">
    	<table class="table table-hover">
            <thead>
            <tr>
			<% for (int i=0; i<DBcollect.TITLES.length; i++){ %>
			<th><%=DBcollect.TITLES[i]%></th>
			<%} %>
			</tr>
            </thead>
            <tbody>
            <%
            	DBcollect db = new DBcollect();
				List<Hostel> collects = db.getAllCollect((String)session.getAttribute("user"));
				for (Hostel col: collects){
			%>
			<tr>
				<% for (int i=0; i<DBcollect.TITLES.length; i++){ %>
					<td><%=col.get(i)%></td>
				<% }%><td><a href="/Hostel/SetHostelServlet?PNO=<%=col.gethostel_id()%>">進入主頁</a></td>
				<td><a href="/Hostel/CancelCollectServlet?PNO=<%=col.gethostel_id()%>">取消收藏</a></td>
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