package org.wesejong.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class AlarmVO {
	private Long alarm_seq;

	private String alarm_title;
	private String alarm_writer;
	private String alarm_content;
	
	private String alarm_type;
	private Date alarm_regdate;
	private Long alarm_readcheck;
	
	private Long mem_seq;
}
