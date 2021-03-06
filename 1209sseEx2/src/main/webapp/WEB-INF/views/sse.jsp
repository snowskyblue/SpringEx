<%@ page language="java" contentType="text/html; charset= UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content = "IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!--font-awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
</head>
<body>

<h3>이벤트 결과값 받기</h3>
<hr/>
<h3>이벤트 결과값 표시 영역</h3>
<button type = "button" id = "btn1">이벤트 받기</button>
<button type = "button" id = "btn2">Home</button>

<h3>이벤트 1값</h3>
<div id = "div1"></div>
<h3>이벤트 2값</h3>
<div id = "div2"></div>



<!--jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--popper -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!--javascript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src = "http://cdnjs.cloudflare.com/ajax/libs/event-source-polyfill/0.0.9/eventsource.js"></script>
<script src = "http://cdnjs.cloudflare.com/ajax/libs/event-source-polyfill/0.0.9/eventsource.min.js"></script>

<script>
$(document).ready(function(){
   $("#btn1").click(function(){
	  /*The EventSource object is used to receive server-sent event notifications:
		  Each time an update is received, the onmessage event occurs*/
      var eventSource = new EventSource("eventEx");
      eventSource.addEventListener("up_vote",function(event){
         $("#div1").text(event.data);
      },false);
      eventSource.addEventListener("down_vote",function(event){
         $("#div2").text(event.data);
      },false);
   });
   
   $("#btn2").click(function(){
      location.href = "http://localhost:8181/sseEx2/";
   });
});
</script>
</body>
</html>