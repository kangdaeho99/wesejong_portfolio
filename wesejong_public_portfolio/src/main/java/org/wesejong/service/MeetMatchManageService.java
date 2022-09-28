package org.wesejong.service;

import java.util.List;

import org.wesejong.domain.MeetMatchManageVO;
import org.wesejong.domain.MeetMatchTeamVO;
import org.wesejong.domain.MemberVO;

public interface MeetMatchManageService {
	public void register(MeetMatchManageVO meetmatchmanagevo);
	
	public MeetMatchManageVO get(Long meetmatchmanage_seq);
	
	public MeetMatchManageVO get_by_meetmatchteammate_meetmatchteammate(MemberVO membervo);
	
	public boolean modify(MeetMatchManageVO meetmatchmanagevo);

	public boolean remove(Long meetmatchmanage_seq);
	
	public List<MeetMatchManageVO> getList();
	
	public List<MeetMatchManageVO> getListWith_meetmatchpersonnelmanage();
	
	public List<MeetMatchManageVO> getListWith_meetmatchpersonnelmanage_by_meetmatchmanage_seq(MeetMatchManageVO meetmatchmanagevo);
	
	public List<MeetMatchManageVO> getList_by_meetmatchmanage_seq_of_meetmatchteam(MemberVO membervo);
	
	public MeetMatchManageVO get_MeetMatchManageVO_by_read_Max_meetmatchmanage_seq();
	
	
	
}
