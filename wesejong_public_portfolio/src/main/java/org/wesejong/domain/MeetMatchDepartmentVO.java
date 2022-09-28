package org.wesejong.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MeetMatchDepartmentVO {
	private Long meetmatchdepartment_seq;
	private String meetmatchdepartment_department;
	private Date meetmatchdepartment_regdate;
}
