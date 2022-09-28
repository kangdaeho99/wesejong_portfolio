package org.wesejong.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.wesejong.domain.BoardLikeVO;
import org.wesejong.domain.BoardVO;

public interface BoardLikeService {
	public void register(BoardLikeVO boardlikevo, Authentication authentication);
	
	public BoardLikeVO get(BoardLikeVO boardlikevo);
	
	public boolean modify(BoardLikeVO boardlikevo);

	public boolean remove(BoardLikeVO boardlikevo);
	
	public void remove_by_bno_and_mem_seq(BoardLikeVO boardlikevo, Authentication authentication);
	
	public List<BoardLikeVO> getList(BoardVO boardvo);
	
	public Long getTotalBoardLikeCount_of_post_by_bno(BoardLikeVO boardlikevo);
	
	public Long getTotalBoardLikeCount_of_post_by_bno(BoardVO boardvo);
	
	public int checkExistsLikeColumn_by_bno_and_mem_seq(BoardLikeVO boardlikevo);	
	
	public int checkExistsLikeColumn_by_bno_and_mem_seq(BoardVO boardvo, Authentication authentication);	
	
	
}
