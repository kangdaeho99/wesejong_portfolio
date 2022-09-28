package org.wesejong.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


//  /meetmatch/event/applicationhistory.jsp에서 표시를 편하게 하기 위해 만든 VO입니다.
@Data
public class MeetMatchApplicationDetailsVO {
	
	private String mem_userid;
	private String meetmatchteammate_gender;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date meetmatchteaammate_regdate;
	
	private Long meetmatchteammate_certified;
	private Long meetmatchteam_matchedflag;
	
	
}



//create table meetmatchmanage(
//meetmatchmanage_seq int(11) not null auto_increment primary key,
//meetmatchmanage_eventid int(11) not null,
//meetmatchmanage_eventtitle varchar(400) not null,
//meetmatchmanage_eventcontent varchar(400) not null,
//meetmatchmanage_eventregdate timestamp default current_timestamp,
//meetmatchmanage_eventstartdate timestamp default current_timestamp,
//meetmatchmanage_eventenddate timestamp default current_timestamp,
//meetmatchmanage_eventendflag int(11) not null default 0
//);
