<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!--font-awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- datepicker -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css" rel="stylesheet"/>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Insert title here</title>
<style>
@font-face { font-family: 'Eoe_Zno_L'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_eight@1.0/Eoe_Zno_L.woff') format('woff'); font-weight: normal; font-style: normal; }
@font-face { font-family: 'S-CoreDream-2ExtraLight'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/S-CoreDream-2ExtraLight.woff') format('woff'); font-weight: normal; font-style: normal; }
@font-face { font-family: 'KBIZHanmaumGothic'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/KBIZHanmaumGothic.woff') format('woff'); font-weight: normal; font-style: normal; }
.header {
    position: fixed;
    top: 0;
    background-color: #fff;
    border-bottom: 1px solid #e5e5e5;
    z-index: 999;
    width : 100%;
}
.carousel {
	margin-top : 100px;
}
nav, figure, footer, header {
    display: block;
}

figure {
    margin: 0;
}

.header #logo {
    position: relative;
    line-height: 100px;
}

.header #logo img {
    transition: all .2s ease-in-out;
    width: 300px;
    height: auto;
}

.header .navbar {
    border-left: 1px solid #e5e5e5;
    border-right: 1px solid #e5e5e5;
    border-top: 0;
    border-bottom: 0;
    margin-bottom: 0;
    border-radius: 0;
    display: block;
    padding: 0;
    margin-left: -15px;
    margin-right: 15px;
    position: relative;
    min-height: 50px;

}

.header .top-navbar {
    line-height: 50px;
    border-bottom: 1px solid #e5e5e5;
    margin: 0;
}
.header .search-box {
    width: 40%;
}
.header .link-box, .header .search-box {
    float: left;
    text-align: center;
}

.header .link-box {
    width: 30%;
    border-left: 1px solid #e5e5e5;
}
.header .link-box ul {
    margin: 0 2% 0 3%;
    width: 93%;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
    -webkit-justify-content: space-around;
    -ms-flex-pack: distribute;
    justify-content: space-around;
}

.header .link-box li {
    float: left;
}
.header .link-box li a, .header .search-box a {
	font-family: 'Eoe_Zno_L';
    display: inline-block;
    color: #000;
    font-size: 13px;
    height: 50px;
    line-height: 50px;
    text-decoration: none;
    font-weight: 700;
}

.header .main-navbar ul {
	font-family: 'Eoe_Zno_L';
    margin: 0 2% 0 3%;
    width: 93%;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
    -webkit-justify-content: space-around;
    -ms-flex-pack: distribute;
    justify-content: space-around;
}

.header .main-navbar li {
    float: left;
}
.header .main-navbar li a {
    display: inline-block;
    color: #000;
    font-size: 13px;
    height: 50px;
    line-height: 50px;
    text-decoration: none;
    font-weight: 700;
}

.carousel-caption p {
   font-family: 'S-CoreDream-2ExtraLight';
   font-size: 30px;
   font-style: italic;
   margin-bottom: 80px;
   margin-left: 50%;
   width:600px;
   position: relative;
   background-color: rgba(0, 0, 0, 0.4);
   transform: translate(-50%, -50%);
}
/************************************/
.booking-form {
   font-family: 'Eoe_Zno_L';
   color : white;
}
.input-grp {
   width : 150px;
   display : inline-block;
   margin: 30px 10px;
}
.form-control {
   font-size : 12px;
   background : transparent;
   border-radius : 0;
   color:#fff;
   box-shadow: none;
   margin : 0px 50px;
   height : 33px;

}
.custom-select {
   background : black;
   color : #fff;
   font-size:12px;
   border : 1px solid #ced4da;
   box-shadow: none;
   border-radius : 0;
   background : transparent;
   margin : 0px 50px;
   height : 33px;
}
option {
   background : #343a40;
   font-size:12px;
}
input[type="number"]::-webkit-outer-spin-button,
input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}

