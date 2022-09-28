package org.wesejong.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MeetMatchProfileVO {
	private Long meetmatchprofile_seq;
	private String meetmatchprofile_gender;
	private String meetmatchprofile_department;
	private Date meetmatchprofile_regdate;
	
	private Long mem_seq;
//	private String mem_userid;
}


//meetmatchprofile 데이터베이스에
//-meetmatchprofile_seq:1
//-meetmatchprofile_gender:male,female
//-meetmatchprofile_department:컴퓨터공학과
//
//create table meetmatchprofile(
//meetmatchprofile_seq int(11) not null auto_increment primary key,
//meetmatchprofile_gender varchar(400) not null,
//meetmatchprofile_department varchar(400) not null default '',
//
//mem_seq int(11) not null,
//mem_userid varchar(400) not null
//)
