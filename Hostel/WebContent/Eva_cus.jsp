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
<title>評價客戶</title>
<%@include file="navbar.jspf" %>
<%@include file="navbarpersonal.jspf" %>
</head>
<body>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
<div class="panel-heading">
<h4><span class="glyphicon glyphicon-star"></span> 評價客戶</h4>
</div>
<div class="panel-body">
    	<table class="table table-hover">
            <thead>
            <tr>
			<% for (int i=0; i<DBevaluate_cus.TITLES.length; i++){ %>
			<th><%=DBevaluate_cus.TITLES[i]%></th>
			<%} %>
			</tr>
            </thead>
            <tbody>
            <%
           		DBevaluate_cus db = new DBevaluate_cus();
            	DBorder db1 = new DBorder();
            	DBlogin db2 = new DBlogin();
            	List<Hostel> evacustomer = db.getEvaCus((String)session.getAttribute("user"));
				for (Hostel evacus: evacustomer){
				boolean ischeck_in = db1.getcheckin(evacus.gethostel_name(),evacus.getuser_email());
				String pass = db2.getpassword(evacus.getuser_email());
			%>
			<tr>
				<% if(db.isEvaluateCus(evacus.gethostel_name(),evacus.getuser_email())==false&&ischeck_in==true&&pass.equals("cfcd208495d565ef66e7dff9f98764da")!=true){
					for (int i=0; i<DBevaluate_cus.TITLES.length; i++){ %>
					<td><%=evacus.get1(i)%></td>
				<%  } %><td><a href="Evaluate_cus.jsp?PNO=<%=evacus.gethostel_name()%>&PNO2=<%=evacus.getuser_email()%>">評價</a></td>
			</tr>
			<%	} }%>
            </tbody>
          </table>
   	</div>
   	</div>
   	</div>
   	</div>
<%@include file="footer.jspf" %>
</body>
</html>