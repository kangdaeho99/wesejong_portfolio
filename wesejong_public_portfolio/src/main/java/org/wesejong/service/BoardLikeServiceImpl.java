package org.wesejong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.wesejong.domain.BoardLikeVO;
import org.wesejong.domain.BoardVO;
import org.wesejong.domain.MemberVO;
import org.wesejong.mapper.BoardLikeMapper;
import org.wesejong.mapper.BoardMapper;
import org.wesejong.security.domain.CustomUser;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardLikeServiceImpl implements BoardLikeService{
	
	@Setter(onMethod_=@Autowired)
	private BoardLikeMapper boardlikemapper;

	@Setter(onMethod_=@Autowired)
	private BoardMapper boardmapper;
	
	@Setter(onMethod_=@Autowired)
	private BoardService boardservice;
	
	@Override
	public void register(BoardLikeVO boardlikevo, Authentication authentication) {
		// TODO Auto-generated method stub
		
		log.info("reigster...."+boardlikevo);
		if(authentication != null) {
			CustomUser customuser = (CustomUser) authentication.getPrincipal();
			MemberVO membervo = customuser.getMember();
			boardlikevo.setMem_seq(membervo.getMem_seq());
			boardlikevo.setLikecheck((long) 1); 
		}
		boardlikemapper.insertSelectKey(boardlikevo);

		boardservice.update_boardlikecount(boardlikevo);
		
	}

	@Override
	public BoardLikeVO get(BoardLikeVO boardlikevo) {
		// TODO Auto-generated method stub
		log.info("get....."+boardlikevo);
		return boardlikemapper.read(boardlikevo);
	}

	@Override
	public boolean modify(BoardLikeVO boardlikevo) {
		// TODO Auto-generated method stub
		log.info("modify......"+boardlikevo);
		return boardlikemapper.update(boardlikevo) == 1;
	}

	@Override
	public boolean remove(BoardLikeVO boardlikevo) {
		// TODO Auto-generated method stub
		log.info("remove......"+boardlikevo);
		return boardlikemapper.delete(boardlikevo) == 1;
	}
	
	@Override
	public void remove_by_bno_and_mem_seq(BoardLikeVO boardlikevo, Authentication authentication) {
		log.info("remove_by_mem_seq...."+boardlikevo);
		if(authentication != null) {
			CustomUser customuser = (CustomUser) authentication.getPrincipal();
			MemberVO membervo = customuser.getMember();
			boardlikevo.setMem_seq(membervo.getMem_seq());
		}
		boardlikemapper.delete_by_bno_and_mem_seq(boardlikevo);
		boardservice.update_boardlikecount(boardlikevo);
	}

	@Override
	public List<BoardLikeVO> getList(BoardVO boardvo) {
		// TODO Auto-generated method stub
		log.info("getList...........");
		return boardlikemapper.getList(boardvo);
	}
	
	@Override
	public Long getTotalBoardLikeCount_of_post_by_bno(BoardLikeVO boardlikevo) {
		log.info("getTotalLikeCount_of_post");
		return boardlikemapper.getTotalBoardLikeCount_of_post_by_bno(boardlikevo);
	}
	
	@Override
	public Long getTotalBoardLikeCount_of_post_by_bno(BoardVO boardvo) {
		// TODO Auto-generated method stub
		
		return boardlikemapper.getTotalBoardLikeCount_of_post_by_bno(boardvo);
	}

	@Override
	public int checkExistsLikeColumn_by_bno_and_mem_seq(BoardLikeVO boardlikevo) {
		// TODO Auto-generated method stub
		log.info("checkExistsLikeColumn_by_bno_and_mem_seq");
		return boardlikemapper.getExistsBoardLikeColumn(boardlikevo);
	}

	
	@Override
	public int checkExistsLikeColumn_by_bno_and_mem_seq(BoardVO boardvo, Authentication authentication) {
		// TODO Auto-generated method stub
		BoardLikeVO boardlikevo = new BoardLikeVO();
		if(authentication != null) {
			CustomUser customuser = (CustomUser) authentication.getPrincipal();
			MemberVO membervo = customuser.getMember();
			boardlikevo.setBno(boardvo.getBno());
			boardlikevo.setMem_seq(membervo.getMem_seq());			
			return boardlikemapper.getExistsBoardLikeColumn(boardlikevo);
		}
		
		return 0;
		
	}


}
