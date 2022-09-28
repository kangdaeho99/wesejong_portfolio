package org.wesejong.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.wesejong.domain.ChatRoomVO;
import org.wesejong.service.ChatRoomService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/admin/chat/chatroom/*")
@Log4j
public class AdminChatRoomController {
	
	
	
	@Setter(onMethod_=@Autowired)
	private ChatRoomService chatroomservice;

	@GetMapping("/list")
	public void dolistPage(Model model) {
		log.info("gotoboardList....");
		model.addAttribute("chatroomlist", chatroomservice.getList());
	}
	
	@GetMapping("/register")
	public void doregisterPage(Model model) {
		log.info("gotoboardregister....");
	}
	
	@PostMapping("/register")
	public String register(ChatRoomVO chatroomvo, RedirectAttributes rttr) {
		log.info("register:" + chatroomvo);
		chatroomservice.register(chatroomvo);
//		rttr.addFlashAttribute("result",chatroomvo.getMbno());
		return "redirect:/admin/chat/chatroom/list";
	}
	
	@GetMapping({"/get","/modify"})
	public void get(ChatRoomVO chatroomvo, Model model) { 
		log.info("/get");
		model.addAttribute("chatroom", chatroomservice.get(chatroomvo));
	}

	@PostMapping("/modify")
	public String modify(ChatRoomVO chatroomvo, RedirectAttributes rttr) {
		log.info("modify:"+chatroomvo);
		
		if(chatroomservice.modify(chatroomvo)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/admin/chat/chatroom/list";
	}
	
	@PostMapping("/remove")
	public String remove(ChatRoomVO chatroomvo, RedirectAttributes rttr) {
		log.info("remove....."+chatroomvo);
		
		if(chatroomservice.remove(chatroomvo)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/admin/chat/chatroom/list";
	}	
	
	@PostMapping("/removebychkbox")
	public String go_delete(HttpServletRequest request) {
		String[] arr = request.getParameterValues("chkbox");
		
		System.out.println(arr[0]);
		long chatroom_seq;
		ChatRoomVO chatroomvo = new ChatRoomVO();
		for(int i=0;i<arr.length;i++) {
			chatroom_seq =(long)Integer.parseInt(arr[i]);
			chatroomvo.setChatroom_seq(chatroom_seq);
			chatroomservice.remove(chatroomvo);
		}
		return "redirect:/admin/chat/chatroom/list";
	}


	
}
