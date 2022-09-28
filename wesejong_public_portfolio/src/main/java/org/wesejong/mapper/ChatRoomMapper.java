package org.wesejong.mapper;

import java.util.List;

import org.wesejong.domain.ChatRoomJoinVO;
import org.wesejong.domain.ChatRoomVO;

public interface ChatRoomMapper {
	
	public List<ChatRoomVO> getList();
	
	public ChatRoomVO get_by_chatroom_uuid(ChatRoomVO chatroomvo);
	
	public ChatRoomVO get_by_chatroom_seq(ChatRoomJoinVO chatroomjoinvo);
	
	public void insert(ChatRoomVO chatroomvo);
	
	public void insertSelectKey(ChatRoomVO chatroomvo);
	
	public Long insertSelectKey_return_chatroom_seq(ChatRoomVO chatroomvo);
	
	public ChatRoomVO read(ChatRoomVO chatroomvo);
	
	public ChatRoomVO read_by_chatroom_seq(Long chatroom_seq);
	
	public int delete(ChatRoomVO chatroomvo);
	
	public int delete_by_chatroomvo(ChatRoomVO chatroomvo);
	
	public int update(ChatRoomVO chatroomvo);
	
//	chatroom_uuid를 통해 chatroom데이터베이스에 해당 방이 존재하는지 확인합니다.
	public int getExists_by_chatroom_uuid(ChatRoomVO chatroomvo);
	
}
