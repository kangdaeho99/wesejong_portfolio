package org.wesejong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.wesejong.domain.BoardReplyVO;
import org.wesejong.domain.BoardVO;
import org.wesejong.domain.MemberVO;
import org.wesejong.mapper.BoardMapper;
import org.wesejong.mapper.BoardReplyMapper;
import org.wesejong.security.domain.CustomUser;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardReplyServiceImpl implements BoardReplyService{
	
	@Setter(onMethod_=@Autowired)
	private BoardReplyMapper boardreplymapper;
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper boardmapper;
	
	@Setter(onMethod_=@Autowired)
	private BoardService boardservice;
	
	@Override
	public void register(BoardReplyVO boardreplyvo, Authentication authentication) {
		// TODO Auto-generated method stub
		log.info("reigster...."+boardreplyvo);
		if(authentication != null) {
			CustomUser customuser = (CustomUser) authentication.getPrincipal();
			MemberVO membervo = customuser.getMember();
			boardreplyvo.setMem_seq(membervo.getMem_seq());
			boardreplymapper.insertSelectKey(boardreplyvo);

			boardservice.update_boardreply_count(boardreplyvo);

		}
	}

	@Override
	public BoardReplyVO get(BoardReplyVO BoardReplyvo) {
		// TODO Auto-generated method stub
		log.info("get....."+BoardReplyvo);
		return boardreplymapper.read(BoardReplyvo);
	}

	@Override
	public boolean modify(BoardReplyVO BoardReplyvo) {
		// TODO Auto-generated method stub
		log.info("modify......"+BoardReplyvo);
		return boardreplymapper.update(BoardReplyvo) == 1;
	}

	@Override
	public void remove(BoardReplyVO boardreplyvo) {
		// TODO Auto-generated method stub
		log.info("remove......"+boardreplyvo);
		System.out.println(boardreplyvo);
		if(boardreplymapper.delete(boardreplyvo) == 1) {
			boardservice.update_boardreply_count(boardreplyvo);
		}
	}

	
	
//	댓글을 삭제하고 포함된 대댓글까지 모두 삭제합니다. 대댓글이 존재한다면 de
	@Override
	public void remove_reply_and_rereply(BoardReplyVO boardreplyvo) {
		// TODO Auto-generated method stub
		boardreplyvo = boardreplymapper.read(boardreplyvo);
		
		System.out.println(boardreplyvo);
		
//		해당 댓글에 대댓글이 존재한다면, reply deleted = 1 로 업데이트합니다.
		if(boardreplymapper.getExists_rereply_by_parent(boardreplyvo) == 1) {
			boardreplymapper.update_reply_deleteflag_by_brno(boardreplyvo);
			boardservice.update_boardreply_count(boardreplyvo);
		}
//		해당 댓글에 대댓글이 존재하지 않다면, 
		else {
			if(boardreplymapper.delete(boardreplyvo) == 1) {
				boardservice.update_boardreply_count(boardreplyvo);	
			}
			
		}
	}

	@Override
	public List<BoardReplyVO> getList(BoardVO boardvo) {
		// TODO Auto-generated method stub
		log.info("getList...........");
		return boardreplymapper.getList(boardvo);
	}


}
