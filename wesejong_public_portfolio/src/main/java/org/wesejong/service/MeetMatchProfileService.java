package org.wesejong.service;

import java.util.List;

import org.wesejong.domain.MeetMatchProfileVO;

public interface MeetMatchProfileService {
	public void register(MeetMatchProfileVO meetmatchprofilevo);
	
	public MeetMatchProfileVO get(Long meetmatchprofile_seq);
	
	public MeetMatchProfileVO get_by_mem_seq(Long mem_seq);
	
	public boolean modify(MeetMatchProfileVO meetmatchprofilevo);

	public boolean remove(Long meetmatchprofile_seq);
	
	public List<MeetMatchProfileVO> getList();

	public int getExists_by_mem_seq(Long mem_seq);
	
}
