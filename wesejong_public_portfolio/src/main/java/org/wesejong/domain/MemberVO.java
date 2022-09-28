package org.wesejong.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	private Long mem_seq;
	private String mem_userid;
	private String mem_password;
	private String mem_nickname;
	private String mem_email;
	private int mem_email_certified;
	private int mem_studentid;
	private Date mem_regdate;
	private Date mem_updateDate;
	private int mem_enabled;
	
	private List<AuthorityVO> mem_authorityList;
}
