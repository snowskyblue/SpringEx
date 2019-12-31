<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- HomeController RequestMapping
model.addAttribute("ticketInfo", ticketDto);
return "buy_ticket_end";

 -->
buy_ticket_end.jsp 입니다. <br />

${ticketInfo.consumerId } <br />
${ticketInfo.amount } <br />

<form action="AccommodationWrite" method="post">
	<input type="hidden" name="consumerId" value="${ticketInfo.consumerId }"> <br />
	<input type="hidden" name="amount" value="${ticketInfo.amount }"> <br />
	<input type="text" name="secondId"> <br/>
	<input type="submit" value="구매" > <br />
</form>
<a href="/">뒤로</a>

</body>
</html>