package org.wesejong.mapper;

import java.util.List;

import org.wesejong.domain.AlarmVO;
import org.wesejong.domain.MemberVO;

public interface AlarmMapper {
	
	public List<AlarmVO> getList();
	
	public List<AlarmVO> getList_by_mem_seq(MemberVO membervo);
	
	public void insert(AlarmVO alarmvo);
	
	public void insertSelectKey(AlarmVO alarmvo);
	
	public AlarmVO read(Long alarm_seq);
	
	public int delete(Long alarm_seq);
	
	public int update(AlarmVO boardmanagevo);

	public int getCount_by_mem_seq_and_alarm_readcheck(AlarmVO alarmvo);
	
	public int update_alarm_readcheck_by_mem_seq(AlarmVO alarmvo);
	
	
}
