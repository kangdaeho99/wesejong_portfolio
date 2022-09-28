package org.wesejong.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardReplyVO {
	private Long brno;
	private Long bno;
	private String reply;
	private String replyer;
	
	private Long anonymous;
	private Long deleteflag;
	
	private Date regDate;
	private Date updateDate;
	private Date deleteDate;
	private Long parent;
	
	private Long mem_seq;
}
