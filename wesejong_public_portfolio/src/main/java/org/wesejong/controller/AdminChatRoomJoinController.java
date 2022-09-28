package org.wesejong.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.wesejong.domain.ChatRoomJoinVO;
import org.wesejong.service.ChatRoomJoinService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/admin/chat/chatroomjoin/*")
@Log4j
public class AdminChatRoomJoinController {
	
	@Setter(onMethod_=@Autowired)
	private ChatRoomJoinService chatroomjoinservice;

	@GetMapping("/list")
	public void dolistPage(Model model) {
		log.info("gotoboardList....");
		model.addAttribute("chatroomjoinlist", chatroomjoinservice.getList());
	}
	
	@GetMapping("/register")
	public void doregisterPage(Model model) {
		log.info("gotoboardregister....");
	}
	
	@PostMapping("/register")
	public String register(ChatRoomJoinVO chatroomjoinvo, RedirectAttributes rttr) {
		log.info("register:" + chatroomjoinvo);
		chatroomjoinservice.register(chatroomjoinvo);
//		rttr.addFlashAttribute("result",chatroomjoinvo.getMbno());
		return "redirect:/admin/chat/chatroomjoin/list";
	}
	
	@GetMapping({"/get","/modify"})
	public void get(ChatRoomJoinVO chatroomjoinvo, Model model) { 
		log.info("/get");
		model.addAttribute("chatroomjoin", chatroomjoinservice.get(chatroomjoinvo));
	}

	@PostMapping("/modify")
	public String modify(ChatRoomJoinVO chatroomjoinvo, RedirectAttributes rttr) {
		log.info("modify:"+chatroomjoinvo);
		
		if(chatroomjoinservice.modify(chatroomjoinvo)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/admin/chat/chatroomjoin/list";
	}
	
	@PostMapping("/remove")
	public String remove(ChatRoomJoinVO chatroomjoinvo, RedirectAttributes rttr) {
		log.info("remove....."+chatroomjoinvo);
		
		if(chatroomjoinservice.remove(chatroomjoinvo)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/admin/chat/chatroomjoin/list";
	}	
	
	@PostMapping("/removebychkbox")
	public String go_delete(HttpServletRequest request) {
		String[] arr = request.getParameterValues("chkbox");
		System.out.println(arr[0]);
		long chatroomjoin_seq;
		ChatRoomJoinVO chatroomjoinvo = new ChatRoomJoinVO();
		for(int i=0;i<arr.length;i++) {
			chatroomjoin_seq =(long)Integer.parseInt(arr[i]);
			chatroomjoinvo.setChatroomjoin_seq(chatroomjoin_seq);
			chatroomjoinservice.remove(chatroomjoinvo);
		}
		return "redirect:/admin/chat/chatroomjoin/list";
	}


	
}
