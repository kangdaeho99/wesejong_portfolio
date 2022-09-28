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
import org.wesejong.domain.BoardVO;
import org.wesejong.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/admin/board/*")
@Log4j
public class AdminBoardController {
	
	@Setter(onMethod_=@Autowired)
	private BoardService boardservice;

	@GetMapping("/list")
	public void dolistPage(Model model) {
		log.info("gotoboardList....");
		model.addAttribute("boardnoticelist", boardservice.AdminBoard_getboardnoticeList_limit_0_300());
		model.addAttribute("boardlist", boardservice.AdminBoard_getList_limit_0_300());
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("/get");
		model.addAttribute("board", boardservice.get(bno));
	}

	@PostMapping("/modify")
	public String modifyx(BoardVO boardvo, RedirectAttributes rttr) {
		log.info("modify:"+boardvo);
		
		if(boardservice.AdminBoard_modify_board_id_title_content_notice(boardvo)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/admin/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("remove....."+bno);
		
		if(boardservice.remove(bno)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/admin/board/list";
	}	
	
	@PostMapping("/removebychkbox")
	public String go_delete(HttpServletRequest request) {
		String[] arr = request.getParameterValues("chkbox");
		long bno;
		for(int i=0;i<arr.length;i++) {
			bno =(long)Integer.parseInt(arr[i]);
			boardservice.remove(bno);
		}
		return "redirect:/admin/board/list";
	}


	
}
