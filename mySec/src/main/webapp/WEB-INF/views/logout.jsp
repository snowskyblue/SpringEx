<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width,initial-scale=1.0">
<title>log out</title>
<link type="text/css" rel="stylesheet" href="style/styleSheet.css" />
<style>
form {	
	position : fixed;
	left : 5px;
	top : 5px;
	background : #e1e1e1;
	width : 90%;
	color : red;
	margin : auto;
}
</style>
<script src="//code.jquery.com/jquery-latest.min.js"></script>
<script>
$(document).ready(function(){
	$("#div1").load("html/menu.html");
	$("#reset").click(function(e){
		e.preventDefault();
		$("#frm1").css("display","none");
	});
});
</script>
</head>
<body>

<div id="div1">
</div>

<form id="frm1" action=" logout" method="post" target="_TOP" >
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<h4>정말로 로그아웃 하시렵니까?</h4>
	<input id="sub" type="submit" value="확인">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="reset" type="reset" value="취소">	
	<br/>	
</form>



</body>
</html>