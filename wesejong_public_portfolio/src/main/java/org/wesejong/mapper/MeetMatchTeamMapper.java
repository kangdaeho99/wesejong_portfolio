package org.wesejong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.wesejong.domain.MeetMatchTeamMateVO;
import org.wesejong.domain.MeetMatchTeamVO;

public interface MeetMatchTeamMapper {
	
	public List<MeetMatchTeamVO> getList();
	
	public List<MeetMatchTeamVO> getList_by_meetmatchmanage_seq_and_meetmatchpersonnelmanage_personnel(MeetMatchTeamVO meetmatchteamvo);
	
	public List<MeetMatchTeamVO> getList_by_meetmatchmanage_seq_and_meetmatchpersonnelmanage_personnel_and_meetmatchteam_matchedflag_and_meetmatchteam_gender(MeetMatchTeamVO meetmatchteamvo);
	
	public List<MeetMatchTeamVO> getList_by_meetmatchmanage_seq_and_meetmatchteam_matchedflag(MeetMatchTeamVO meetmatchteamvo);
	
	public List<MeetMatchTeamVO> getList_by_meetmatchmanage_seq_and_meetmatchteam_certified_and_meetmatchpersonnelmanage_personnel_and_meetmatchteam_gender(MeetMatchTeamVO meetmatchteamvo);
	
	public MeetMatchTeamVO get_by_meetmatchteam_seq_of_meetmatchteammate(MeetMatchTeamMateVO meetmatchteammatevo);
	
	public void insert(MeetMatchTeamVO meetmatchteamvo);
	
	public void insertSelectKey(@Param("meetmatchteamvo") MeetMatchTeamVO meetmatchteamvo);
	
	public MeetMatchTeamVO read(Long meetmatchteam_seq);
	
	public int delete(Long meetmatchteam_seq);
	
	public int update(MeetMatchTeamVO meetmatchteamvo);
	
	public int update_meetmatchteam_certified(MeetMatchTeamVO meetmatchteamvo);
	
	public int update_meetmatchteam_matchedflag(MeetMatchTeamVO meetmatchteamvo);
	
	public int update_meetmatchteam_matchedpartner(MeetMatchTeamVO meetmatchteamvo);

	public int update_certified_count_by_meetmatchteam_seq(MeetMatchTeamVO meetmatchteamvo);
	
	
}
