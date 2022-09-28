/**
 * @license Copyright (c) 2003-2021, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.on('dialogDefinition', function(ev){
    var dialogName = ev.data.name;
    var dialog = ev.data.definition.dialog;
    var dialogDefinition = ev.data.definition;
    
//    txtWidth = dialogDefinition.getContents('Upload').get('txtWidth');

//    dialog.
    
    if(dialogName == 'image'){
        dialog.on('show', function(obj){
            this.selectPage('Upload');  // 업로드 탭으로 시작
        });
       
        dialogDefinition.removeContents('advanced');    //자세히탭 제거
        dialogDefinition.removeContents('Link');    //링크탭 제거
        var infoTab = dialogDefinition.getContents('info'); // info탭을 제거하면 
        //info 탭내에 불필요한 엘리먼트들 제거
        // dialogDefinition.removeContents('info'); 
        
        infoTab.remove('txtAlt');	//대체문자열
//        infoTab.remove('txtWidth');		//너비
//        infoTab.remove('txtHeight');	//높이
        infoTab.remove('txtBorder');	//테두리
        infoTab.remove('txtBorder');	//세로여백
        infoTab.remove('cmbAlign');		//정렬
        infoTab.remove('ratioLock');	//비율유지
        infoTab.remove('browse');	//원래 크기로
        infoTab.remove('txtHSpace');	//세로여백
        infoTab.remove('txtVSpace');	//가로여백
        
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
        		
//        		클래스 연속으로 붙일떄 .을 안썻엇습니다. .을 붙이니 확인가능했습니다.
//        		document.querySelector('.cke_dialog_ui_button.cke_dialog_ui_button_ok').click();
//        		var info_ok_button = 
//        		document.querySelector('#cke_90_uiElement').click();하면 댐
        		
//        		var infoButton = this.getDialog().getContentElement('info', 'ok');
//        		info_ok_button.click();
        }
        
        infoTab.onChange = function(){
        	document.querySelector('.cke_dialog_ui_button.cke_dialog_ui_button_ok').click();
        }
        
        
        
        
        
        
    }

}); 
 	
 	

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	config.uiColor = '#EEEEEE';
//	config.skin = "minimalist";
	config.skin = "moono-lisa";
	config.language = 'ko';
	
//	유튜브 plugin이 안되었던 이유는 Youtube(대문자)로 써야함.
//	https://stackoverflow.com/questions/24867776/install-youtube-plugin-in-ckeditor-with-a-custom-toolbar
	
	config.toolbar = [
		{ name : 'fontname', items:['fontname']},
		{ name : 'fontsize', items:['fontsize']},
		{ name: 'styles', items: [ 'Styles', 'Format', 'Font', 'FontSize' ] },
		{ name: 'basicstyles', items: [ 'Bold']},
		{ name: 'insert', items: [ 'Image'] },
		{ name: 'document', items: [ 'Youtube'] },
		{ name: 'colors', items: [ 'TextColor', 'BGColor' ] },
	];
	
//	{ name: 'links', items: [ 'Link', 'Unlink', 'Anchor' ] } 버튼에 링크를 넣고싶을시 버튼이미지에 ctrl+k 누릅니다.

	config.bottom="none"
	config.font_defaultLabel = '맑은고딕';
	config.font_names="나눔고딕; 맑은고딕; 굴림체; 명조체; 바탕체; 돋움체; 궁서체; Arial/Arial, Helvetica, sans-serif;Comic Sans MS/Comic Sans MS, cursive;Courier New/Courier New, Courier, monospace;Georgia/Georgia, serif;Lucida Sans Unicode/Lucida Sans Unicode, Lucida Grande, sans-serif;Tahoma/Tahoma, Geneva, sans-serif;Times New Roman/Times New Roman, Times, serif;Trebuchet MS/Trebuchet MS, Helvetica, sans-serif;Verdana/Verdana, Geneva, sans-serif";
	config.fontSize_defaultLabel = '12px';
	config.fontSize_sizes = '8/8px;9/9px;10/10px;11/11px;12/12px;14/14px;16/16px;18/18px;20/20px;22/22px;24/24px;26/26px;28/28px;36/36px;48/48px;';
	config.enterMode = CKEDITOR.ENTER_BR; // 엔터모드는 <br/>
	config.shiftEnterMode = CKEDITOR.ENTER_P; // 엔터키 입력시 p태그로 변경
	config.startupFocus = true;
	config.toolbarCanCollapse = false; // 에디터 메뉴 축소/확대 가능 버튼 보이기
	
	config.removePlugins = 'elementspath,resize'; //https://ckeditor.com/old/forums/CKEditor-3.x/Disable-bottom-bar-editor
	
	config.resize_dir = 'both'  //  사이즈 둘 다 조정
	config.resize_minWidth = 200;
	//config.resize_maxWidth = 400;
	config.resize_minHeight = 200;
	config.width='100%';
	config.height=400;
	config.resize_maxHeight = 600;
    // 업로드 설정
//	
    config.filebrowserUploadUrl      = '/upload/imageUploadAction?type=Files',
    config.filebrowserImageUploadUrl = '/upload/imageUploadAction?type=Images',
    config.filebrowserUploadMethod='form'; //파일 오류났을때 alert띄워줌
    config.filebrowserWindowWidth = '640',
    config.filebrowserWindowHeight= '480',
    
    
    config.image_prefillDimensions = false;
	    	
	config.removeButtons = 'Source,Save,NewPage,ExportPdf,Print,Cut,Copy,Paste,PasteText,PasteFromWord,Find,Replace,SelectAll,Scayt,Form,Checkbox,Radio,TextField,Textarea,Select,Button,ImageButton,HiddenField,CopyFormatting,RemoveFormat,BulletedList,BidiLtr,BidiRtl,Language,Format,Styles,Maximize,ShowBlocks,About,CreateDiv,Anchor,Unlink,Flash,PageBreak,Iframe';
	
};







/*         
<textarea class="ckeditor"></textarea>로 사용하면 아래처럼 안해도 가능합니다.

	CKEDITOR.replace('textarea1',{
		filebrowserUploadUrl:'${pageContext.request.contextPath}/upload/imageUploadAction'

	});
	 */
// 	window.parent.CKEDITOR.tools.callFunction(1,"${url}",'submit complete')
// 	{"filename" : "[fileName]", "uploaded" : 1, "url":"url]"}
	
	/* ?${_csrf.parameterName}=${_csrf.token} */
	/* it doesn;t looks like csrf problem 404 error cannot find the file */
	
/*  	CKEDITOR.on('dialogDefinition', function(ev){
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
	});  */
	
