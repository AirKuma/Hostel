<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
html { height: 100% }
body { height: 100%; margin: 0px; padding: 0px }
#map_canvas { height: 100% }
</style>
<script type="text/javascript" src="https://maps.google.com/maps/api/js?sensor=false"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript">
var addr = '<%=request.getParameter("address")%>';
var name = '<%=request.getParameter("name")%>';
$(document).ready(function(){

var dat={};
  dat.address = addr;
  dat.sensor = "false";
  $.ajax({
  url: 'http://maps.googleapis.com/maps/api/geocode/json',
  type: 'GET',
  dataType: 'html',
  data: dat,
  async: false,
  success: function(data){
    callback(data); 
    }
  });
});
function callback(data)
{
 var o=eval('(' + data + ')');
 if(o.status=="OK")
 {
  var lat = o.results[0].geometry.location.lat;
  var lng = o.results[0].geometry.location.lng;
  initialize(lat,lng);
 }
 }



function initialize(lat,lng) {
  var latlng = new google.maps.LatLng(lat, lng);
  var myOptions = {
   zoom: 15,
   center: latlng,
   mapTypeId: google.maps.MapTypeId.ROADMAP  
  };


  var map = new google.maps.Map(document.getElementById("map_canvas"),
   myOptions);
    var marker = new google.maps.Marker({
 position: latlng, 
 map: map, 
 title:name
 });
}


</script>
</head>
<body>
<div id="map_canvas" style="width:100%; height:100%"></div>
</body>
</html>