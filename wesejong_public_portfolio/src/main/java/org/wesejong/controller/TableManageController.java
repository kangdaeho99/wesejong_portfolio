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
import org.wesejong.domain.BoardManageVO;
import org.wesejong.domain.TableVO;
import org.wesejong.service.TableManageService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/admin/tablemanage/*")
@Log4j
public class TableManageController {
	
	@Setter(onMethod_=@Autowired)
	private TableManageService tablemanageservice;

	@GetMapping("/list")
	public void dolistPage(Model model) {
		log.info("gototablelist....");
		model.addAttribute("tablelist", tablemanageservice.getTableList());
		
	}
	
//	@GetMapping("/register")
//	public void doregisterPage(Model model) {
//		log.info("gotoboardregister....");
//	}
//	
//	@PostMapping("/register")
//	public String registerx(BoardManageVO boardmanagevo, RedirectAttributes rttr) {
//		log.info("register:" + boardmanagevo);
//		boardmanageservice.register(boardmanagevo);
//		rttr.addFlashAttribute("result",boardmanagevo.getMbno());
//		return "redirect:/admin/boardmanage/list";
//	}
//	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("table_name") String table_name, Model model) {
		TableVO tablevo = new TableVO();
		tablevo.setTable_name(table_name);
		log.info("/desctable");
		model.addAttribute("table_name", table_name);
		model.addAttribute("desctable", tablemanageservice.descTable(tablevo));
	}
//
//	@PostMapping("/modify")
//	public String modifyx(BoardManageVO boardmanagevo, RedirectAttributes rttr) {
//		log.info("modify:"+boardmanagevo);
//		
//		if(boardmanageservice.modify(boardmanagevo)) {
//			rttr.addFlashAttribute("result","success");
//		}
//		return "redirect:/admin/boardmanage/list";
//	}
//	
//	@PostMapping("/remove")
//	public String remove(@RequestParam("mbno") Long mbno, RedirectAttributes rttr) {
//		log.info("remove....."+mbno);
//		
//		if(boardmanageservice.remove(mbno)) {
//			rttr.addFlashAttribute("result","success");
//		}
//		return "redirect:/admin/boardmanage/list";
//	}	
//	
//	@PostMapping("/removebychkbox")
//	public String go_delete(HttpServletRequest request) {
//		String[] arr = request.getParameterValues("chkbox");
//		long mbno;
//		for(int i=0;i<arr.length;i++) {
//			mbno =(long)Integer.parseInt(arr[i]);
//			boardmanageservice.remove(mbno);
//		}
//		return "redirect:/admin/boardmanage/list";
//	}


	
}
