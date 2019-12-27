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
<!-- 관리자 페이지에 csv,pdf 넣을것-->
<div class="container">
	<h1>jQuery TableHTMLExport Plugin Examples</h1>
	<table id="example" class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">#</th> <!-- scope는 시각장애인을 위한 읽는 방식 -->
				<th scope="col">First</th>
				<th scope="col">Last</th>
				<th scope="col">Handle</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">1</th>
      			<td>Mark</td>
      			<td>Otto</td>
      			<td>@mdo</td>				
			</tr>
			<tr>
				<th scope="row">2</th>
      			<td>Jacob</td>
      			<td>Thornton</td>
      			<td>@fat</td>
			</tr>
		</tbody>
	</table>
	<p class="lead"> <!-- lead는 BS4의 클래스로 p의 글자크기와 라인 간격을 증가시킴 -->
		<button id="json" class="btn btn-primary">TO JASON</button>
		<button id="csv" class="btn btn-info">TO CSV</button>
		<button id="pdf" class="btn btn-danger">TO PDF</button>
	</p>
</div>

<!--jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--popper -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!--javascript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


<!-- (pdf 로 변환 convert)위해서 api라이브러리 추가 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.2.11/jspdf.plugin.autotable.min.js"></script>
<!-- cnd이 아닌 다운로드 방식의 java script 링크 (제일 밑으로)-->
<script src="js/tableHTMLExport.js"></script>

<!-- jQuery -->
<script>
$(document).ready(function(){
	/*.click()이 아닌 .on("이벤트종류", 할일 함수)을 썼음*/
	$("#json").on("click", function(){ //json객체는 문자열(쓸일 없음)
		$("#example").tableHTMLExport({		//파라메터로 객체형 씀
			type:'json',
			filename:'sample.json' 
		});
	});
	$("#csv").on("click", function(){
		$("#example").tableHTMLExport({		//Comma Seperated Value(엑셀로 열리지만 원래는 그냥 컴마로 구분된 문자열??) - 엑셀파일로 주기때문에 관리자 페이지에서 씀
			type:'csv',				//생성될 파일 유형
			filename:'sample.csv' //생성될 파일 이름
		});
	});
	$("#pdf").on("click", function(){
		$("#example").tableHTMLExport({		//파라메터로 객체형 씀
			type:'pdf',
			filename:'sample.pdf'
		});
	});
});
</script>

</body>
</html>