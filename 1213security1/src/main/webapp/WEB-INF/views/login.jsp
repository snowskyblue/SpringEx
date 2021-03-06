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
<!-- csrf 정보 -->
<meta id="_csrf" name="_csrf" content="${_csrf.token}" />
<!-- default header name is X-C -->
<!--bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!--font-awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
</head>
<body>

<h3>JS안에 jquery로 메시지 출력 위치</h3>
<hr/>
<div id="div1"></div>

<!--j_spring_security_check는 개발자의 frontcontroller에 있는 경로처리가 아니고
spring security로 요청하는 경로임
csrf를 방지하기 위한 헤더 부분 추가 -->
<!-- <form id="frm1" method="post" action="j_spring_security_check"> -->
<form id="frm1" method="post" action="login">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /><br/>
	<b>아이디:</b> <input type="email" name="uid" size="40" placeholder="email Enter" required><br/><br/>
	<b>비&nbsp;&nbsp;&nbsp;번</b><input type="password" name="upw" size="40"  placeholder="pw Enter" required><br/><br/>
	<input type="submit" value="로그인">
</form>
<br/>
<!-- security에 암호화 더하기 -->
<a href="join_view">가입처리</a> <br/>

<!--jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--popper -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!--javascript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script>
/*c:choose JSTL로, core쪽, js안에서의 jquery사용은 JSTL + EL만 가능
 * model.addObject("log", "before login!");하면 log가 not empty
 */
$(document).ready(function(){
	<c:choose>
		<c:when test="${not empty log}"> //model의 log속성이 null이 아니면
			$("#div1").text("Welcome!(로그인 폼 위에 출력)");
		</c:when>
		<c:when test="${not empty msg}"> //model의 msg값이 null이 아니면(로그아웃)
			$("#div1").text("Logged out!(로그인 폼 위에 출력)");
		</c:when>
		<c:otherwise>
		$("#div1").text("Login Fail!(로그인 폼 위에 출력)");
		</c:otherwise>
	</c:choose>
	/* 내 jsp에서 보내는게 아니어서 에이젝스로 보낼 필요 없음(시큐리티를 적용하지 않고 내가 처리할때 필요)
	$("#frm1").submit(function(event){
		event.preventDefault();
		$.ajax({
			url : $("#frm1").attr("action"), //login RequestMapping
			type : $("#frm1").attr("method"), //post
			data : $("#frm1").serialize(),
			dataType : "text", //리턴되는 데이터 타입??????????
			beforeSend : function(xhr, settings){
				xhr.setRequestHeader("X-CSRF-TOKEN", $("meta[name='_csrf']").attr('content'));
			},
			success : function() {				
				location.href = "mainFrame";
			},
			error : function(){
				$("#div1").text("server error!");
			}
		});
	});
	*/
});
</script>
</body>
</html>