/**
 * 
 */

/******************************************************************/
/******************************************************************/
/*							Reply 관련							  */
/*																  */
/*						 									      */
/******************************************************************/
/******************************************************************/


//ajax post json 버전 (아래 사이트 참고)
//https://velog.io/@y1andyu/1.VanillaJS-3-AJAX-FormData-dataset
//https://stackoverflow.com/questions/48551345/how-to-send-ajax-post-request-and-receive-back-json-data-in-vanilla-js
//https://krcodeblog.com/blog/595829
//좋아요 버튼 누른 후 작동하는 흐름입니다.

//현재 문제는 jquery를 사용한 ajax 사용시에는 항상 get방식을 썻어서 security 관련 체크를 생각못했음
//생각해보니깐 spring security 때문에 지금 json parse할시 에러가 생기는듯
//<HashMap><data>1</data><cnt>1</cnt></HashMap> 
//검색어:(stackoverflow) Unexpected token < in JSON at position 0     
//해결방안: 이 에러는 개발자모드-네트워크-에서 해당 버튼 클릭시 contentType 확인할 경우 application/json을 설정했음에도 applicaiton/xml로 뜨고있었습니다.
//즉 문제는 백엔드에서 보내주는 JSON 값을 Request값을 받아오는 'ACCEPT'에서 JSON값을 받지 못했기에 계속해서 String으로 받아오는 것이었습니다.
//xhr.setRequestHeader('Content-Type','application/json; charset=UTF-8;');
//xhr.setRequestHeader('Accept','application/json; charset=UTF-8;');
//2개를 같이 사용해주니 해결되었습니다/
//클라이언트단에서 데이터 전송할시에는 항상 network 탭의 response request값을 확인해야 합니다.
//console.log(JSON.parse(xhr.response))를 했을시 String이 아닌 Object로 나와야 JSON 값입니다.
//https://magpienote.tistory.com/37
//https://stackoverflow.com/questions/37269808/react-js-uncaught-in-promise-syntaxerror-unexpected-token-in-json-at-posit
//function thumbs_up(){
//	var xhr = new XMLHttpRequest();
//	xhr.onreadystatechange = function(){
//		if(xhr.readyState === 4){
//			if(xhr.status === 200){
//				var test = JSON.parse(xhr.response);
//				console.log(typeof xhr.response);
//				console.log(test.checkclicked);
//				console.log(test.totallikecount);
//				console.log("test"+test);
//				alert("checkclicked:"+test.checkclicked);
//				alert("testtotallikecount:"+test.totallikecount);
//				if(test.checkclicked == "0"){
//					console.log("registered...");
//					alert("registered...");
//				}else if(test.checkcliked == "1"){
//					console.log("removed...");
//					alert("removed....");
//				}
//			}else{
//				alert("현재 서버에 문제가 있습니다. 이후에 다시 시도하시기 바랍니다.");
//			}
//		}
//	};
//		
//
//	xhr.open('POST'
//			,'/board/like/likecheck'
//			,true);
//	xhr.setRequestHeader('Content-Type','application/json; charset=UTF-8;');
//	xhr.setRequestHeader('Accept','application/json; charset=UTF-8;');
//
//	var data = 	{
//			bno:1,
//			mem_seq:1,
//			likecheck:1
//	}

//	var boardLocation = $('input[name=boardLocation]').val();
//	var bno = $('input[name=bno]').val();
//	var mem_seq=$('input[name=mem_seq]').val();
	
//	xhr.send(JSON.stringify(data));
//	
//}


