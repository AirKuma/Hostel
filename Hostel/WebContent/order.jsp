<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.List" %>
<%@ page import="Hostel.*" %>
<%@ page import="DBHostel.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="header.jspf" %>
<title>預約民宿</title>
<%@include file="navbar.jspf" %>
<%@include file="navbarhostel.jspf" %>
</head>
<body>
<%
	if(request.getParameter("cus")!=null){
		DBregister db = new DBregister();
		if(request.getParameter("cus_email").equals("")||db.isInvalidUseremail("GUEST_"+request.getParameter("cus_email"))!=true)
			response.sendRedirect("customerdata.jsp");
		else 
			session.setAttribute("customerorder","GUEST_"+request.getParameter("cus_email"));
	}	
	else	
   		session.setAttribute("customerorder",request.getParameter("PNO"));
%>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
<form  name="myForm" action="unbookingroom.jsp" method="GET" class="smart-green">
<div class="panel-heading">
<h4><span class="glyphicon glyphicon-home"></span> 預約民宿</h4>
</div>
<div class="panel-body">
		<table  width="300" height="150">
		<tr>
		<td>訂房起始日期：</td>
		<td><input type="date" name="begin_time"  /></td>
		</tr>
		<tr>  
		<td>訂房天數：</td>
		<td><input type="number" name="order_day" placeholder="0"/></td>
		</tr>
		</table>
<br />
<input type="submit" name="searchroom" value="查詢空房" class="btn-style">
</form>
<%if(request.getParameter("error")!=null){
			if(request.getParameter("error").equals("1"))
				out.println("</p><br>"+"查無空房");
			else if(request.getParameter("error").equals("2"))
				out.println("</p><br>"+"尚未選擇訂房日期或訂房天數");
			}%>
</div>
</div>
</div>
</div>
<%@include file="footer.jspf" %>
</body>
</html>