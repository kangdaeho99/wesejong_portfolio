package org.wesejong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wesejong.domain.ChatMessageVO;
import org.wesejong.domain.ChatRoomVO;
import org.wesejong.mapper.ChatMessageMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ChatMessageServiceImpl implements ChatMessageService{
	
	@Setter(onMethod_=@Autowired)
	private ChatMessageMapper chatmessagemapper;

	@Override
	public void register(ChatMessageVO chatmessagevo) {
		// TODO Auto-generated method stub
		log.info("reigster...."+chatmessagevo);
		chatmessagemapper.insertSelectKey(chatmessagevo);
	}

	@Override
	public ChatMessageVO get(Long chatmessage_seq) {
		// TODO Auto-generated method stub
		log.info("get....."+chatmessage_seq);
		return chatmessagemapper.read(chatmessage_seq);
	}

	@Override
	public boolean modify(ChatMessageVO chatmessagevo) {
		// TODO Auto-generated method stub
		log.info("modify......"+chatmessagevo);
		return chatmessagemapper.update(chatmessagevo) == 1;
	}

	@Override
	public boolean remove(Long chatmessage_seq) {
		// TODO Auto-generated method stub
		log.info("remove......"+chatmessage_seq);
		return chatmessagemapper.delete(chatmessage_seq) == 1;
	}

	@Override
	public boolean remove_chatmessage_by_chatroomvo(ChatRoomVO chatroomvo) {
		// TODO Auto-generated method stub
		log.info("remove....."+chatroomvo);
		return chatmessagemapper.delete_by_chatroomvo(chatroomvo) == 1;
	}
	
	@Override
	public List<ChatMessageVO> getList() {
		// TODO Auto-generated method stub
		log.info("getList...........");
		return chatmessagemapper.getList();
	}

	@Override
	public List<ChatMessageVO> getChatMessageVOList_by_chatroom_seq_via_chatroom_uuid(ChatRoomVO chatroomvo) {
		// TODO Auto-generated method stub
		log.info("getChatMessageVOList....");
		ChatRoomVO chatroom_seq = chatmessagemapper.getChatRoom_seq_by_chatroom_uuid(chatroomvo);
		log.info("chatroom_url......:"+chatroom_seq);
//		List<ChatMessageVO> chatmessagevoList = chatmessagemapper.getChatMessageVOList(chatroom_seq);
		List<ChatMessageVO> chatmessagevoList = chatmessagemapper.getChatMessageVOList_limit_0_30(chatroom_seq);
		return chatmessagevoList;
	}



}
