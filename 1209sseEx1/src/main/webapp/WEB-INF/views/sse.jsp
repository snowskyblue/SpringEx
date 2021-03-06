<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
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
<div id="div1"></div>
<button type="button" id="btn1">이벤트 받기</button>
<button type="button" id="btn2">home</button>

<!--jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--popper -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!--javascript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/event-source-polyfill/0.0.9/eventsource.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/evnet-source-polyfill/0.0.9/eventsource.min.js"></script>
<script>
$(document).ready(function(){
	$("#btn1").click(function(){
		//이벤트를 받기 위한 이벤트소스 객체 생성
		var eventSource = new EventSource("eventEx"); //서버요청경로가 eventEx
		eventSource.onmessage = function(event){ //message이벤트 발생시 event객체에 데이터가 실려옴
			$("#div1").text(event.data); //event에 실려있는 data 출력
		}
	});
	$("#btn2").click(function(){
		location.href="http://localhost:8181/1209sseEx1/";
	});
});
</script>
</body>
</html>