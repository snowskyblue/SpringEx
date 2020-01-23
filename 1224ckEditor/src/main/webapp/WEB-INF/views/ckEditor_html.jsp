<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width,initial-scale=1.0">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.css">
<link rel="stylesheet" href="assets/content-styles.css" type="text/css">
<title>Insert title here</title>
<!--  
<style>

:root {
	--ck-image-style-spacing: 1.5em;
}
.ck-content .image-style-side {
    max-width: 50%;
    float: right;
    margin-left: var(--ck-image-style-spacing);
}

.ck-content .image.image_resized {
    display: block;
    box-sizing: border-box;    
}

.ck-content .image.image_resized img {
    width: 100%;    
}

.ck-content .image.image_resized > figcaption {
    display: block;
}

</style>
-->

<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/chrome-frame/1/CFInstall.min.js"></script>
<script>CFInstall.check({mode: 'overlay'});</script>
<![endif]-->
</head>
<body>

<h3>CkEditor</h3>
<hr/>
<form>
<!-- toolbar container id non-changable -->
<!-- editor container id non-changable -->
<div id="toolbar-container" style="max-width:50%"></div>
<div id="editor"  style="max-width:50%;min-height:300px;border:1px solid grey;line-height:0.8rem">	
</div>

<textarea id="div1" name="te" style="width:50%;min-height:300px;border:1px solid grey;line-height:0.8rem;display:none">kook</textarea>
</form>
<button onclick="myFunction()">button</button>
<div id="div2" class="ck-content" style="width:50%;min-height:300px;border:1px solid grey;">
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/16.0.0/decoupled-document/ckeditor.js"></script>
<script src="https://ckeditor.com/apps/ckfinder/3.4.5/ckfinder.js"></script>   

<script type="module">
DecoupledEditor
    .create( document.querySelector('#editor'),{    	    	
    	language: 'ko',    	    	
    	ckfinder: {
	   		uploadUrl: 'ckedit' //요청경로	   		
	   	},
	   	toolbar: [ 'ckfinder', 'imageUpload', '|', 'heading', '|', 'bold', 'italic','link', 'bulletedList',
	   		'numberedList', 'blockQuote', '|', 'undo','redo','Outdent','Indent','highlight', 'fontsize',
	   		'fontfamily','insertTable','alignment']			
    })
    /*
    .then(editor  => {
        const toolbarContainer = document.querySelector( '#toolbar-container' );
        toolbarContainer.appendChild( editor.ui.view.toolbar.element );
    } )
    .catch(error => {
        console.error( error );
    } );
    */  
    .then(function(editor) {
    	//window.editorResize = editor;
    	const toolbarContainer = document.querySelector( '#toolbar-container' );
        toolbarContainer.appendChild( editor.ui.view.toolbar.element );        
    });
   // .catch(function(error){
   //   console.error( error );
   // });  
</script>
<script>
function myFunction() {
	//var x = document.getElementById("editor").innerHTML; innerHTML대신 jQuery는 html()
	var x = $("#editor").html();
	alert(x);
	//document.getElementById("div1").innerHTML = x;
	$("#div1").text(x);
	var y = $("#div1").text();
	//$("#div2").html('<!DOCTYPE html><html lang="ko"><head><meta charset="UTF-8" name="viewport" content="width=device-width,initial-scale=1.0"></head><body>' + y + "</body></html>");
	$("#div2").html(y);
	//document.getElementById("div2").innerHTML = y;
}
</script>

</body>
</html>