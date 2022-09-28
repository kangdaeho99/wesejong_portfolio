package org.wesejong.service;

import java.util.List;

import org.wesejong.domain.MeetMatchDepartmentVO;

public interface MeetMatchDepartmentService {
	public void register(MeetMatchDepartmentVO meetmatchdepartmentvo);
	
	public MeetMatchDepartmentVO get(Long meetmatchdepartment_seq);
	
	public boolean modify(MeetMatchDepartmentVO meetmatchdepartmentvo);

	public boolean remove(Long meetmatchdepartment_seq);
	
	public List<MeetMatchDepartmentVO> getList();

	
}
