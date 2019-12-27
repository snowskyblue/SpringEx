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
<script src="//code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>

<h3>CkEditor</h3>
<hr/>
<!-- The toolbar will be rendered in this container. -->
<div id="toolbar-container" style="width:50%"></div>

<!-- This container will become the editable. -->

<div id="editor"  style="width:50%;min-height:300px;border:1px solid grey;line-height:0.5rem">
    <textarea>textarea영역임</textarea>
</div>
 

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/16.0.0/decoupled-document/ckeditor.js"></script>

<script>
DecoupledEditor
    .create( document.querySelector('#editor'),{
    	removePlugins: ['ImageUpload']
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
    	const toolbarContainer = document.querySelector( '#toolbar-container' );
        toolbarContainer.appendChild( editor.ui.view.toolbar.element );
    });
   // .catch(function(error){
   //   console.error( error );
   // });
  
</script>

</body>
</html>