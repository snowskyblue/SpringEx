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
    position: -webkit-sticky;
    position: sticky;
    top: 0;
    background-color: #fff;
    border-bottom: 1px solid #e5e5e5;
    z-index: 999;
}
article, aside, details, figcaption, nav, figure, footer, header, hgroup, main, menu, section, summary {
    display: block;
}

.container {
    margin-right: auto;
    margin-left: auto;
    padding-left: 15px;
    padding-right: 15px;
}
div {
    display: block;
}
.row {
    margin-left: -15px;
    margin-right: -15px;
}
.header #logo {
    position: relative;
    line-height: 100px;
}
.col-lg-1, .col-lg-10, .col-lg-11, .col-lg-12, .col-lg-2, .col-lg-3, .col-lg-4, .col-lg-5, .col-lg-6, .col-lg-7, .col-lg-8, .col-lg-9, .col-md-1, .col-md-10, .col-md-11, .col-md-12, .col-md-2, .col-md-3, .col-md-4, .col-md-5, .col-md-6, .col-md-7, .col-md-8, .col-md-9, .col-sm-1, .col-sm-10, .col-sm-11, .col-sm-12, .col-sm-2, .col-sm-3, .col-sm-4, .col-sm-5, .col-sm-6, .col-sm-7, .col-sm-8, .col-sm-9, .col-xs-1, .col-xs-10, .col-xs-11, .col-xs-12, .col-xs-2, .col-xs-3, .col-xs-4, .col-xs-5, .col-xs-6, .col-xs-7, .col-xs-8, .col-xs-9 {
    position: relative;
    min-height: 1px;
    padding-left: 15px;
    padding-right: 15px;
}
figure {
    margin: 0;
}
a {
    cursor: pointer;
    -webkit-tap-highlight-color: rgba(0,0,0,.1);
}
a {
    color: #666;
    text-decoration: none;
}
a {
    background-color: transparent;
}
.header #logo img {
    transition: all .2s ease-in-out;
    width: 300px;
    height: auto;
}
img {
    vertical-align: middle;
}
img {
    border: 0;
}
.visible-lg, .visible-lg-block, .visible-lg-inline, .visible-lg-inline-block, .visible-md, .visible-md-block, .visible-md-inline, .visible-md-inline-block, .visible-print, .visible-print-block, .visible-print-inline, .visible-print-inline-block, .visible-sm, .visible-sm-block, .visible-sm-inline, .visible-sm-inline-block, .visible-xs, .visible-xs-block, .visible-xs-inline, .visible-xs-inline-block {
    display: none!important;
}
.fa {
    display: inline-block;
    font-family: FontAwesome;
    font-style: normal;
    font-weight: 400;
    line-height: 1;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
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
}

.navbar {
    position: relative;
    min-height: 50px;
    margin-bottom: 20px;
    border: 1px solid transparent;
}

