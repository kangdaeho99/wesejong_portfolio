package org.wesejong.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MeetMatchTeamMateVO {
	private Long meetmatchteammate_seq;
	private String meetmatchteammate_gender;
	private String meetmatchteammate_department;
	private Long meetmatchteammate_teamleaderflag;
	private Date meetmatchteammate_regdate;
	private Long meetmatchteammate_certified;
	private Date meetmatchteammate_certifieddate;

	private Long meetmatchteam_seq;
	private Long mem_seq;
}


//meetmatchteammate 데이터베이스에
//-meetmatchteammate_seq:1
//-meetmatchteammate_eventid:10
//-meetmatchteammate_gender:"male"."female"
//-meetmatchteammate_certified
//-meetmatchteammate_certifieddate
//-meetmatchteammate_regdate:지원날짜
//-meetmatchteammate_matchedflag:"fail,"success" "
		
//create table meetmatchteammate(
//meetmatchteammate_seq int(11) not null auto_increment primary key,
//meetmatchteammate_gender varchar(400) not null,
//meetmatchteammate_department varchar(400) not null default '',
//meetmatchteammate_certified int(11) not null default 0,
//meetmatchteammate_certifieddate timestamp default null,
//
//meetmatchteam_seq int(11) not null,
//meetmatchteam_eventid int(11) not null,
//mem_seq int(11) not null
//);
