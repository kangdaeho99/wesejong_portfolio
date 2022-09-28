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
import org.wesejong.domain.MeetMatchProfileVO;
import org.wesejong.service.MeetMatchProfileService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/admin/meetmatch/meetmatchprofile/*")
@Log4j
public class AdminMeetMatchProfileController {
	
	@Setter(onMethod_=@Autowired)
	private MeetMatchProfileService meetmatchprofileservice;

	@GetMapping("/list")
	public void dolistPage(Model model) {
		log.info("gotomeetmatchprofileList....");
		model.addAttribute("meetmatchprofilelist", meetmatchprofileservice.getList());
		
	}
	
	@GetMapping("/register")
	public void doregisterPage(Model model) {
		log.info("gotomeetmatchprofileregister....");
	}
	
	@PostMapping("/register")
	public String register(MeetMatchProfileVO meetmatchprofilevo, RedirectAttributes rttr) {
		log.info("register:" + meetmatchprofilevo);
		meetmatchprofileservice.register(meetmatchprofilevo);
		rttr.addFlashAttribute("result",meetmatchprofilevo.getMeetmatchprofile_seq());
		return "redirect:/admin/meetmatch/meetmatchprofile/list";
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("meetmatchprofile_seq") Long meetmatchprofile_seq, Model model) {
		log.info("/get");
		model.addAttribute("meetmatchprofile", meetmatchprofileservice.get(meetmatchprofile_seq));
	}

	@PostMapping("/modify")
	public String modify(MeetMatchProfileVO meetmatchprofilevo, RedirectAttributes rttr) {
		log.info("modify:"+meetmatchprofilevo);
		
		if(meetmatchprofileservice.modify(meetmatchprofilevo)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/admin/meetmatch/meetmatchprofile/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("meetmatchprofile_seq") Long meetmatchprofile_seq, RedirectAttributes rttr) {
		log.info("remove....."+meetmatchprofile_seq);
		
		if(meetmatchprofileservice.remove(meetmatchprofile_seq)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/admin/meetmatch/meetmatchprofile/list";
	}	
	
	@PostMapping("/removebychkbox")
	public String go_delete(HttpServletRequest request) {
		String[] arr = request.getParameterValues("chkbox");
		long meetmatchprofile_seq;
		for(int i=0;i<arr.length;i++) {
			meetmatchprofile_seq =(long)Integer.parseInt(arr[i]);
			meetmatchprofileservice.remove(meetmatchprofile_seq);
		}
		return "redirect:/admin/meetmatch/meetmatchprofile/list";
	}


	
}
