<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width,initial-scale=1.0">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="style/styleSheet.css" />
<style>
html,body {
	height : 100%; /*block은 width는 전체 화면 100%이나 height는 내부 엘리먼트가 
	차지 하는 영역만 기본으로 차지 */
}
#iframe1 {
	width : 20%;
	height : 100%;
	display : inline-block;	/*inline성격과 block성격 모두 보유 */
	scrolling : auto;
}
#iframe2 {
	width : 78%;
	height : 100%;
	display : inline-block;	
	scrolling : auto;
}
</style>
<script src="//code.jquery.com/jquery-latest.min.js"></script>
<script>
</script>
</head>
<body>

<!-- iframe은 inline속성과 고정된 기본 크기를 갖음 -->
<iframe id="iframe1" src = "html/menu.html" name="ifr1" ></iframe>
<!-- iframe1에는 menu.html페이지를 보여주고 scroll바는 없앰 -->
<iframe id="iframe2" src="html/home.html" name="content"></iframe>
<!-- iframe2에는 기본으로 home.html을 보여주고 content를 타겟으로 하여 화면 교환 -->

</body>
</html>