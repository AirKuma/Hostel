<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jspf" %>
<title>會員登入</title>
<%@include file="navbar.jspf" %>
</head>

<body>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
<div class="panel-heading">
<h4><span class="glyphicon glyphicon-user"></span> 會員登入</h4>
</div>
<div class="panel-body">
<form action="LoginServlet" method="GET" class="smart-green">
		<table width="250" height="70">
			<tr>
				<td>Email</td>
				<td><input type="text" name="user_email"></td>
			</tr>
			<tr>
			    <td>密碼 </td>
				<td><input type="password" name="user_password"></td>
		    </tr>
		</table>
<br />
<input type="submit" name="login" value="登入" class="btn-style">
</form>
<% 
if(session.getAttribute("login")!=null){
  	if("Invalid login".equalsIgnoreCase((String)session.getAttribute("error"))){ %>
<h6> Invalid login. Please try again.</h6>
  	<%}else if("無效會員".equalsIgnoreCase((String)session.getAttribute("error"))){%>
  	<h6>無效會員，無法使用此帳號</h6>
  	<%}session.removeAttribute("login"); } %>
</div>
</div>
</div>
</div>
<%@include file="footer.jspf" %>
</body>
</html>