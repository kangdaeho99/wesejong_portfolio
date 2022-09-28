package org.wesejong.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ChatMessageVO {
	private Long chatmessage_seq;
	private Long mem_seq;
	private Long chatroom_seq;
	private String chatmessage;
	private Date chatregdate;
}
