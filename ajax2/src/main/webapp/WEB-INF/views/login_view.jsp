<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="x"  uri="http://java.sun.com/jsp/jstl/xml" %> 
<%@ taglib prefix="sql"  uri="http://java.sun.com/jsp/jstl/sql" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<h3>LogIn창</h3>
<hr/>
<form id="frm1" action="login" method="post">
	아이디 : <input type="email" name="uid" size="40" placeholder="E-Mail주소 입력" required><br/><br/>
	비   번 : <input type="password" name="upw" size="40" placeholder="비밀번호 입력" required><br/><br/>
	<input type="submit" value="로그인" >
</form>
<h3>현재 위치에 결과 표시</h3>
<div id="div1"></div>
<h3>modal로 처리</h3>
<hr/>
<div id="modalPos"></div> <!-- modal창의 위치 확보 -->


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
	//form입력후 submit시 ajax처리
	$("#frm1").submit(function(e){
		e.preventDefault();
		$.ajax({
			url : $("#frm1").attr("action"), //8181/ajax2/ url 변경 없음
			type : $("#frm1").attr("method"),
			data : $("#frm1").serialize(), //form에서 입력한 값을 문자열로 변환해주는 메서드
			success : function(data) { //data는 결과를 나타내는 문자열
				if(data.search("login-success") > -1) { //***인 경우 여기로 들어감
					$("#div1").text(data); //login-success
					$("#modalPos").load("html/modal.html",function(){
						$("p#mb1").text("로그인 성공");  //modal.html안의 내용 수정
						$("p#mb2").text("환영합니다");
					});
				}
				else {
					$("#div1").text(data);
					$("#modalPos").load("html/modal.html",function(){
						$("p#mb1").text("로그인 실패");
						$("p#mb2").text("재 로그인");
					});
				}
			},
			error : function() {
				$("#div1").text("접속실패");
				$("#modalPos").load("html/modal.html",function(){
					$("p#mb1").text("서버 접속 실패");
					$("p#mb2").text("다시 시도");
				});
			}
		});
	});
	
});
</script>
</body>
</html>