package org.wesejong.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wesejong.domain.ChatRoomJoinVO;
import org.wesejong.domain.ChatRoomVO;
import org.wesejong.mapper.ChatRoomJoinMapper;
import org.wesejong.mapper.ChatRoomMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ChatRoomServiceImpl implements ChatRoomService{
	
	@Setter(onMethod_=@Autowired)
	private ChatRoomMapper chatroommapper;

	@Setter(onMethod_=@Autowired)
	private ChatRoomJoinMapper chatroomjoinmapper;
	
	@Override
	public void register(ChatRoomVO chatroomvo) {
		// TODO Auto-generated method stub
		log.info("reigster...."+chatroomvo);
		UUID uuid = UUID.randomUUID();
		chatroomvo.setChatroom_uuid(uuid.toString());

		chatroommapper.insertSelectKey(chatroomvo);
	}
	
	@Override
	public String register_return_chatroom_uuid(ChatRoomVO chatroomvo) {
		// TODO Auto-generated method stub
		log.info("reigster...."+chatroomvo);
		UUID uuid = UUID.randomUUID();
		chatroomvo.setChatroom_uuid(uuid.toString());

		chatroommapper.insertSelectKey(chatroomvo);
		
		return uuid.toString();
	}
	
	@Override
	public ChatRoomVO register_return_chatroom_seq(ChatRoomVO chatroomvo) {
		log.info("register...."+chatroomvo);
		UUID uuid = UUID.randomUUID();
		chatroomvo.setChatroom_uuid(uuid.toString());
		
		chatroommapper.insertSelectKey(chatroomvo);
		return chatroomvo;
	}

	
	

	@Override
	public String register_chatroom_chatroomjoin(ChatRoomVO chatroomvo, Long mem_seq1, Long mem_seq2) {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
		String uuid_string = uuid.toString();
		chatroomvo.setChatroom_uuid(uuid_string);
		
		chatroommapper.insertSelectKey_return_chatroom_seq(chatroomvo);
		
		Long chatroom_seq = chatroomvo.getChatroom_seq()+1;
		
		ChatRoomJoinVO chatroomjoinvo_mem_seq1 = new ChatRoomJoinVO();
		ChatRoomJoinVO chatroomjoinvo_mem_seq2 = new ChatRoomJoinVO();
		chatroomjoinvo_mem_seq1.setMem_seq(mem_seq1);
		chatroomjoinvo_mem_seq1.setChatroom_seq(chatroom_seq);
		chatroomjoinvo_mem_seq2.setMem_seq(mem_seq2);
		chatroomjoinvo_mem_seq2.setChatroom_seq(chatroom_seq);		
		
		
		chatroomjoinmapper.insertSelectKey(chatroomjoinvo_mem_seq1);
		chatroomjoinmapper.insertSelectKey(chatroomjoinvo_mem_seq2);
		
		return uuid_string;
	}
	
	@Override
	public ChatRoomVO get(ChatRoomVO chatroomvo) {
		// TODO Auto-generated method stub
		log.info("get....."+chatroomvo);
		return chatroommapper.read(chatroomvo);
	}
	
	@Override
	public ChatRoomVO get_by_chatroom_uuid(ChatRoomVO chatroomvo) {
		// TODO Auto-generated method stub
		log.info("get....."+chatroomvo);
		return chatroommapper.get_by_chatroom_uuid(chatroomvo);
	}

	@Override
	public boolean modify(ChatRoomVO chatroomvo) {
		// TODO Auto-generated method stub
		log.info("modify......"+chatroomvo);
		return chatroommapper.update(chatroomvo) == 1;
	}

	@Override
	public boolean remove(ChatRoomVO chatroomvo) {
		// TODO Auto-generated method stub
		log.info("remove......"+chatroomvo);
		return chatroommapper.delete(chatroomvo) == 1;
	}

	@Override
	public boolean remove_chatroom_by_chatroomvo(ChatRoomVO chatroomvo) {
		// TODO Auto-generated method stub
		log.info("remove....."+chatroomvo);
		return chatroommapper.delete_by_chatroomvo(chatroomvo) == 1;
	}

	@Override
	public List<ChatRoomVO> getList() {
		// TODO Auto-generated method stub
		log.info("getList...........");
		return chatroommapper.getList();
	}

	@Override
	public ChatRoomVO getChatRoomVO_by_chatroom_uuid(ChatRoomVO chatroomvo) {
		// TODO Auto-generated method stub
		log.info("getChatRoomVO_by_chatroom_url......");
		ChatRoomJoinVO chatroomjoinvo = new ChatRoomJoinVO();
		chatroomvo = chatroommapper.get_by_chatroom_uuid(chatroomvo);
		
//		채팅방에 포함된 인원이 몇명인지 /socket/chat에서 알기위해 추가했습니다.
		chatroomjoinvo.setChatroom_seq(chatroomvo.getChatroom_seq());
		Long chatroom_personnel = chatroomjoinmapper.getCount_by_chatroom_seq(chatroomjoinvo);
		chatroomvo.setChatroom_personnel(chatroom_personnel);
		return chatroomvo;
	}

	@Override
	public String check_chatroomjoin_mem_seq1_mem_seq2_and_return_chatroom_uuid(Long mem_seq1, Long mem_seq2) {
		// TODO Auto-generated method stub
		
		
		List<ChatRoomJoinVO> chatroomjoinvolist_mem_seq1 = new ArrayList<ChatRoomJoinVO>();
		List<ChatRoomJoinVO> chatroomjoinvolist_mem_seq2 = new ArrayList<ChatRoomJoinVO>();
		
		ChatRoomJoinVO chatroomjoinvo_mem_seq1 = new ChatRoomJoinVO();
		ChatRoomJoinVO chatroomjoinvo_mem_seq2 = new ChatRoomJoinVO();
		chatroomjoinvo_mem_seq1.setMem_seq(mem_seq1);
		chatroomjoinvo_mem_seq2.setMem_seq(mem_seq2);
		
		chatroomjoinvolist_mem_seq1 = chatroomjoinmapper.getList_by_mem_seq(chatroomjoinvo_mem_seq1);
		chatroomjoinvolist_mem_seq2 = chatroomjoinmapper.getList_by_mem_seq(chatroomjoinvo_mem_seq2);
		
		for (int i = 0; i < chatroomjoinvolist_mem_seq1.size(); i++) {
			Long chatroomjoinvolist_mem_seq1_chatroom_seq = chatroomjoinvolist_mem_seq1.get(i).getChatroom_seq();
			for (int j = 0; j < chatroomjoinvolist_mem_seq2.size(); j++) {
				Long chatroomjoinvolist_mem_seq2_chatroom_seq = chatroomjoinvolist_mem_seq2.get(j).getChatroom_seq();
				
				if(chatroomjoinvolist_mem_seq1_chatroom_seq == chatroomjoinvolist_mem_seq2_chatroom_seq) {
					return chatroommapper.read_by_chatroom_seq(chatroomjoinvolist_mem_seq1_chatroom_seq).getChatroom_uuid();
				}
			}
		}
		
		return "null";
	}
	
	@Override
	public int getExists_by_chatroom_uuid(ChatRoomVO chatroomvo) {
		
		return chatroommapper.getExists_by_chatroom_uuid(chatroomvo);
	}

}
