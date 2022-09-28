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
import org.wesejong.domain.AlarmVO;
import org.wesejong.service.AlarmService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/admin/alarm/*")
@Log4j
public class AdminAlarmController {
	
	@Setter(onMethod_=@Autowired)
	private AlarmService alarmservice;

	@GetMapping("/list")
	public void dolistPage(Model model) {
		log.info("gotoboardList....");
		model.addAttribute("alarmlist", alarmservice.getList());
		
	}
	
	@GetMapping("/register")
	public void doregisterPage(Model model) {
		log.info("gotoboardregister....");
	}
	
	@PostMapping("/register")
	public String register(AlarmVO alarmvo, RedirectAttributes rttr) {
		log.info("register:" + alarmvo);
		alarmservice.register(alarmvo);
//		rttr.addFlashAttribute("result",alarmvo.getMbno());
		return "redirect:/admin/alarm/list";
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("alarm_seq") Long alarm_seq, Model model) {
		log.info("/get");
		model.addAttribute("alarm", alarmservice.get(alarm_seq));
	}

	@PostMapping("/modify")
	public String modify(AlarmVO alarmvo, RedirectAttributes rttr) {
		log.info("modify:"+alarmvo);
		
		if(alarmservice.modify(alarmvo)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/admin/alarm/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("alarm_seq") Long alarm_seq, RedirectAttributes rttr) {
		log.info("remove....."+alarm_seq);
		
		if(alarmservice.remove(alarm_seq)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/admin/alarm/list";
	}	
	
	@PostMapping("/removebychkbox")
	public String go_delete(HttpServletRequest request) {
		String[] arr = request.getParameterValues("chkbox");
		long alarm_seq;
		for(int i=0;i<arr.length;i++) {
			alarm_seq =(long)Integer.parseInt(arr[i]);
			alarmservice.remove(alarm_seq);
		}
		return "redirect:/admin/alarm/list";
	}


	
}
