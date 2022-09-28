package org.wesejong.mapper;

import java.util.List;

import org.wesejong.domain.BoardReplyVO;
import org.wesejong.domain.BoardVO;

public interface BoardReplyMapper {
	
	public List<BoardReplyVO> getList(BoardVO boardvo);
	
	public void insert(BoardReplyVO boardreplyvo);
	
	public void insertSelectKey(BoardReplyVO boardreplyvo);
	
	public BoardReplyVO read(BoardReplyVO boardreplyvo);
	
	public int delete(BoardReplyVO boardreplyvo);
	
	public int delete_by_bno_and_parent(BoardReplyVO boardreplyvo);
	
	public int update(BoardReplyVO boardreplyvo);
	
//	deleteflag = 1 로 변경해주는 함수입니다.
	public int update_reply_deleteflag_by_brno(BoardReplyVO boardreplyvo);
	
//	게시물의 댓글 전체개수
	public Long getTotalReplyCount_of_board_by_bno(BoardReplyVO boardreplyvo);

//	해당 댓글이 대댓글이 존재하는지 확인합니다.
	public int getExists_rereply_by_parent(BoardReplyVO boardreplyvo);

	
}
