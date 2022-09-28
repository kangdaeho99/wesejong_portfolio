package org.wesejong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.wesejong.domain.BoardManageVO;
import org.wesejong.service.BoardManageService;
import org.wesejong.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class CommonController {
	
	
	@Setter(onMethod_= {@Autowired})
	private BoardService boardservice;
	
	@Setter(onMethod_= {@Autowired})
	private BoardManageService boardmanageservice;
	
	@GetMapping(value= {"/", "/index"})
	public String gotoIndex(Model model, Authentication auth) {
		 log.info("access Denied:"+auth);
		
		 
		return "index";
	}

	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model){
		log.info("error:"+error);
		log.info("logout:"+logout);
		
		if(error!=null){
			model.addAttribute("error","Login Error Check your Account");
		}
		
		if(logout!=null){
			model.addAttribute("logout","Logout!!");
		}
	}	
	
	@GetMapping("/login")
	public void gotoLogin(String error, String logout, Model model){
		log.info("error:"+error);
		log.info("logout:"+logout);
		
		if(error!=null){
			model.addAttribute("error","Login Error Check your Account");
		}
		
		if(logout!=null){
			model.addAttribute("logout","Logout!!");
		}
	}	
	
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied:"+auth);
		model.addAttribute("msg","Access Denied");
	}
	
	@GetMapping("/customLogout")
	public void logoutGET(){
	  log.info("custom Logout");
	}
	
	
	@GetMapping(value= {"/popup"})
	public String popup(Model model, Authentication auth) {
		 log.info("popup:"+auth);
		
		return "popup";
	}
	
}
