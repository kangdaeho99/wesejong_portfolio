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

var room_id = getParameter("chatroom_id");
console.log(room_id);

var ws = null;
var url = "ws://localhost:8080/echo-endpoint";


function setConnected(connected){
	document.getElementById('connect').disabled = connected;
	document.getElementById('disconnect').disabled = !connected;
	document.getElementById('echo').disabled = !connected;
}

function connect(){
// '/echo-endpoint'라는 이름으로 소켓을 생성합니다.
//	서버쪽 브로커는 WebSocketStompConfiguration의 registerStompEndpoints 함수를 통해서
//	주소를 알아내고 connect를 받습니다.
	var sock = new SockJS("/echo-endpoint");	
	ws = Stomp.over(sock);
	alert("ws connected button clicked");
	ws.connect({},function(){
		console.log("Connected Stomp!!!!!!");
		setConnected(true);
		
//		/topic은 브로커에서 흐름을 넘기는 prefix일뿐, 뒤에 room_id를 구독합니다.
//		https://nobase2dev.tistory.com/25 
//		/topic이냐 /app이냐 차이는 message를 send 할때 차이가 벌어집니다.(subscribe할때라고 착각했엇음)
		ws.subscribe('/topic/'+room_id, onMessageReceived);
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
		var mem_seq=1;
		var chatroom_seq= document.getElementById('chatroom_seq').value;
		var chatmessage = document.getElementById('message').value;
		var chatregdate;
		console.log("echo message: "+message);
//		ws.send('/echo', {}, message);
//		ws.send('/echo', {}, JSON.stringify({message:message}));
//		첫번째 인자는 spring controller mapping("/app"은 spring controller로 보낸다는 stomp prefix 규칙입니다. 즉"/app 뒤가 진짜 mapping주소)
//		@MessageMapping에서 @MessageMapping("/{chatroom_url}")인 이유는 websocketConfiguration에서 /app이 자동으로 spring으로 가도록 설정했습니다.
//		두번째 인자는 서버로 보낼때 추가하고 싶은 stomp 헤더입니다.
//		세번째 인자는 서버로 보낼떄 추가하고 싶은 stomp 바디입니다. 서버컨트롤러에서는 mapping된 함수의 String인자로 Json stringify된 문자열을 받을 수 있습니다.
		ws.send('/app/'+room_id, {}, JSON.stringify({mem_seq:mem_seq,chatroom_seq:chatroom_seq,chatmessage:chatmessage}));
	}else{
		alert('connection not established, please connect.');
	}
}

function log(message){
	
	var console = document.getElementById('logging');
	var p = document.createElement('p');
	p.appendChild(document.createTextNode(message));
	console.appendChild(p);
	while(console.childNodes.length > 12){
		console.removeChild(console.firstChild);
	}
	console.scrollTop = console.scrollHeight;
}

function onMessageReceived(payload){
	var chatmessagevoJSON = JSON.parse(payload.body);
	
	var console = document.getElementById('logging');
	var p = document.createElement('p');
	p.appendChild(document.createTextNode(chatmessagevoJSON.chatmessage));
	console.appendChild(p);
	while(console.childNodes.length > 12){
		console.removeChild(console.firstChild);
	}
	console.scrollTop = console.scrollHeight;
	
}

