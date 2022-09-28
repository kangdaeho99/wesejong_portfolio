package org.wesejong.mapper;

import java.util.List;

import org.wesejong.domain.BoardLikeVO;
import org.wesejong.domain.BoardVO;

public interface BoardLikeMapper {

	public List<BoardLikeVO> getList(BoardVO boardvo);
	
	public void insert(BoardLikeVO boardlikevo);
	
	public void insertSelectKey(BoardLikeVO boardlikevo);
	
	public BoardLikeVO read(BoardLikeVO boardlikevo);
	
	public BoardLikeVO read_by_bno_and_mem_seq(BoardLikeVO boardlikevo);
	
	public int delete(BoardLikeVO boardlikevo);
	
	public int delete_by_bno_and_mem_seq(BoardLikeVO boardlikevo);
	
	public int update(BoardLikeVO boardlikevo);

//	데이터 존재여부를 bno와 mem_seq를 통해 가져옴 	
	public int getExistsBoardLikeColumn(BoardLikeVO boardlikevo); 
	
//	게시물의 좋아요 전체개수
	public Long getTotalBoardLikeCount_of_post_by_bno(BoardLikeVO boardlikevo);
//	게시물의 좋아요 전체개수	
	public Long getTotalBoardLikeCount_of_post_by_bno(BoardVO boardvo);
	
}