.banner {
   /*float: left;*/
    margin: 10px 0;
    /*position: relative;*/
}

.banner a {
	display: block;
    background-color: rgba(0,0,0,.5);
    width: 100%;
    height: 100%;
}

.banner img {
	z-index: 1;
    display: block;
    height: 100%;
    width: 100%;
    position: relative;
}

.centered {
	z-index: 2;
	font-family: 'S-CoreDream-2ExtraLight';
    font-weight: bold;
    border-radius: 5px;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    font-size: 25px;
    color: #fff;
    text-shadow: 0 1px #000;
    text-align: center;
    background-color: rgba(0, 0, 0, 0.2);
    width: 80px;
    height: 45px;
    border: 2px solid white;
}

.banner:hover img {
	z-index: -1;
	position: relative;
}
/************************************/
.container-fluid {
	padding: 0;
}

/*##################################*/
@media screen and (max-width: 768px) {
	.container {
		max-width: 1000px;
	}
	
	.header #logo img {
    width: 200px;
    height: auto;
    margin-left: 0;
	}
	.menu-toggle {
		display: block;
		width: 40px;
		height: 70px;
		margin: 5px;
		float: right;
		cursor: pointer;
		text-align: center;
		font-size: 30px;
		
	}
	.menu-toggle:before {
		content: '\f0c9';
		font-family: fontAwesome;
		line-height:20px;
	}
	
	nav {
		display:none!important;
	}
	
	nav.active {
		display: block!important;
		width:100%;
		margin-left: 0!important;
    	margin-right: 0!important;
	}
	
	nav.active .top-navbar {
		border-top: 1px solid #e5e5e5;
		margin-right: 10px;
		width: 100%;
	}
	
	.form-control, .custom-select {
		margin:0;
	}
	
	.input-grp {
		width: 100%;
		margin: 10px 10px;
	}
	
}

@media screen and (min-width: 768px) and (max-width: 1200px) {
	.input-grp {
		margin: 20px 20px;
		width: 25%;
	}
}

footer {
	 height:300px;
	 width:100%;
}

/*##################################*/
</style>
</head>
<body>
<header id="header" class="header">
  <div class="container">
    <div class="row">
      <figure id="logo" class="col-md-6">
        <a href="#">
        	<img src="img/logo.jpg" id="logoimg" alt="stay with me">
        </a>
        <div class="menu-toggle"></div>
      </figure>
      
      <nav class="navbar col-md-6" id="top-nav-bar">
        <div class="top-navbar row">
          <div class="search-box">
          	<a href="#">지역별 숙소찾기</a>
          </div>
          <div class="link-box">
            <ul class="list-unstyled">
              	<li class="qna-btn-li"><a href="#">Q&A</a></li>
            	<li class="cs-btn-li"><a href="#">고객센터</a></li>
            </ul>
          </div>
          <div class="link-box">
            <ul class="list-unstyled">
              	<li class="login-btn-li"><a href="#">로그인</a></li>
            	<li class="signup-btn-li"><a href="#">회원가입</a></li>
            </ul>
          </div>
        </div>
        <div id="main-nav-bar" class="main-navbar row">
          <ul class="list-unstyled">
            <li class="wish-btn-li"><a href="#">위시리스트</a></li>
            <li class="confirm-btn-li"><a href="#">예약확인</a></li>
            <li class="host-btn-li"><a href="#">호스트</a></li>
            <li class="message-btn-li"><a href="#">쪽지</a></li>
            <li class="notice-btn-li"><a href="#">공지사항</a></li>
          </ul>
        </div>
      </nav>
    </div>
  </div>
