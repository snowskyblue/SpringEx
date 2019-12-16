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
<title>Insert title here</title>
<style>
.header {
    position: -webkit-sticky;
    position: sticky;
    top: 0;
    background-color: #fff;
    border-bottom: 1px solid #e5e5e5;
    z-index: 999;
}
article, aside, details, figcaption, figure, footer, header, hgroup, main, menu, nav, section, summary {
    display: block;
}
@media (min-width: 768px)
.container {
    width: 750px;
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
@media (min-width: 768px)
.col-sm-3 {
    width: 25%;
}
@media (min-width: 768px)
.col-sm-1, .col-sm-10, .col-sm-11, .col-sm-12, .col-sm-2, .col-sm-3, .col-sm-4, .col-sm-5, .col-sm-6, .col-sm-7, .col-sm-8, .col-sm-9 {
    float: left;
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
    width: 90px;
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
@media (min-width: 768px)
.navbar {
    border-radius: 3px;
}
.navbar {
    position: relative;
    min-height: 50px;
    margin-bottom: 20px;
    border: 1px solid transparent;
}
@media (min-width: 768px)
.col-sm-9 {
    width: 75%;
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
    margin: 0;
}
.list-unstyled {
    padding-left: 0;
    list-style: none;
}
ol, ul {
    margin-top: 0;
    margin-bottom: 10px;
}
.header .link-box li {
    float: left;
    width: 20%;
    text-align: center;
}
.header .link-box li a {
    display: block;
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
    margin: 0 2% 0 3%;
    width: 93%;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
    -webkit-justify-content: space-around;
    -ms-flex-pack: distribute;
    justify-content: space-around;
}
.list-unstyled {
    padding-left: 0;
    list-style: none;
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
</style>
</head>
<body>
<header id="header" class="header ng-scope" ng-class="{'show-search-menu':isShowSearchMenu}">
  <div class="container">
    <div class="row">
      <figure id="logo" class="col-md-6 col-sm-3" data-hook="">
        <a ui-sref="main.list" href="/"><img src="img/play-btn.png" width="74" height="74" alt="stayfolio main"></a>
        <a class="search-bar visible-xs" ui-sref="main.search" href="/search"><i class="fa fa-search"></i></a>
        <a class="menu-bar visible-xs" ng-click="showMobileMenu()"><i class="fa fa-bars"></i></a>
      </figure>
      <nav class="navbar col-md-6 col-sm-9 hidden-xs" id="top-nav-bar">
        <div class="top-navbar row">
          <div class="search-box">
            <form ng-submit="search()" class="search-form ng-pristine ng-valid">
              <input type="text" class="search-input ng-pristine ng-untouched ng-valid" placeholder="Search" ng-model="searchText">
              <input type="image" src="img/play-btn.png" class="btn-search">
            </form>
          </div>
          <div class="link-box">
            <ul class="list-unstyled">
              <li>
                <a href="https://www.facebook.com/stayfolio" target="_blank">
                  <img src="img/play-btn.png" alt="stayfolio facebook">
                </a>
              </li>
              <li>
                <a href="https://instagram.com/stayfolio/" target="_blank">
                  <img src="img/play-btn.png" alt="stayfolio instagram">
                </a>
              </li>
              <li>
                <a href="http://stayfolio.blog.me/" target="_blank">
                  <img src="img/play-btn.png" alt="stayfolio naver">
                </a>
              </li>
              <li>
                <a href="https://brunch.co.kr/@stayfolio#magazines" target="_blank">
                  <img src="img/play-btn.png" alt="stayfolio brunch">
                </a>
              </li>
              <li>
                <a href="https://www.youtube.com/channel/UCyxHiHdFLxmnNxl5435Q0eA" target="_blank">
                  <img src="img/play-btn.png" alt="stayfolio youtube">
                </a>
              </li>
            </ul>
          </div>
          <div class="login-box">
            <div ng-show="isUserSignedIn()" class="ng-hide">
              <a ng-href="https://booking.stayfolio.com/mypage" href="https://booking.stayfolio.com/mypage">MyPage</a>
              /
              <a ui-sref="logout" href="/logout">Logout</a>
            </div>
            <div ng-hide="isUserSignedIn()">
              <a ui-sref="main.login" class="login-btn" href="/login">LOGIN</a>
              or
              <a ui-sref="main.join" class="join-btn" href="/join">REGISTER</a>
            </div>
          </div>
        </div>
        <div id="main-nav-bar" class="main-navbar row">
          <ul class="list-unstyled">
            <li class="promotion-btn-li"><a ng-href="https://booking.stayfolio.com/careby" href="https://booking.stayfolio.com/careby">CARE BY</a></li>
            <li class="magazine-btn-li"><a ui-sref="main.magazines({page: null})" ng-class="{ active: $state.includes('main.magazines') }" href="/magazines">MAGAZINE</a></li>
            <li class="pick-btn-li"><a ui-sref="main.picks({page: null})" ng-class="{ active: $state.includes('main.picks') }" href="/picks">PICK</a></li>
            <li class="event-btn-li"><a ui-sref="main.promotion.list" ng-class="{ active: $state.includes('main.promotion') || $state.is('main.event_list') || $state.is('main.event_detail') || $state.is('main.special.list')}" href="/promotion">EVENT</a></li>
            <li class="funding-btn-li"><a ng-href="https://booking.stayfolio.com/fundings" href="https://booking.stayfolio.com/fundings">FUNDING</a></li>
            <li class="localgoods-btn-li"><a ng-href="https://booking.stayfolio.com" href="https://booking.stayfolio.com"><span class="special-menu">BOOKING</span></a></li>
          </ul>
        </div>
      </nav>
    </div>
  </div>
</header>
<!--jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--popper -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!--javascript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>