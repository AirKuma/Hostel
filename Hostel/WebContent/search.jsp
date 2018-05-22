<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.List" %>
<%@ page import="Hostel.*" %>
<%@ page import="DBHostel.*" %>
<%@ page import="java.util.Calendar" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jspf" %>
<title>查詢民宿</title>
<%@include file="navbar.jspf" %>
<script>
department=new Array();
department[0]=[];
department[1]=["新北市", "台北市", "桃園", "新竹"];	
department[2]=["苗栗", "台中", "彰化", "南投", "雲林"];	
department[3]=["嘉義", "台南", "高雄", "屏東"];			
department[4]=["宜蘭", "花蓮", "台東"];				

function renew(index){
	for(var i=0;i<department[index].length;i++)
		document.myForm.location.options[i]=new Option(department[index][i], department[index][i]);	
	document.myForm.location.length=department[index].length;	
}
</script>
</head>
<body>
<div class="container theme-showcase" role="main">
<div class="col-md-12">
      <div class="panel panel-default panel-transparent">
<div class="panel-heading">
<h4><span class="glyphicon glyphicon-search"></span> 查詢民宿</h4>
</div>
<div class="panel-body">
<form name="myForm" action="" method="POST" class="smart-green"> 
<div class="tabbable"> 
  <ul class="nav nav-tabs">
    <li class="active"><a href="#tab1" data-toggle="tab">地區查詢</a></li>
    <li><a href="#tab2" data-toggle="tab">關鍵字查詢</a></li>
  </ul>
  <div class="tab-content">
    <div class="tab-pane active" id="tab1">
      </p>地區：
<select name="position" onChange="renew(this.selectedIndex);">
	<option></option>
  	<option>北部</option>
  	<option>中部</option>
  	<option>南部</option>
  	<option>東部</option>
</select>
縣市：
<select name="location">
  	<option value="">請由左方選取地區
</select></p>
    </div>
    <div class="tab-pane" id="tab2">
    </p>  關鍵字：<input type="text" name="keyword" placeholder=" 關鍵字" /></p>
    </div>
  </div>
</div>
空房查詢：<input type="date" name="begin_time"  />
~ <input type="date" name="end_time" /></p> 
<input type="submit" name="sbm_register" value="查詢" class="btn-style" />
</form>
<table class="table table-hover">
            <thead>
            <tr>
            <th></th>
			<% for (int i=1; i<DBhostel.TITLES.length; i++){ %>
			<th><%=DBhostel.TITLES[i]%></th>
			<%} %>
			</tr>
            </thead>
            <tbody>
            <%
            	request.setCharacterEncoding("utf-8");
                DBhostel db = new DBhostel();
                String local = request.getParameter("location");
                String key = request.getParameter("keyword");
                List<Hostel> hostels;
            	if(request.getParameter("location")!=""&&request.getParameter("location")!=null){
            		hostels = db.getLocalHostel(local);}
            	else if(request.getParameter("keyword")!=""&&request.getParameter("keyword")!=null){
            	    hostels = db.getKeyHostel(key);}
            	else{
            		 hostels = db.getAllHostel();}
            	
            	boolean print = true;
				for (Hostel hos: hostels){
					if(request.getParameter("begin_time")!=null&&request.getParameter("begin_time")!=""&&request.getParameter("end_time")!=null&&request.getParameter("end_time")!=""){
            			print = false;
						String begin_time = request.getParameter("begin_time");
    					java.sql.Date begintime=java.sql.Date.valueOf(begin_time);
    					String end_time = request.getParameter("end_time");
    					java.sql.Date endtime=java.sql.Date.valueOf(end_time);
    					
    					Calendar begin = Calendar.getInstance();
    					begin.setTime(begintime);
    					Calendar end = Calendar.getInstance();
    					end.setTime(endtime);
    					long timebegin=begin.getTimeInMillis();
    					long timeend=end.getTimeInMillis();
    					long orderday =(timeend-timebegin)/(1000*60*60*24);
    					for(int i=0;i<=orderday;i++){				
    						if(db.isAvailable(begintime,hos.gethostel_id())!=true){
    							print = true;
    							break;
    						}
    						Calendar cal = Calendar.getInstance();
    						cal.setTime(begintime);
    						cal.add(Calendar.DATE,1);
    						begintime = new java.sql.Date(cal.getTime().getTime()); 
    					}
					}
    				if(print){
			%>
			<tr>
				<td width="200"><img class="img-responsive img-portfolio img-hover" src="<%=hos.get(7)%>" style="width:150px;height:100px;"></td>
				<td><%=hos.get(1)%></td>
				<td><%=hos.get(2)%></td>
				<td><a href="/Hostel/SetHostelServlet?PNO=<%=hos.gethostel_id()%>&PNO2=<%=hos.gethostel_name()%>">進入主頁</a></td>
			</tr>
			<%	}} %>
            </tbody>
          </table>
</div>
</div>
</div>
</div>
<%@include file="footer.jspf" %>
</body>
</html>