//검색어:vanilla button this   vanila js에서 버튼 클릭시 해당 버튼의 value를 가져오는방법
//https://stackoverflow.com/questions/48470034/correctly-using-this-to-print-value-of-a-button-inside-a-form-in-vanilla-java
//https://stackoverflow.com/questions/16756048/on-click-get-button-value/49679347
//var status = document.querySelector('button[name=show_hide_rereply_button]');// 이와 같이 할시 중복된 코드 존재시 에러발생Vanilla JS 
//검색어:vanilla append   append 생성할시 TAG생성 한뒤 TAG형식으로 붙여줘야합니다.
//https://stackoverflow.com/questions/46025191/trying-to-append-a-div-to-the-document-using-vanilla-js
//검색어:vanilla aria-hidden  aria-hidden속성을 추가하기위해  rereply_div_button_i.aria-hidden 으로 진행하면 오류나서 setAttribute로 해야합니다.
//https://stackoverflow.com/questions/47661130/how-to-add-aria-hidden-property-to-span-on-focus-change
function origin_hide_reply_list(show_hide_rereply_button){	//댓글에서 아래화살표누르면 대댓글 목록 숨겨짐
	
	
	var status_count = show_hide_rereply_button.value;
	var brno = show_hide_rereply_button.nextElementSibling.value;
	/*alert(show_hide_rereply_button.value);*/
	
	var reply_parent = document.querySelector(".reply"+brno);
	
	const rereply_div = document.createElement('div');
	rereply_div.className='write_reply'
	
	const rereply_div_input = document.createElement('input');
	rereply_div_input.type='text';
	rereply_div_input.value='답댓달기';
	rereply_div_input.className='hide_reply';
	rereply_div_input.onclick='show_reply_box()';
	
	const rereply_div_textarea = document.createElement('textarea');
	rereply_div_textarea.name="reply";
	rereply_div_textarea.className="rereply_textarea";
	rereply_div_textarea.rows="8";
	rereply_div_textarea.cols="80";
	
	const rereply_div_input_parent = document.createElement('input');
	rereply_div_input_parent.type='hidden';
	rereply_div_input_parent.name='parent';
	rereply_div_input_parent.value=brno;
	
	const rereply_div_button = document.createElement('button');
	rereply_div_button.setAttribute("onclick","rereplyform_register(this);");
	rereply_div_button.value = brno;
	rereply_div_button.type = 'button';
	
	const rereply_div_button_i = document.createElement('i');
	rereply_div_button_i.className = 'fa fa-paper-plane';
	rereply_div_button_i.setAttribute("aria-hidden","true");
	
	rereply_div_button.append(rereply_div_button_i);
	
	rereply_div.append(rereply_div_input,rereply_div_textarea,rereply_div_input_parent,rereply_div_button);
	
//	alert(rereply_div.innerHTML);
//	reply_parent.append(rereply_div); for test
	reply_parent.prepend(rereply_div);
//	var rereply_textarea = '<div class="write_reply">'
//			+'<input type="text" value="답댓 달기" class="hide_reply" onclick="show_reply_box()"/>'
//			+'<textarea name="name" rows="8" cols="80" ></textarea>'
//			+'<input type="hidden" name="parent" value="'+brno+'"/>'
//			+'<button onclick="submit_reply"><i class="fa fa-paper-plane" aria-hidden="true"></i></button>'
//			+'</div>';
	
	const reply=document.querySelector(".reply"+status_count);
	const arrow=document.querySelector('.reply_arrow');
	
	if(!reply.style.display){
		reply.style.display='block';
		arrow.innerHTML='<i class="fa fa-chevron-up" aria-hidden="true"></i>';		
	}
	
	if(reply.style.display==''){
		reply.style.display='block';
		arrow.innerHTML='<i class="fa fa-chevron-up" aria-hidden="true"></i>';		
	}
	else if(reply.style.display=='none'){
		reply.style.display='block';
		arrow.innerHTML='<i class="fa fa-chevron-up" aria-hidden="true"></i>';
	}else{
		reply.style.display='none';
		arrow.innerHTML='<i class="fa fa-chevron-down" aria-hidden="true"></i>';
	}
}




// forEach로 이전에 달렸던 댓글들이 모두 생깁니다.
// 1..2..3..4.. 식으로 생깁니다.
// 답댓 input쪽을 눌렀을시, 해당하는 button을 display:block을 보여줌
// 그리고 해당 reregister시 해당글에 해당하는 값을 postmapping

function show_reply_box(hide_reply_input){//가독성을 높이기 위해 댓글창 크기를 최소화시킴. input 클릭 시 댓글 창 크기가 커짐
	var status_count = hide_reply_input.nextElementSibling.value;
	
	

//	documentquerySelector는 클래스 이름지을때 숫자가 앞에 가면 안대서 status_count를 뒤로했습니다.
	const hide_reply=document.querySelector(".rereply_input"+status_count);
	const write_reply=document.querySelector(".write_reply"+status_count);
	const textarea=document.querySelector(".write_reply .rereply_textarea"+status_count);
	const button=document.querySelector(".write_reply .button"+status_count);
	

//	alert(status_count);
//	alert(hide_reply.style.display);
	
//	if(hide_reply.style.display=='none'){//댓글박스가 보인다면
//		hide_reply.style.display='block';
//		write_reply.style.display='none';
//		textarea.style.display='none';
//		button.style.display='none';
//	}else{//댓글박스가 닫혀있다면
//		hide_reply.style.display='none';
//		write_reply.style.display='block';
//		textarea.style.display='block';
//		button.style.display='block';
//	}
	
//	safari라서 안대는줄알았는데 그냥 웹버전, 모바일버전 달라서 안댓음..
	if (window.matchMedia("(min-width: 768px)").matches){// 768px 이상
		if(hide_reply.style.display=='none'){//댓글박스가 보인다면
			hide_reply.style.display='block';
			write_reply.style.display='none';
		}else{//댓글박스가 닫혀있다면
			hide_reply.style.display='none';
			write_reply.style.display='block';
		}
}else{//모바일 버전
		if(hide_reply.style.display=='none'){//댓글박스가 보인다면
			hide_reply.style.display='block';
			write_reply.style.display='none';
			textarea.style.display='none';
			button.style.display='none';
		}else{//댓글박스가 닫혀있다면
			hide_reply.style.display='none';
			write_reply.style.display='block';
			textarea.style.display='block';
			button.style.display='block';
//			console.log(matchMedia("screen and (min-width:769px)".matches));
		}
	}
}


