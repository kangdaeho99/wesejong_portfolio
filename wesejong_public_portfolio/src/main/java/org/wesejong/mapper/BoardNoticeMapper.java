package org.wesejong.mapper;

import java.util.List;

import org.wesejong.domain.BoardVO;

public interface BoardNoticeMapper {
	
	public List<BoardVO> getList();
	
	public void insert(BoardVO boardvo);
	
	public void insertSelectKey(BoardVO boardvo);
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO boardvo);

	public BoardVO read_by_board_id(Long board_id);
	
	
}
