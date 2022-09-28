package org.wesejong.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MeetMatchManageVO {
	private Long meetmatchmanage_seq;
	private Long meetmatchmanage_eventid;
	private String meetmatchmanage_eventtitle;
	private String meetmatchmanage_eventcontent;
	
	
//	pattern안의 데이터 타입으로 들어오면 DateForMat으로 변경해주는 어노테이션입니다.
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date meetmatchmanage_eventregdate;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date meetmatchmanage_eventupdatedate;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date meetmatchmanage_eventstartdate;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date meetmatchmanage_eventenddate;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date meetmatchmanage_eventreleasedate;
	
	private Long meetmatchmanage_eventendflag;
	
	private List<MeetMatchPersonnelManageVO> meetmatchpersonnelmanagevoList;
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
