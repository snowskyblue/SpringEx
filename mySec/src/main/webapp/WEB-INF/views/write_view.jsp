<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width,initial-scale=1.0"> 
<title>write_view</title>
<link type="text/css" rel="stylesheet" href="style/styleSheet.css" />
<style>
th,td {
	border:1px solid black;	
	padding : 5px;
}
table {
	width : 500px;
}
input {
	padding : 10px;
}
</style>
<script src="//code.jquery.com/jquery-latest.min.js">
</script>
<script>
//ajax response처리
$(document).ready(function(){
	$("#frm1").submit(function(event){ //form엘리먼트의 submit이벤트 처리 메서드
		//원래의 submitt기능 비활성화
		event.preventDefault();			
		$.ajax({ //.ajax메서드는 Ajax로 서버에 요청시 사용하는 메서드
			type : $("#frm1").attr("method"),  
			url : $("#frm1").attr("action"),
			data : $("#frm1").serialize(), //data는 서버로 보내는 데이터
			//async   : false, //동기식
			//dataType : "script",
			success : function(data) { //data는 서버에서 받는 데이터
				if(data.search("write-sucess") > -1) { //response데이터에 success문자열이 있나 파악(색인번호)	
					$("#modalPos").load("html/modal.html",function(){
						$("p#mb1").text("게시판 등록 성공");
						$("p#mb2").text("수고 하셨습니다.");
						setTimeout(function(){location.href = "list?pg=1";},3000);
						//location.href = "list?pg=1"; 
					});					
				}
				else {
					$("#modalPos").load("html/modal.html",function(){
						$("p#mb1").text("게시판 등록 실패");
						$("p#mb2").text("다시 등록 하세요");
					});					
				}				
			},
			error : function(data) {
				$("#modalPos").load("html/modal.html",function(){
					$("p#mb1").text("인터넷 접속 실패");
					$("p#mb2").text("조금후 다시 시도하세요");
				});	
			}
		});			
	});	
});
</script>
</head>
<body>

<div class="pageTitle">게시판 등록하기</div>
<div id="modalPos"></div>

<p>
	게시판 등록은 작성자 이름, 제목, 게시판 내용을 작성하여 form 엘리먼트를 이용하여 서버로 보냄
	<ol>
		<li><b>FrontController서브렛으로 보냄 :&nbsp;</b></li>
		<li><b>서버로 보낼시는 POST방식으로 보냄 :&nbsp;</b></li>
		<li><b>DB에 작성 내용 저장후 다시 목록창으로 화면을 변경해줌</b></li>	
		<li><b>Submit는 AJAX의 ajax()메서드로 보내줌</b></li>
		<li><b>성공,실패시 modal창을 이용하여 메세지를 보여줌</b></li>		
	</ol>	
</p>

<h3>게시판 입력창</h3>

<table cellpadding="0" cellspacing="0">
	<form id="frm1" action="write" method="post">
		<tr>
			<td>이름</td>
			<td><input type="text" name="bName" size = "80" placeholder="게시자 이름"></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="bTitle" size = "80" placeholder="게시물 제목"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="bContent" rows="10" cols="82" placeholder="게시판 내용" ></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="AJAX Submit">&nbsp;&nbsp;
			<a href="list?pg=1" target="content">목록보기</a>
			</td>			
		</tr>
	</form>
</table>

</body>
</html>