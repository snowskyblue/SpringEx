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

<h3>Login_view.jsp 로그인창</h3>
<hr/>
<form id="frm1" action="login" method="post">
	<b>아이디: </b> <input type="email" name="uid" size="40" placeholder="email entering" required><br/><br/>
	<b>비번: </b> <input type="password" name="upw" size="40" placeholder="pw entering" required><br/><br/>
	<input type="submit" value="로그인">
</form>

<hr/>
<h3>결과를 표시할 영역</h3>
<div id="div1"></div>
<h3>모들로 처리</h3>
<dv id="modalPos"></dv>

<!--jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--popper -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!--javascript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
	//form입력후 submit시(이벤트) ajax처리
	$("#frm1").submit(function(e){
		e.preventDefault();
		$.ajax({
			url : $("#frm1").attr("action"),
			type : $("#frm1").attr("method"),
			data : $("#frm1").serialize(),	//form에서 입력한 값을 문자열로 변환(직렬화)해주는 메서드
			//{uid=???,upw=???}
			success : function(data){ //data는 결과를 나타내는 문자열
				if(data.search("login-success") > -1){ //색인번호가 0이상이면 찾앗다는 뜻
					$("#div1").text(data);
					/*.load()라는 ajax를 이용하여, 모달창html가져오기*/
					$("#modalPos").load("html/modal.html",function(){ /*콜백함수*/
						$("p#mb1").text("로그인 성공"); /*modal.html 문서 안 내용 수정*/
						$("p#mb2").text("환영합니다");
					});
				}
				else {
					$("#div1").text(data);
					$("#modalPos").load("html/modal.html",function(){
						$("p#mb1").text("로그인 실패");
						$("p#mb2").text("재로그인하세요");
					});
				}
			},
			error : function(){
				$("#div1").text("접속실패");
				$("#modalPos").load("html/modal.html",function(){
					$("p#mb1").text("서버 접속 실패");
					$("p#mb2").text("다시 시도하세요");
				});
			}
		});
	});
});
</script>
</body>
</html>