<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jspf" %>
<title>首頁</title>
<%@include file="navbar.jspf" %>
</head>
<body>
<div class="container">	
<div class="col-md-12 column">

<div id="myCarousel" class="carousel slide">
<ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
    <li data-target="#myCarousel" data-slide-to="4"></li>
    <li data-target="#myCarousel" data-slide-to="5"></li>
    <li data-target="#myCarousel" data-slide-to="6"></li>
</ol>
<div class="carousel-inner" >
	<div class="item active">
         <img src="img/hostelimg/1.jpg" class="fill">
         <div class="carousel-caption">
         </div>
    </div>
    <div class="item">
         <img src="img/hostelimg/2.jpg" class="fill">
         <div class="carousel-caption">
         </div>
    </div>
    <div class="item">
         <img src="img/hostelimg/3.jpg" class="fill">
         <div class="carousel-caption">
         </div>
    </div>
    <div class="item">
         <img src="img/hostelimg/4.jpg" class="fill">
         <div class="carousel-caption">
         </div>
    </div>
    <div class="item">
        <img src="img/hostelimg/5.jpg" class="fill">
        <div class="carousel-caption">
         </div>
    </div>
    <div class="item">
         <img src="img/hostelimg/6.jpg" class="fill">
         <div class="carousel-caption">
         </div>
    </div>
    <div class="item">
         <img src="img/hostelimg/7.jpg" class="fill">
         <div class="carousel-caption">
         </div>
    </div>

</div>
<a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Next</span>
        </a>
</div>

    <script src="CSS/jquery.js"></script>
<script>
    $('.carousel').carousel({
        interval: 800 
    })
</script>
	<div><center><h2>歡迎來到這裡！<p><p>
	 <small> 想要在外出時找到一個像家一樣的民宿嗎?<p>
	                    想要向民宿老闆了解更多的資訊嗎？<p>
	       Four in One 是您最好的選擇。</small></h2>
	                  
	                    </center></div>
	</div>
</div>

<%@include file="footer.jspf" %>
</body>
</html>