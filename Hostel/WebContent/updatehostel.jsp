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
<title>修改民宿</title>
<%@include file="navbar.jspf" %>
<%@include file="navbarpersonal.jspf" %>
</head>

<body>
<%
        DBhostel db = new DBhostel();
		List<Hostel> hostels = db.getHostel((String)session.getAttribute("hostel"));
		for (Hostel hos: hostels){	
%>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
<div class="panel-heading">
<h4><span class="glyphicon glyphicon-home"></span> 修改民宿</h4>
</div>
<div class="panel-body">
<form action="UpdateHostelServlet" method="GET" class="smart-green">  
		<table  width="480" height="450">
		<tr>
		    <td>民宿名稱</td>
            <td><%=hos.get(1)%></td>
		</tr>
		<tr>
		    <td>民宿電話</td>
		     <td><input type="text" name="hostel_phone" value=<%=hos.get(3)%>></td>
		</tr>
		<tr>
		    <td>民宿地址</td>
		    <td><%=hos.get(2)%></td>
		</tr>
		<tr>
		    <td>提供之服務</td>
		    <td> <textarea name="hostel_server"  cols="50" rows="5"><%=hos.get(4)%></textarea></td>
		</tr>
	    <tr>
		    <td>付款方式</td>
		    <td> <textarea name="hostel_payway"  cols="50" rows="5"><%=hos.get(5)%></textarea></td>
		</tr>
		<tr>
		    <td>訂金比率(小數)</td>
		    <td> <input type="text" name="hostel_deposit" value=<%=Double.parseDouble(hos.gethostel_deposit())%>></td>
		</tr>
		<tr>
		    <td>圖片網址</td>
		    <td> <input type="text" name="hostel_img" value=<%=hos.get(7)%> size="49"></td>
		</tr>
	    <%} %>
		</table>

<br />
<input type="submit" name="updatehostel" value="修改" class="btn-style">
</form>
<% 
if(session.getAttribute("updatehostel")!=null){
	if("民宿資料尚未填寫完成".equalsIgnoreCase((String)session.getAttribute("error"))){
  			out.println("</p><br>"+"民宿資料尚未填寫完成");
  	}else if("訂金比例錯誤".equalsIgnoreCase((String)session.getAttribute("error"))){
  	  			out.println("</p><br>"+"訂金比例錯誤");		
  		}session.removeAttribute("updatehostel");  
  	}%>
</div>
</div>
</div>
</div>
<%@include file="footer.jspf" %>
</body>
</html>