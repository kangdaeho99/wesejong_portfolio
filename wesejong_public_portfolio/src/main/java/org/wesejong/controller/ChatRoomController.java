package org.wesejong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.wesejong.domain.BoardManageVO;
import org.wesejong.domain.ChatMessageVO;
import org.wesejong.domain.ChatRoomVO;
import org.wesejong.security.domain.CustomUser;
import org.wesejong.service.BoardManageService;
import org.wesejong.service.BoardService;
import org.wesejong.service.ChatMessageService;
import org.wesejong.service.ChatRoomJoinService;
import org.wesejong.service.ChatRoomService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class ChatRoomController {

	
	@Setter(onMethod_=@Autowired)
	private ChatRoomService chatroomservice;

	@Setter(onMethod_=@Autowired)
	private ChatRoomJoinService chatroomjoinservice;
	
	@Setter(onMethod_=@Autowired)
	private ChatMessageService chatmessageservice;
	
	@Setter(onMethod_=@Autowired)
	private SimpMessagingTemplate simpmessagingtemplate;

	@Setter(onMethod_=@Autowired)
	private BoardService boardservice;
	
	@Setter(onMethod_=@Autowired)
	private BoardManageService boardmanageservice;
	
	@MessageMapping("/echox")
	@SendTo("/topic/echox")
	public String echox(String msg) {
		System.out.println("RECEIVED:"+msg);
		return "RECEIVED:"+msg;
	}
	
	@MessageMapping("/echoxx")
	@SendTo("/topic/echoxx")
	public ChatMessageVO echoxx(ChatMessageVO msg) throws Exception{
		System.out.println("RECEIVED:"+msg);
		return msg;
	}
	
	@MessageMapping("/{chatroom_uuid}")
	@ResponseBody
	public void echo(@DestinationVariable("chatroom_uuid") String chatroom_uuid,@RequestBody ChatMessageVO chatmessagevo) throws Exception{
		simpmessagingtemplate.convertAndSend("/topic/"+chatroom_uuid, chatmessagevo);
		System.out.println("chatmessageSEND");
		chatmessageservice.register(chatmessagevo);

//		원래 public String으로 chatmessagevo를 return 해줬었는데 
//		simpmessagingtemplate.convertAndSend("/topic/"+chatroom_uuid, chatmessagevo); 에서 이미 해당 url에 값을 보내주므로 값이 메시지를 2번받았습니다.
//		두번데이터가 오기에 두번 메시지가 떠서 확인해보니, 2번 보내고 있었습니다.
//		return chatmessagevo;

	}
	
//	@GetMapping("/socket/chat")
//	public void chat(ChatRoomVO chatroomvo, Model model) {
//		log.info("/chatpage");
//		
//		model.addAttribute("chatmessagevolist", chatmessageservice.getChatMessageVOList(chatroomvo));
//		model.addAttribute("chatroomvo", chatroomservice.getChatRoomVO_by_chatroom_uuid(chatroomvo));
//	}

	
	
//	/socket/chat 을 접근하게 될 여러가지 방법에 대하여 생각해봅니다.
//	1. 게시판에서 게시글의 작성자명 을 통해 대화를 시도할때입니다.(처음으로 대화를 시도할떄입니다.)
//	- 이때는 /socket/chat/mem_seq=작성자의mem_seq  을 통해 Controller로 들어옵니다.
//	- chatroom_uuid = null 인상태로 들어가고, mem_seq은 작성자의 mem_seq이므로 
//	- chatroom_uuid를 새로 생성한뒤 chatroom register 함수를 통해서 mem_seq의 사용자와 session의 사용자 두명을 chatroomjoin에 넣은뒤 다시
//	- redirect:/socket/chat/chatroom_uuid=URLURLURLURL 을 통해 이동시킵니다.
	
//	2. 게시판에서 게시글의 작성자명 을 통해 대화를 시도할때입니다.(두번째로 대화를 시도할떄입니다.)
//	- 이때는 /socket/chat/mem_seq=작성자의 mem_seq 을 통해 controller로 들어옵니다.
//	- chatroom_uuid = null 인상태로 들어가고, mem_seq은 작성자의 mem_seq입니다.
//	- 여기서 이전에 대화한 이력이 있는 것을 확인한뒤, 대화한 이력이 있다면 해당 chatroom_uuid를 가져와서 
//	- redirect:/socket/chat/chatroom_uuid=URLURLURLURL 을 통해 이동시킵니다.

	@GetMapping("/socket/chatcheck")
	public String chatcheck(@RequestParam(value="chatroom_uuid", required=false, defaultValue="null") String chatroom_uuid, 
					@RequestParam(value="mem_seq", required=false, defaultValue="-1") Long mem_seq1,
					ChatRoomVO chatroomvo, Model model,Authentication authentication) {

		String redirect_chatroom_uuid;
		log.info("/chatpage");
		
//		회원이 게시판에 접속하였을때 상대방 mem_seq만 가진상태로 /socket/chatcheck?mem_seq=35 일때입니다.
		if(chatroom_uuid.equals("null") && mem_seq1!=-1) {
			if(authentication!=null) {
				CustomUser customuser = (CustomUser) authentication.getPrincipal();
				Long mem_seq2 = customuser.getMember().getMem_seq();
				
//				mem_seq1과 mem_seq2가 이전에 대화한 채팅방이 있는지 확인하는 함수입니다.
				redirect_chatroom_uuid = chatroomservice.check_chatroomjoin_mem_seq1_mem_seq2_and_return_chatroom_uuid(mem_seq1, mem_seq2);
				if(!redirect_chatroom_uuid.equals("null")) {
					return "redirect:/socket/chat?chatroom_uuid="+redirect_chatroom_uuid;
				} 
				else if(redirect_chatroom_uuid.equals("null")) {
//					mem_seq1과 mem_seq2가 이전에 대화한 채팅방이 존재하지 않아, 새로운 채팅방을 만들고 chatroomjoin에 데이터를 넣는 함수입니다.				
					redirect_chatroom_uuid = chatroomservice.register_chatroom_chatroomjoin(chatroomvo, mem_seq1, mem_seq2);					
					return "redirect:/socket/chat?chatroom_uuid="+redirect_chatroom_uuid;
				}
			}
		} 
		
//		회원이 /socket/chatcheck?chatroom_uuid=kewqedq'wpkqd'kqwod[qkwdo'qwkdq 로 들어왔을때입니다.
//		이때 처음으로 대화에 접속한것이라면 해당 member를 chatroomjoin에 추가시켜줍니다.
//		이미 추가되어있는 상태라면 바로 그 대화방에 들어갑니다.
		else if(!chatroom_uuid.equals("null") && mem_seq1 == -1) {

			//해당 채팅방이 실제로 존재하는지 확인합니다. 
//			이미 존재하는 채팅방 링크라면, 접속한 member를 해당 방에 넣어줍니다.
			if(chatroomservice.getExists_by_chatroom_uuid(chatroomvo) == 1) {
				chatroomjoinservice.check_Existence_and_register(chatroomvo, authentication);
				return "redirect:/socket/chat?chatroom_uuid="+chatroom_uuid;
				
			} else if(chatroomservice.getExists_by_chatroom_uuid(chatroomvo) != 1){
//				존재하지 않는다면 메인화면으로 이동시킵니다.
			}
			

				
		}
		
		
		return "redirect:/index";	
	}
	
	
	@GetMapping("/socket/chat")
	public void chat(ChatRoomVO chatroomvo, Model model, Authentication authentication) {
		log.info("/chatpage");
//		해당방 멤버(chatroom_uuid가 UUID 절차를 따른 방인지 체크하기위함)가 아니라면 데이터를 못가져옵니다.
		if(chatroomservice.getExists_by_chatroom_uuid(chatroomvo) == 1) {
			chatroomjoinservice.check_Existence_and_register(chatroomvo, authentication);
			model.addAttribute("chatmessagevolist", chatmessageservice.getChatMessageVOList_by_chatroom_seq_via_chatroom_uuid(chatroomvo));
			model.addAttribute("chatroomvo", chatroomservice.getChatRoomVO_by_chatroom_uuid(chatroomvo));
			
		}
		
		
	}
	
	@PostMapping("/socket/chat/leavechatroom")
	public String leavechatroom(ChatRoomVO chatroomvo, Authentication authentication) {
		log.info("/leave the chatroom");
		
		chatroomjoinservice.remove_chatroomjoinvo_by_chatroom_seq_and_mem_seq(chatroomvo, authentication);
		return "redirect:/member/info/chatroomlist";
	}
	
	

	@GetMapping("/socket/list")
	public void dolistPage(Model model) {
		log.info("gotochatlist....");
		model.addAttribute("chatroomlist", chatroomservice.getList());		
		
	}

	@GetMapping("/socket/register")
	public void doregisterPage(Model model) {
		log.info("gotochatregister....");
	}	
	
	@PostMapping("/socket/register")
	public String register(ChatRoomVO chatroomvo, RedirectAttributes rttr) {
		log.info("register:" + chatroomvo);
		chatroomservice.register(chatroomvo);
		rttr.addFlashAttribute("result",chatroomvo.getChatroom_seq());
		return "redirect:/socket/list";
	}	
	
	@GetMapping({"/socket/get","/socket/modify"})
	public void get(ChatRoomVO chatroomvo, Model model) {
		log.info("/get");
		model.addAttribute("chatroom", chatroomservice.get(chatroomvo));
	}

	@PostMapping("/socket/modify")
	public String modifyx(ChatRoomVO chatroomvo, RedirectAttributes rttr) {
		log.info("modify:"+chatroomvo);
		
		if(chatroomservice.modify(chatroomvo)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/socket/list";
	}	

	@PostMapping("/socket/removex")
	public String removex(ChatRoomVO chatroomvo, RedirectAttributes rttr) {
		log.info("remove....."+chatroomvo);
		if(chatroomservice.remove(chatroomvo)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/socket/list";
	}	

	@PostMapping("/socket/remove")
	public String remove(@RequestParam("chatroom_seq") Long chatroom_seq, RedirectAttributes rttr) {
		log.info("remove....."+chatroom_seq);
		ChatRoomVO chatroomvo_seq = new ChatRoomVO();
		chatroomvo_seq.setChatroom_seq(chatroom_seq);
		
		if(chatroomservice.remove_chatroom_by_chatroomvo(chatroomvo_seq) 
			&& chatmessageservice.remove_chatmessage_by_chatroomvo(chatroomvo_seq)) {
			rttr.addFlashAttribute("result","success");
		}

		return "redirect:/socket/list";
	}	
	
	
	
	
//	내가 테스트해본것을 정리해봅니다.
//	1.
//	ws.subscribe('/topic/echo')
//	ws.subscribe('/topic/1234')
//	/topic/echo일경우, /topic을 구독한 것이 아닌 /echo를 구독한것임
//	위의 설정은 WebSocketStompConfiguration의 configureMessageBroker의
//	registry.enableSimpleBroker("/topic")을 통해 /topic을 일종의 prefix로 지정함
//	이 구독한 곳에 메세지를 보내기 위해선는
//	@SendTo('/topic/echo')
//	@SendTo('/topic/1234')와 연동됨
//
//	2.
//	ws.send('/echo')
//	ws.send('/1234')
//	앞에 /~/echo 인이유는 //	WebSocketStompConfiguration의 configureMessageBroker의
//	registry.setApplicationDestinationPrefixes("/");을 통해 설정했습니다.
//	(여기서 "/"로 설정한 이유는 tomcat 서버에서 [modules]설정에서 /로 설정했기 떄문입니다.)
//	@MessageMapping('/echo')
//	@MessageMapping('/1234')와 연동됨
//
//	3.	var sock = new SockJS("/echo-endpoint");
//		ws = Stomp.over(sock);
//	WebSocketStompConfiguration의 registerStompEndpoints의
//	registry.addEndpoint("/echo-endpoint").setAllowedOrigins("*").withSockJS();
//	를 통해 '/echo-endpoint'로 끝나는 연결은 브로커가 connect를 받아온다고 인식함.
//
//	4.회원입장, 퇴장 구현방법. 각각의 함수를 각각 구현
//	-ws.send('/in')
//	@MessageMapping('/in')
//	@SendTo('/topic/echo')
//	-ws.send('/out')
//	@MessageMapping('/out')
//	@SendTo('/topic/echo')
	

//	지금 문제는 
//	@MessageMapping
//	@SendTo()에 room_id값을 넣는것입니다.
//
//	messagemapping에서 paramter값을 얻기위해서는 @DestinableVaraible을 사용합니다.
//	웹에서는 PathVariable을 사용합니다.
//	검색어:스프링 @SendTo에 변수
//	https://pythonq.com/so/java/120328
//	https://sup2is.github.io/2019/06/21/websocket-2.html (★★★★★)
//
//	읽어보니 일단은 @SendTo에는 동적으로 대상을 정의할 수 없다고합니다.
//	대안으로 SimpMessagingTemplate을 사용한다고합니다.


}