</header>
<!-- Carousel -->
<div class="container-fluid carousel">
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators(사진 순서 표시하는 작은 막대기들) -->
		<ul class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active bg-light"></li>
			<li data-target="#myCarousel" data-slide-to="1" class="bg-light"></li>
			<li data-target="#myCarousel" data-slide-to="2" class="bg-light"></li>
			<li data-target="#myCarousel" data-slide-to="3" class="bg-light"></li>
		</ul>
		<!-- 실제 내용(사진+설명) -->
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img style="height:500px; width:100%; margin:0;" src="img/1.jpg" alt="seoul" class="d-block mx-auto">
				<div class="carousel-caption">
					<p>여행과 장소의 변화는<br/>
					우리 마음에 활력을 선사한다<br/>
					<span style="font-size:15px;">세네카</span></p>
				</div>
			</div>
			<div class="carousel-item">
				<img style="height:500px; width:100%; margin:0;" src="img/2.jpg" alt="LA" class="d-block mx-auto">
				<div class="carousel-caption">
					<p>바보는 방황하고,<br/>
					현명한 사람은 여행한다.<br/>
					<span style="font-size:15px;">토마스 풀러</span></p>
				</div>
			</div>
			<div class="carousel-item">
				<img style="height:500px; width:100%; margin:0;" src="img/3.jpg" alt="3" class="d-block mx-auto">
				<div class="carousel-caption">
					<p>낯선 땅이란 없다.<br/>
					단지 여행자가 낯설 뿐이다.<br/>
					<span style="font-size:15px;">로버트 루이스 스티븐슨</span></p>
				</div>
			</div>
			<div class="carousel-item">
				<img style="height:500px; width:100%; margin:0;" src="img/4.jpg" alt="4" class="d-block mx-auto">
				<div class="carousel-caption">
					<p>희망차게 여행하는 것이<br/>
					목적지에 도착하는 것보다 좋다.<br/>
				<span style="font-size:15px;">로버트 루이스</span></p>
			</div><!-- carousel-item(4개) --> 
		  </div><!-- carousel-item(2개) -->
       </div> <!-- carousel-inner(1개) -->
	 </div> <!-- carousel (1개) -->
</div> <!-- container -->

<!-- Booking Form -->
<div class="container-fluid bg-dark">
	<form>
		<div class="booking-form container input-group">
			<div class="input-grp">
				<select class="custom-select" name="Area">
						<option value="#">&nbsp;&nbsp;지역&nbsp;&nbsp;</option>
						<option value="1">&nbsp;&nbsp;강원&nbsp;&nbsp;</option>
					   	<option value="2">&nbsp;&nbsp;경기&nbsp;&nbsp;</option>
					   	<option value="3">&nbsp;&nbsp;경남&nbsp;&nbsp;</option>
					    <option value="4">&nbsp;&nbsp;경북&nbsp;&nbsp;</option>
					    <option value="5">&nbsp;&nbsp;대구&nbsp;&nbsp;</option>
					   	<option value="6">&nbsp;&nbsp;부산&nbsp;&nbsp;</option>
					   	<option value="7">&nbsp;&nbsp;서울&nbsp;&nbsp;</option>
					    <option value="8">&nbsp;&nbsp;인천&nbsp;&nbsp;</option>
					    <option value="8">&nbsp;&nbsp;전남&nbsp;&nbsp;</option>
					    <option value="8">&nbsp;&nbsp;전북&nbsp;&nbsp;</option>
					    <option value="8">&nbsp;&nbsp;제주&nbsp;&nbsp;</option>
					    <option value="8">&nbsp;&nbsp;충남&nbsp;&nbsp;</option>
					    <option value="8">&nbsp;&nbsp;충북&nbsp;&nbsp;</option>
				</select>
			</div>
			<div class="input-grp">
				<input type="text" id="CheckIn" class="form-control select-date" value="Check In">
			</div>
			<div class="input-grp">
				<input type="text" id="CheckOut"class="form-control select-date" value="Check Out">
			</div>
			<div class="input-grp">
	            <input type="number"  class="form-control" placeholder="Adult">
	        </div>
	        <div class="input-grp">
	            <input type="number"  class="form-control" placeholder="Child">
	        </div>
			<div class="input-grp">
	            <input type="submit"  class="form-control" value="제출">
	        </div>
		</div>
	</form>
