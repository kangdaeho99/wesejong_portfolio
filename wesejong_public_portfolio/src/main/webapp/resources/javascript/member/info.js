/**
 * 
 */

/******************************************************************/
/******************************************************************/
/*							BackEnd								  */
/*																  */
/*						 									      */
/******************************************************************/
/******************************************************************/

var is_mem_nickname_duplication_check = true;
var is_mem_password_confirm_check = false;


var is_edit_pw_button_clicked = false;

function mypage_validation(){	
//	만약 비밀번호 변경하기를 눌렀다면,
	if(is_edit_pw_button_clicked == true){
		if(document.querySelector('.nickname').length==0) {
			alert('변경할 닉네임을 입력해주세요.'); return false;
		} else if(document.querySelector('#origin_mem_password').length==0) {
			alert('기존비밀번호를 입력하세요.'); return false;
		} else if(document.querySelector('#mem_password').length==0) {
			alert('변경힐 비밀번호를 입력하세요.'); return false;
		} else if(document.querySelector('#cor_mem_password').length==0) {
			alert('비밀번호 확인을 입력하세요.'); return false;
		} else if(document.querySelector('#mem_password').value != document.querySelector('#cor_mem_password').value) {
			alert('비밀번호를 일치하게 입력하세요.'); return false;
		} else if(check_pw() == false){
			alert('비밀번호 조건을 지켜주세요.'); return false;
		} else if(is_mem_nickname_duplication_check == false){
			alert('닉네임 중복체크를 하시기 바랍니다.(익명으로 사용가능합니다.)'); return false;
		} else if(is_mem_password_confirm_check == false){
			alert('변경할 비밀번호를 정확히 입력하세요.'); return false;
		} else{
			return true;
		}
	}
//	만약 비밀번호 변경하기를 안눌렀다면
	else if(is_edit_pw_button_clicked == false){
		if(document.querySelector('.nickname').length==0) {
			alert('변경할 닉네임을 입력해주세요.'); return false;
		} else if(is_mem_nickname_duplication_check == false){
			alert('닉네임 중복체크를 하시기 바랍니다.(익명으로 사용가능합니다.)'); return false;
		} else{
			document.querySelector('#mem_password').value = null;
			return true;
		}
	}
	
}

function check_pw(){//비밀번호 영문 숫자 검사
	  var pw = document.getElementById('mem_password').value;
	  var pt = /[a-zA-Z]/;
	  var pt2=/[0-9]/;
	  if(!pt.test(pw)||!pt2.test(pw)||pw.length<4||pw.length>12){
	    document.getElementById('pw_txt').innerHTML = "영문+숫자를 4자리 이상 12자리 이하로 입력하세요";
	    return false;
	  }
	  else{
	    document.getElementById('pw_txt').innerHTML = "";
	    return true;
	  }
}

function mypageform_submit(){
	
//	유효성검사시 false, true 값 확인
	if(mypage_validation()){
		alert("hello");
		document.mypageform.action="/member/mypage/modify";
		document.mypageform.method = 'post';
		document.mypageform.submit();		
	}
	

}


function mem_nickname_duplication_check(){
	is_mem_nickname_duplication_check = false;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			if(xhr.status === 200){
				console.log(xhr.response);
				if(xhr.response == '-1'){
					document.getElementById('nickname_txt').style.color = "#c3002e";
					document.getElementById('nickname_txt').innerHTML="이미 사용중인 닉네임입니다.";
					is_mem_nickname_duplication_check = false;
				} else if(xhr.response == '99'){
					document.getElementById('nickname_txt').style.color = "#c3002e";
					document.getElementById('nickname_txt').innerHTML="닉네임 '익명'은 중복처리 없이 누구나 사용가능합니다.";
					is_mem_nickname_duplication_check = true;
				} else if(xhr.response == '0'){
					document.getElementById('nickname_txt').style.color = "green";
					document.getElementById('nickname_txt').innerHTML="사용가능한 닉네임입니다.";
					is_mem_nickname_duplication_check = true;
				} 			
			}else{
				alert("현재 서버에 문제가 있습니다. 이후에 다시 시도하시기 바랍니다.");
//				alert("현재 서버에 문제가 있습니다. 이후에 다시 시도하시기 바랍니다.");
			}
		}
	};
	
	var mem_nickname = document.getElementById('mem_nickname').value;
	//요청을 보낼 방식, 주소, 비동기 여부 설정
	xhr.open('GET'
			,'/member/mem_nickname_duplication_check?mem_nickname='+mem_nickname		
//			,false);
			,true); //	동기 방식을 통해 비동기의 오류발생가능성 없애기
	
    // send method가 호출될 때 XMLHttpRequest객체가 통신을 시작하게 된다
    // 데이터는 문자열로 raw하게 날라가므로 반드시 본인이 타입에 맞게 인코딩 해야함 ex) xhr.send(JSON.parse(data));
	xhr.send();
}


