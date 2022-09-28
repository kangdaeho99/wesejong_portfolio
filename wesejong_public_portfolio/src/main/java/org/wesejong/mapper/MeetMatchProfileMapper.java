package org.wesejong.mapper;

import java.util.List;

import org.wesejong.domain.MeetMatchProfileVO;

public interface MeetMatchProfileMapper {
	
	public List<MeetMatchProfileVO> getList();
	
	public void insert(MeetMatchProfileVO meetmatchprofilevo);
	
	public void insertSelectKey(MeetMatchProfileVO meetmatchprofilevo);
	
	public MeetMatchProfileVO read(MeetMatchProfileVO meetmatchprofilevo);
	
	public MeetMatchProfileVO read_by_mem_seq(MeetMatchProfileVO meetmatchprofilevo);
	
	public int delete(Long meetmatchprofile_seq);
	
	public int update(MeetMatchProfileVO meetmatchprofilevo);
	
	public int getExists_by_mem_seq(MeetMatchProfileVO meetmatchprofilevo); 

	
}
