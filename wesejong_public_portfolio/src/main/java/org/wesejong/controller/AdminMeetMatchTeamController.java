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
import org.wesejong.domain.MeetMatchTeamVO;
import org.wesejong.service.MeetMatchTeamService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/admin/meetmatch/meetmatchteam/*")
@Log4j
public class AdminMeetMatchTeamController {
	
	@Setter(onMethod_=@Autowired)
	private MeetMatchTeamService meetmatchteamservice;

	@GetMapping("/list")
	public void dolistPage(Model model) {
		log.info("gotoboardList....");
		model.addAttribute("meetmatchteamlist", meetmatchteamservice.getList());
		
	}
	
	@GetMapping("/register")
	public void doregisterPage(Model model) {
		log.info("gotoboardregister....");
	}
	
	@PostMapping("/register")
	public String register(MeetMatchTeamVO meetmatchteamvo, RedirectAttributes rttr) {
		log.info("register:" + meetmatchteamvo);
		meetmatchteamservice.register(meetmatchteamvo);
		rttr.addFlashAttribute("result",meetmatchteamvo.getMeetmatchteam_seq());
		return "redirect:/admin/meetmatch/meetmatchteam/list";
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("meetmatchteam_seq") Long meetmatchteam_seq, Model model) {
		log.info("/get");
		model.addAttribute("meetmatchteam", meetmatchteamservice.get(meetmatchteam_seq));
	}

	@PostMapping("/modify")
	public String modify(MeetMatchTeamVO meetmatchteamvo, RedirectAttributes rttr) {
		log.info("modify:"+meetmatchteamvo);
		log.info(meetmatchteamvo);;
		if(meetmatchteamservice.modify(meetmatchteamvo)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/admin/meetmatch/meetmatchteam/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("meetmatchteam_seq") Long meetmatchteam_seq, RedirectAttributes rttr) {
		log.info("remove....."+meetmatchteam_seq);
		
		if(meetmatchteamservice.remove(meetmatchteam_seq)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/admin/meetmatch/meetmatchteam/list";
	}	
	
	@PostMapping("/removebychkbox")
	public String go_delete(HttpServletRequest request) {
		String[] arr = request.getParameterValues("chkbox");
		long meetmatchteam_seq;
		for(int i=0;i<arr.length;i++) {
			meetmatchteam_seq =(long)Integer.parseInt(arr[i]);
			meetmatchteamservice.remove(meetmatchteam_seq);
		}
		return "redirect:/admin/meetmatch/meetmatchteam/list";
	}


	
}
