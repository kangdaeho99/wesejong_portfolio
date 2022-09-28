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
import org.wesejong.domain.MeetMatchDepartmentVO;
import org.wesejong.service.MeetMatchDepartmentService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/admin/meetmatch/meetmatchdepartment/*")
@Log4j
public class AdminMeetMatchDepartmentController {
	
	@Setter(onMethod_=@Autowired)
	private MeetMatchDepartmentService meetmatchdepartmentservice;

	@GetMapping("/list")
	public void dolistPage(Model model) {
		log.info("gotomeetmatchdepartmentList....");
		model.addAttribute("meetmatchdepartmentlist", meetmatchdepartmentservice.getList());
		
	}
	
	@GetMapping("/register")
	public void doregisterPage(Model model) {
		log.info("gotomeetmatchdepartmentregister....");
	}
	
	@PostMapping("/register")
	public String register(MeetMatchDepartmentVO meetmatchdepartmentvo, RedirectAttributes rttr) {
		log.info("register:" + meetmatchdepartmentvo);
		meetmatchdepartmentservice.register(meetmatchdepartmentvo);
		rttr.addFlashAttribute("result",meetmatchdepartmentvo.getMeetmatchdepartment_seq());
		return "redirect:/admin/meetmatch/meetmatchdepartment/list";
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("meetmatchdepartment_seq") Long meetmatchdepartment_seq, Model model) {
		log.info("/get");
		model.addAttribute("meetmatchdepartment", meetmatchdepartmentservice.get(meetmatchdepartment_seq));
	}

	@PostMapping("/modify")
	public String modifyx(MeetMatchDepartmentVO meetmatchdepartmentvo, RedirectAttributes rttr) {
		log.info("modify:"+meetmatchdepartmentvo);
		
		if(meetmatchdepartmentservice.modify(meetmatchdepartmentvo)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/admin/meetmatch/meetmatchdepartment/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("meetmatchdepartment_seq") Long meetmatchdepartment_seq, RedirectAttributes rttr) {
		log.info("remove....."+meetmatchdepartment_seq);
		
		if(meetmatchdepartmentservice.remove(meetmatchdepartment_seq)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/admin/meetmatch/meetmatchdepartment/list";
	}	
	
	@PostMapping("/removebychkbox")
	public String go_delete(HttpServletRequest request) {
		String[] arr = request.getParameterValues("chkbox");
		long meetmatchdepartment_seq;
		for(int i=0;i<arr.length;i++) {
			meetmatchdepartment_seq =(long)Integer.parseInt(arr[i]);
			meetmatchdepartmentservice.remove(meetmatchdepartment_seq);
		}
		return "redirect:/admin/meetmatch/meetmatchdepartment/list";
	}


	
}
