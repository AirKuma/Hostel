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
<title>預約資訊</title>
<%@include file="navbar.jspf" %>
<%@include file="navbarpersonal.jspf" %>
</head>
<body>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
<div class="panel-heading">
<h4><span class="glyphicon glyphicon-list-alt"></span> 預約資訊</h4>
</div>
<div class="panel-body">
<form  name="myForm" action="orderlist.jsp" method="GET" class="smart-green">
<%
	DBhostel db1 = new DBhostel();
	String deposit = db1.getHostelDeposit((String)session.getAttribute("hostel"));
	double depositratio = Double.parseDouble(deposit); 
	String price = request.getParameter("PNO");
	String roomid = request.getParameter("PNO2");
	int room_id = Integer.parseInt(roomid);
	int price1 = Integer.parseInt(price);
	DBRoom db = new DBRoom();
	List<Room> room = db.Getthisroom(room_id);%>
	<table width="200" height="300">
	<%for (Room rom: room){
		out.println("<tr><td>房間民稱：</td><td>"+rom.getroom_name()+"</td></tr></p>");
		out.println("<tr><td>房間人數：</td><td>"+rom.getroom_peoplenum()+"</td></tr></p>");
	}
	out.println("<tr><td>訂房日期：</td><td>"+(String)session.getAttribute("begin_time")+"</td></tr></p>");
	out.println("<tr><td>訂房天數：</td><td>"+(String)session.getAttribute("order_day")+"</td></tr></p>");
	out.println("<tr><td>總共價格：</td><td>"+price+"</td></tr></p>");
	out.println("<tr><td>訂金：</td><td>"+Math.round(price1*depositratio)+"</td></tr></p>");
%>
</table>
<input type="submit" name="orderdata" value="確定" class="btn-style">
</form>
</div>
</div>
</div>
</div>
<%@include file="footer.jspf" %>
</body>
</html>