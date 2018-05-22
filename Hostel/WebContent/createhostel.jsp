<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jspf" %>
<title>新增民宿</title>
<%@include file="navbar.jspf" %>
</head>

<body>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
<div class="panel-heading">
<h4><span class="glyphicon glyphicon-home"></span> 新增民宿</h4>
</div>
<div class="panel-body">
<form action="CreateHostelServlet" method="GET" class="smart-green">
		<table  width="480" height="450">
		<tr>
		    <td>民宿名稱</td>
            <td><input type="text" name="hostel_name"></td>
		</tr>
		<tr>
		    <td>民宿電話</td>
		     <td><input type="text" name="hostel_phone"></td>
		</tr>
		<tr>
		    <td>民宿地址</td>
		    <td> <input type="text" name="hostel_address" size="49"></td>
		</tr>
		<tr>
		    <td>提供之服務</td>
		    <td> <textarea name="hostel_server"  cols="50" rows="5"></textarea></td>
		</tr>
		<tr>
		    <td>付款方式</td>
		    <td> <textarea name="hostel_payway" cols="50" rows="5"></textarea></td>
		</tr>
		<tr>
		    <td>訂金比率(小數)</td>
		    <td> <input type="text" name="hostel_deposit"></td>
		</tr>
		<tr>
		    <td>圖片網址</td>
		    <td> <input type="text" name="hostel_img" size="49"></td>
		</tr>
		</table>

<br />
<input type="submit" name="createhostel" value="確認" class="btn-style">
</form>
<% 
if(session.getAttribute("createhostel")!=null){
  	if("民宿已存在".equalsIgnoreCase((String)session.getAttribute("error"))){
  		out.println("</p><br>"+"民宿已存在");
  	}else if("民宿資料尚未填寫完成".equalsIgnoreCase((String)session.getAttribute("error"))){
  			out.println("</p><br>"+"民宿資料尚未填寫完成");
  	}else if("訂金比例錯誤".equalsIgnoreCase((String)session.getAttribute("error"))){
  	  			out.println("</p><br>"+"訂金比例錯誤");		
  		} session.removeAttribute("createhostel");  
  	}%>
</div>
</div>
</div>
</div>
<%@include file="footer.jspf" %>
</body>
</html>