//https://www.zerocho.com/category/HTML&DOM/post/594bc4e9991b0e0018fff5ed
//xhr ajax post 사용방법 자세하게 나와있습니다.
function mem_password_confirm_check(){
	is_mem_password_confirm_check = false;
	

	var origin_mem_password = document.getElementById('origin_mem_password').value;
//	JSON 타입으로 보낼시
	var data = {
		mem_password : origin_mem_password
	};
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			if(xhr.status === 200){
				console.log(xhr.response);
				if(xhr.response == '-1'){
					is_mem_password_confirm_check = false;
					alert('패스워드가 옳지 않습니다.');
					
				} else if(xhr.response == '1'){
					is_mem_password_confirm_check = true;
					alert('변경할 패스워드를 입력하세요.');
					edit_pw();
				}
			}else{
				alert("현재 서버에 문제가 있습니다. 이후에 다시 시도하시기 바랍니다.");
			}
		}
	};
	
//	var mem_password = document.getElementById('mem_password').value;
	xhr.open('post'
			,'/member/mypage/mem_password_confirm_check'
			,true);
	xhr.setRequestHeader('Content-Type', 'application/json'); //컨텐츠 타입을 JSON으로 합니다.
	xhr.send(JSON.stringify(data));
			
}



/******************************************************************/
/******************************************************************/
/*							Front								  */
/*															      */
/******************************************************************/
/******************************************************************/
function edit_pw(){
//	is_mem_password_confirm_check = false;
	document.querySelector('#mem_password').disabled=false;
	document.querySelector('#cor_mem_password').disabled=false;
	is_edit_pw_button_clicked = true;
	document.querySelector(".hidden_profile").style.display="inline-block";
}
function loadFile(input) {
    var file = input.files[0];
    var newImage = document.querySelector('.profile_img');
    newImage.src = URL.createObjectURL(file);
    newImage.style.visibility = "visible";
    newImage.style.objectFit = "contain";
};
function submit_profile(){
	  if(document.querySelector('.nickname').length==0) alert('변경할 닉네임을 입력해주세요.');
	  else if(document.querySelector('.info_list .pw').value=="") alert('기존 비밀번호를 확인해주세요.');
	  else if(document.querySelector('#mem_password').value=="") alert('변경힐 비밀번호를 입력하세요.');
	  else if(document.querySelector('#cor_mem_password').value=="") alert('비밀번호 확인을 입력하세요.');
}

function nick_length_test(){//아이디 길이 제한
  var nick=document.querySelector('.nickname').value;
  is_mem_nickname_duplication_check = false;
  if(nick.length<2||nick.length>12){
	  is_mem_nickname_duplication_check = false;
	  document.getElementById('nickname_txt').innerHTML="닉네임을 2자리 이상 12자리 이하로 입력하세요.";
  } else{
	  document.getElementById('nickname_txt').innerHTML="";
	  mem_nickname_duplication_check();
    
  }
}








/******************************************************************/
/******************************************************************/
/*					   Secession Front & BackEnd				  */
/*															      */
/******************************************************************/
/******************************************************************/

var is_secession_mem_password_check = false;

function open_secession(){//탈퇴하기 창을 열어줌
//  window.open('secession.html','_blank','width=570,  height=300, toolbar=no, menubar=no, scrollbars=no, resizable=yes');return false;alert('g');
  window.open('/member/secession','_blank','width=570,  height=300, toolbar=no, menubar=no, scrollbars=no, resizable=yes');return false;alert('g');
}
function secession_cb(){//탈퇴에 동의하는지 확인
	var check= document.getElementById('scb').checked;
	if(!check) {
		alert('안내사항에 동의해주세요.'); return false;
	} else if(document.querySelector('#pw').value.length<=0){
		alert('패스워드를 입력하세요.'); return false;
	}
//	alert('secession_cb 성공');
	return true;

}


//이상하게 xMLHttpRequest xhr ajax에서 return false 값을 통해 진행할려고하였는데 진행불가
//https://animal-park.tistory.com/193 (ajax로 return 사용할려고할때할시)
//위의 방법도 결국에는 함수의 실행속도가 다르기에 안댓음.
//그냥 onkeyup에 넣고서 진행했습니다.

function secession_mem_password_check(){
	is_secession_mem_password_check = false;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			if(xhr.status === 200){
				console.log(xhr.response);
				if(xhr.response == '-1'){
					
//					alert('패스워드가 일치하지 않습니다.');
					is_secession_mem_password_check = false;
				} else if(xhr.response == '1'){
//					alert('secession_mem_password_check 성공');
					is_secession_mem_password_check = true;
				}
			}else{
				alert("현재 서버에 문제가 있습니다. 이후에 다시 시도하시기 바랍니다.");
				is_secession_mem_password_check = false;
			}
		}
	};
	var secessionmem_mem_password = document.getElementById('pw').value;
	var data = {
		mem_password : secessionmem_mem_password
	};
	
	xhr.open('post'
			,'/member/secession_mem_password_check'
			,true);
	xhr.setRequestHeader('Content-Type', 'application/json'); //컨텐츠 타입을 JSON으로 합니다.
	xhr.send(JSON.stringify(data));
	
}


function secessionform_submit(){
	if(secession_cb() == false || is_secession_mem_password_check == false){
		return false;
	}else{
		document.secessionform.action="/member/secession";
		document.secessionform.method = 'post';
		document.secessionform.submit();		
	}
}
