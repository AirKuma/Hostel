<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jspf" %>
<title>通知顧客</title>
<%@include file="navbar.jspf" %>
</head>
<body>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
<div class="panel-heading">
<h4><span class="glyphicon glyphicon-comment"></span> 站內通訊</h4>
</div>
<div class="panel-body">
<form action="SendMessageServlet" method="GET">
 收信者：<input type="text" name="recever" placeholder=" 收信者" /><p><br>
  主旨：<input type="text" name="subject" placeholder=" 主旨" /><p><br>
 內文：<p>
  <textarea name="context" cols="70" rows="8"></textarea><br /></p>
<input type="submit" name="buttom" value="送出" class="btn-style" />
<input type="reset" value="重寫" class="btn-style"/>
</form>
</div>
</div>
</div>
</div>
<%@include file="footer.jspf" %>
</body>
</html>