var myWorker;

function initWorker() {
	if(typeof(Worker) != 'undefined') { //worker 지원여부
		if(typeof(myWorker) == 'undefined') { //myWorker가 안만들어져있으면 생성
			myWorker = new Worker('../js/worker.js');
			console.log('[Main]', 'Init Web Worker');
			myWorker.onmessage = function(event) { //메인스레드로부터 myWorker가 메시지를 받으면
				handleMessage(event);
			}
			myWorker.onerror = function(event) {
				 console.log('[Main]', 'Error', event.message, event);
			}
		}
	}
	else {
		console.log("[Main]", "The browser doesn't support web worker");
	}
}

function handleMessage(event) {
	console.log('[Main]', 'Main Thread receives command: ', event.data.cmd, event.data.msg);
	if(event.data.cmd == 'stop') {
		console.log('[Main]', 'Web Worker is already stopped');
	}
}

function startWorker() {
	if(typeof(myWorker) != 'undefined') {
		var arrBuf1 = new ArrayBuffer(1000);
		//원소의 개수가 1000개인 배열()대표적인 transferable object
	    var arrBuf2 = new ArrayBuffer(100000);
	    
	    console.log('[Main]', 'Before Transfering:');
	    console.log('[Main]', 'Length of Array Buffer 1:', arrBuf1.byteLength);
	    console.log('[Main]', 'Length of Array Buffer 2:', arrBuf2.byteLength);
	    
	    myWorker.postMessage({cmd : 'start', buf1 : arrBuf1, buf2 : arrBuf2}, [arrBuf1, arrBuf2]);
	    
	    console.log('[Main]', 'After Transfering:');
	    console.log('[Main]', 'Length of Array Buffer 1:', arrBuf1.byteLength);
	    console.log('[Main]', 'Length of Array Buffer 2:', arrBuf2.byteLength);
	}
	else {
		console.log('[Main]', 'Worker is undefined.');
	}
}

function stopWorker() {
	if(typeof(myWorker) != 'undefined') {
		myWorker.terminate();
	    myWorker = undefined;
	    console.log('[Main]', 'Worker terminated.');  
	}
	else {
		console.log('[Main]', 'Worker is undefined.');
	}
}