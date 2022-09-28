package org.wesejong.mapper;

import java.util.List;

import org.wesejong.domain.MeetMatchTeamMateVO;
import org.wesejong.domain.MeetMatchTeamVO;
import org.wesejong.domain.MemberVO;

public interface MeetMatchTeamMateMapper {
	
	public List<MeetMatchTeamMateVO> getList();
	
	public List<MeetMatchTeamMateVO> getList_by_mem_seq_of_member(MemberVO membervo);
	
	public List<MeetMatchTeamMateVO> getList_by_meetmatchteam_seq_of_meetmatchteam(MeetMatchTeamVO meetmatchteamvo);
	
	public void insert(MeetMatchTeamMateVO meetmatchteammatevo);
	
	public void insertSelectKey(MeetMatchTeamMateVO meetmatchteammatevo);
	
	public MeetMatchTeamMateVO read(Long meetmatchteammate_seq);
	
	public int delete(Long meetmatchteammate_seq);
	
	public int update(MeetMatchTeamMateVO meetmatchteammatevo);
	
	public int getCertifiedCount_by_meetmatchteam_seq_of_meetmatchteam(MeetMatchTeamVO meetmatchteamvo);
	
	public MeetMatchTeamMateVO get_by_meetmatchteam_seq_and_mem_seq(MeetMatchTeamMateVO meetmatchteammatevo);
	
	public int update_meetmatchteammate_certified_by_meetmatchteam_seq_and_mem_seq(MeetMatchTeamMateVO meetmatchteammatevo);
}
