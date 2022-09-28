package org.wesejong.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.wesejong.domain.ChatRoomJoinVO;
import org.wesejong.domain.ChatRoomVO;

public interface ChatRoomJoinService {

	public void register(ChatRoomJoinVO chatroomjoinvo);
	
	public ChatRoomJoinVO get(ChatRoomJoinVO chatroomjoinvo);
	
	public boolean modify(ChatRoomJoinVO chatroomjoinvo);

	public boolean remove(ChatRoomJoinVO chatroomjoinvo);	
	
	public List<ChatRoomJoinVO> getList();	
	
	public void check_Existence_and_register(ChatRoomVO chatroomvo, Authentication authentication);
	
	public void remove_chatroomjoinvo_by_chatroom_seq_and_mem_seq(ChatRoomVO chatroomvo, Authentication authentication);
	
}
