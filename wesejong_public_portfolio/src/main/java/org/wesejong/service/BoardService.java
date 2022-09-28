package org.wesejong.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.Authentication;
import org.wesejong.domain.BoardDisLikeVO;
import org.wesejong.domain.BoardLikeVO;
import org.wesejong.domain.BoardManageVO;
import org.wesejong.domain.BoardReplyVO;
import org.wesejong.domain.BoardVO;
import org.wesejong.domain.Criteria;

public interface BoardService {
	
	public void register_without_boardattachimage(BoardVO boardvo);
	
	public void register_with_boardattachimage(BoardVO boardvo);
	
	public void register_with_boardmanage_boardattachimage(BoardManageVO boardmanagevo, BoardVO boardvo, Authentication authentication);
	
	public void modify_with_boardmanage_boardattachimage(BoardManageVO boardmanagevo, BoardVO boardvo, Authentication authentication);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO boardvo);
	
	public boolean remove(Long bno);
	
	public boolean remove_by_bno(BoardVO boardvo);
	
	public List<BoardVO> getList();
	
	public List<BoardVO> getList_by_bno_limit_0_5(Long board_id);
	
//	인기게시판용 5개씩 미리보기 함수
	public List<BoardVO> getList_by_bno_and_boardlikecount_bigger_than_ten_limit_0_5(Long board_id);
	
//	전체게시판용 5개씩 미리보기 함수
	public List<BoardVO> getList_by_bno_limit_0_5_get_allpost();
	
	public List<BoardVO> getList_without_boardattachimage(Criteria cri);
	
	public List<BoardVO> getList_with_boardattachimage(Criteria cri);
	
	public List<BoardVO> getList_with_boardmanage_boardattachimage(BoardManageVO boardmanagevo, Criteria cri);
	
//	인기게시판용 목록 가져오기 함수
	public List<BoardVO> getList_with_boardmanage_boardattachimage_by_bno_and_boardlikecount_bigger_than_ten(BoardManageVO boardmanagevo, Criteria cri);
	
//	전체모든글 가져오기(검색을 위해 생각했지만 전체게시판으로 생각바뀜)
	public List<BoardVO> getList_with_boardmanage_boardattachimage_get_allpost(@Param("boardmanagevo") BoardManageVO boardmanagevo, @Param("cri") Criteria cri);
	
	public int getTotal(Criteria cri);
	
	public int getTotalCount_with_boardmanage(BoardManageVO boardmanagevo, Criteria cri);
	
	public int getTotalCount_with_boardmanage_by_bno_and_boardlikecount_bigger_than_ten(BoardManageVO boardmanagevo, Criteria cri);
	
	public int getTotalCount_with_boardmanage_boardattachimage_get_allpost(BoardManageVO boardmanagevo, Criteria cri);

//	home.jsp에서 now() - 1 부터 now() 까지 새로운글이 한개라도 존재하면 카테고리에 new 버튼을 띄어주는 함수입니다.
	public int getExists_by_board_id_and_regdate_yesterday_to_today(BoardManageVO boardmanagevo);
	
//	home.jsp에서 now() - 1 부터 now() 까지 새로운글이 한개라도 존재하면 카테고리에 new 버튼을 띄어주는 함수입니다.
	public int getExists_by_board_id_and_regdate_yesterday_to_today_allpost();
	
//	게시판 boardreply_count 개수 업데이트
	public void update_boardreply_count(BoardReplyVO boardreplyvo);
	
//	게시판 boardlikecount 개수 업데이트
	public void update_boardlikecount(BoardLikeVO boardlikevo);

//	게시판 boardlikecount 개수 업데이트
	public void update_boarddislikecount(BoardDisLikeVO boarddislikevo);
	
//	
	public void update_boardviewcount(BoardVO boardvo);
	
	
/////////////////////
//	AdminBoard용    //
/////////////////////
	
	public List<BoardVO> AdminBoard_getList_limit_0_300();
	
	public List<BoardVO> AdminBoard_getboardnoticeList_limit_0_300();
	
	public boolean AdminBoard_modify_board_id_title_content_notice(BoardVO boardvo);
}
