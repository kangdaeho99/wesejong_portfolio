package org.wesejong.service;

import java.util.List;


import org.wesejong.domain.BoardManageVO;

public interface BoardManageService {
	public void register(BoardManageVO boardmanagevo);
	
	public BoardManageVO get(Long mbno);
	
	public boolean modify(BoardManageVO boardmanagevo);

	public boolean remove(Long mbno);
	
	public List<BoardManageVO> getList();
	
	public List<BoardManageVO> getList_by_board_order();

	public BoardManageVO get_by_board_id(Long board_id);
	
}
