package org.wesejong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.wesejong.domain.BoardLikeVO;
import org.wesejong.domain.BoardManageVO;
import org.wesejong.domain.BoardVO;
import org.wesejong.domain.Criteria;
import org.wesejong.domain.PageDTO;
import org.wesejong.service.BoardDisLikeService;
import org.wesejong.service.BoardLikeService;
import org.wesejong.service.BoardManageService;
import org.wesejong.service.BoardReplyService;
import org.wesejong.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController {
	
	@Setter(onMethod_=@Autowired)
	private BoardService boardservice;
	
	@Setter(onMethod_=@Autowired)
	private BoardReplyService boardreplyservice;
	
	@Setter(onMethod_=@Autowired)
	private BoardManageService boardmanageservice;
	
	@Setter(onMethod_=@Autowired)
	private BoardLikeService boardlikeservice;
	
	@Setter(onMethod_=@Autowired)
	private BoardDisLikeService boarddislikeservice;
	
	@GetMapping("/listx")
	public void dolistPage(Model model) {
		log.info("gotoboardList....");
		model.addAttribute("list", boardservice.getList());
	}
	
	@GetMapping("/list")
	public void list(BoardManageVO boardmanagevo, Criteria cri, Model model){
	    log.info("list:"+cri+boardmanagevo);
	    log.info(boardmanageservice.get_by_board_id(boardmanagevo.getBoard_id()));
	    BoardManageVO boardmanagetestvo = boardmanageservice.get_by_board_id(boardmanagevo.getBoard_id());	
	    
	    
	    
	    model.addAttribute("boardmanage",boardmanageservice.get_by_board_id(boardmanagevo.getBoard_id()));
//	    일반게시판입니다.
	    if(boardmanagetestvo.getBoard_type().equals("1")) {
	    	model.addAttribute("list", boardservice.getList_with_boardmanage_boardattachimage(boardmanagevo, cri));
	    	model.addAttribute("pageMaker", new PageDTO(cri, boardservice.getTotalCount_with_boardmanage(boardmanagevo, cri)));
	    }
//	    인기게시판입니다.
	    else if(boardmanagetestvo.getBoard_type().equals("2")) {
	    	model.addAttribute("list", boardservice.getList_with_boardmanage_boardattachimage_by_bno_and_boardlikecount_bigger_than_ten(boardmanagevo, cri));
	    	model.addAttribute("pageMaker", new PageDTO(cri, boardservice.getTotalCount_with_boardmanage_by_bno_and_boardlikecount_bigger_than_ten(boardmanagevo, cri)));
	    }
//	    전체게시판입니다.
	    else if(boardmanagetestvo.getBoard_type().equals("3")) {
	    	model.addAttribute("list", boardservice.getList_with_boardmanage_boardattachimage_get_allpost(boardmanagevo, cri));
	    	model.addAttribute("pageMaker", new PageDTO(cri, boardservice.getTotalCount_with_boardmanage_boardattachimage_get_allpost(boardmanagevo, cri)));
	    }

	

	    
	}

	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Long bno, BoardManageVO boardmanagevo, BoardLikeVO boardlikevo, Criteria cri, Model model, Authentication authentication) {
		log.info("/get");
		BoardVO boardvo = boardservice.get(bno);
		boardservice.update_boardviewcount(boardvo);
		
		model.addAttribute("board", boardvo);
		model.addAttribute("boardreply", boardreplyservice.getList(boardvo));
		model.addAttribute("boardrereply", boardreplyservice.getList(boardvo));
//		get에 바로갈 경우 board_id를 못받고 가므로 아래의 방식으로 변경했습니다.
		model.addAttribute("boardmanage",boardmanageservice.get_by_board_id(boardvo.getBoard_id()));
		model.addAttribute("boardmanagelist",boardmanageservice.getList_by_board_order());
		model.addAttribute("boardlikeexists", boardlikeservice.checkExistsLikeColumn_by_bno_and_mem_seq(boardvo, authentication));
		model.addAttribute("boarddislikeexists", boarddislikeservice.checkExistsDisLikeColumn_by_bno_and_mem_seq(boardvo, authentication));
//		이건 나중에 boardlikecount로 보여지게할꺼임
//		model.addAttribute("boardliketotalcount", boardlikeservice.getTotalBoardLikeCount_of_post_by_bno(boardvo));
		
		
		
		boardmanagevo.setBoard_id(boardvo.getBoard_id());
		BoardManageVO boardmanagetestvo = boardmanageservice.get_by_board_id(boardmanagevo.getBoard_id());	
//	    일반게시판입니다.
	    if(boardmanagetestvo.getBoard_type().equals("1")) {
	    	model.addAttribute("list", boardservice.getList_with_boardmanage_boardattachimage(boardmanagevo, cri));
	    	model.addAttribute("pageMaker", new PageDTO(cri, boardservice.getTotalCount_with_boardmanage(boardmanagevo, cri)));
	    }
//	    인기게시판입니다.
	    else if(boardmanagetestvo.getBoard_type().equals("2")) {
	    	model.addAttribute("list", boardservice.getList_with_boardmanage_boardattachimage_by_bno_and_boardlikecount_bigger_than_ten(boardmanagevo, cri));
	    	model.addAttribute("pageMaker", new PageDTO(cri, boardservice.getTotalCount_with_boardmanage_by_bno_and_boardlikecount_bigger_than_ten(boardmanagevo, cri)));
	    }
//	    전체게시판입니다.
	    else if(boardmanagetestvo.getBoard_type().equals("3")) {
	    	model.addAttribute("list", boardservice.getList_with_boardmanage_boardattachimage_get_allpost(boardmanagevo, cri));
	    	model.addAttribute("pageMaker", new PageDTO(cri, boardservice.getTotalCount_with_boardmanage_boardattachimage_get_allpost(boardmanagevo, cri)));
	    }
	
	    
	    
	}
	
	@GetMapping("/register")
	public void doregisterPage(BoardManageVO boardmanagevo, Criteria cri, Model model) {
		log.info("gotoboardregister....");
		model.addAttribute("boardmanage", boardmanagevo);
		model.addAttribute("boardmanagelist",boardmanageservice.getList_by_board_order());
		model.addAttribute("pageMaker", new PageDTO(cri, boardservice.getTotalCount_with_boardmanage(boardmanagevo, cri)));
		
	}
	
	@PostMapping("/register_basic_withoutImageFile")
	public String registerx(BoardVO board, RedirectAttributes rttr) {
		log.info("register:" + board);
		boardservice.register_without_boardattachimage(board);
		rttr.addFlashAttribute("result",board.getBno());
		return "redirect:/board/list";
	}
	
	@PostMapping("/register")
	public String register(BoardManageVO boardmanagevo, BoardVO boardvo, Criteria cri, Authentication authentication, RedirectAttributes rttr) {
		log.info("register:" + boardvo);
		log.info(boardmanagevo + "cri:" + cri);
		
		boardservice.register_with_boardmanage_boardattachimage(boardmanagevo, boardvo, authentication);
			
		rttr.addFlashAttribute("result",boardvo.getBno());
		return "redirect:/board/list?board_id="+boardmanagevo.getBoard_id();
	}
	
	
	@PostMapping("/modify")
	public String modify(BoardManageVO boardmanagevo, BoardVO boardvo, Authentication authentication, RedirectAttributes rttr) {
		log.info("modify:"+boardvo);
		
//		boardservice.modify_with_boardattachimage(boardvo);
		
		boardservice.modify_with_boardmanage_boardattachimage(boardmanagevo, boardvo, authentication);
		
		return "redirect:/board/list?board_id="+boardmanagevo.getBoard_id();
	}
	
	@PostMapping("/remove")
	public String remove(BoardManageVO boardmanagevo, BoardVO boardvo, Authentication authentication, RedirectAttributes rttr) {
		log.info("register:" + boardvo);
			
		boardservice.remove_by_bno(boardvo);
		rttr.addFlashAttribute("result",boardvo.getBno());
		return "redirect:/board/list?board_id="+boardmanagevo.getBoard_id();
	}
	
	


	
}
