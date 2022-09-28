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
//document.querySelector('input[name=meetmatchteammate_mem_userid]').nextSibling.nextSibling.style.display = 'flex';

var is_mem_userid_duplication_check;

function mem_userid_duplication_check(input_meetmatchteammate_mem_userid){
	//XMLHttpRequest 객체 생성
//	alert(input_meetmatchteammate_mem_userid.value);
	var xhr = new XMLHttpRequest();
	
	if(input_meetmatchteammate_mem_userid.value.length == 0){
		input_meetmatchteammate_mem_userid.nextSibling.nextSibling.setAttribute('class','fa-solid fa-x');
	}
	
	// onreadystatechange는 서버와의 통신이 끝났을 때 호출 됨
	// xhr.open 보다 위에 있어야합니다.	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			if(xhr.status === 200){
				console.log(xhr.response);
								
//				아이디가 존재할시에 입니다.(여기서는 존재할때만 적용가능합니다.)
				if(xhr.response == '-1'){
					input_meetmatchteammate_mem_userid.nextSibling.nextSibling.style.display = 'flex';
					input_meetmatchteammate_mem_userid.nextSibling.nextSibling.setAttribute('class','fa-solid fa-check');
					is_mem_userid_duplication_check = true;
				} 
//				아이디가 존재하지 않을시 입니다.(존재하지 않아, 등록 불가능합니다.)
				else if(xhr.response == '0'){
					input_meetmatchteammate_mem_userid.nextSibling.nextSibling.style.display = 'flex';
					input_meetmatchteammate_mem_userid.nextSibling.nextSibling.setAttribute('class','fa-solid fa-x');
					is_mem_userid_duplication_check = false;
				}			
			}else{
				alert("현재 서버에 문제가 있습니다. 이후에 다시 시도하시기 바랍니다.");
			}
		}
	};

	
	
	var mem_userid = input_meetmatchteammate_mem_userid.value;
	//요청을 보낼 방식, 주소, 비동기 여부 설정
	xhr.open('GET'
			,'/member/mem_userid_duplication_check?mem_userid='+mem_userid		
//			,false);
			,true); //	동기 방식을 통해 비동기의 오류발생가능성 없애기
	
    // send method가 호출될 때 XMLHttpRequest객체가 통신을 시작하게 된다
    // 데이터는 문자열로 raw하게 날라가므로 반드시 본인이 타입에 맞게 인코딩 해야함 ex) xhr.send(JSON.parse(data));
	xhr.send();
	
}





/******************************************************************/
/******************************************************************/
/*							Front								  */
/*															      */
/******************************************************************/
/******************************************************************/













function collect_personal() {//개인정보 제공 동의
  if (document.querySelector('.inrow .agree').checked) {
    document.querySelector(".turn_next").style.display = "block"
  }
}
function select_personnel() {
  const selection = document.querySelector('.personnel');
  console.log(selection.options[selection.selectedIndex].value);
  const personnel = selection.options[selection.selectedIndex].value;
  var last = 1;
  let second = document.querySelector('.chk2').style;
  let third = document.querySelector('.chk3').style;
  let fourth = document.querySelector('.chk4').style;
  console.log(last);
  if (personnel == '1') {
    second.display = 'none';
    third.display = 'none';
    fourth.display = 'none';
  }
  else if (personnel == 2) {
    second.display = 'flex';
    third.display = 'none';
    fourth.display = 'none';
    /* console.log(last);
     let inrow=document.createElement("div");
     let p = document.createElement("input");
     let chk=document.createElement("i");
     chk.setAttribute("class","fa-solid fa-check");
     p.style.margin="5px";
     document.querySelector('.info').appendChild(p);
     inrow.appendChild(p);
     inrow.appendChild(chk);*/
  }
  else if (personnel == 4) {
    second.display = 'flex';
    third.display = 'flex';
    fourth.display = 'flex';
  }

}

//function mem_userid_validiation_check(){
//	  var select = document.querySelector('.meetmatchpersonnelmanage_personnel');
//	  var value = select.options[select.selectedIndex].value;
//	  var input_array= new Array();
//	  
//	  alert(value);
//	  var i;

//	 for(var i=0;i<personnelInputTag_start-1;i++){	
//		  input_array.push(document.querySelectorAll('input[name=meetmatchteammate_mem_userid]')[i].value);
//		  alert(document.querySelectorAll('input[name=meetmatchteammate_mem_userid]')[i].value);
//	  }
//	  
//	  for(var i=0;i<personnelInputTag_start-1;i++){
//		  for(var j=i+1;j<personnelInputTag_start-1;j++){
//			  
//			  if(input_array[i] ==  input_array[j]){
//				  alert('error');
//				  return false;
//			  }
//			  
//		  }
//	  }
//}

///////라디오 방식으로 할려고했지만 안되서 그냥 mm_submit에서 다처리했습니다.
//function meetmatchteam_gender_radio_btn_check(){
//	var radio_btn = document.querySelectorAll('input[name="meetmatchteam_gender"]');
//	var selected = null;
////	alert(typeof radio_btn[0].checked);
////	alert(typeof radio_btn[1].checked);
//	for(var i=0;radio_btn.length;i++){
//		if(radio_btn[i].checked){
//			selected = radio_btn[i].value;
//		}
//	}
//	
//	if(selected == null){
//		return false;
//	}
//	
//}


//개인 정보 제공 동의, 성별 선택 없으면 alert
function mm_submit() {
	
	
  if (!document.querySelector('#meetmatchteam_gender_male').checked && !document.querySelector('#meetmatchteam_gender_female').checked){
	alert('성별을 선택해주세요.');
	return false;
  }
  else if (!document.querySelector('.inrow .agree').checked) {
	  alert('개인 정보 제공 동의에 체크해주세요.');
	  return false;
  }
  //원래 화면단에서 똑같은 아이디 여러개 입력하는것 처리할려했지만, 서버단에서 진행합니다.
  else if(is_mem_userid_duplication_check == false){
	  alert('팀원아이디 입력이 올바르게 되지 않았습니다.');
	  return false;
  }
  

  
 
}
