package org.wesejong.mapper;

import java.util.List;

import org.wesejong.domain.ChatRoomJoinVO;
import org.wesejong.domain.ChatRoomVO;

public interface ChatRoomJoinMapper {
	
	public List<ChatRoomJoinVO> getList();
	
	public List<ChatRoomJoinVO> getList_by_mem_seq(ChatRoomJoinVO chatroomjoinvo);
	
	public void insert(ChatRoomJoinVO chatroomjoinvo);
	
	public void insertSelectKey(ChatRoomJoinVO chatroomjoinvo);
	
	public ChatRoomJoinVO read(ChatRoomJoinVO chatroomjoinvo);
	
	public int delete(ChatRoomJoinVO chatroomjoinvo);
	
	public int delete_by_chatroom_seq_and_mem_seq(ChatRoomJoinVO chatroomjoinvo);
	
	public int update(ChatRoomJoinVO chatroomjoinvo);
	
//	chatroom_seq과 mem_seq이 일치하는 chatroomjoin이 존재하는지 찾습니다.
	public int getExists_by_chatroom_seq_and_mem_Seq(ChatRoomJoinVO chatroomjoinvo);
		
//	chatroom_seq를 통해 chatroomjoin 값이 몇개 존재하는지 찾습니다.
	public Long getCount_by_chatroom_seq(ChatRoomJoinVO chatroomjoinvo);
}
