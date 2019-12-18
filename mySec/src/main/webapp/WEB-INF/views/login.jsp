<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width,initial-scale=1.0"> 
<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<!-- 
<meta id="_csrf_header" name="_csrf_header" th:content="${_csrf.headerName}"/>
-->
<title>login.jsp</title>
<link type="text/css" rel="stylesheet" href="style/styleSheet.css" />
<style>
html,body {
	margin : 0px;
	padding : 0px;
}

#div1 {
	border : 1px solid #e1e1e1;	
	box-sizing: border-box;	
}

#div2 {	
	border : 1px solid #e1e1e1;
	background : #d8d8d8;
	box-sizing: border-box;
	height : 700px;
}

img {
	width : 100%;
	height : 300px;	
}

form {
	width : 40%;
	margin : auto;
	position : relative;
	top : 100px;
}

input {
	padding : 10px;
}

[type="submit"] {
	display : inline-block;	
	position : relative;
	left : 40px;	
}

#btn1 {	
	display : inline-block;
}

#btn2 {	
	display : inline-block;
	position : relative;
	left : 70px;	
}

button {
	padding : 10px 10px;	
}

h3 {
	text-align : center;
	font-weight : bold;
	margin : 6px;
}

</style>
<script src="//code.jquery.com/jquery-latest.min.js">
</script>
<script>
$(document).ready(function(){
/*
	<c:choose>
		<c:when test="${not empty error}">
			$("#modalPos").load("html/modal.html",function(){
				$("p#mb1").text("로그인 실패");
				$("p#mb2").text("ID와 패스워드를 다시 확인 하세요");
			});
		</c:when>
		
		<c:when test="${not empty msg}">
			$("#modalPos").load("html/modal.html",function(){
				$("p#mb1").text("로그아웃");
				$("p#mb2").text("안녕히 가세요");
			});
		</c:when>
		
		<c:otherwise>
			window.open('html/popup.html', 'popup01', 'width=300, height=400, scrollbars= 0, toolbar=0, menubar=no');		
		</c:otherwise>	
		
	</c:choose>
*/

	<c:choose>
		<c:when test="${not empty log}">
			window.open('html/popup.html', 'popup01', 'width=300, height=400, scrollbars= 0, toolbar=0, menubar=no');		
		</c:when>
		
		<c:when test="${not empty msg}">
			$("#modalPos").load("html/modal.html",function(){
				$("p#mb1").text("로그아웃");
				$("p#mb2").text("안녕히 가세요");
			});
		</c:when>
		
		<c:otherwise>
			$("#modalPos").load("html/modal.html",function(){
				$("p#mb1").text("로그인 실패");
				$("p#mb2").text("ID와 패스워드를 다시 확인 하세요");				
			});		
		</c:otherwise>	
	
	</c:choose>

	
	$("#btn1").click(function(e){
		e.preventDefault();
		location.href = "join_view";		
	});
	
	$("#btn2").click(function(e){
		e.preventDefault();
		location.href = "seekInfo_view";		
	});
	
	$("#frm1").submit(function(event){ //form엘리먼트의 submit이벤트 처리 메서드
		//원래의 submitt기능 비활성화
		event.preventDefault();			
		$.ajax({ //.ajax메서드는 Ajax로 서버에 요청시 사용하는 메서드			
		type : $("#frm1").attr("method"),  
			url : $("#frm1").attr("action"),
			data : $("#frm1").serialize(),
			//async   : false, //동기,비동기 지정 기본은 true로 비동기
			dataType : "text", //응답데이터형
			
			beforeSend : function(xhr,settings) {
				xhr.setRequestHeader("X-CSRF-TOKEN",$("meta[name='_csrf']").attr('content'));				
			},
			success : function(data) { //csrf : ayuth success에만 오고 실패시는  security에서 자체 처리					
				location.href = "mainFrame";	
			    //login성공시는 ajax에서 처리하고	실패시는 spring이 처리		
				//if(data.search("login-success") > -1) { //data객체에 success의 색인번호를 반환					
				//	location.href = "mainFrame"; 
				//}
				//else {
				//	$("#modalPos").load("html/modal.html",function(){
				//		$("p#mb1").text("로그인 실패");
				//		$("p#mb2").text("ID와 패스워드를 다시 확인 하세요");
				//	});
				//}				
			},		
			error : function() {			
				$("#modalPos").load("html/modal.html",function(){
					$("p#mb1").text("서버 접속 실패");
					$("p#mb2").text("인터넷 상태를 확인해 보세요");
				});
			}
		});		
		
	});		
	
});
</script>
</head>
<body>

<div id="div1">
	<img src="images/shalcom.jpg">
</div>
<div id="modalPos"></div> <!-- modal창의 위치 확보 -->
<h3>본 프로젝트는 </h3>

<h3 style='color:green'>클라이언트는 HTML5,CSS(3),자바스크립트,JQuery,AJAX,RWD 등의 기술이 적용되었으며</h3>
<h3 style='color:blue'>서버는 SpringFrameWork를 이용한 MVC모델로 Controller,Command형태를 채택 하였고 </h3>
<h3 style="color:red">데이터베이스 접속은 ORACLE jdbcTemplate를 이용하며 security를 적용하였습니다.</h3>

<div id="div2">
	<form id="frm1" action="j_spring_security_check" method="post">
		<fieldset>
			<legend>로그인</legend>
			<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" />		
			<b>아이디 :</b> <input type="email" name="uid" size="40" placeholder="E-Mail주소 입력" required><br/><br/>
			<b>비&nbsp;&nbsp;&nbsp;번 :</b> <input type="password" name="upw" size="40" placeholder="비밀번호 입력" required><br/><br/>
			<div>
				<button id="btn1" style="margin-left:20px;">회원가입</button><input type="submit" value="로그인" >
				<button id="btn2">ID,PW찾기</button>
			</div>			
		</fieldset>
	</form>	
</div>
</body>
</html>