package org.wesejong.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.wesejong.domain.AlarmVO;
import org.wesejong.domain.BoardVO;
import org.wesejong.domain.ChatRoomVO;

public interface MemberInfoService {
	
	public List<BoardVO> get_mypost_by_mem_seq(Authentication authentication);
	
	public List<AlarmVO> get_alarm_by_mem_seq(Authentication authentication);
	
	public List<ChatRoomVO> get_chatroom_by_mem_seq(Authentication authentication);
	
}
