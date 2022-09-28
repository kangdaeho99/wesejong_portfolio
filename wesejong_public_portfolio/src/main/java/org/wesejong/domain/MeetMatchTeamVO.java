package org.wesejong.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MeetMatchTeamVO {
	private Long meetmatchteam_seq;
	private String meetmatchteam_gender;
	private Long meetmatchteam_certified;
	private Long meetmatchteam_matchedflag;
	private Long meetmatchteam_matchedpartner;

	private Date meetmatchteam_regdate;
	private Date meetmatchteam_certifieddate;
	
	private Long meetmatchmanage_seq;
	private Long meetmatchpersonnelmanage_personnel;
	private Long meetmatchteammate_certifiedcount;
}



//meetmatchteam 데이터베이스에
//-meetmatchteam_seq:1
//-meetmatchteam_eventid:10
//-meetmatchteam_gender:"male"."female"
//-meetmatchteam_certified
//-meetmatch
//-meetmatchteam_regdate:지원날짜
//-meetmatchteam_matchedflag:"fail,"success" 

//create table meetmatchteam(
//meetmatchteam_seq int(11) not null auto_increment primary key,
//meetmatchteam_eventid int(11) not null,
//meetmatchteam_gender varchar(400) not null,
//meetmatchteam_certified int(11) not null default 0,
//meetmatchteam_matchedflag int(11) not null deafult 0, 
//meetmatchteam_regdate timestamp default current_timestamp,
//meetmatchteam_certifieddate timestamp default null,
//);
