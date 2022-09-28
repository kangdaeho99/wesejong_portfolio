package org.wesejong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wesejong.domain.MeetMatchProfileVO;
import org.wesejong.mapper.MeetMatchProfileMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MeetMatchProfileServiceImpl implements MeetMatchProfileService{
	
	@Setter(onMethod_=@Autowired)
	private MeetMatchProfileMapper meetmatchprofilemapper;
	
	@Override
	public void register(MeetMatchProfileVO meetmatchprofilevo) {
		// TODO Auto-generated method stub
		log.info("reigster...."+meetmatchprofilevo);
		meetmatchprofilemapper.insertSelectKey(meetmatchprofilevo);
	}

	@Override
	public MeetMatchProfileVO get(Long meetmatchprofile_seq) {
		// TODO Auto-generated method stub
		log.info("get....."+meetmatchprofile_seq);
		MeetMatchProfileVO meetmatchprofilevo = new MeetMatchProfileVO();
		meetmatchprofilevo.setMeetmatchprofile_seq(meetmatchprofile_seq);
		return meetmatchprofilemapper.read(meetmatchprofilevo);
	}
	
	@Override
	public MeetMatchProfileVO get_by_mem_seq(Long mem_seq) {
		// TODO Auto-generated method stub
		log.info("get..."+mem_seq);
		MeetMatchProfileVO meetmatchprofilevo = new MeetMatchProfileVO();
		meetmatchprofilevo.setMem_seq(mem_seq);
		return meetmatchprofilemapper.read_by_mem_seq(meetmatchprofilevo);
	}

	@Override
	public boolean modify(MeetMatchProfileVO meetmatchprofilevo) {
		// TODO Auto-generated method stub
		log.info("modify......"+meetmatchprofilevo);
		return meetmatchprofilemapper.update(meetmatchprofilevo) == 1;
	}

	@Override
	public boolean remove(Long meetmatchprofile_seq) {
		// TODO Auto-generated method stub
		log.info("remove......"+meetmatchprofile_seq);
		return meetmatchprofilemapper.delete(meetmatchprofile_seq) == 1;
	}

	@Override
	public List<MeetMatchProfileVO> getList() {
		// TODO Auto-generated method stub
		log.info("getList...........");
		return meetmatchprofilemapper.getList();
	}

	@Override
	public int getExists_by_mem_seq(Long mem_seq) {
		// TODO Auto-generated method stub
		log.info("getExists....");
		MeetMatchProfileVO meetmatchprofilevo = new MeetMatchProfileVO();
		meetmatchprofilevo.setMem_seq(mem_seq);
		return meetmatchprofilemapper.getExists_by_mem_seq(meetmatchprofilevo);
	}

}
