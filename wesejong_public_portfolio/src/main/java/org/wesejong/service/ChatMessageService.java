package org.wesejong.service;

import java.util.List;

import org.wesejong.domain.ChatMessageVO;
import org.wesejong.domain.ChatRoomVO;

public interface ChatMessageService {

	public void register(ChatMessageVO chatmessagevo);
	
	public ChatMessageVO get(Long chatmessage_seq);
	
	public boolean modify(ChatMessageVO chatmessagevo);

	public boolean remove(Long chatmessage_seq);	
	
	public boolean remove_chatmessage_by_chatroomvo(ChatRoomVO chatroomvo);
	
	public List<ChatMessageVO> getList();	
	
	public List<ChatMessageVO> getChatMessageVOList_by_chatroom_seq_via_chatroom_uuid(ChatRoomVO chatroomvo);
	
	
	
}
