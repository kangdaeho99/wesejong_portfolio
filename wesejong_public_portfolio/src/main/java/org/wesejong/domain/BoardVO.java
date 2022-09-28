package org.wesejong.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardVO {
	private Long bno;
	private Long board_id;
	private String title;
	private String content;
	private String writer;
	
	private Long anonymous;
	private String ip;
	
	private Date regdate;
	private Date updatedate;
	
	private Long viewcount;
	private Long boardlikecount;
	private Long boarddislikecount;
	private Long boardreply_count;
	
	private Long deleted;
	private Long notice;
	
	private Long mem_seq;
	
	private List<BoardAttachImageVO> boardattachimagefilelist;
}
