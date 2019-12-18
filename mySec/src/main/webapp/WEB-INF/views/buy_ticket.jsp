<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width,initial-scale=1.0"> 
<title>buy ticket</title>
<link type="text/css" rel="stylesheet" href="style/styleSheet.css" />
<style>
</style>
<script src="//code.jquery.com/jquery-latest.min.js">
</script>
<script>
</script>
</head>
<body>

<h3>카드 결제</h3>
<h4>TransactionManager를 이용하여 데이터베이스 처리</h4>

<form action="buy_ticket_card">
	고객 아이디 : <input type="text" name="consumerId" > <br />
	티켓 구매수 : <input type="text" name="amount" > <br />
	<input type="submit" value="구매" > <br />
</form>

</body>
</html>