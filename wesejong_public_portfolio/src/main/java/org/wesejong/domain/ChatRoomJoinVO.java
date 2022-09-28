package org.wesejong.domain;

import lombok.Data;

@Data
public class ChatRoomJoinVO {
	private Long chatroomjoin_seq;
	private Long chatroom_seq;
	private Long mem_seq;
}
