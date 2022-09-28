package org.wesejong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.wesejong.domain.ChatRoomJoinVO;
import org.wesejong.domain.ChatRoomVO;
import org.wesejong.domain.MemberVO;
import org.wesejong.mapper.ChatRoomJoinMapper;
import org.wesejong.security.domain.CustomUser;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ChatRoomJoinServiceImpl implements ChatRoomJoinService{
	
	@Setter(onMethod_=@Autowired)
	private ChatRoomJoinMapper chatroomjoinmapper;

	@Setter(onMethod_=@Autowired)
	private ChatRoomService chatroomservice;
	
	@Override
	public void register(ChatRoomJoinVO chatroomjoinvo) {
		// TODO Auto-generated method stub
		log.info("reigster...."+chatroomjoinvo);

		chatroomjoinmapper.insertSelectKey(chatroomjoinvo);
	}

	@Override
	public ChatRoomJoinVO get(ChatRoomJoinVO chatroomjoinvo) {
		// TODO Auto-generated method stub
		log.info("get....."+chatroomjoinvo);
		return chatroomjoinmapper.read(chatroomjoinvo);
	}

	@Override
	public boolean modify(ChatRoomJoinVO chatroomjoinvo) {
		// TODO Auto-generated method stub
		log.info("modify......"+chatroomjoinvo);
		return chatroomjoinmapper.update(chatroomjoinvo) == 1;
	}

	@Override
	public boolean remove(ChatRoomJoinVO chatroomjoinvo) {
		// TODO Auto-generated method stub
		log.info("remove......"+chatroomjoinvo);
		return chatroomjoinmapper.delete(chatroomjoinvo) == 1;
	}

	@Override
	public List<ChatRoomJoinVO> getList() {
		// TODO Auto-generated method stub
		log.info("getList...........");
		return chatroomjoinmapper.getList();
	}

	@Override
	public void check_Existence_and_register(ChatRoomVO chatroomvo, Authentication authentication) {
		// TODO Auto-generated method stub
		ChatRoomJoinVO chatroomjoinvo = new ChatRoomJoinVO();
		
		if(authentication!=null) {
			CustomUser customuser = (CustomUser) authentication.getPrincipal();
			MemberVO membervo =  (MemberVO)customuser.getMember();
			
//			chatroom 존재여부는 Controller단에서 확인헀습니다.
			chatroomvo = chatroomservice.get_by_chatroom_uuid(chatroomvo);
//			System.out.println(chatroomvo);
			chatroomjoinvo.setMem_seq(membervo.getMem_seq());
			chatroomjoinvo.setChatroom_seq(chatroomvo.getChatroom_seq());
			if(chatroomjoinmapper.getExists_by_chatroom_seq_and_mem_Seq(chatroomjoinvo) == 0) {
				chatroomjoinmapper.insertSelectKey(chatroomjoinvo);
			}else {
				
			}					
		
		}

	}

	@Override
	public void remove_chatroomjoinvo_by_chatroom_seq_and_mem_seq(ChatRoomVO chatroomvo, Authentication authentication) {
		// TODO Auto-generated method stub
		ChatRoomJoinVO chatroomjoinvo = new ChatRoomJoinVO();
		if(authentication != null) {
			CustomUser customuser = (CustomUser) authentication.getPrincipal();
			MemberVO membervo = (MemberVO) customuser.getMember();
			chatroomjoinvo.setChatroom_seq(chatroomvo.getChatroom_seq());
			chatroomjoinvo.setMem_seq(membervo.getMem_seq());
			System.out.println(chatroomjoinvo);
			if(chatroomjoinmapper.getExists_by_chatroom_seq_and_mem_Seq(chatroomjoinvo) == 1) {
				chatroomjoinmapper.delete_by_chatroom_seq_and_mem_seq(chatroomjoinvo);	
			}
		}
	}



}
