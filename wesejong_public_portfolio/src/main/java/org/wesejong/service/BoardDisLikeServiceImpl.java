package org.wesejong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.wesejong.domain.BoardDisLikeVO;
import org.wesejong.domain.BoardVO;
import org.wesejong.domain.MemberVO;
import org.wesejong.mapper.BoardDisLikeMapper;
import org.wesejong.mapper.BoardMapper;
import org.wesejong.security.domain.CustomUser;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardDisLikeServiceImpl implements BoardDisLikeService{
	
	@Setter(onMethod_=@Autowired)
	private BoardDisLikeMapper boarddislikemapper;

	@Setter(onMethod_=@Autowired)
	private BoardMapper boardmapper;
	
	@Setter(onMethod_=@Autowired)
	private BoardService boardservice;
	
	@Override
	public void register(BoardDisLikeVO boarddislikevo, Authentication authentication) {
		// TODO Auto-generated method stub
		
		log.info("reigster...."+boarddislikevo);
		if(authentication != null) {
			CustomUser customuser = (CustomUser) authentication.getPrincipal();
			MemberVO membervo = customuser.getMember();
			boarddislikevo.setMem_seq(membervo.getMem_seq());
			boarddislikevo.setDislikecheck((long) 1); 
		}
		boarddislikemapper.insertSelectKey(boarddislikevo);

		boardservice.update_boarddislikecount(boarddislikevo);
		
	}

	@Override
	public BoardDisLikeVO get(BoardDisLikeVO boarddislikevo) {
		// TODO Auto-generated method stub
		log.info("get....."+boarddislikevo);
		return boarddislikemapper.read(boarddislikevo);
	}

	@Override
	public boolean modify(BoardDisLikeVO boarddislikevo) {
		// TODO Auto-generated method stub
		log.info("modify......"+boarddislikevo);
		return boarddislikemapper.update(boarddislikevo) == 1;
	}

	@Override
	public boolean remove(BoardDisLikeVO boarddislikevo) {
		// TODO Auto-generated method stub
		log.info("remove......"+boarddislikevo);
		return boarddislikemapper.delete(boarddislikevo) == 1;
	}
	
	@Override
	public void remove_by_bno_and_mem_seq(BoardDisLikeVO boarddislikevo, Authentication authentication) {
		log.info("remove_by_mem_seq...."+boarddislikevo);
		if(authentication != null) {
			CustomUser customuser = (CustomUser) authentication.getPrincipal();
			MemberVO membervo = customuser.getMember();
			boarddislikevo.setMem_seq(membervo.getMem_seq());
		}
		boarddislikemapper.delete_by_bno_and_mem_seq(boarddislikevo);
		boardservice.update_boarddislikecount(boarddislikevo);
	}

	@Override
	public List<BoardDisLikeVO> getList(BoardVO boardvo) {
		// TODO Auto-generated method stub
		log.info("getList...........");
		return boarddislikemapper.getList(boardvo);
	}
	
	@Override
	public Long getTotalBoardDisLikeCount_of_post_by_bno(BoardDisLikeVO boarddislikevo) {
		log.info("getTotalLikeCount_of_post");
		return boarddislikemapper.getTotalBoardDisLikeCount_of_post_by_bno(boarddislikevo);
	}
	
	@Override
	public Long getTotalBoardDisLikeCount_of_post_by_bno(BoardVO boardvo) {
		// TODO Auto-generated method stub
		
		return boarddislikemapper.getTotalBoardDisLikeCount_of_post_by_bno(boardvo);
	}

	@Override
	public int checkExistsDisLikeColumn_by_bno_and_mem_seq(BoardDisLikeVO boarddislikevo) {
		// TODO Auto-generated method stub
		log.info("checkExistsLikeColumn_by_bno_and_mem_seq");
		return boarddislikemapper.getExistsBoardDisLikeColumn(boarddislikevo);
	}

	
	@Override
	public int checkExistsDisLikeColumn_by_bno_and_mem_seq(BoardVO boardvo, Authentication authentication) {
		// TODO Auto-generated method stub
		BoardDisLikeVO boarddislikevo = new BoardDisLikeVO();
		
		if(authentication != null) {
			CustomUser customuser = (CustomUser) authentication.getPrincipal();
			MemberVO membervo = customuser.getMember();
			boarddislikevo.setBno(boardvo.getBno());
			boarddislikevo.setMem_seq(membervo.getMem_seq());			
			return boarddislikemapper.getExistsBoardDisLikeColumn(boarddislikevo);
		}
		
		return 0;
		
	}


}
