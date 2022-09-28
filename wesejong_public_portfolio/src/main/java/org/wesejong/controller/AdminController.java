package org.wesejong.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/admin")
@Log4j
public class AdminController {
	
	@GetMapping("/index")
	public void doadminindexPage(Authentication auth) {
		log.info("gotoadminidexpage...."+auth);
	}
	
	
}
