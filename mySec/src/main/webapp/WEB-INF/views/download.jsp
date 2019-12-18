<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width,initial-scale=1.0"> 
<title>download</title>
<link type="text/css" rel="stylesheet" href="style/styleSheet.css" />
<style>
</style>
<script src="//code.jquery.com/jquery-latest.min.js">
</script>
<script>
</script> 
</head>
<body>

<h3>다운로드 페이지</h3>
<h4>작성자 : ${author}</h4>
<h4>파일 사이즈 : ${fileSize}</h4>
<h4><a href="download?file_name=${fileName}"> ${fileName} 다운로드 </a></h4>

</body>
</html>