.header .top-navbar {
    line-height: 50px;
    border-bottom: 1px solid #e5e5e5;
    margin: 0;
}
.header .search-box {
    width: 40%;
}
.header .link-box, .header .login-box, .header .search-box {
    float: left;
    text-align: center;
}
.header .search-form {
    position: relative;
    padding: 0 20px 0 35px;
}
.header .search-form .search-input {
    border: 0;
    width: 100%;
    line-height: 25px;
}
button, input, select, textarea {
    font-family: inherit;
    font-size: inherit;
    line-height: inherit;
}
button, input, optgroup, select, textarea {
    color: inherit;
    font: inherit;
    margin: 0;
}
.header .search-form .btn-search {
    position: absolute;
    right: 20px;
    top: 18px;
}
.header .link-box, .header .login-box {
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

ol, ul {
    margin-top: 0;
    margin-bottom: 10px;
}
.header .link-box li {
    float: left;
}
.header .link-box li a {
	font-family: 'Eoe_Zno_L';
    display: inline-block;
    color: #000;
    font-size: 13px;
    height: 50px;
    line-height: 50px;
    text-decoration: none;
    font-weight: 700;
}
.header .login-box {
    font-size: 11px;
}
[ng\:cloak], [ng-cloak], [data-ng-cloak], [x-ng-cloak], .ng-cloak, .x-ng-cloak, .ng-hide:not(.ng-hide-animate) {
    display: none !important;
}
.header .login-box a {
    color: #333;
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
.search-menu {
    background-color: #fff;
}
.search-menu, .search-menu.show-search-menu {
    display: none;
}
.search-menu .top-menu {
    height: 70px;
    border-bottom: 1px solid #e5e5e5;
}
.search-menu .top-menu .search-title {
    float: left;
    padding-left: 25px;
    line-height: 70px;
}
.search-menu .top-menu .close-menu-btn {
    float: right;
    width: 70px;
    line-height: 70px;
    text-align: center;
    border-left: 1px solid #e5e5e5;
}
.search-menu .header-search-form {
    padding: 25px 15px;
    border-bottom: 1px solid #f0f0f0;
}
.header-search-form .search-location-wrapper, .header-search-form .search-place-type-wrapper {
    padding-right: 8px;
}
.col-xs-6 {
    width: 50%;
}

button, select {
    text-transform: none;
}
.header-search-form .search-price-wrapper {
    padding-left: 8px;
}
.main-top-banner-wrapper {
    position: relative;
    display: block;
    height: 400px;
    background-color: #000;
    overflow: hidden;
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

.banner a {
	display: block;
    background-color: rgba(0,0,0,.5);
    width: 100%;
    height: 100%;
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
	
	nav.active .search-form {
		padding: 0 20px 0 10px!important;
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



footer {
	 height:300px;
	 width:100%;
}

/*##################################*/
</style>
</head>
<body>
<header id="header" class="header ng-scope">
  <div class="container">
    <div class="row">
      <figure id="logo" class="col-md-6" data-hook="">
        <a href="#">
        	<img src="img/logo.jpg" id="logoimg" alt="stay with me">
        </a>
        <div class="menu-toggle"></div>
      </figure>
      
      <nav class="navbar col-md-6 hidden-xs" id="top-nav-bar">
        <div class="top-navbar row">
          <div class="search-box">
            <form class="search-form ng-pristine ng-valid">
              <input type="text" class="search-input ng-pristine ng-untouched ng-valid" placeholder="Search" ng-model="searchText">
              <input type="image" src="img/search.png" class="btn-search">
            </form>
          </div>
          <div class="link-box">
            <ul class="list-unstyled">
              	<li class="promotion-btn-li"><a href="#">Q&A</a></li>
            	<li class="magazine-btn-li"><a href="#">고객센터</a></li>
            </ul>
          </div>
          <div class="link-box">
            <ul class="list-unstyled">
              	<li class="promotion-btn-li"><a href="#">로그인</a></li>
            	<li class="magazine-btn-li"><a href="#">회원가입</a></li>
            </ul>
          </div>
        </div>
        <div id="main-nav-bar" class="main-navbar row">
          <ul class="list-unstyled">
           	<li class="wish-btn-li"><a href="#">위시리스트</a></li>
            <li class="confirm-btn-li"><a href="#">예약확인</a></li>
            <li class="host-btn-li"><a href="#">호스트</a></li>
            <li class="event-btn-li"><a href="#">쪽지</a></li>
            <li class="booking-btn-li"><a href="#">공지사항</a></li>
          </ul>
        </div>
      </nav>
    </div>
  </div>
</header>
<!-- Carousel -->
<div class="container-fluid">
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
						<option value="1">&nbsp;&nbsp;제주&nbsp;&nbsp;</option>
					   	<option value="2">&nbsp;&nbsp;경상&nbsp;&nbsp;</option>
					   	<option value="3">&nbsp;&nbsp;서울&nbsp;&nbsp;</option>
					    <option value="4">&nbsp;&nbsp;부산&nbsp;&nbsp;</option>
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
            <img alt="#" src="https://d1y1d2o3eynuk0.cloudfront.net/contents/images/201602/44f1e6b5d107c3176d046840d5da2953.jpg">
         </a>
      </div>
      <div class="col-lg-4 col-md-6 col-sm-6 banner">
         <a href="#">
            <div class="centered">#</div>
            <img alt="#" src="https://d1y1d2o3eynuk0.cloudfront.net/contents/images/201602/39c07cc6c8da1b7ab20e0917e976a212.jpg">
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