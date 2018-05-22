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
<title>我的民宿</title>
<%@include file="navbar.jspf" %>
<%@include file="navbarpersonal.jspf" %>
</head>
<body>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
<div class="panel-heading">
<h4><span class="glyphicon glyphicon-home"></span> 我的民宿</h4>
</div>
<div class="panel-body">
    	<table class="table table-hover">
            <thead>
            <tr>
			<% for (int i=0; i<2; i++){ %>
			<th><%=DBhostel.TITLES[i]%></th>
			<%} %>
			</tr>
            </thead>
            <tbody>
            <%
            	DBhostel db = new DBhostel();
				List<Hostel> myhostels = db.getMyHostel((String)session.getAttribute("user"));
				for (Hostel hos: myhostels){
			%>
			<tr>
				<% for (int i=0; i<2; i++){ %>
					<td><%=hos.get(i)%></td>
				<% }%>
				<td><a href="createroom.jsp?PNO1=<%=hos.gethostel_id()%>">新增房間</a></td>
				<td><a href="/Hostel/UpdateHostelServlet?PNO=<%=hos.gethostel_id()%>">修改民宿資料</a></td>
				<td><a href="updateorder.jsp?PNO5=<%=hos.gethostel_id()%>">更新出租狀況</a></td>
				<td><a href="customerdata.jsp?PNO6=<%=hos.gethostel_id()%>">遊客預約民宿</a></td>
				<td><a href="cusorderlist.jsp?PNO7=<%=hos.gethostel_id()%>">遊客預約清單</a></td>
				<td><a href="listmyhosteleva.jsp?PNO2=<%=hos.gethostel_name()%>">查看民宿評價</a></td>
				<td><a href="listmycuseva.jsp?PNO3=<%=hos.gethostel_name()%>">查看客戶評價</a></td>
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