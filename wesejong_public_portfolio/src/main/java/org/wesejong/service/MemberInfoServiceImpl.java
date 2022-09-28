package org.wesejong.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.wesejong.domain.AlarmVO;
import org.wesejong.domain.BoardVO;
import org.wesejong.domain.ChatRoomJoinVO;
import org.wesejong.domain.ChatRoomVO;
import org.wesejong.domain.MemberVO;
import org.wesejong.mapper.AlarmMapper;
import org.wesejong.mapper.BoardMapper;
import org.wesejong.mapper.ChatRoomJoinMapper;
import org.wesejong.mapper.ChatRoomMapper;
import org.wesejong.security.domain.CustomUser;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MemberInfoServiceImpl implements MemberInfoService {
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper boardmapper;
	
	@Setter(onMethod_=@Autowired)
	private AlarmMapper alarmmapper;
	
	@Setter(onMethod_=@Autowired)
	private ChatRoomMapper chatroommapper;

	@Setter(onMethod_=@Autowired)
	private ChatRoomJoinMapper chatroomjoinmapper;	
	
	@Override
	public List<BoardVO> get_mypost_by_mem_seq(Authentication authentication) {
		// TODO Auto-generated method stub
		List<BoardVO> boardvo_list = new LinkedList<BoardVO>();
		MemberVO membervo = new MemberVO();
		if(authentication != null) {
			CustomUser customuser = (CustomUser) authentication.getPrincipal();
			membervo = customuser.getMember();
			boardvo_list = boardmapper.getList_by_mem_seq(membervo);
		}
		
		
		return boardvo_list;
	}

	@Override
	public List<AlarmVO> get_alarm_by_mem_seq(Authentication authentication) {
		// TODO Auto-generated method stub
		List<AlarmVO> alarmvo_list = new LinkedList<AlarmVO>();
		MemberVO membervo = new MemberVO();
		if(authentication != null) {
			CustomUser customuser = (CustomUser) authentication.getPrincipal();
			membervo = customuser.getMember();
			alarmvo_list = alarmmapper.getList_by_mem_seq(membervo);
		}
		return alarmvo_list;
	}

	@Override
	public List<ChatRoomVO> get_chatroom_by_mem_seq(Authentication authentication) {
		// TODO Auto-generated method stub
		List<ChatRoomVO> chatroomvo_list = new LinkedList<ChatRoomVO>();
		List<ChatRoomJoinVO> chatroomjoinvo_list = new LinkedList<ChatRoomJoinVO>();
		MemberVO membervo = new MemberVO();
		ChatRoomJoinVO chatroomjoinvo = new ChatRoomJoinVO();
		if(authentication != null) {
			CustomUser customuser = (CustomUser) authentication.getPrincipal();
			membervo = customuser.getMember();
			chatroomjoinvo.setMem_seq(membervo.getMem_seq());
			chatroomjoinvo_list = chatroomjoinmapper.getList_by_mem_seq(chatroomjoinvo);
			for (int i = 0; i < chatroomjoinvo_list.size(); i++) {
				chatroomvo_list.add(i, chatroommapper.get_by_chatroom_seq(chatroomjoinvo_list.get(i)));
				chatroomvo_list.get(i).setChatroom_personnel(chatroomjoinmapper.getCount_by_chatroom_seq(chatroomjoinvo_list.get(i)));
//				chatroomvo_list.add(chatroommapper.get_by_chatroom_seq(chatroomjoinvo_list.get(i)));
			}
		}
		return chatroomvo_list;
		
	}



}
