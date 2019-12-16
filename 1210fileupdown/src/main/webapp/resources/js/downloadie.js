// author: Carlos Machado and  Matthew Consterdine
// version: 0.2
// year: 2015 and 2017

const DownloadIE = {
	name: "",
	reference: "",
	Listener: function() {
		if(name == "") {name = reference;}
		window.navigator.msSaveBlob(this.response, name); 
	},
	Handler: function(evt) {
		name = this.getAttribute("download");
		reference = this.getAttribute("href");
		evt.preventDefault();
		var oReq1 = new XMLHttpRequest();
		oReq1.addEventListener("load", DownloadIE.Listener, false);
		oReq1.open("get", this, true);
		oReq1.responseType = 'blob';
		oReq1.send();
	},
	Load: function(event) {
		var items = document.querySelectorAll('a[download], area[download]');
		for(var i = 0; i < items.length; i++) {
			console.log("IE Detected");
			items[i].addEventListener('click', DownloadIE.Handler, false);
		}
	}
}

if(/Trident/ig.test(window.navigator.userAgent)) {
	console.log("IE Detected");
	if(window.addEventListener) { 
		window.addEventListener("load", DownloadIE.Load);
	} else if(window.attachEvent) { 
		window.attachEvent("onload", DownloadIE.Load);
	} else if(window.onLoad) {
		window.onload = DownloadIE.Load;
	}
}