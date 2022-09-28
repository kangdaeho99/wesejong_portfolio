package org.wesejong.mapper;

import java.util.List;

import org.wesejong.domain.BoardManageVO;
import org.wesejong.domain.TableVO;

public interface BoardManageMapper {
	
	public List<BoardManageVO> getList();
	
	public List<BoardManageVO> getList_by_board_order();
	
	public void insert(BoardManageVO boardmanagevo);
	
	public void insertSelectKey(BoardManageVO boardmanagevo);
	
	public BoardManageVO read(Long mbno);
	
	public int delete(Long mbno);
	
	public int update(BoardManageVO boardmanagevo);

	public BoardManageVO read_by_board_id(Long board_id);
	
	
}
