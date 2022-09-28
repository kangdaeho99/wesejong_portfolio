package org.wesejong.domain;

import lombok.Data;

@Data
public class ChatRoomVO {
	private Long chatroom_seq;
	private String chatroom_uuid;
	private String chatroom_name;
	
//	데이터베이스에는 존재하지않음. 채팅방 인원수를 쉽게 가지고 오기 위해 만든것임.
	private Long chatroom_personnel;
}
