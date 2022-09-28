package org.wesejong.service;

import java.util.List;

import org.wesejong.domain.MeetMatchTeamMateVO;
import org.wesejong.domain.MeetMatchTeamVO;

public interface MeetMatchTeamService {
	public void register(MeetMatchTeamVO meetmatchteamvo);
	
	public MeetMatchTeamVO get(Long meetmatchteam_seq);
	
	public boolean modify(MeetMatchTeamVO meetmatchteamvo);

	public boolean remove(Long meetmatchteam_seq);
	
	public List<MeetMatchTeamVO> getList();
	
	public List<MeetMatchTeamVO> getList_by_meetmatchteam_seq_of_meetmatchteammate(List<MeetMatchTeamMateVO> meetmatchteammatevo);
	
	public List<MeetMatchTeamVO> getList_by_meetmatchmanage_seq_and_meetmatchpersonnelmanage_personnel(MeetMatchTeamVO meetmatchteamvo);
	
	public List<MeetMatchTeamVO> getList_by_meetmatchmanage_seq_and_meetmatchteam_matchedflag(MeetMatchTeamVO meetmatchteamvo);
	
	public List<MeetMatchTeamVO> getList_by_meetmatchmanage_seq_and_meetmatchpersonnelmanage_personnel_and_meetmatchteam_matchedflag_and_meetmatchteam_gender(MeetMatchTeamVO meetmatchteamvo);

	public List<MeetMatchTeamVO> getList_by_meetmatchmanage_seq_and_meetmatchteam_certified_and_meetmatchpersonnelmanage_personnel_and_meetmatchteam_gender(MeetMatchTeamVO meetmatchteamvo);
	
	public void update_certified_count_by_meetmatchteam_seq(MeetMatchTeamVO meetmatchteamvo);
	
	public boolean update_meetmatchteam_certified(MeetMatchTeamVO meetmatchteamvo);
	
	public boolean update_meetmatchteam_matchedflag(MeetMatchTeamVO meetmatchteamvo);
	
	public boolean update_meetmatchteam_matchedpartner(MeetMatchTeamVO meetmatchteamvo);
}
