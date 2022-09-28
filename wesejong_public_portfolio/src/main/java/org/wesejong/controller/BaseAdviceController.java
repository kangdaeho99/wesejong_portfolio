package org.wesejong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.wesejong.domain.AlarmVO;
import org.wesejong.domain.BoardManageVO;
import org.wesejong.domain.MemberVO;
import org.wesejong.security.domain.CustomUser;
import org.wesejong.service.AlarmService;
import org.wesejong.service.BoardManageService;
import org.wesejong.service.BoardService;

import lombok.Setter;

//@ControllerAdvice를 사용하여 (@ModelAttribute?) 원하는 컨트롤러에 model을 공통적으로 뿌릴수잇음
//https://hooongs.tistory.com/113
//https://ncucu.me/52

@ControllerAdvice(assignableTypes = {CommonController.class, BoardController.class, MemberInfoController.class, ChatRoomController.class })
public class BaseAdviceController {

		@Setter(onMethod_= {@Autowired})
		private BoardService boardservice;

		@Setter(onMethod_= {@Autowired})
		private BoardManageService boardmanageservice;
		
		@Setter(onMethod_= {@Autowired})
		private AlarmService alarmservice;
		
		@ModelAttribute
		public void getList_by_0_5(Model model) {
			
//			 화면에 미리보기글, 새로운글 new 를 띄어주는 함수입니다.
		    List<BoardManageVO> boardmanagevo_list = boardmanageservice.getList();
		    for(int i=0;i<boardmanagevo_list.size();i++) {
		    	BoardManageVO boardmanagevo_category = boardmanagevo_list.get(i);
		    	Long board_id = boardmanagevo_list.get(i).getBoard_id();
		    	model.addAttribute("boardmanagevo_board_id_"+board_id, boardmanagevo_category);
		    	model.addAttribute("board_id_"+board_id,boardservice.getList_by_bno_limit_0_5(board_id));
		    	model.addAttribute("new_board_id_"+board_id,boardservice.getExists_by_board_id_and_regdate_yesterday_to_today(boardmanagevo_category));
		    }
		    
//		    board_type : 2 인기게시판
		    model.addAttribute("board_id_102", boardservice.getList_by_bno_and_boardlikecount_bigger_than_ten_limit_0_5((long) 102));
//		    model.addAttribute("new_board_id_102", boardservice.getList_by_bno_and_boardlikecount_bigger_than_ten_limit_0_5((long) 102));
		    
//		    board_type : 3 전체게시판
		    
		    model.addAttribute("board_id_999",boardservice.getList_by_bno_limit_0_5_get_allpost());
		    model.addAttribute("new_board_id_999",boardservice.getExists_by_board_id_and_regdate_yesterday_to_today_allpost());
		}
		
		@ModelAttribute
		public void getAlarm_chatroom_check(Model model, Authentication authentication) {
			
			if(authentication != null) {
				CustomUser customuser = (CustomUser) authentication.getPrincipal();
				MemberVO membervo = customuser.getMember();
				
				AlarmVO alarmvo = new AlarmVO();
				alarmvo.setAlarm_readcheck((long) 0);
				alarmvo.setMem_seq(membervo.getMem_seq());
				model.addAttribute("new_alarm", alarmservice.getCount_by_mem_seq_and_alarm_readcheck(alarmvo));
			}
			
		}
}
