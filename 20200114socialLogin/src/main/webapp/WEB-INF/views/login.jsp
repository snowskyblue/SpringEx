<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="x"  uri="http://java.sun.com/jsp/jstl/xml" %> 
<%@ taglib prefix="sql"  uri="http://java.sun.com/jsp/jstl/sql" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
</head>
<style>
  html, div, body,h3{ /*브라우져별로 설정이 다르기때문에 이를 통일시키기 위해(브라우져 설정값이 최하위 우선순위)*/
  	margin: 0;
  	padding: 0;
  }
  h3{
  	display: inline-block;
  	padding: 0.6em;
  }
</style>



<body>

<div style="background-color:#15a181; width: 100%; height: 50px;text-align: center; color: white; ">
	<h3>HAEDU Login</h3>
</div>
<br>
<!-- 네이버 로그인 화면으로 이동 시키는 URL -->
<!-- 네이버 로그인 화면에서 ID, PW를 올바르게 입력하면 callback 메소드 실행 요청 -->
<!-- model 속성값은 EL로 바로 쓸 수 있음 -->
<div id="naver_id_login" style="text-align:center">
	<a href="${url}"><img width="223" src="img/naverid_login_button_short.png"/></a>
</div>
<br>

<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>