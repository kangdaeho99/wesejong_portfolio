package org.wesejong.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wesejong.domain.BoardLikeVO;
import org.wesejong.domain.BoardManageVO;
import org.wesejong.domain.BoardVO;
import org.wesejong.service.BoardLikeService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/like/*")
@Log4j
public class BoardLikeController {
	@Setter(onMethod_=@Autowired)
	private BoardLikeService boardlikeservice;
	
//	동기방식으로 진행했을때입니다.
//	@PostMapping("/likebtnclicked")
//	public String likebtnclicked(BoardManageVO boardmanagevo, BoardVO boardvo, BoardLikeVO boardlikevo, Authentication authentication) {
//		System.out.println(boardmanagevo);
//		System.out.println(boardvo);
//		System.out.println(boardlikevo);
//		if(authentication != null) {
//			int checkExistsLikeColumn = boardlikeservice.checkExistsLikeColumn_by_bno_and_mem_seq(boardvo, authentication);
//			if(checkExistsLikeColumn == 0) {
//				boardlikeservice.register(boardlikevo, authentication);
//			}else if(checkExistsLikeColumn != 0) {
//				boardlikeservice.remove_by_bno_and_mem_seq(boardlikevo, authentication);
//			}
//		}
//		return "redirect:/board/get?bno="+boardlikevo.getBno();
////		return "forward:/board/get?bno="+boardlikevo.getBno();w
//	}
	
//	비동기방식으로 진행했을때 입니다.
//	@RequestBody를 BoardVO와 boardlikevo 두곳에 넣는것은 불가.boardvo.bno에 받고서 boardlikevo.bno에 넣습니다.
	@PostMapping(value = "/likebtnclicked")
	@ResponseBody
	public Object likebtnclicked(BoardManageVO boardmanagevo,@RequestBody BoardVO boardvo, BoardLikeVO boardlikevo, Authentication authentication) {
		System.out.println(boardmanagevo);
		System.out.println(boardvo);
		System.out.println(boardlikevo);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		boardlikevo.setBno(boardvo.getBno());
		
		if(authentication != null) {
			map.put("data",1);
			
			int checkExistsLikeColumn = boardlikeservice.checkExistsLikeColumn_by_bno_and_mem_seq(boardvo, authentication);
			if(checkExistsLikeColumn == 0) {
				boardlikeservice.register(boardlikevo, authentication);
				map.put("checkclicked", 1);	
			}else if(checkExistsLikeColumn != 0) {
				boardlikeservice.remove_by_bno_and_mem_seq(boardlikevo, authentication);
				map.put("checkclicked", 0);
			}
			
			map.put("boardlikecount", boardlikeservice.getTotalBoardLikeCount_of_post_by_bno(boardlikevo));
		}
		return map;
		
	}
	
//	@RequestMapping(value = "/likeCheck", method = RequestMethod.GET)
//	@ResponseBody
//	public Object updateLikeCheck(HttpServletRequest request) {
//		int boardLocation = Integer.parseInt(request.getParameter("boardLocation"));
//		//Long lno = Long.parseLong(request.getParameter("lno"));
//		
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		Long bno = Long.parseLong(request.getParameter("bno"));
//		Long mem_seq = Long.parseLong(request.getParameter("mem_seq"));
//		
//		boardManageVO = manageservice.getManageBoardInfoByBoardLocation(boardLocation);
//		
//		int ExistlikeAndInsertAndChange=service.getExistlikeAndInsertAndChange(boardManageVO, bno, mem_seq);
//		int getLikeCheck = service.getlikeCheck(boardManageVO, bno, mem_seq);
//	
//		map.put("data",ExistlikeAndInsertAndChange);
//		map.put("cnt",getLikeCheck);
//
//		return map;
//	}
	
	
//  검색어:ajax post mapping (현재 member쪽 데이터를 가져오는 값들은 getMapping으로 되어있어도 insert되지 않으므로 괜찮
//	하지만, 이번건은 insert가 이루어지므로 postmapping으로 바꿔야할것같음.
//	https://okky.kr/article/667503
//	검색어:requestbody 어노테이션(JSON값을 받기위한 어노테이션입니다.)
//	https://velog.io/@shson/%EC%8A%A4%ED%94%84%EB%A7%81-controller%EC%97%90%EC%84%9C-%ED%8C%8C%EB%9D%BC%EB%AF%B8%ED%84%B0%EB%A5%BC-%EB%B0%9B%EB%8A%94-%EB%8B%A4%EC%96%91%ED%95%9C-%EB%B0%A9%EB%B2%95-RequestParam-RequestBody-PathVariable
//	@PostMapping("/likecheck")
//	@ResponseBody
//	public Object likecheck(@RequestBody BoardLikeVO boardlikevo) {
//		System.out.println(boardlikevo);
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		int checkExistsLikeColumn = boardlikeservice.checkExistsLikeColumn_by_bno_and_mem_seq(boardlikevo);
//		System.out.println("checkExistsLikeColumn"+checkExistsLikeColumn);
//		if(checkExistsLikeColumn == 0) {
//			boardlikeservice.register(boardlikevo);
//			map.put("checkclicked", 0);
//		} else if(checkExistsLikeColumn == 1){
//			boardlikeservice.remove_by_bno_and_mem_seq(boardlikevo);
//			map.put("checkclicked", 1);
//		}
//		
//		
//		Long getTotalLikeCount_by_bno = boardlikeservice.getTotalBoardLikeCount_of_post_by_bno(boardlikevo);
//		map.put("totallikecount", getTotalLikeCount_by_bno);
//		return map;
//	}
}
