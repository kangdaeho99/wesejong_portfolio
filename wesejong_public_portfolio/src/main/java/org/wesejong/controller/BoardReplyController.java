package org.wesejong.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.wesejong.domain.BoardReplyVO;
import org.wesejong.domain.BoardVO;
import org.wesejong.service.BoardManageService;
import org.wesejong.service.BoardReplyService;
import org.wesejong.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/reply/*")
@Log4j
public class BoardReplyController {
	
	@Setter(onMethod_=@Autowired)
	private BoardReplyService boardreplyservice;
	
	@Setter(onMethod_=@Autowired)
	private BoardManageService boardmanageservice;
	
	@Setter(onMethod_=@Autowired)
	private BoardService boardservice;
	
	
	
	@PostMapping("/register")
	public String register(BoardReplyVO BoardReplyvo, BoardVO boardvo, Authentication authentication, RedirectAttributes rttr) {
		log.info("register:" + BoardReplyvo);
		boardreplyservice.register(BoardReplyvo, authentication);
		rttr.addFlashAttribute("result",BoardReplyvo.getBrno());
		return "redirect:/board/get?bno="+BoardReplyvo.getBno()+"&board_id="+boardvo.getBoard_id();
	}
	
	@PostMapping("/reregister")
	public String reregister(BoardReplyVO BoardReplyvo, BoardVO boardvo, Authentication authentication, RedirectAttributes rttr) {
		log.info("register:" + BoardReplyvo);
		boardreplyservice.register(BoardReplyvo, authentication);
		rttr.addFlashAttribute("result",BoardReplyvo.getBrno());
		return "redirect:/board/get?bno="+BoardReplyvo.getBno()+"&board_id="+boardvo.getBoard_id();
	}

	@PostMapping("/modify")
	public String modifyx(BoardReplyVO BoardReplyvo, BoardVO boardvo, RedirectAttributes rttr) {
		log.info("modify:"+BoardReplyvo);
		
		if(boardreplyservice.modify(BoardReplyvo)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/admin/BoardReply/list";
	}
	
	//댓글삭제시 대댓글까지 전부 다삭제처리
	@PostMapping("/remove")
	public String remove(BoardReplyVO boardreplyvo, BoardVO boardvo, RedirectAttributes rttr) {
		log.info("remove....."+boardreplyvo);
		
		boardreplyservice.remove_reply_and_rereply(boardreplyvo);
		return "redirect:/board/get?bno="+boardreplyvo.getBno()+"&board_id="+boardvo.getBoard_id();
	}	
	
//대댓글 삭제처리
	@PostMapping("/rereply/remove")
	public String rereplyremove(BoardReplyVO boardreplyvo, BoardVO boardvo, RedirectAttributes rttr) {
		log.info("remove....."+boardreplyvo);
		
		boardreplyservice.remove(boardreplyvo);
		
		return "redirect:/board/get?bno="+boardreplyvo.getBno()+"&board_id="+boardvo.getBoard_id();
	}	
	
}