/**
 * 
 */

/******************************************************************/
/******************************************************************/
/*							Front   							  */
/*																  */
/*						 									      */
/******************************************************************/
/******************************************************************/



function copy_url_to_clipboard(){//현재 페이지 url을 클립보드에 복사
	var url = document.getElementById("text_url");
  url.value = window.document.location.href;
	url.select();
	document.execCommand("copy");
	alert("현재 페이지 주소가 복사되었습니다.");
}
function open_chat(){//채팅하기 창을 열어줌
  window.open('chat.html','_blank','width=570,  height=800, toolbar=no, menubar=no, scrollbars=no, resizable=yes');return false;
}
function show_comment_box(){//모바일 버전에서 가독성을 높이기 위해 댓글창 크기를 최소화시킴. input 클릭 시 댓글 창 크기가 커짐
	const hide_comment=document.querySelector(".hide_comment");
	const text=document.querySelector(".write_comment textarea");
	const button=document.querySelector(".write_comment button");
	if(hide_comment.style.display=='none'){//댓글박스가 보인다면
		hide_comment.style.display='block';
		text.style.display='none';
		button.style.display='none'
	}else{//댓글박스가 닫혀있다면
			hide_comment.style.display='none';
			text.style.display='block';
			button.style.display='block';

	}
}
function modify_comment(){//댓글 수정 누르면 해당댓글 수정폼으로 바뀜
	const txt=document.querySelector(".cmt");
	if(txt.disabled==true){
		txt.disabled=false;
		txt.style.outline="1px solid";
		document.querySelector(".edit_cmt button").style.display="block";

			if (window.matchMedia("(min-width: 768px)").matches){// 768px 이상
			txt.style.width="90%";
		}
		else{
			txt.style.width="97%";
			txt.style.marginLeft="2.3%";
		}
	}
}
function submit_comment(){//제출버튼 누르면 수정폼이 사라짐
	const txt=document.querySelector(".cmt");
	if(txt.disabled==false){
		txt.disabled=true;
		txt.style.outline="none";
		txt.style.width="92%";
		document.querySelector(".edit_cmt button").style.display="none";
}
}

//BackEnd로 이동시켰음
//function show_reply_box(){//가독성을 높이기 위해 댓글창 크기를 최소화시킴. input 클릭 시 댓글 창 크기가 커짐
//	const hide_reply=document.querySelector(".hide_reply");
//	const box=document.querySelector(".write_reply");
//	const text=document.querySelector(".write_reply textarea");
//	const button=document.querySelector(".write_reply button");
//
//	if (window.matchMedia("(min-width: 768px)").matches){// 768px 이상
//		if(hide_reply.style.display=='none'){//댓글박스가 보인다면
//			hide_reply.style.display='block';
//			box.style.display='none';
//		}else{//댓글박스가 닫혀있다면
//			hide_reply.style.display='none';
//			box.style.display='block';
//		}
//}else{//모바일 버전
//		if(hide_reply.style.display=='none'){//댓글박스가 보인다면
//			hide_reply.style.display='block';
//			text.style.display='none';
//			button.style.display='none';
//			box.style.backgroundColor="transparent";
//		}else{//댓글박스가 닫혀있다면
//			hide_reply.style.display='none';
//			text.style.display='block';
//			button.style.display='block';
//			box.style.backgroundColor="white";
//			console.log(matchMedia("screen and (min-width:769px)".matches));
//
//		}
//	}
//}
function show_reply(){
	const reply=document.querySelector(".reply");
	if(reply.style.display=='none'){
		reply.style.display='block';
	}else{
		reply.style.display='none';
	}
}
function hide_reply_list(){
	const reply=document.querySelector(".reply");
	const arrow=document.querySelector('.reply_arrow');
	if(reply.style.display==''){
		reply.style.display='block';
		arrow.innerHTML='<i class="fa fa-chevron-up" aria-hidden="true"></i>';
	}
	else if(reply.style.display=='none'){
		reply.style.display='block';
		arrow.innerHTML='<i class="fa fa-chevron-up" aria-hidden="true"></i>';
	}else{
		reply.style.display='none';
		arrow.innerHTML='<i class="fa fa-chevron-down" aria-hidden="true"></i>';
	}
}
/*function click_anywhere(){//외부클릭시 설정창 닫힘
	const a_o_category=document.querySelector(".a_o_category");
	if(a_o_category.style.display=='block'){
		a_o_category.style.display='none';
}*/

window.addEventListener('scroll', () => {//스크롤 다운 시, header shadow 발생
	let scroll_location = document.documentElement.scrollTop; // 현재 스크롤바 위치
	var header = document.getElementById("header");
	if(scroll_location==0){
		header.style.boxShadow='none';
	}else{
		header.style.boxShadow='1px 1px 8px #555555';}
});

