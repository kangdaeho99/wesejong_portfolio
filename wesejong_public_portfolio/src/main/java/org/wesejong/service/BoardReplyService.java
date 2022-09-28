package org.wesejong.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.wesejong.domain.BoardReplyVO;
import org.wesejong.domain.BoardVO;

public interface BoardReplyService {
	public void register(BoardReplyVO BoardReplyvo, Authentication authentication);
	
	public BoardReplyVO get(BoardReplyVO BoardReplyvo);
	
	public boolean modify(BoardReplyVO BoardReplyvo);

	//	댓글을 삭제하고 포함된 대댓글까지 모두 삭제합니다.
	public void remove_reply_and_rereply(BoardReplyVO boardreplyvo);
	
	public void remove(BoardReplyVO boardreplyvo);
	
	public List<BoardReplyVO> getList(BoardVO boardvo);
	
}
