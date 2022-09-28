package org.wesejong.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.wesejong.domain.BoardDisLikeVO;
import org.wesejong.domain.BoardVO;

public interface BoardDisLikeService {
	public void register(BoardDisLikeVO boarddislikevo, Authentication authentication);
	
	public BoardDisLikeVO get(BoardDisLikeVO boarddislikevo);
	
	public boolean modify(BoardDisLikeVO boarddislikevo);

	public boolean remove(BoardDisLikeVO boarddislikevo);
	
	public void remove_by_bno_and_mem_seq(BoardDisLikeVO boarddislikevo, Authentication authentication);
	
	public List<BoardDisLikeVO> getList(BoardVO boardvo);
	
	public Long getTotalBoardDisLikeCount_of_post_by_bno(BoardDisLikeVO boarddislikevo);
	
	public Long getTotalBoardDisLikeCount_of_post_by_bno(BoardVO boardvo);
	
	public int checkExistsDisLikeColumn_by_bno_and_mem_seq(BoardDisLikeVO boarddislikevo);	
	
	public int checkExistsDisLikeColumn_by_bno_and_mem_seq(BoardVO boardvo, Authentication authentication);	
	
	
}
