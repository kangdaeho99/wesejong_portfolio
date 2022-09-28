package org.wesejong.mapper;

import java.util.List;

import org.wesejong.domain.MeetMatchManageVO;
import org.wesejong.domain.MeetMatchTeamVO;

public interface MeetMatchManageMapper {

	public List<MeetMatchManageVO> getList();
	
	public List<MeetMatchManageVO> getListWith_meetmatchpersonnelmanage();
	
	public List<MeetMatchManageVO> getListWith_meetmatchpersonnelmanage_by_meetmatchmanage_seq(MeetMatchManageVO meetmatchmanagevo);
	
	public MeetMatchManageVO get_by_meetmatchmanage_seq_of_meetmatchteam(MeetMatchTeamVO meetmatchteamvo);
	
	public void insert(MeetMatchManageVO meetmatchmanagevo);
	
	public void insertSelectKey(MeetMatchManageVO meetmatchmanagevo);
	
	public MeetMatchManageVO read(Long meetmatchmanage_seq);
	
	public int delete(Long meetmatchmanage_seq);
	
	public int update(MeetMatchManageVO meetmatchmanagevo);
	
	public Long Max_meetmatchmanage_seq();
	
}
