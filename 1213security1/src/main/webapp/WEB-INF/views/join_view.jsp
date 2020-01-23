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
<!-- 회원가입 시 security를 위해 csrf 추가 -->
<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<!-- 회원가입에서 암호화하기 -->
<!-- csrf : 정상적인 사이트에서 원래 열리는 다른 정상사이트2 대신 해킹 사이트를 열음(크로스 사이트,사이트 간 요청 위조) -->
<div id="div1">
	<form action="join" method="post" id="frm1">
		<fieldset>
			<legend>회 원 가 입</legend>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /><br/>		
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!-- 
<script>
$(document).ready(function(){
	$("#frm1").submit(function(event){ //form엘리먼트의 submit이벤트 처리 메서드(jquery에서는 헨들러에서 on을 빼고 씀)
		//원래의 submitt기능 비활성화
		event.preventDefault();			
		$.ajax({ //.ajax메서드는 Ajax로 서버에 요청시 사용하는 메서드
			type : $("#frm1").attr("method"),  
			url : $("#frm1").attr("action"),
			data : $("#frm1").serialize(),
			//async   : false, async : 멀티스레드를 이용해 순서없이 보냄(기본은 트루) 
			//dataType : "script", dataType : 안쓰면 ajax에서 알아서 결정해서 해줌
			//beforesend : 서버에 데이터를 보내기 전에 처리할 일
			
			//controller에서 다시 jsp로 돌어옴(data를 갖고)
			success : function(data) {	
				//성공(내가 짠 서버 어플리케이션에서 데이터를 받고 결과data를 전달받았을때)(서버에서 관리하는 성공실패가 아님)(이벤트)시 할일
				alert(data);
				if(data.search("join-success") > -1) { //색인번호가 -1보다 크다는 말은 data의 문자열중에 저 문자가 존재한다는 뜻
					location.href = "login";  //회원가입 성공시 login 폼으로 이동
				}
				else {
					alert("동일한 아이디가 존재 합니다");
				}	
			},
			error : function(data) { //시스템 관련 에러 404.500
				alert("Ajax 데이터 전송 실패");
			}
		});	
		
	});	
});
</script> -->
</body>
</html>