package org.wesejong.domain;

import lombok.Data;

@Data
public class MailVO {
	private String from;
	private String subject;
	private String to;
	private String text;
	
}
