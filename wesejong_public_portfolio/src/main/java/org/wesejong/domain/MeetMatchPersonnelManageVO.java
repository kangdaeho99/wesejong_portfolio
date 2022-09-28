package org.wesejong.domain;

import lombok.Data;

@Data
public class MeetMatchPersonnelManageVO {
	private Long meetmatchpersonnelmanage_seq;
	private Long meetmatchpersonnelmanage_personnel;
	private Long meetmatchmanage_seq;
}


//create table meetmatchpersonnelmanage(
//meetmatchpersonnelmanage_seq int(11) not null auto_increment primary key,
//meetmatchpersonnelmanage_personnel int(11) not null,
//meetmatchmanage_eventid int(11) not null
//);