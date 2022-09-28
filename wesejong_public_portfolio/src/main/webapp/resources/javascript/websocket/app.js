/**
검색어:자바스크립트에서 파라미터값 사용
https://gomest.tistory.com/10

 * 
 */

function getParameter(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

window.onload = function(){
	connect();
}

function scroll_to_bottom(){
	var objDiv = document.getElementById("app_chat_list");
	objDiv.scrollTop = objDiv.scrollHeight;
}

var room_uuid = getParameter("chatroom_uuid");
console.log(room_uuid);

var ws = null;
//when url is http
//var url = "ws://localhost:8080/echo-endpoint";
//when url is https
var url = "wss://localhost:8080/echo-endpoint";


function setConnected(connected){
//	document.getElementById('connect').disabled = connected;
//	document.getElementById('disconnect').disabled = !connected;
//	document.getElementById('echo').disabled = !connected;

}

function connect(){
// '/echo-endpoint'라는 이름으로 소켓을 생성합니다.
//	서버쪽 브로커는 WebSocketStompConfiguration의 registerStompEndpoints 함수를 통해서
//	주소를 알아내고 connect를 받습니다.
	var sock = new SockJS("/echo-endpoint");	
	ws = Stomp.over(sock);
//	alert("ws connected button clicked");
	ws.connect({},function(){
		console.log("Connected Stomp!!!!!!");
		setConnected(true);
		
//		/topic은 브로커에서 흐름을 넘기는 prefix일뿐, 뒤에 room_uuid를 구독합니다.
//		https://nobase2dev.tistory.com/25 
//		/topic이냐 /app이냐 차이는 message를 send 할때 차이가 벌어집니다.(subscribe할때라고 착각했엇음)
		ws.subscribe('/topic/'+room_uuid, onMessageReceived);
		
//		스크롤을 최하단으로 이동시키는 방법
		
		
//		ws.subscribe('/topic/echo', onMessageReceived);
//		ws.subscribe('/topic/echo', function(event){
//			
//			console.log("!!!!!!!!!event>>",event);
//			
//		})
	});
}

function disconnect(){
	if(ws != null){
		ws.disconnect();
		ws = null;
	}
	setConnected(false);
}

function echo(){
	if(ws){
		var chatmessage_seq;
		var mem_seq = document.querySelector('input[name=mem_seq]').value;
		var chatroom_seq= document.querySelector('input[name=chatroom_seq]').value;
		var chatmessage = document.getElementById('message').value;
		
		
		
		var chatmessagevo = {
				chatroom_seq : chatroom_seq,
				chatmessage : chatmessage,
				mem_seq : mem_seq
		}
		console.log("echo message: "+message);
//		ws.send('/echo', {}, message);
//		ws.send('/echo', {}, JSON.stringify({message:message}));
//		첫번째 인자는 spring controller mapping("/app"은 spring controller로 보낸다는 stomp prefix 규칙입니다. 즉"/app 뒤가 진짜 mapping주소)
//		@MessageMapping에서 @MessageMapping("/{chatroom_url}")인 이유는 websocketConfiguration에서 /app이 자동으로 spring으로 가도록 설정했습니다.
//		두번째 인자는 서버로 보낼때 추가하고 싶은 stomp 헤더입니다.
//		세번째 인자는 서버로 보낼떄 추가하고 싶은 stomp 바디입니다. 
//		서버컨트롤러에서는 mapping된 함수의 String인자로 Json stringify된 문자열을 받을 수 있습니다.
//		@RequestBody:JSON 값을 받을 파라미터 설정  @ResponseBody:Controller에서 JSON 리턴할것을 알려줌
//		(JSON을 Controller로 인자로 보낼려면 stringify를 사용해야합니다.)
//		ws.send('/app/'+room_uuid, {}, JSON.stringify({mem_seq:mem_seq,chatroom_seq:chatroom_seq,chatmessage:chatmessage}));
		ws.send('/app/'+room_uuid, {}, JSON.stringify(chatmessagevo));

	}else{
//		ws.send(message);
		alert('connection not established, please connect.');
	}
}


function onMessageReceived(payload){
	//payload자체에는 전체 데이터가 함께들어오니, J
	var chatmessagevoJSON = JSON.parse(payload.body);
//	alert(chatmessagevoJSON.chatmessage);
	
	var mem_seq = document.querySelector('input[name=mem_seq]').value;
	
	
	if(chatmessagevoJSON.mem_seq != mem_seq){
		
		var console = document.querySelector('.chat_content ul');
		
		var li_left = document.createElement('li');
		li_left.setAttribute('class','left');
		
		var li_left_span1 = document.createElement('span');
		
		var li_left_span_img = document.createElement('img');
		li_left_span_img.setAttribute('src','../../resources/img/profile.jpg');
		
		li_left_span1.appendChild(li_left_span_img);
		
		var li_left_span2 = document.createElement('span');
		li_left_span2.setAttribute('class','name');
		li_left_span2.appendChild(document.createTextNode("익명"));
		
		var li_left_div = document.createElement('div');
		li_left_div.setAttribute('class','content');
		
		var li_left_div_spancontent = document.createElement('span');
		li_left_div_spancontent.appendChild(document.createTextNode(chatmessagevoJSON.chatmessage));
		
	//	var li_left_div_spanread = document.createElement('span');
	//	li_left_div_spanread.appendChild(document.createTextNode("읽음혹은안읽음"));
		
		var li_left_div_divtime = document.createElement('div');
		li_left_div_divtime.setAttribute('class','time');
	//	li_left_div_divtime.appendChild(document.createTextNode("13:00"));
		var now = new Date();
		var hour = now.getHours();
		hour = hour >= 10 ?  hour : '0' + hour;
		var min = now.getMinutes();
		min = min >= 10 ? min : '0' + min;	
		li_left_div_divtime.appendChild(document.createTextNode(hour+":"+min));
	
		li_left_div.appendChild(li_left_div_spancontent);
	//	li_left_div.appendChild(li_left_div_spanread);
		li_left_div.appendChild(li_left_div_divtime);
		
		
		li_left.appendChild(li_left_span1);
		li_left.appendChild(li_left_span2);
		li_left.appendChild(li_left_div);
		
		console.appendChild(li_left);
		
		
	} else if(chatmessagevoJSON.mem_seq == mem_seq){
		
	
	var console = document.querySelector('.chat_content ul');
	
	var li_right = document.createElement('li');
	li_right.setAttribute('class','right');
	
	var li_right_span1 = document.createElement('span');
	
	var li_right_span_img = document.createElement('img');
	li_right_span_img.setAttribute('src','../../resources/img/profile.jpg');
	
	li_right_span1.appendChild(li_right_span_img);
	
	var li_right_span2 = document.createElement('span');
	li_right_span2.setAttribute('class','name');
	li_right_span2.appendChild(document.createTextNode("나"));
	
	var li_right_div = document.createElement('div');
	li_right_div.setAttribute('class','content');
	
	var li_right_div_spancontent = document.createElement('span');
	li_right_div_spancontent.appendChild(document.createTextNode(chatmessagevoJSON.chatmessage));
	
//	var li_right_div_spanread = document.createElement('span');
//	li_right_div_spanread.appendChild(document.createTextNode("읽음혹은안읽음"));
	
	var li_right_div_divtime = document.createElement('div');
	li_right_div_divtime.setAttribute('class','time');
//	li_right_div_divtime.appendChild(document.createTextNode("13:00"));
	var now = new Date();
	var hour = now.getHours();
	hour = hour >= 10 ?  hour : '0' + hour;
	var min = now.getMinutes();
	min = min >= 10 ? min : '0' + min;	
	li_right_div_divtime.appendChild(document.createTextNode(hour+":"+min));

	li_right_div.appendChild(li_right_div_spancontent);
//	li_right_div.appendChild(li_right_div_spanread);
	li_right_div.appendChild(li_right_div_divtime);
		
	li_right.appendChild(li_right_span1);
	li_right.appendChild(li_right_span2);
	li_right.appendChild(li_right_div);

	console.appendChild(li_right);
	
	
	
	}
	
//	while(console.childNodes.length > 12){
//		console.removeChild(console.firstChild);
//	}
	console.scrollTop = console.scrollHeight;
	
	scroll_to_bottom();
	
}

