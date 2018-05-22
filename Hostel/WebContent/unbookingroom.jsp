<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.List" %>
<%@ page import="Hostel.*" %>
<%@ page import="DBHostel.*" %> 
<%@ page import="java.util.Calendar" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="header.jspf" %>
<title>空房預約</title>
<%@include file="navbar.jspf" %>
<%@include file="navbarhostel.jspf" %>
<head>
</head>
<%
String order_day = request.getParameter("order_day");
String begin_time = request.getParameter("begin_time");
if(order_day.equals("")||begin_time.equals(""))
	response.sendRedirect("order.jsp?error=2");
else{
int orderday = Integer.parseInt(order_day);
session.setAttribute("order_day",order_day);
session.setAttribute("begin_time",begin_time);

DBorder db1 = new DBorder();
	List<Integer> ids = db1.getOrderId();
	int i1 =0;
	for (Integer id: ids){
		session.setAttribute("order_group",Integer.toString(id+1));
		i1++;
	}
	if(i1==0)
		session.setAttribute("order_group","1");
%>
<body>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
<div class="panel-heading">
<h4><span class="glyphicon glyphicon-home"></span> 預約民宿</h4>
</div>
<div class="panel-body">
<form  name="myForm" action="OrderServlet" method="GET" class="smart-green">
選擇房間：
<%		
			int j = 0;
            DBRoom db = new DBRoom();
			List<Room> rooms = db.GetAllroom((String)session.getAttribute("hostel"));%>
			<select name="room">
			<% for (Room rom: rooms){
				boolean print = true;
				java.sql.Date orderdate=java.sql.Date.valueOf(begin_time);
				for(int i=0;i<orderday;i++){				
					if(db.isbooking(orderdate,rom.getroom_id())==true){
						print = false;
						break;
					}
					Calendar cal = Calendar.getInstance();
					cal.setTime(orderdate);
					cal.add(Calendar.DATE,1);
					orderdate = new java.sql.Date(cal.getTime().getTime()); 
				}
				if(print){
					%>
				    <option value="<%=rom.get(0)%>"><%=rom.get(1)%></option>
					<% 
					j++;
				}
			}
			if(j==0)
				response.sendRedirect("order.jsp?error=1");}
%></select></P>
<input type="submit" name="orderroom" value="訂房" class="btn-style">
</form>
</div>
</div>
</div>
</div>
</body>
</html>