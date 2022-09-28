package org.wesejong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wesejong.domain.MeetMatchPersonnelManageVO;
import org.wesejong.mapper.MeetMatchPersonnelManageMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MeetMatchPersonnelManageServiceImpl implements MeetMatchPersonnelManageService{
	
	@Setter(onMethod_=@Autowired)
	private MeetMatchPersonnelManageMapper meetmatchpersonnelmanagemapper;
	
	@Override
	public void register(MeetMatchPersonnelManageVO meetmatchpersonnelmanagevo) {
		// TODO Auto-generated method stub
		log.info("reigster...."+meetmatchpersonnelmanagevo);
		meetmatchpersonnelmanagemapper.insertSelectKey(meetmatchpersonnelmanagevo);
	}

	@Override
	public MeetMatchPersonnelManageVO get(Long meetmatchpersonnelmanage_seq) {
		// TODO Auto-generated method stub
		log.info("get....."+meetmatchpersonnelmanage_seq);
		return meetmatchpersonnelmanagemapper.read(meetmatchpersonnelmanage_seq);
	}

	@Override
	public boolean modify(MeetMatchPersonnelManageVO meetmatchpersonnelmanagevo) {
		// TODO Auto-generated method stub
		log.info("modify......"+meetmatchpersonnelmanagevo);
		return meetmatchpersonnelmanagemapper.update(meetmatchpersonnelmanagevo) == 1;
	}

	@Override
	public boolean remove(Long meetmatchpersonnelmanage_seq) {
		// TODO Auto-generated method stub
		log.info("remove......"+meetmatchpersonnelmanage_seq);
		return meetmatchpersonnelmanagemapper.delete(meetmatchpersonnelmanage_seq) == 1;
	}

	@Override
	public List<MeetMatchPersonnelManageVO> getList() {
		// TODO Auto-generated method stub
		log.info("getList...........");
		return meetmatchpersonnelmanagemapper.getList();
	}
	
	@Override
	public List<MeetMatchPersonnelManageVO> getListWith_meetmatchpersonnelmanage() {
		// TODO Auto-generated method stub
		log.info("getListWith_meetmatchpersonnelmanage...........");
		
		return meetmatchpersonnelmanagemapper.getList();
	}

}
