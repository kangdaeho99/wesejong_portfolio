package org.wesejong.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.wesejong.domain.AlarmVO;

public interface AlarmService {
	public void register(AlarmVO alarmvo);
	
	public void register_welcome_join(Long mem_seq);
	
//	public void register_meetmatch_apply(AlarmVO alarmvo);
//	
//	public void register_meetmatch_applicationdetails_certify(AlarmVO alarmvo);
	
	public AlarmVO get(Long alarm_seq);
	
	public boolean modify(AlarmVO alarmvo);

	public boolean remove(Long alarm_seq);
	
	public List<AlarmVO> getList();
	
	public int getCount_by_mem_seq_and_alarm_readcheck(AlarmVO alarmvo);
	
	public boolean update_alarm_readcheck_by_mem_seq(Authentication authentication);
	
}
