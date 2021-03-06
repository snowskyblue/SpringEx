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

<h3>ajax.jsp입니다</h3>
<hr/>
<h3>리턴 받은 내용을 표시할 부분</h3>
<div id="content"></div>
<button type="button" id="btn">Ajax</button>

<!--jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--popper -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!--javascript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<script>
$(document).ready(function(){
	$("#btn").click(function(){
		/*jQuery ajax() Method
		The ajax() method is used to perform an AJAX (asynchronous HTTP) request.
		All jQuery AJAX methods use the ajax() method. 
		This method is mostly used for requests where the other methods cannot be used.*/
		$.ajax({
			url : "http://localhost:8181/ajax1/data", //클릭해도 8181/ajax1/ajax에서 url은 변경 x
			cache : false,
			data : "", //서버로 보내는 데이터*
			dataType : "html", //리턴받은 데이터형
			success : function(data){ //data는 서버로부터 리턴받은 data(*과 상관 없음)(응용프로그램 처리 성공한 경우)
				$("#content").html(data);
			},
			fail : function(){ //접속 실패 등에 따른 처리(코드상 문제x) error로도 처리
				console.log("fail: ");
			},
			always : function(){ //complete로도 처리 가능
				console.log("always: ");
			}
		});
	});
});
</script>
</body>
</html>