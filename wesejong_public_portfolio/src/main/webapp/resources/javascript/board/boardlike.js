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
//https://kkh0977.tistory.com/1042 (ajax/에이젝스) post body json 방식 데이터 전송 및 스프링 서버 api 데이터 확인 방법

function likebtnclicked(){
	var xhr = new XMLHttpRequest();
	
	xhr.open('POST'
			,'/board/like/likebtnclicked'
			,true);
	
	xhr.setRequestHeader('Content-Type','application/json; charset=UTF-8;');
	xhr.setRequestHeader('Accept','application/json; charset=UTF-8;');

	var bno = document.querySelector('input[name="bno"]').value;
//	alert(bno);
	var data = 	{
			"bno" : bno
	};

	xhr.send(JSON.stringify(data));
	
	
	var likebtn = document.querySelector("button[name='likebtn'");
	var like_it_num = document.querySelector('.like_it_num');
	var i_thumbs_up = document.querySelector('.fa-thumbs-o-up');
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			
			
			
			if(xhr.status === 200){
				var result = JSON.parse(xhr.response);
				console.log(typeof xhr.response);
				console.log(result.data);
				console.log(result.checkclicked);
				console.log(result.boardlikecount);

				if(result.data == "1"){
					
					if(result.checkclicked == "1"){
						likebtn.style.backgroundColor = '#c3200e';
						i_thumbs_up.style.color = 'white';
//						alert(result.boardlikecount);
						like_it_num.innerHTML = result.boardlikecount;
						like_it_num.style.color = 'white';
					}
					else if(result.checkclicked == "0"){
						likebtn.style.backgroundColor = 'white';
						i_thumbs_up.style.color = '#c3200e';
						like_it_num.innerHTML = result.boardlikecount;
						like_it_num.style.color = 'black';
					}
					
				}
			}else{
				alert("현재 서버에 문제가 있습니다. 이후에 다시 시도하시기 바랍니다.");
			}

		}
	};
		
	
}

function dislikebtnclicked(){
	var xhr = new XMLHttpRequest();
	
	xhr.open('POST'
			,'/board/dislike/dislikebtnclicked'
			,true);
	
	xhr.setRequestHeader('Content-Type','application/json; charset=UTF-8;');
	xhr.setRequestHeader('Accept','application/json; charset=UTF-8;');

	var bno = document.querySelector('input[name="bno"]').value;
//	alert(bno);
	var data = 	{
			"bno" : bno
	};

	xhr.send(JSON.stringify(data));
	
	
	var dislikebtn = document.querySelector("button[name='dislikebtn'");
	var dislike_it_num = document.querySelector('.hate_it button .like_it_num');
	var i_thumbs_up = document.querySelector('.hate_it button .fa-thumbs-o-up');
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			
			
			
			if(xhr.status === 200){
				var result = JSON.parse(xhr.response);
				console.log(typeof xhr.response);
				console.log(result.data);
				console.log(result.checkclicked);
				console.log(result.boardlikecount);

				if(result.data == "1"){
					
					if(result.checkclicked == "1"){
						dislikebtn.style.backgroundColor = '#283598';
						i_thumbs_up.style.color = 'white';
//						alert(result.boardlikecount);
						dislike_it_num.innerHTML = result.boarddislikecount;
						dislike_it_num.style.color = 'white';
					}
					else if(result.checkclicked == "0"){
						dislikebtn.style.backgroundColor = 'white';
						i_thumbs_up.style.color = 'blue';
						dislike_it_num.innerHTML = result.boarddislikecount;
						dislike_it_num.style.color = 'black';
					}
					
				}
			}else{
				alert("현재 서버에 문제가 있습니다. 이후에 다시 시도하시기 바랍니다.");
			}

		}
	};
		
	
}

