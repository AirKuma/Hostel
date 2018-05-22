<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jspf" %>
<title>遊客資料</title>
<%@include file="navbar.jspf" %>
<%@include file="navbarpersonal.jspf" %>
</head>
<body>
<%
session.setAttribute("hostel",request.getParameter("PNO6"));
%>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
     <div class="panel panel-default panel-transparent">
        <div class="panel-heading">
<h4><span class="glyphicon glyphicon-user"></span> 遊客資料</h4> 
</div>
<div class="panel-body">
<div class="tabbable"> 
  <ul class="nav nav-tabs">
    <li class="active"><a href="#tab1" data-toggle="tab">未有遊客資料</a></li>
    <li><a href="#tab2" data-toggle="tab">已有遊客資料</a></li>
  </ul>
  <div class="tab-content">
    <div class="tab-pane active" id="tab1">
      	<form action="RegisterServlet" method="GET" class="smart-green">
      	<table width="250" height="350">
		<tr>
			<td>Email</td>
            <td><input type="text" name="user_email"></td>
		</tr>
		<tr>
		    <td>真實姓名</td>
            <td><input type="text" name="user_name"></td>
		</tr>
		<tr>
		    <td>性別</td>
		    <td>
			 <input type="radio" name="user_gender" value="male"/>  男
		     <input type="radio" name="user_gender" value="female" /> 女
		    </td>
		</tr>
		<tr>
		    <td>出生日期</td>
		    <td><input type="date" name="user_birthday"></td>
		</tr>
		<tr>
			 <td>電話</td>
			<td><input type="text" name="user_phone"></td>
		</tr>
		<tr>
			<td>地址</td>
			<td><input type="text" name="user_address"></td>
		</tr>
		<tr>
		  <td>身份證號</td>
		  <td><input type="text" name="user_IDnumber"></td>
		</tr>
		<tr>
			<td>國籍</td>
			<td><input type="text" name="user_nationality"></td>
		</tr>
		<tr>
			<td>護照號碼</td>
			<td><input type="text" name="user_passport"></td>
		</tr>

		</table>

<br />
<input type="submit" name="customer" value="完成" class="btn-style">
</form>
<% 
if(session.getAttribute("customer")!=null){
  	if("資料未填寫完成".equalsIgnoreCase((String)session.getAttribute("error"))){	%>
<h6> 資料未填寫完成</h6>
	<%}else if("E-mail已存在".equalsIgnoreCase((String)session.getAttribute("error"))){%>
  		<h6> E-mail已存在</h6>
  	<%}else if("E-mail格式不符".equalsIgnoreCase((String)session.getAttribute("error"))){%>
  		<h6> E-mail格式不符</h6>
  	<% }session.removeAttribute("customer");
  	session.removeAttribute("error");} %>
</div> 
 <div class="tab-pane" id="tab2">
    <form action="order.jsp" method="GET" class="smart-green">
      	<table width="300" height="80">
      	<tr>
			<td>遊客Email</td>
            <td><input type="text" name="cus_email"></td>
		</tr>
    	</table> 
    	<input type="submit" name="cus" value="完成" class="btn-style">
	</form> 	
</div>
</div>
</div>
</div>
</div>
</div>
</div>
<%@include file="footer.jspf" %>
</body>
</html>