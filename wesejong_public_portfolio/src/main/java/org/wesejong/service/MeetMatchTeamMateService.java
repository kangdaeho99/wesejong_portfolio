package org.wesejong.service;

import java.util.List;

import org.wesejong.domain.MeetMatchTeamMateVO;
import org.wesejong.domain.MeetMatchTeamVO;
import org.wesejong.domain.MemberVO;

public interface MeetMatchTeamMateService {
	public void register(MeetMatchTeamMateVO meetmatchteammatevo);
	
	public MeetMatchTeamMateVO get(Long meetmatchteammate_seq);
	
	public boolean modify(MeetMatchTeamMateVO meetmatchteammatevo);

	public boolean remove(Long meetmatchteammate_seq);
	
	public List<MeetMatchTeamMateVO> getList();

	public List<MeetMatchTeamMateVO> getList_by_mem_seq_of_member(MemberVO membervo);
	
	public List<MeetMatchTeamMateVO> getList_by_meetmatchteam_seq_of_meetmatchteam(MeetMatchTeamVO meetmatchteamvo, MemberVO membervo);
	
	public List<MeetMatchTeamMateVO> getList_by_meetmatchteam_seq_of_meetmatchteam(MeetMatchTeamVO meetmatchteamvo);
	
	public MeetMatchTeamMateVO get_by_meetmatchteam_seq_and_mem_seq(MeetMatchTeamMateVO meetmatchteammatevo);
	
	public boolean update_meetmatchteammate_certified_by_meetmatchteam_seq_and_mem_seq(MeetMatchTeamMateVO meetmatchteammatevo);
	
}
