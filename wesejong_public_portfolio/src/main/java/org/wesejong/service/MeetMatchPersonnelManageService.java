package org.wesejong.service;

import java.util.List;

import org.wesejong.domain.MeetMatchPersonnelManageVO;

public interface MeetMatchPersonnelManageService {
	public void register(MeetMatchPersonnelManageVO meetmatchpersonnelmanagevo);
	
	public MeetMatchPersonnelManageVO get(Long meetmatchpersonnelmanage_seq);
	
	public boolean modify(MeetMatchPersonnelManageVO meetmatchpersonnelmanagevo);

	public boolean remove(Long meetmatchpersonnelmanage_seq);
	
	public List<MeetMatchPersonnelManageVO> getList();
	
	public List<MeetMatchPersonnelManageVO> getListWith_meetmatchpersonnelmanage();
	
}
