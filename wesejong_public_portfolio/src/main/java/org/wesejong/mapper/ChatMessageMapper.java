package org.wesejong.mapper;

import java.util.List;

import org.wesejong.domain.ChatMessageVO;
import org.wesejong.domain.ChatRoomVO;

public interface ChatMessageMapper {
	
	public List<ChatMessageVO> getList();
	
	public List<ChatMessageVO> getChatMessageVOList(ChatRoomVO chatroomvo);
	
	public List<ChatMessageVO> getChatMessageVOList_limit_0_30(ChatRoomVO chatroomvo);
	
	public ChatRoomVO getChatRoom_seq_by_chatroom_uuid(ChatRoomVO chatroomvo);
	
	public void insert(ChatMessageVO chatmessagevo);
	
	public void insertSelectKey(ChatMessageVO chatmessagevo);
	
	public ChatMessageVO read(Long chatmessage_seq);
	
	public int delete(Long chatmessage_seq);
	
	public int delete_by_chatroomvo(ChatRoomVO chatroomvo);
	
	public int update(ChatMessageVO chatmessagevo);
	
}
