package org.wesejong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.wesejong.domain.AlarmVO;
import org.wesejong.domain.MemberVO;
import org.wesejong.mapper.AlarmMapper;
import org.wesejong.security.domain.CustomUser;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class AlarmServiceImpl implements AlarmService{
	
	@Setter(onMethod_=@Autowired)
	private AlarmMapper alarmmapper;
	
	@Override
	public void register(AlarmVO alarmvo) {
		// TODO Auto-generated method stub
		log.info("reigster...."+alarmvo);
		alarmmapper.insertSelectKey(alarmvo);
	}
	
	@Override
	public void register_welcome_join(Long mem_seq) {
		// TODO Auto-generated method stub
		AlarmVO alarmvo = new AlarmVO();
		
		alarmvo.setMem_seq(mem_seq);
		alarmvo.setAlarm_title("세종대 웹커뮤니티 위세종(wesejong)에 오신것을 환영합니다!");
		alarmvo.setAlarm_content("자유게시판에서 자유롭게 첫번쨰 게시글을 한번 작성해보세요!");
		alarmvo.setAlarm_writer("wesejongadmin");
		alarmvo.setAlarm_type("0");
		alarmmapper.insertSelectKey(alarmvo);
	}
	

	@Override
	public AlarmVO get(Long alarm_seq) {
		// TODO Auto-generated method stub
		log.info("get....."+alarm_seq);
		return alarmmapper.read(alarm_seq);
	}

	@Override
	public boolean modify(AlarmVO alarmvo) {
		// TODO Auto-generated method stub
		log.info("modify......"+alarmvo);
		return alarmmapper.update(alarmvo) == 1;
	}

	@Override
	public boolean remove(Long alarm_seq) {
		// TODO Auto-generated method stub
		log.info("remove......"+alarm_seq);
		return alarmmapper.delete(alarm_seq) == 1;
	}

	@Override
	public List<AlarmVO> getList() {
		// TODO Auto-generated method stub
		log.info("getList...........");
		return alarmmapper.getList();
	}

	@Override
	public int getCount_by_mem_seq_and_alarm_readcheck(AlarmVO alarmvo) {
		// TODO Auto-generated method stub
				
		alarmvo.setAlarm_readcheck((long) 0); 

		return alarmmapper.getCount_by_mem_seq_and_alarm_readcheck(alarmvo);
	}

	@Override
	public boolean update_alarm_readcheck_by_mem_seq(Authentication authentication) {
		// TODO Auto-generated method stub
		AlarmVO alarmvo = new AlarmVO();
		
		if(authentication != null) {
			CustomUser customuser = (CustomUser) authentication.getPrincipal();
			MemberVO membervo = customuser.getMember();
			
			alarmvo.setAlarm_readcheck((long) 1);
			alarmvo.setMem_seq(membervo.getMem_seq());
		}

		return alarmmapper.update_alarm_readcheck_by_mem_seq(alarmvo) == 1;
	}



}









