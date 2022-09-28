package org.wesejong.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wesejong.domain.MeetMatchTeamMateVO;
import org.wesejong.domain.MeetMatchTeamVO;
import org.wesejong.mapper.MeetMatchTeamMapper;
import org.wesejong.mapper.MeetMatchTeamMateMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MeetMatchTeamServiceImpl implements MeetMatchTeamService{
	
	@Setter(onMethod_=@Autowired)
	private MeetMatchTeamMapper meetmatchteammapper;

	@Setter(onMethod_=@Autowired)
	private MeetMatchTeamMateMapper meetmatchteammatemapper;
	
	@Override
	public void register(MeetMatchTeamVO meetmatchteamvo) {
		// TODO Auto-generated method stub
		log.info("reigster...."+meetmatchteamvo);
		meetmatchteammapper.insertSelectKey(meetmatchteamvo);
	}

	@Override
	public MeetMatchTeamVO get(Long mmeetmatchteam_seq) {
		// TODO Auto-generated method stub
		log.info("get....."+mmeetmatchteam_seq);
		return meetmatchteammapper.read(mmeetmatchteam_seq);
	}

	@Override
	public boolean modify(MeetMatchTeamVO meetmatchteamvo) {
		// TODO Auto-generated method stub
		log.info("modify......"+meetmatchteamvo);
		return meetmatchteammapper.update(meetmatchteamvo) == 1;
	}

	@Override
	public boolean remove(Long mmeetmatchteam_seq) {
		// TODO Auto-generated method stub
		log.info("remove......"+mmeetmatchteam_seq);
		return meetmatchteammapper.delete(mmeetmatchteam_seq) == 1;
	}

	@Override
	public List<MeetMatchTeamVO> getList() {
		// TODO Auto-generated method stub
		log.info("getList...........");
		return meetmatchteammapper.getList();
	}

	@Override
	public List<MeetMatchTeamVO> getList_by_meetmatchteam_seq_of_meetmatchteammate(
			List<MeetMatchTeamMateVO> meetmatchteammatevo) {
		// TODO Auto-generated method stub
		List<MeetMatchTeamVO> meetmatchteamvo = new ArrayList<MeetMatchTeamVO>();
		for(int i=0;i<meetmatchteammatevo.size();i++) {
			meetmatchteamvo.add(meetmatchteammapper.get_by_meetmatchteam_seq_of_meetmatchteammate(meetmatchteammatevo.get(i)));
		}
		return meetmatchteamvo;
	}
	
	@Override
	public List<MeetMatchTeamVO> getList_by_meetmatchmanage_seq_and_meetmatchpersonnelmanage_personnel(
			MeetMatchTeamVO meetmatchteamvo) {
		// TODO Auto-generated method stub
		
		return meetmatchteammapper.getList_by_meetmatchmanage_seq_and_meetmatchpersonnelmanage_personnel(meetmatchteamvo);
	}
	
	@Override
	public List<MeetMatchTeamVO> getList_by_meetmatchmanage_seq_and_meetmatchteam_matchedflag(
			MeetMatchTeamVO meetmatchteamvo) {
		// TODO Auto-generated method stub
		return meetmatchteammapper.getList_by_meetmatchmanage_seq_and_meetmatchteam_matchedflag(meetmatchteamvo);
	}
	
	@Override
	public List<MeetMatchTeamVO> getList_by_meetmatchmanage_seq_and_meetmatchpersonnelmanage_personnel_and_meetmatchteam_matchedflag_and_meetmatchteam_gender(
			MeetMatchTeamVO meetmatchteamvo) {
		// TODO Auto-generated method stub
		return meetmatchteammapper.getList_by_meetmatchmanage_seq_and_meetmatchpersonnelmanage_personnel_and_meetmatchteam_matchedflag_and_meetmatchteam_gender(meetmatchteamvo);
	}

	
	@Override
	public List<MeetMatchTeamVO> getList_by_meetmatchmanage_seq_and_meetmatchteam_certified_and_meetmatchpersonnelmanage_personnel_and_meetmatchteam_gender(
			MeetMatchTeamVO meetmatchteamvo) {
		// TODO Auto-generated method stub
		return meetmatchteammapper.getList_by_meetmatchmanage_seq_and_meetmatchteam_certified_and_meetmatchpersonnelmanage_personnel_and_meetmatchteam_gender(meetmatchteamvo);
	}


	@Override
	public void update_certified_count_by_meetmatchteam_seq(MeetMatchTeamVO meetmatchteamvo) {
		// TODO Auto-generated method stub
		Long meetmatchteam_certified_count = (long) meetmatchteammatemapper.getCertifiedCount_by_meetmatchteam_seq_of_meetmatchteam(meetmatchteamvo);
		meetmatchteamvo.setMeetmatchteammate_certifiedcount(meetmatchteam_certified_count);
		meetmatchteammapper.update_certified_count_by_meetmatchteam_seq(meetmatchteamvo);
	}
	
	@Override
	public boolean update_meetmatchteam_certified(MeetMatchTeamVO meetmatchteamvo) {
		// TODO Auto-generated method stub
		log.info("modify......"+meetmatchteamvo);
		return meetmatchteammapper.update_meetmatchteam_certified(meetmatchteamvo) == 1;
	}

	@Override
	public boolean update_meetmatchteam_matchedflag(MeetMatchTeamVO meetmatchteamvo) {
		// TODO Auto-generated method stub
		return meetmatchteammapper.update_meetmatchteam_matchedflag(meetmatchteamvo) == 1;
	}

	@Override
	public boolean update_meetmatchteam_matchedpartner(MeetMatchTeamVO meetmatchteamvo) {
		// TODO Auto-generated method stub
		return meetmatchteammapper.update_meetmatchteam_matchedpartner(meetmatchteamvo) == 1;
	}

}









