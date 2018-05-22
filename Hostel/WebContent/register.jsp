<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jspf" %>
<title>會員註冊</title>
<%@include file="navbar.jspf" %>
</head>
<body>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
<div class="panel-heading">
<h4><span class="glyphicon glyphicon-user"></span> 會員註冊</h4>
</div>
<div class="panel-body">
<form   action="RegisterServlet" method="GET" class="smart-green"> 
		<table width="250" height="350">
		<tr>
			<td>Email</td>
            <td><input type="text" name="user_email"></td>
		</tr>
		<tr>
		    <td>密碼 </td>
		    <td><input type="password" name="user_password"></td>
		</tr>
		<tr>
		    <td>確認密碼 </td>
		    <td><input type="password" name="reuser_password"></td>
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
<input type="submit" name="register" value="註冊" class="btn-style">
</form>
<% 
if(session.getAttribute("register")!=null){
  	if("資料未填寫完成".equalsIgnoreCase((String)session.getAttribute("error"))){	%>
<h6> 資料未填寫完成</h6>
	<%}else if("密碼不能為零".equalsIgnoreCase((String)session.getAttribute("error"))){%>
  		<h6> 密碼不能為零</h6>
	<%}else if("確認密碼錯誤".equalsIgnoreCase((String)session.getAttribute("error"))){%>
  		<h6> 確認密碼錯誤</h6>
  	<%}else if("E-mail已存在".equalsIgnoreCase((String)session.getAttribute("error"))){%>
  		<h6> E-mail已存在</h6>
  	<%}else if("E-mail格式不符".equalsIgnoreCase((String)session.getAttribute("error"))){%>
  		<h6> E-mail格式不符</h6>
  	<% }session.removeAttribute("register");
  	session.removeAttribute("error");} %>
</div>
</div>
</div>
</div>
<%@include file="footer.jspf" %>
</body>
</html>