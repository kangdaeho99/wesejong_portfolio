package org.wesejong.mapper;

import java.util.List;

import org.wesejong.domain.BoardDisLikeVO;
import org.wesejong.domain.BoardVO;

public interface BoardDisLikeMapper {

	public List<BoardDisLikeVO> getList(BoardVO boardvo);
	
	public void insert(BoardDisLikeVO boarddislikevo);
	
	public void insertSelectKey(BoardDisLikeVO boarddislikevo);
	
	public BoardDisLikeVO read(BoardDisLikeVO boarddislikevo);
	
	public BoardDisLikeVO read_by_bno_and_mem_seq(BoardDisLikeVO boarddislikevo);
	
	public int delete(BoardDisLikeVO boarddislikevo);
	
	public int delete_by_bno_and_mem_seq(BoardDisLikeVO boarddislikevo);
	
	public int update(BoardDisLikeVO boarddislikevo);

//	데이터 존재여부를 bno와 mem_seq를 통해 가져옴 	
	public int getExistsBoardDisLikeColumn(BoardDisLikeVO boarddislikevo); 
	
//	게시물의 좋아요 전체개수
	public Long getTotalBoardDisLikeCount_of_post_by_bno(BoardDisLikeVO boarddislikevo);
//	게시물의 좋아요 전체개수	
	public Long getTotalBoardDisLikeCount_of_post_by_bno(BoardVO boardvo);
	
}
