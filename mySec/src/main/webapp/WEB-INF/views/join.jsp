<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width,initial-scale=1.0"> 
<title>Join</title>
<link type="text/css" rel="stylesheet" href="style/styleSheet.css">
<style>
body {
	margin : 0px;
	padding : 0px;
	background : #d8d8d8;	
}
#div1 {		
	margin-top : 10px;	
	width : 43%;
	margin : auto;	
}
input {
	padding : 10px;
}
</style>
<script src="//code.jquery.com/jquery-latest.min.js">
</script>
<script>

$(document).ready(function(){
	$("#frm1").submit(function(event){ //form엘리먼트의 submit이벤트 처리 메서드
		//원래의 submitt기능 비활성화
		event.preventDefault();			
		$.ajax({ //.ajax메서드는 Ajax로 서버에 요청시 사용하는 메서드
			type : $("#frm1").attr("method"),  
			url : $("#frm1").attr("action"),
			data : $("#frm1").serialize(),
			//async   : false,
			//dataType : "script",
			success : function(data) {
				if(data.search("join-success") > -1) {
					location.href = "login"; 
				}
				else {
					alert("동일한 아이디가 존재 합니다");
				}				
			},
			error : function(data) {
				alert("Ajax 데이터 전송 실패");
			}
		});	
		
	});	
});

</script>
</head>
<body>

<div class="pageTitle" style="text-align:center;">회원 가입 페이지</div>

<div id="div1">
	<form action="join" method="post" id="frm1">
		<fieldset>
			<legend>회 원 가 입</legend>		
			<b>아이디 :</b> <input type="email" name="uid" size="60" placeholder="E-Mail주소 입력"><br/><br/>
			<b>비&nbsp;&nbsp;&nbsp;번 :</b> <input type="password" name="upw" size="60" placeholder="비밀번호 입력"><br/><br/>
			<b>주&nbsp;&nbsp;&nbsp;소 :</b> <input type="text" name="uaddress" size="60" placeholder="주소 입력"><br/><br/>
			<b>취&nbsp;&nbsp;&nbsp;미 :</b> <input type="text" name="uhobby" size="60" placeholder="취미 입력"><br/><br/>
			<b>프로필 :</b><br/></br>
			<textarea name="uprofil" cols="74" rows = "20" placeholder="자기소개를 작성하세요">
			</textarea><br/><br/>			
			<input type="submit" value="회원가입">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" value=" 취&nbsp;&nbsp;&nbsp;소 ">						
		</fieldset>
	</form>
</div>

</body>
</html>