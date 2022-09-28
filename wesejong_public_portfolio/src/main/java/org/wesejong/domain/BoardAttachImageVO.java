package org.wesejong.domain;

import lombok.Data;

@Data
public class BoardAttachImageVO {
	private Long boardattachimage_seq;
	private String boardattachimage_uploadpath;
	private String boardattachimage_uuid;

	private Long bno;
}
