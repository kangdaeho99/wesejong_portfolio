package org.wesejong.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wesejong.domain.BoardManageVO;
import org.wesejong.mapper.BoardManageMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardManageServiceImpl implements BoardManageService{
	
	@Setter(onMethod_=@Autowired)
	private BoardManageMapper boardmanagemapper;
	
	@Override
	public void register(BoardManageVO boardmanagevo) {
		// TODO Auto-generated method stub
		log.info("reigster...."+boardmanagevo);
		boardmanagemapper.insertSelectKey(boardmanagevo);
	}

	@Override
	public BoardManageVO get(Long mbno) {
		// TODO Auto-generated method stub
		log.info("get....."+mbno);
		return boardmanagemapper.read(mbno);
	}

	@Override
	public boolean modify(BoardManageVO boardmanagevo) {
		// TODO Auto-generated method stub
		log.info("modify......"+boardmanagevo);
		return boardmanagemapper.update(boardmanagevo) == 1;
	}

	@Override
	public boolean remove(Long mbno) {
		// TODO Auto-generated method stub
		log.info("remove......"+mbno);
		return boardmanagemapper.delete(mbno) == 1;
	}

	@Override
	public List<BoardManageVO> getList() {
		// TODO Auto-generated method stub
		log.info("getList...........");
		return boardmanagemapper.getList();
	}

	@Override
	public List<BoardManageVO> getList_by_board_order() {
		// TODO Auto-generated method stub
//		List<BoardManageVO> boardmanagevo_list = new LinkedList<BoardManageVO>();
		return boardmanagemapper.getList_by_board_order();
	}
	
	@Override
	public BoardManageVO get_by_board_id(Long board_id) {
		log.info("get_by_board_id...."+board_id);
		return boardmanagemapper.read_by_board_id(board_id);
	}



}
