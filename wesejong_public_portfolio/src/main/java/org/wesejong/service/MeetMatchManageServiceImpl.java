package org.wesejong.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wesejong.domain.MeetMatchManageVO;
import org.wesejong.domain.MeetMatchTeamMateVO;
import org.wesejong.domain.MeetMatchTeamVO;
import org.wesejong.domain.MemberVO;
import org.wesejong.mapper.MeetMatchManageMapper;
import org.wesejong.mapper.MeetMatchTeamMapper;
import org.wesejong.mapper.MeetMatchTeamMateMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MeetMatchManageServiceImpl implements MeetMatchManageService{
	
	@Setter(onMethod_=@Autowired)
	private MeetMatchManageMapper meetmatchmanagemapper;
	
	@Setter(onMethod_=@Autowired)
	private MeetMatchTeamMapper meetmatchteammapper;
	
	@Setter(onMethod_=@Autowired)
	private MeetMatchTeamMateMapper meetmatchteammatemapper;
	
	@Override
	public void register(MeetMatchManageVO meetmatchmanagevo) {
		// TODO Auto-generated method stub
		log.info("reigster...."+meetmatchmanagevo);
		meetmatchmanagemapper.insertSelectKey(meetmatchmanagevo);
	}

	@Override
	public MeetMatchManageVO get(Long meetmatchmanage_seq) {
		// TODO Auto-generated method stub
		log.info("get....."+meetmatchmanage_seq);
		return meetmatchmanagemapper.read(meetmatchmanage_seq);
	}
	
	@Override
	public MeetMatchManageVO get_by_meetmatchteammate_meetmatchteammate(MemberVO membervo) {
		log.info("get_by_meetmatchteammate_meetmatchteammate");
		MeetMatchManageVO meetmatchmanagevo = new MeetMatchManageVO();
		MeetMatchTeamVO meetmatchteamvo = new MeetMatchTeamVO();
		MeetMatchTeamMateVO meetmatchteammatevo = new MeetMatchTeamMateVO();
		
		
		return meetmatchmanagevo;
	}

	@Override
	public boolean modify(MeetMatchManageVO meetmatchmanagevo) {
		// TODO Auto-generated method stub
		log.info("modify......"+meetmatchmanagevo);
		return meetmatchmanagemapper.update(meetmatchmanagevo) == 1;
	}

	@Override
	public boolean remove(Long meetmatchmanage_seq) {
		// TODO Auto-generated method stub
		log.info("remove......"+meetmatchmanage_seq);
		return meetmatchmanagemapper.delete(meetmatchmanage_seq) == 1;
	}

	@Override
	public List<MeetMatchManageVO> getList() {
		// TODO Auto-generated method stub
		log.info("getList...........");
		return meetmatchmanagemapper.getList();
	}
	
	@Override
	public List<MeetMatchManageVO> getListWith_meetmatchpersonnelmanage() {
		// TODO Auto-generated method stub
		return meetmatchmanagemapper.getListWith_meetmatchpersonnelmanage();
	}
	
	@Override
	public List<MeetMatchManageVO> getListWith_meetmatchpersonnelmanage_by_meetmatchmanage_seq(MeetMatchManageVO meetmatchmanagevo) {
		// TODO Auto-generated method stub
		log.info("getListWith_meetmatchpersonnelmanage...........");
		
//		MeetMatchManageVO meetmatchmanagevo = new MeetMatchManageVO();
//		meetmatchmanagevo.setMeetmatchmanage_seq(meetmatchmanage_seq);
		
		return meetmatchmanagemapper.getListWith_meetmatchpersonnelmanage_by_meetmatchmanage_seq(meetmatchmanagevo);
	}

	@Override
	public MeetMatchManageVO get_MeetMatchManageVO_by_read_Max_meetmatchmanage_seq() {
		// TODO Auto-generated method stub
		log.info("getMax_meetmatchmanage_seq.................");
		return meetmatchmanagemapper.read(meetmatchmanagemapper.Max_meetmatchmanage_seq());
	}

	@Override
	public List<MeetMatchManageVO> getList_by_meetmatchmanage_seq_of_meetmatchteam(MemberVO membervo) {
		// TODO Auto-generated method stub
//		현재 사용자가 신청했었던 모든 teammate 값들을 가져옵니다.
		List<MeetMatchTeamMateVO> meetmatchteammatevo = meetmatchteammatemapper.getList_by_mem_seq_of_member(membervo);
		List<MeetMatchTeamVO> meetmatchteamvo = new ArrayList<MeetMatchTeamVO>();
		List<MeetMatchManageVO> meetmatchmanagevo = new ArrayList<MeetMatchManageVO>();
//		현재 사용자가 포함된 모든 team값들을 가져옵니다.
		for(int i=0;i<meetmatchteammatevo.size();i++) {
			meetmatchteamvo.add(meetmatchteammapper.get_by_meetmatchteam_seq_of_meetmatchteammate(meetmatchteammatevo.get(i)));
		}
//		현재 사용자가 신청했었던 meetmatchmanage 값들을 가져옵니다.
		for(int i=0;i<meetmatchteamvo.size();i++) {
			meetmatchmanagevo.add(meetmatchmanagemapper.get_by_meetmatchmanage_seq_of_meetmatchteam(meetmatchteamvo.get(i)));
		}
		return meetmatchmanagevo;
	}


}
