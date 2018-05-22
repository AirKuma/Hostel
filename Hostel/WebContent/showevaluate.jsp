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
<title>查看民宿評價</title>
<%@include file="navbar.jspf" %>
<%@include file="navbarhostel.jspf" %>
</head>
<body>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
<div class="panel-heading">
<h4><span class="glyphicon glyphicon-star"></span> 民宿評價</h4>
</div>
<div class="panel-body"> 
    	<table class="table table-hover">
            <tbody>
            <%
            	double score =0;
           		DBevaluate_hostel db = new DBevaluate_hostel();
				List<Evaluate_hostel> evahostel = db.getEvaluateHostel((String)session.getAttribute("hostel_name"));
				for (Evaluate_hostel evahos: evahostel){
			%>
			<tr>
				<% for (int i=1; i<=5; i++){
					out.println(DBevaluate_hostel.TITLES2[i]+"：");
					if(Math.round((double)evahos.get(i)*10)/10.0<1.5){%>
					<img src="img/1star.gif"><% }
					else if(Math.round((double)evahos.get(i)*10)/10.0<2){%>
					<img src="img/15star.gif"><% }
					else if(Math.round((double)evahos.get(i)*10)/10.0<2.5){%>
					<img src="img/2star.gif"><% }
					else if(Math.round((double)evahos.get(i)*10)/10.0<3){%>
					<img src="img/25star.gif"><% }
					else if(Math.round((double)evahos.get(i)*10)/10.0<3.5){%>
					<img src="img/3star.gif"><% }
					else if(Math.round((double)evahos.get(i)*10)/10.0<4){%>
					<img src="img/35star.gif"><% }
					else if(Math.round((double)evahos.get(i)*10)/10.0<4.5){%>
					<img src="img/4star.gif"><% }
					else if(Math.round((double)evahos.get(i)*10)/10.0<5){%>
					<img src="img/45star.gif"><% }
					else if(Math.round((double)evahos.get(i)*10)/10.0==5){%>
					<img src="img/5star.gif"><% }
					out.println(" "+Math.round((double)evahos.get(i)*10)/10.0+"分");%></p><%
					score += Math.round((double)evahos.get(i)*10)/10.0;}%>
				<%  } %>
			</tr>
			<tr>
			<% out.println("總體評價： ");
			if(score/5.0<1.5){%>
					<img src="img/1star.gif"><% }
					else if(score/5.0<2){%>
					<img src="img/15star.gif"><% }
					else if(score/5.0<2.5){%>
					<img src="img/2star.gif"><% }
					else if(score/5.0<3){%>
					<img src="img/25star.gif"><% }
					else if(score/5.0<3.5){%>
					<img src="img/3star.gif"><% }
					else if(score/5.0<4){%>
					<img src="img/35star.gif"><% }
					else if(score/5.0<4.5){%>
					<img src="img/4star.gif"><% }
					else if(score/5.0<5){%>
					<img src="img/45star.gif"><% }
					else if(score/5.0==5){%>
					<img src="img/5star.gif"><% }
					out.println(" "+score/5.0+"分");%>
			</tr>
            </tbody>
            </table>
            <legend>各遊客對民宿之評價</legend> 
            <table class="table table-hover">
            <thead>
            <tr>
			<% for (int i=0; i<DBevaluate_hostel.TITLES3.length; i++){ %>
			<th><%=DBevaluate_hostel.TITLES3[i]%></th>
			<%} %>
			</tr>
            </thead>
            <tbody>
            <%
           		DBevaluate_hostel db1 = new DBevaluate_hostel();
				List<Evaluate_hostel> evahostel1 = db1.getAllEvaluateHostel((String)session.getAttribute("hostel_name"));
				for (Evaluate_hostel allevahos: evahostel1){
			%>
			<tr>
				<% for (int i=0; i<DBevaluate_hostel.TITLES3.length; i++){%>
				     <td><%=allevahos.get(i)%></td>
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