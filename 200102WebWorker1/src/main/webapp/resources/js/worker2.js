onmessage = function(evt) {
	var num = evt.data;
	var result = 0;
	for (var i = 1; i <= num; i++){
		result += i;
	} //백만을 입력하면 백만번 돈다(워커 없이 싱글스레드면 이거할동안 뒤의 스크립트는 실행 못됨)
	//자바스크립트로 셋인터벌로 시간을 계속해서 찍어주는 경우, 워커객체가 맡아야 함
	postMessage(result);
}