package org.wesejong.mapper;

import java.util.List;

import org.wesejong.domain.MeetMatchPersonnelManageVO;

public interface MeetMatchPersonnelManageMapper {

	public List<MeetMatchPersonnelManageVO> getList();
	
	public void insert(MeetMatchPersonnelManageVO meetmatchpersonnelmanagevo);
	
	public void insertSelectKey(MeetMatchPersonnelManageVO meetmatchpersonnelmanagevo);
	
	public MeetMatchPersonnelManageVO read(Long meetmatchpersonnelmanage_seq);
	
	public int delete(Long meetmatchpersonnelmanage_seq);
	
	public int update(MeetMatchPersonnelManageVO meetmatchpersonnelmanagevo);
	
}
