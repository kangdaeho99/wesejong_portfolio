package org.wesejong.service;

import java.util.List;

import org.wesejong.domain.ChatRoomVO;

public interface ChatRoomService {

	public void register(ChatRoomVO chatroomvo);
	
	public String register_return_chatroom_uuid(ChatRoomVO chatroomvo);
	
	public ChatRoomVO register_return_chatroom_seq(ChatRoomVO chatroomvo);
	
	public String register_chatroom_chatroomjoin(ChatRoomVO chatroomvo, Long mem_seq1, Long mem_seq2);
	
	public ChatRoomVO get(ChatRoomVO chatroomvo);
	
	public ChatRoomVO get_by_chatroom_uuid(ChatRoomVO chatroomvo);
	
	public boolean modify(ChatRoomVO chatroomvo);

	public boolean remove(ChatRoomVO chatroomvo);	
	
	public boolean remove_chatroom_by_chatroomvo(ChatRoomVO chatroomvo);
	
	public List<ChatRoomVO> getList();	
	
	public ChatRoomVO getChatRoomVO_by_chatroom_uuid(ChatRoomVO chatroomvo);
	
	public String check_chatroomjoin_mem_seq1_mem_seq2_and_return_chatroom_uuid(Long mem_seq1, Long mem_seq2);
	
	public int getExists_by_chatroom_uuid(ChatRoomVO chatroomvo);
	

	
	
}
