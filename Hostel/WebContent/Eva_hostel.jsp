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
<title>評價民宿</title>
<%@include file="navbar.jspf" %>
<%@include file="navbarpersonal.jspf" %>
</head>
<body>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
<div class="panel-heading">
<h4><span class="glyphicon glyphicon-star"></span> 評價民宿</h4>
</div>
<div class="panel-body">
    	<table class="table table-hover">
            <thead>
            <tr>
			<% for (int i=0; i<DBevaluate_hostel.TITLES.length; i++){ %>
			<th><%=DBevaluate_hostel.TITLES[i]%></th>
			<%} %>
			</tr>
            </thead>
            <tbody>
            <%
           		DBevaluate_hostel db = new DBevaluate_hostel();
            	DBorder db1 = new DBorder();
				List<Hostel> evahostel = db.getEvaHostel((String)session.getAttribute("user"));
				for (Hostel evahos: evahostel){
					boolean ischeck_in = db1.getcheckin(evahos.gethostel_name(),(String)session.getAttribute("user"));
			%>
			<tr>
				<% for (int i=0; i<DBevaluate_hostel.TITLES.length; i++){ 
					if(db.isEvaluateHostel(evahos.gethostel_name(),(String)session.getAttribute("user"))==false&&ischeck_in==true){%>
					<td><%=evahos.get(1)%></td>
				<td><a href="Evaluate_hostel.jsp?PNO=<%=evahos.gethostel_name()%>">評價</a></td>
			</tr>
			<%	}} }%>
            </tbody>
          </table>
   	</div>
   	</div>
   	</div>
   	</div>
<%@include file="footer.jspf" %>
</body>
</html>