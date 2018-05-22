<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jspf" %>
<title>評價客戶</title>
<%@include file="navbar.jspf" %>
<%@include file="navbarpersonal.jspf" %>
</head>
<body>
<%
if(session.getAttribute("eva_cus")==null)
{
	session.setAttribute("hostel_name",request.getParameter("PNO"));
	session.setAttribute("customer",request.getParameter("PNO2"));
}
%>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
<div class="panel-heading">
<h4><span class="glyphicon glyphicon-star"></span> 客戶評價</h4>
</div>
<div class="panel-body">
<form action="Evaluate_cusServlet" method="GET" class="smart-green"> 
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
    <td bgcolor="EEFCEE">住房頻率</td>
    <td><input type="radio" name="eva_cus_cusrequency" value="1"/>很低</td >
    <td><input type="radio" name="eva_cus_cusrequency" value="2" />低 </td>
    <td><input type="radio" name="eva_cus_cusrequency" value="3" />普通 </td>
    <td><input type="radio" name="eva_cus_cusrequency" value="4" />高 </td>
    <td><input type="radio" name="eva_cus_cusrequency" value="5" />很高 </td>
  </tr>
  <tr align="center">
    <td bgcolor="#EEFCEE">品性行為</td>
    <td><input type="radio" name="eva_cus_behavior" value="1"/>很差</td >
    <td><input type="radio" name="eva_cus_behavior" value="2" />差</td>
    <td><input type="radio" name="eva_cus_behavior" value="3" />普通</td>
    <td><input type="radio" name="eva_cus_behavior" value="4"/>好</td>
    <td><input type="radio" name="eva_cus_behavior" value="5"/>很好</td>
  </tr>
  <tr align="center">
    <td bgcolor="EEFCEE">衛生習慣</td>
    <td><input type="radio" name="eva_cus_sanitation" value="1"/>很差</td >
    <td><input type="radio" name="eva_cus_sanitation" value="2" />差 </td>
    <td><input type="radio" name="eva_cus_sanitation" value="3" />普通 </td>
    <td><input type="radio" name="eva_cus_sanitation" value="4" />好 </td>
    <td><input type="radio" name="eva_cus_sanitation" value="5" />很好 </td>
  </tr>
 <tr align="center">
     <td bgcolor="EEFCEE">信用程度</td>
    <td><input type="radio" name="eva_cus_credence" value="1"/>很差</td >
    <td><input type="radio" name="eva_cus_credence" value="2" />差 </td>
    <td><input type="radio" name="eva_cus_credence" value="3" />普通 </td>
    <td><input type="radio" name="eva_cus_credence" value="4" />好 </td>
    <td><input type="radio" name="eva_cus_credence" value="5" />很好 </td>
  </tr>
  <tr align="center">
     <td bgcolor="EEFCEE">住客回流率</td>
    <td><input type="radio" name="eva_cus_reflux" value="1"/>很低</td >
    <td><input type="radio" name="eva_cus_reflux" value="2" />低 </td>
    <td><input type="radio" name="eva_cus_reflux" value="3" />普通 </td>
    <td><input type="radio" name="eva_cus_reflux" value="4" />高 </td>
    <td><input type="radio" name="eva_cus_reflux" value="5" />很高 </td>
  </tr>
</table>
<br />
<h4>顧客行為</h4></P>
 <textarea name="eva_cus_customer" id="textarea" cols="96" rows="8"></textarea>
<br />
<input type="submit" name="eva_cus" value="送出" class="btn-style" />
<input type="reset" value="重填" class="btn-style"/>
</form>
<% 
if(session.getAttribute("eva_cus")!=null){
  	if("表單尚未填寫完成".equalsIgnoreCase((String)session.getAttribute("error"))){
  		out.println("</p><br>"+"表單尚未填寫完成");	
  	} session.removeAttribute("eva_cus");  
  	}%>
</div>
</div>
</div>
</div>
<%@include file="footer.jspf" %>
</body>
</html>