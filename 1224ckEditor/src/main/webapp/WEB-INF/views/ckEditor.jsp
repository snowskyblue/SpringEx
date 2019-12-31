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
<title>Insert title here</title>
<style>
/*사진 좌우로 글씨를 쓸수 있게 해줌 근디 없어도 되는거같은디......*/
:root {
	--ck-image-style-spacing: 1.5em;
}

.ck-content {
	& .image-style-side	{
		max-width: 50%;
		float: right;
		margin-left: var(--ck-image-style-spacing);
	}	
}
/*사진 좌우로 글씨를 쓸수 있게 해줌*/
</style>
</head>
<body>

<h3>CkEditor with Image Uploading(ck editor중에 제일 고급)</h3>
<hr/>
<!-- The toolbar will be rendered in this container. -->
<div id="toolbar-container" style="max-width:50%"></div>

<form>
<!-- This container will become the editable. -->
<!-- max-width 는 rwd?? 됨 , 툴바 부문하고 너비를 맞춰줌-->
<div id="editor"  style="max-width:50%;min-height:300px;border:1px solid grey;line-height:0.5rem">
	<textarea name="ta">
		text area
	</textarea>
</div>
</form>
 

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.js"></script>
<!-- ckEditor DecoupledEditor  -->
<script src="https://cdn.ckeditor.com/ckeditor5/16.0.0/decoupled-document/ckeditor.js"></script>
<script src="https://ckeditor.com/apps/ckfinder/3.4.5/ckfinder.js"></script>


<script type="module">
DecoupledEditor
    .create( document.querySelector('#editor'),{
    	//removePlugins: ['ImageUpload'],
    	language: 'ko',
    	ckfinder: {
	   		 uploadUrl: 'ckedit' //요청경로
	   	},
	   	toolbar: [ 'ckfinder', 'imageUpload', '|', 'heading', '|', 'bold', 'italic','link', 'bulletedList',
	   		'numberedList', 'blockQuote', '|', 'undo','redo','Outdent','Indent','highlight', 'fontsize',
	   		'fontfamily','insertTable','alignment']	
    })
    /* 화살표는 람다식(이클립스 버그 나서 아래에 일반함수식으로 대신했음-작동은 잘 됨)
    .then(editor  => {
        const toolbarContainer = document.querySelector( '#toolbar-container' );
        toolbarContainer.appendChild( editor.ui.view.toolbar.element );
    } )
    .catch(error => {
        console.error( error );
    } );
    */  
    .then(function(editor) {
    	const toolbarContainer = document.querySelector( '#toolbar-container' );
        toolbarContainer.appendChild( editor.ui.view.toolbar.element );
    });
   // .catch(function(error){
   //   console.error( error );
   // });
  
</script>

</body>
</html>