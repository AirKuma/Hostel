<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jspf" %>
<title>新增房間</title>
<%@include file="navbar.jspf" %>
<%@include file="navbarpersonal.jspf" %>
</head>

<body>
<%
if(session.getAttribute("createroom")==null)
	session.setAttribute("hostel",request.getParameter("PNO1"));
%>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
<div class="panel-heading">
<h4><span class="glyphicon glyphicon-home"></span> 新增房間</h4>
</div>
<div class="panel-body">
<form   action="CreateRoomServlet" method="GET" class="smart-green">
		<table  width="480" height="320">		
		<tr>
		    <td>房間名稱</td>
            <td><input type="text" name="room_name"></td>
		</tr>
				<tr>
		    <td>房間人數</td>
            <td><input type="text" name="room_peoplenum"></td>
		</tr>
		<tr>
		    <td>平日價</td>
		     <td><input type="text" name="room_weekdayprice"></td>
		</tr>
		<tr>
		    <td>節假日價</td>
		    <td> <input type="text" name="room_holidayprice"></td>
		</tr>
		<tr>
		    <td>房間簡介</td>
		    <td> <textarea name="room_describe" cols="50" rows="5"></textarea></td>
		</tr>
		<tr>
		    <td>圖片網址</td>
		    <td> <input type="text" name="room_img" size="49"></td>
		</tr>
		</table>
<br />
<input type="submit" name="createroom" value="確認" class="btn-style">
</form>
<% 
if(session.getAttribute("createroom")!=null){
  	if("房間資料尚未填寫完成".equalsIgnoreCase((String)session.getAttribute("error"))){
  		out.println("</p><br>"+"房間資料尚未填寫完成");
  	}else if("房間人數或價格非數值".equalsIgnoreCase((String)session.getAttribute("error"))){
  			out.println("</p><br>"+"房間人數或價格非數值");
  	}session.removeAttribute("createroom");  
  	}%>
</div>
</div>
</div>
</div>
<%@include file="footer.jspf" %>
</body>
</html>