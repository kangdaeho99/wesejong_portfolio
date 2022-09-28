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
import org.wesejong.domain.MeetMatchTeamMateVO;
import org.wesejong.service.MeetMatchTeamMateService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/admin/meetmatch/meetmatchteammate/*")
@Log4j
public class AdminMeetMatchTeamMateController {
	
	@Setter(onMethod_=@Autowired)
	private MeetMatchTeamMateService meetmatchteammateservice;

	@GetMapping("/list")
	public void dolistPage(Model model) {
		log.info("gotoboardList....");
		model.addAttribute("meetmatchteammatelist", meetmatchteammateservice.getList());
		
	}
	
	@GetMapping("/register")
	public void doregisterPage(Model model) {
		log.info("gotoboardregister....");
	}
	
	@PostMapping("/register")
	public String register(MeetMatchTeamMateVO meetmatchteammatevo, RedirectAttributes rttr) {
		log.info("register:" + meetmatchteammatevo);
		meetmatchteammateservice.register(meetmatchteammatevo);
		rttr.addFlashAttribute("result",meetmatchteammatevo.getMeetmatchteammate_seq());
		return "redirect:/admin/meetmatch/meetmatchteammate/list";
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("meetmatchteammate_seq") Long meetmatchteammate_seq, Model model) {
		log.info("/get");
		model.addAttribute("meetmatchteammate", meetmatchteammateservice.get(meetmatchteammate_seq));
	}

	@PostMapping("/modify")
	public String modifyx(MeetMatchTeamMateVO meetmatchteammatevo, RedirectAttributes rttr) {
		log.info("modify:"+meetmatchteammatevo);
		
		if(meetmatchteammateservice.modify(meetmatchteammatevo)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/admin/meetmatch/meetmatchteammate/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("meetmatchteammate_seq") Long meetmatchteammate_seq, RedirectAttributes rttr) {
		log.info("remove....."+meetmatchteammate_seq);
		
		if(meetmatchteammateservice.remove(meetmatchteammate_seq)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/admin/meetmatch/meetmatchteammate/list";
	}	
	
	@PostMapping("/removebychkbox")
	public String go_delete(HttpServletRequest request) {
		String[] arr = request.getParameterValues("chkbox");
		long meetmatchteammate_seq;
		for(int i=0;i<arr.length;i++) {
			meetmatchteammate_seq =(long)Integer.parseInt(arr[i]);
			meetmatchteammateservice.remove(meetmatchteammate_seq);
		}
		return "redirect:/admin/meetmatch/meetmatchteammate/list";
	}


	
}
