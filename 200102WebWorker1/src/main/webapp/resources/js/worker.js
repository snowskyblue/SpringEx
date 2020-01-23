/**
 * javascript 그냥 쓰면 됨(태그 필요없음) 
 */
var i = 0;

function timedCount(){
	i = i + 1; //외부변수를 변경 (0.5초 주기로 1씩 증가)
	postMessage(i); //main스레드(html)에 있는 자바스크립트로 파라메터를 전달, message이벤트를 일으킴
	setTimeout("timedCount()", 500); //실행할 함수, 500밀리세컨트 후에 실행
}

timedCount(); //worker thread