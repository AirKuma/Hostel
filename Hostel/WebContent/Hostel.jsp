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
<title>民宿</title>
<%@include file="navbar.jspf" %>
<%@include file="navbarhostel.jspf" %>
<script type="text/javascript">
// Popup window code
function newPopup(url) {
	popupWindow = window.open(
		url,'popUpWindow','height=300,width=300,left=10,top=10,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no,status=yes')
}
</script>

</head>
<body>
<%
        DBhostel db = new DBhostel();
		DBcollect db1 = new DBcollect();
		List<Hostel> hostels = db.getHostel((String)session.getAttribute("hostel"));
		for (Hostel hos: hostels){	
%>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
              <div class="panel-heading">
                   <h4><span class="glyphicon glyphicon-home"></span> <%=hos.get(1)%>
                   <div style="float:right">
                   <%
                   if(db1.iscollect((String)session.getAttribute("user"),(String)session.getAttribute("hostel"))==false) {%>
                   <form action="CollectServlet" method="GET" class="smart-green">
                       <input type="image" src="img\collect.png" style="width:30px;height:30px;" onClick="document.formname.submit();">
                    </form>   
                   <%}else{ %>
                   <form action="CancelCollectServlet" method="GET" class="smart-green">
                  	    <input type="hidden" name="cancel" value="save">
                   		<input type="image" name="save" src="img\cancollect.png" style="width:30px;height:30px;" onClick="document.formname.submit();">
                   </form> 	
                   		<%} %>
                   </div>
				   </h4>
              </div>
              <div class="panel-body">
              	<div class="col-md-6 col-sm-8">
                    <img class="img-responsive img-portfolio img-hover" src="<%=hos.get(7)%>" style="width:700px;height:350px;" alt="">
            	</div>
            	   <p>地址：<%=hos.get(2)%> <a href="JavaScript:newPopup('showmap.jsp?address=<%=hos.get(2)%>name=<%=hos.get(1)%>');"><img src="img\gmap_icon.png" style="width:30px;height:30px;"></a></p>
              	   <p>電話：<%=hos.get(3)%></p>
              	   <p>E-mail：<%=hos.get(6)%></p>	
            	   <p>提供之服務：<%=hos.get(4)%></p>
            	   <p>付款方式：<%=hos.get(5)%></p>
            	   <p>訂金比率：<%=hos.get(8)%></p>
                   <p><%} %></p>
                   
               </div>
        </div>
</div>
</div>
<%@include file="footer.jspf" %>
</body>
</html>