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
<title>房間</title>
<%@include file="navbar.jspf" %>
<%@include file="navbarhostel.jspf" %>
</head>
<body>
<%
        DBhostel db = new DBhostel();
		List<Hostel> hostels = db.getHostel((String)session.getAttribute("hostel"));
		for (Hostel hos: hostels){	
%>
<div class="container theme-showcase" role="main" >
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
              <div class="panel-heading">
                   <form action="CollectServlet" method="GET" class="smart-green">
                   <h4><span class="glyphicon glyphicon-home"></span> <%=hos.get(1)%>
                   <div style="float:right">
                   <%} %></div>
				   </form></h4>
              </div>  
              <div class="panel-body">
              <table class="table table-hover">
            <thead>
            <tr>
			<% for (int i=0; i<DBRoom.TITLES.length; i++){ %>
			<th><%=DBRoom.TITLES[i]%></th>
			<%} %>
			</tr>
            </thead>
            <tbody>
            <%
            	DBRoom db1 = new DBRoom();
				List<Room> room = db1.GetAllroom((String)session.getAttribute("hostel"));
				for (Room rom: room){
			%>
			<tr>	
					<td><%=rom.get(1)%></td>
					<td><img src="<%=rom.get(2)%>" style="width:300px;height:200px;"></td>
					<td><%=rom.get(3)%></td>
					<td><%=rom.get(4)%></td>
					<td><%=rom.get(5)%></td>
					<td><%=rom.get(6)%></td>
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