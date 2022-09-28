package org.wesejong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.wesejong.domain.MemberVO;
import org.wesejong.service.AlarmService;
import org.wesejong.service.BoardManageService;
import org.wesejong.service.BoardService;
import org.wesejong.service.MemberInfoService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member/info/*")
@Log4j
public class MemberInfoController {

	
	@Setter(onMethod_= {@Autowired})
	private MemberInfoService memberinfoservice;

	@Setter(onMethod_= {@Autowired})
	private BoardService boardservice;
	
	@Setter(onMethod_= {@Autowired})
	private BoardManageService boardmanageservice;

	@Setter(onMethod_= {@Autowired})
	private AlarmService alarmservice;

	
	@GetMapping("/mypost")
	public void domypostPage(Model model, Authentication authentication) {
//		mailservice.sendEmail(new MailVO());
		model.addAttribute("list", memberinfoservice.get_mypost_by_mem_seq(authentication));
		log.info("gotomypost....");
		
	}

	@GetMapping("/alarm")
	public void doalarmPage(Model model, Authentication authentication) {
//		mailservice.sendEmail(new MailVO());
		
		if(authentication != null) {
			alarmservice.update_alarm_readcheck_by_mem_seq(authentication);			
		}
		
		model.addAttribute("list", memberinfoservice.get_alarm_by_mem_seq(authentication));
		
		
		log.info("gotomypost....");

	}
	
	@GetMapping("/chatroomlist")
	public void dochatroomlistPage(Model model, Authentication authentication) {
//		mailservice.sendEmail(new MailVO());
//		model.addAttribute("list", memberinfoservice.get(authentication));
		log.info("gotomypost....");
		model.addAttribute("list", memberinfoservice.get_chatroom_by_mem_seq(authentication));

//		UUID uuid = UUID.randomUUID();
//		uploadFileName = uuid.toString() + "_" + uploadFileName;
	}
	
	@PostMapping("/join")
	public String memberJoin(MemberVO membervo, RedirectAttributes rttr) {
		log.info("join:"+membervo);
//		memberservice.join(membervo);
		rttr.addFlashAttribute("result",membervo.getMem_seq());
		return "redirect:/index";
	}


	
}
