<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jspf" %>
<title>評價民宿</title>
<%@include file="navbar.jspf" %>
<%@include file="navbarpersonal.jspf" %>
</head>
<body>
<%
if(session.getAttribute("eva_hostel")==null)
	session.setAttribute("hostel_name",request.getParameter("PNO"));
%>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
<div class="panel-heading">
<h4><span class="glyphicon glyphicon-star"></span> 民宿評價</h4>
</div>
<div class="panel-body">
<form action="Evaluate_hostelServlet" method="GET" class="smart-green">
<table width="700" height="200" bgcolor="F5FCEE">
<tr align="center">
    <td width="100" bgcolor="#EEFCEE">分數</td>
    <td><img src="img/1star.gif"></td>
    <td><img src="img/2star.gif"></td>
    <td><img src="img/3star.gif"></td>
    <td><img src="img/4star.gif"></td>
    <td><img src="img/5star.gif"></td>
   </tr> 
  <tr align="center">
    <td bgcolor="#EEFCEE">服務</td>
    <td><input type="radio" name="eva_hostel_server" value="1"/>很差</td >
    <td><input type="radio" name="eva_hostel_server" value="2" />差</td>
    <td><input type="radio" name="eva_hostel_server" value="3" />普通</td>
    <td><input type="radio" name="eva_hostel_server" value="4"/>好</td>
    <td><input type="radio" name="eva_hostel_server" value="5"/>很好</td>
  </tr>
   <tr align="center">
    <td bgcolor="EEFCEE">位置</td>
    <td><input type="radio" name="eva_hostel_location" value="1"/>很差</td >
    <td><input type="radio" name="eva_hostel_location" value="2" />差 </td>
    <td><input type="radio" name="eva_hostel_location" value="3" />普通 </td>
    <td><input type="radio" name="eva_hostel_location" value="4" />好 </td>
    <td><input type="radio" name="eva_hostel_location" value="5" />很好 </td>
  </tr>
  <tr align="center">
    <td bgcolor="EEFCEE">環境</td>
    <td><input type="radio" name="eva_hostel_environment" value="1"/>很差</td >
    <td><input type="radio" name="eva_hostel_environment" value="2" />差 </td>
    <td><input type="radio" name="eva_hostel_environment" value="3" />普通 </td>
    <td><input type="radio" name="eva_hostel_environment" value="4" />好 </td>
    <td><input type="radio" name="eva_hostel_environment" value="5" />很好 </td>
  </tr>
 <tr align="center">
     <td bgcolor="EEFCEE">餐飲</td>
    <td><input type="radio" name="eva_hostel_food" value="1"/>很差</td >
    <td><input type="radio" name="eva_hostel_food" value="2" />差 </td>
    <td><input type="radio" name="eva_hostel_food" value="3" />普通 </td>
    <td><input type="radio" name="eva_hostel_food" value="4" />好 </td>
    <td><input type="radio" name="eva_hostel_food" value="5" />很好 </td>
  </tr>
  <tr align="center">
     <td bgcolor="EEFCEE">設施</td>
    <td><input type="radio" name="eva_hostel_facility" value="1"/>很差</td >
    <td><input type="radio" name="eva_hostel_facility" value="2" />差 </td>
    <td><input type="radio" name="eva_hostel_facility" value="3" />普通 </td>
    <td><input type="radio" name="eva_hostel_facility" value="4" />好 </td>
    <td><input type="radio" name="eva_hostel_facility" value="5" />很好 </td>
  </tr>
</table>
<br />
<h4>意見回饋</h4></P>
 <textarea name="eva_hostel_feedback" id="textarea" cols="96" rows="8"></textarea>
<br />
<input type="submit" name="eva_hostel" value="送出" class="btn-style" />
<input type="reset" value="重填" class="btn-style"/>
</form>
<% 
if(session.getAttribute("eva_hostel")!=null){
  	if("表單尚未填寫完成".equalsIgnoreCase((String)session.getAttribute("error"))){
  		out.println("</p><br>"+"表單尚未填寫完成");	
  	} session.removeAttribute("eva_hostel");  
  	}%>
</div>
</div>
</div>
</div>
<%@include file="footer.jspf" %>
</body>
</html>