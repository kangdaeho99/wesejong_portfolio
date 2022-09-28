package org.wesejong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wesejong.domain.MeetMatchTeamMateVO;
import org.wesejong.domain.MeetMatchTeamVO;
import org.wesejong.domain.MemberVO;
import org.wesejong.mapper.MeetMatchTeamMateMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MeetMatchTeamMateServiceImpl implements MeetMatchTeamMateService{
	
	@Setter(onMethod_=@Autowired)
	private MeetMatchTeamMateMapper meetmatchteammatemapper;
	
	@Override
	public void register(MeetMatchTeamMateVO meetmatchteammatevo) {
		// TODO Auto-generated method stub
		log.info("reigster...."+meetmatchteammatevo);
		meetmatchteammatemapper.insertSelectKey(meetmatchteammatevo);
	}

	@Override
	public MeetMatchTeamMateVO get(Long mmeetmatchteammate_seq) {
		// TODO Auto-generated method stub
		log.info("get....."+mmeetmatchteammate_seq);
		return meetmatchteammatemapper.read(mmeetmatchteammate_seq);
	}

	@Override
	public boolean modify(MeetMatchTeamMateVO meetmatchteammatevo) {
		// TODO Auto-generated method stub
		log.info("modify......"+meetmatchteammatevo);
		return meetmatchteammatemapper.update(meetmatchteammatevo) == 1;
	}

	@Override
	public boolean remove(Long mmeetmatchteammate_seq) {
		// TODO Auto-generated method stub
		log.info("remove......"+mmeetmatchteammate_seq);
		return meetmatchteammatemapper.delete(mmeetmatchteammate_seq) == 1;
	}

	@Override
	public List<MeetMatchTeamMateVO> getList() {
		// TODO Auto-generated method stub
		log.info("getList...........");
		return meetmatchteammatemapper.getList();
	}
	
	@Override
	public List<MeetMatchTeamMateVO> getList_by_mem_seq_of_member(MemberVO membervo){
		// TODO Auto-generated method stub
		log.info("getList_by_mem_seq_of_member...........");		
		return meetmatchteammatemapper.getList_by_mem_seq_of_member(membervo);
	}

	
//	meetmatchteam_seq를 통해서 meetmatchteammatevo 를 가져옵니다.
//	그 과정에서 현재 사용자가 meetmatchteammatevo에 속해있지 않다면, 값을 리턴하지 않습니다.
	@Override
	public List<MeetMatchTeamMateVO> getList_by_meetmatchteam_seq_of_meetmatchteam(
			MeetMatchTeamVO meetmatchteamvo, MemberVO membervo) {
		// TODO Auto-generated method stub
		List<MeetMatchTeamMateVO> meetmatchteammatevo_list = meetmatchteammatemapper.getList_by_meetmatchteam_seq_of_meetmatchteam(meetmatchteamvo);
		System.out.println(meetmatchteammatevo_list);
		int check_member_included_in_meetmatchteammate=0;
//		meetmatchteam에 접속한 유저가 해당 팀에 속해있는지 아닌지 확인하는 반목문		
		for(int i=0;i<meetmatchteammatevo_list.size();i++) {
			if(meetmatchteammatevo_list.get(i).getMem_seq() == membervo.getMem_seq()) {
				check_member_included_in_meetmatchteammate = 1;
				break;
			}
		}
		System.out.println(meetmatchteammatevo_list);
		if(check_member_included_in_meetmatchteammate == 1) {
			return meetmatchteammatevo_list;
		}else {
			return null;
		}
		
	}
	
	@Override
	public List<MeetMatchTeamMateVO> getList_by_meetmatchteam_seq_of_meetmatchteam(MeetMatchTeamVO meetmatchteamvo) {
		// TODO Auto-generated method stub
		return meetmatchteammatemapper.getList_by_meetmatchteam_seq_of_meetmatchteam(meetmatchteamvo);
	}

	@Override
	public MeetMatchTeamMateVO get_by_meetmatchteam_seq_and_mem_seq(MeetMatchTeamMateVO meetmatchteammatevo) {
		// TODO Auto-generated method stub
		
		return meetmatchteammatemapper.get_by_meetmatchteam_seq_and_mem_seq(meetmatchteammatevo);
	}

	@Override
	public boolean update_meetmatchteammate_certified_by_meetmatchteam_seq_and_mem_seq(
			MeetMatchTeamMateVO meetmatchteammatevo) {
		// TODO Auto-generated method stub
		
		
		return meetmatchteammatemapper.update_meetmatchteammate_certified_by_meetmatchteam_seq_and_mem_seq(meetmatchteammatevo)==1;
	}
	
	

}
