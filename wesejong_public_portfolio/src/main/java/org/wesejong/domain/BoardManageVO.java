package org.wesejong.domain;

import lombok.Data;

@Data
public class BoardManageVO {
	private Long mbno;
	private Long board_id;
	private String board_name;
	private String board_type;
	private String board_url;
	private String board_desc;
	private Long board_order;
}