</div>
<!-- 사진 카드 -->
<div class="container mt-3 mb-3">
   <div class="row">
      <div class="col-lg-4 col-md-6 col-sm-6 banner">
         <a href="#">
            <div class="centered">서울</div>
            <img alt="seoul" src="img/seoul.jpg">
         </a>
      </div>
      <div class="col-lg-4 col-md-6 col-sm-6 banner">
         <a href="#">
            <div class="centered">제주</div>
            <img alt="jongno" src="img/jeju.jpg">
         </a>
      </div>
      <div class="col-lg-4 col-md-6 col-sm-6 banner">
         <a href="#">
            <div class="centered">인천</div>
            <img alt="incheon" src="img/incheon.jpg">
         </a>
      </div>

      <div class="col-lg-4 col-md-6 col-sm-6 banner">
         <a href="#">
            <div class="centered">대구</div>
            <img alt="daegu" src="img/daegu.jpg">
         </a>
      </div>
      <div class="col-lg-4 col-md-6 col-sm-6 banner">
         <a href="#">
            <div class="centered">경기</div>
            <img alt="gyeonggi" src="img/Gyeonggi.jpg">
         </a>
      </div>
      <div class="col-lg-4 col-md-6 col-sm-6 banner">
         <a href="#">
            <div class="centered">강원</div>
            <img alt="gangwon" src="img/gangwon.jpg">
         </a>
      </div>

      <div class="col-lg-4 col-md-6 col-sm-6 banner">
         <a href="#">
            <div class="centered">경남</div>
            <img alt="gyeongnam" src="img/Gyeongsangnam-do.jpg">
         </a>
      </div>
      <div class="col-lg-4 col-md-6 col-sm-6 banner">
         <a href="#">
            <div class="centered">경북</div>
            <img alt="gyeongbuk" src="img/Gyeongbuk.jpg">
         </a>
      </div>
      <div class="col-lg-4 col-md-6 col-sm-6 banner">
         <a href="#">
            <div class="centered">충남</div>
            <img alt="chungnam" src="img/chungnam.jpg">
         </a>
      </div>

      <div class="col-lg-4 col-md-6 col-sm-6 banner">
         <a href="#">
            <div class="centered">충북</div>
            <img alt="chungbuk" src="img/chungbuk.jpg">
         </a>
      </div>
      <div class="col-lg-4 col-md-6 col-sm-6 banner">
         <a href="#">
            <div class="centered">전북</div>
            <img alt="jeonbuk" src="img/jeonbuk.jpg">
         </a>
      </div>
      <div class="col-lg-4 col-md-6 col-sm-6 banner">
         <a href="#">
            <div class="centered">전남</div>
            <img alt="jeonnam" src="img/jeonnam.jpg">
         </a>
      </div>

      <div class="col-lg-4 col-md-6 col-sm-6 banner">
         <a href="#">
            <div class="centered">부산</div>
            <img alt="Busan" src="img/busan.jpg">
         </a>
      </div>
      <div class="col-lg-4 col-md-6 col-sm-6 banner">
         <a href="#">
            <div class="centered">#</div>
            <img alt="#" src="img/shap1.jpg">
         </a>
      </div>
      <div class="col-lg-4 col-md-6 col-sm-6 banner">
         <a href="#">
            <div class="centered">#</div>
            <img alt="#" src="img/shap2.jpg">
         </a>
      </div>
   </div>
</div>

<footer class="bg-dark">
   
</footer>
<!--jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--popper -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!--javascript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- datepicker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>

<script>
$("#CheckIn").datepicker({
	autoclose : true
});
$("#CheckOut").datepicker({
	autoclose : true
});

$(document).ready(function() {
	$(".menu-toggle").click(function() {
		$("nav").toggleClass("active")
	});
});
</script>
</body>
</html>