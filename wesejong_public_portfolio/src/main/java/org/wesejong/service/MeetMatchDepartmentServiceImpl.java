package org.wesejong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wesejong.domain.MeetMatchDepartmentVO;
import org.wesejong.mapper.MeetMatchDepartmentMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MeetMatchDepartmentServiceImpl implements MeetMatchDepartmentService{
	
	@Setter(onMethod_=@Autowired)
	private MeetMatchDepartmentMapper boardmanagemapper;
	
	@Override
	public void register(MeetMatchDepartmentVO meetmatchdepartmentvo) {
		// TODO Auto-generated method stub
		log.info("reigster...."+meetmatchdepartmentvo);
		boardmanagemapper.insertSelectKey(meetmatchdepartmentvo);
	}

	@Override
	public MeetMatchDepartmentVO get(Long meetmatchdepartment_seq) {
		// TODO Auto-generated method stub
		log.info("get....."+meetmatchdepartment_seq);
		return boardmanagemapper.read(meetmatchdepartment_seq);
	}

	@Override
	public boolean modify(MeetMatchDepartmentVO meetmatchdepartmentvo) {
		// TODO Auto-generated method stub
		log.info("modify......"+meetmatchdepartmentvo);
		return boardmanagemapper.update(meetmatchdepartmentvo) == 1;
	}

	@Override
	public boolean remove(Long meetmatchdepartment_seq) {
		// TODO Auto-generated method stub
		log.info("remove......"+meetmatchdepartment_seq);
		return boardmanagemapper.delete(meetmatchdepartment_seq) == 1;
	}

	@Override
	public List<MeetMatchDepartmentVO> getList() {
		// TODO Auto-generated method stub
		log.info("getList...........");
		return boardmanagemapper.getList();
	}

}
