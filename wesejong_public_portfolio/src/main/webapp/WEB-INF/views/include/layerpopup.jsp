<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
//쿠키참고사이트(오늘하루 보지않기) : https://ktko.tistory.com/109 
///javascript site load 되면
document.addEventListener("DOMContentLoaded", function(event){
	if(getCookie("popupYN") != "N"){
		show_layerpopup();
	}
});

//레이어팝업을 '하루동안 보지않기'를 누를때 작동하는 함수입니다.
function close_for_days_layerpopup(){
	close_layerpopup();	
	setCookie("popupYN","N",1);
}

//cookie를 가져오는 함수입니다.
function getCookie(name){
	var cookie = document.cookie;
	
	if(document.cookie != ""){
		var cookie_array = cookie.split("; ");
		for(var index in cookie_array){
			var cookie_name = cookie_array[index].split("=");
			
			if(cookie_name[0] == "popupYN"){
				return cookie_name[1];
			}
		}
	}
	return;
}

//cookie를 설정하는 함수입니다.
function setCookie(name, value, expiredays){
	var date = new Date();
	date.setDate(date.getDate() + expiredays);
	document.cookie = escape(name) + "=" + escape(value) + "; expires=" + date.toUTCString();
}

//레이어팝업을 보여주는 함수입니다.
function show_layerpopup(){
	document.querySelector('#layer').style.display = 'block';
}

//레이어팝업을 닫는 함수입니다.
function close_layerpopup(){	
	document.querySelector('#layer').style.display = 'none';
}

</script>

<style>
#layer {display:none;}
#layer {position: fixed; left:10%; top:10%; width:600px; height:80%; border:10px solid #dceff7; box-shadow: 3px 3px 10px rgba(0,0,0,0,4); z-index:99999999999;}
#layer img {width:100%; height:100%; display:block; font-size:0; line-height:0;}
/* #layer div {width:100%; display:block; height:300px;} */
#layer .close {position: absolute; right:20px; bottom:10px; background: #0093bd; padding:1px 6px; color:#fff;}
#layer .cookieclose {position: absolute; left:10px; bottom:10px; background: white; font-size:5px; padding:1px 6px; color:black;} 

#layer .cookieclose:hover,.close:hover {text-decoration:underline;}


 @media (max-width:768px) and (min-width:320px){
 #layer {position: fixed; left:2%; top:5%; width:90%; height:70%; border:10px solid #dceff7; box-shadow: 3px 3px 10px rgba(0,0,0,0,4); z-index:99999999999;}

 }

</style>

<div id="layer">
	<!-- <img src="http://placehold.it/150x150"/> -->
	<a href="/meetmatch/event/explanation"><img src="../../../resources/img/mm_poster.png" alt=""/></a>
	
	<a href="#" class="cookieclose" onclick="close_for_days_layerpopup();">하루동안 보지않기</a>
	<a href="#" class="close" onclick="close_layerpopup();">Close</a>

</div>
