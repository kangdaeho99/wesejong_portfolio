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
import org.wesejong.domain.MeetMatchPersonnelManageVO;
import org.wesejong.service.MeetMatchPersonnelManageService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/admin/meetmatch/meetmatchpersonnelmanage/*")
@Log4j
public class AdminMeetMatchPersonnelManageController {
	
	@Setter(onMethod_=@Autowired)
	private MeetMatchPersonnelManageService meetmatchpersonnelmanageservice;

	@GetMapping("/list")
	public void dolistPage(Model model) {
		log.info("gotoboardList....");
		model.addAttribute("meetmatchpersonnelmanagelist", meetmatchpersonnelmanageservice.getListWith_meetmatchpersonnelmanage());
		
	}
	
	@GetMapping("/register")
	public void doregisterPage(Model model) {
		log.info("gotoboardregister....");
	}
	
	@PostMapping("/register")
	public String register(MeetMatchPersonnelManageVO meetmatchpersonnelmanagevo, RedirectAttributes rttr) {
		log.info("register:" + meetmatchpersonnelmanagevo);
		meetmatchpersonnelmanageservice.register(meetmatchpersonnelmanagevo);
		//Tue Oct 05 20:15:00 KST 2021
		rttr.addFlashAttribute("result",meetmatchpersonnelmanagevo.getMeetmatchmanage_seq());
		return "redirect:/admin/meetmatch/meetmatchpersonnelmanage/list";
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("meetmatchpersonnelmanage_seq") Long meetmatchpersonnelmanage_seq, Model model) {
		log.info("/get");
		//Tue Oct 05 20:15:00 KST 2021
		model.addAttribute("meetmatchpersonnelmanage", meetmatchpersonnelmanageservice.get(meetmatchpersonnelmanage_seq));
		
	}

	@PostMapping("/modify")
	public String modifyx(MeetMatchPersonnelManageVO meetmatchpersonnelmanagevo, RedirectAttributes rttr) {
		log.info("modify:"+meetmatchpersonnelmanagevo);
		
		if(meetmatchpersonnelmanageservice.modify(meetmatchpersonnelmanagevo)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/admin/meetmatch/meetmatchpersonnelmanage/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("meetmatchpersonnelmanage_seq") Long meetmatchpersonnelmanage_seq, RedirectAttributes rttr) {
		log.info("remove....."+meetmatchpersonnelmanage_seq);
		
		if(meetmatchpersonnelmanageservice.remove(meetmatchpersonnelmanage_seq)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/admin/meetmatch/meetmatchpersonnelmanage/list";
	}	
	
	@PostMapping("/removebychkbox")
	public String go_delete(HttpServletRequest request) {
		String[] arr = request.getParameterValues("chkbox");
		long meetmatchpersonnelmanage_seq;
		for(int i=0;i<arr.length;i++) {
			meetmatchpersonnelmanage_seq =(long)Integer.parseInt(arr[i]);
			meetmatchpersonnelmanageservice.remove(meetmatchpersonnelmanage_seq);
		}
		return "redirect:/admin/meetmatch/meetmatchpersonnelmanage/list";
	}


	
}
