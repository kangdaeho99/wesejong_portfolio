package org.wesejong.mapper;

import java.util.List;

import org.wesejong.domain.MeetMatchDepartmentVO;

public interface MeetMatchDepartmentMapper {
	
	public List<MeetMatchDepartmentVO> getList();
	
	public void insert(MeetMatchDepartmentVO meetmatchdepartmentvo);
	
	public void insertSelectKey(MeetMatchDepartmentVO meetmatchdepartmentvo);
	
	public MeetMatchDepartmentVO read(Long meetmatchdepartment_seq);
	
	public int delete(Long meetmatchdepartment_seq);
	
	public int update(MeetMatchDepartmentVO meetmatchdepartmentvo);

	
}
