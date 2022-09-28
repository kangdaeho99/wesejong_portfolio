<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="#">
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/../../resources/ckeditor/ckeditor.js"></script>
<script>
</script>
</head>
<body>
<%=request.getRealPath("/") %>+"/src/main/webapp/resources/upload"
	<textarea id="textarea1" placeholder="내용입니다." autofocus required wrap="hard" rows="30" cols="80" name="content"></textarea>
	<script>
	CKEDITOR.replace('textarea1',{
		filebrowserUploadUrl:'${pageContext.request.contextPath}/upload/imageUploadAction'			
	});
	
// 	window.parent.CKEDITOR.tools.callFunction(1,"${url}",'submit complete')
// 	{"filename" : "[fileName]", "uploaded" : 1, "url":"url]"}
	
	/* ?${_csrf.parameterName}=${_csrf.token} */
	/* it doesn;t looks like csrf problem 404 error cannot find the file */
	
 	CKEDITOR.on('dialogDefinition', function(ev){
	    var dialogName = ev.data.name;
	    var dialog = ev.data.definition.dialog;
	    var dialogDefinition = ev.data.definition;
	    if(dialogName == 'image'){
	        dialog.on('show', function(obj){
	            this.selectPage('Upload');  // 업로드 탭으로 시작
	        });

	        
	        
	        dialogDefinition.removeContents('advanced');    //자세히탭 제거
	        dialogDefinition.removeContents('Link');    //링크탭 제거
	        var infoTab = dialogDefinition.getContents('info'); // info탭을 제거하면 
	        //info 탭내에 불필요한 엘리먼트들 제거
	        // dialogDefinition.removeContents('info'); 
	        
	        
	        //Get a reference to the "upload" tab
	        var uploadTab = dialogDefinition.getContents('Upload');
	        //Get the "Chhose file" input definition
	        var fileChooserDef = uploadTab.get('upload');
	        //Get the "Send it to the Server" button definition, and hide that button
	        var sendButtonDef = uploadTab.get('uploadButton');
	        sendButtonDef.hidden = true;
	        
	        //When a file is choosen, automicatly send it to the server
	        fileChooserDef.onChange = function(){
	        		//Get the "Send it to the Server button Element.
	        		var sendButton = this.getDialog().getContentElement('Upload', 'uploadButton');
	        		//simulate clicking that button.
	        		sendButton.click();
	        }
	    }
	}); 
	
	
	</script>
</body>
</html>