package org.wesejong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.wesejong.domain.BoardManageVO;
import org.wesejong.domain.BoardReplyVO;
import org.wesejong.domain.BoardVO;
import org.wesejong.domain.Criteria;
import org.wesejong.domain.MemberVO;

public interface BoardMapper {
	
	//insert into tbl_board (title, content, writer) values ('the title', 'the content', 'the writer');
//	@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	public List<BoardVO> getList_by_bno_limit_0_5(Long board_id);
	
//	인기게시판 5개 미리보기
	public List<BoardVO> getList_by_bno_and_boardlikecount_bigger_than_ten_limit_0_5(Long board_id);
	
//	전체게시판 5개 미리보기
	public List<BoardVO> getList_by_bno_limit_0_5_get_allpost();
	
	public List<BoardVO> getListWithPaging_without_boardattachimage(Criteria cri);
	
	public List<BoardVO> getListWithPaging_with_boardattachimage(Criteria cri);

	public List<BoardVO> getListWithPaging_with_boardmanage_boardattachimage(@Param("boardmanagevo") BoardManageVO boardmanagevo, @Param("cri") Criteria cri);
	
//	인기게시판 boardlikecount 10개 이상인 글 전체를 다 가져오는 함수입니다.
	public List<BoardVO> getListWithPaging_with_boardmanage_boardattachimage_by_bno_and_boardlikecount_bigger_than_ten(@Param("boardmanagevo") BoardManageVO boardmanagevo, @Param("cri") Criteria cri);

//	전체모든글 가져오기(검색을 위해 생각했지만 전체게시판으로 생각바뀜)
	public List<BoardVO> getListWithPaging_with_boardmanage_boardattachimage_get_allpost(@Param("boardmanagevo") BoardManageVO boardmanagevo, @Param("cri") Criteria cri);
	
	public List<BoardVO> getList_by_mem_seq(MemberVO membervo);
	
	public void insert(BoardVO boardvo);
	
	public void insertSelectKey(BoardVO boardvo);
	
	public Long insertSelectKey_with_boardmanage(@Param("boardmanagevo") BoardManageVO boardmanagevo, @Param("boardvo") BoardVO boardvo);
	
	public int last_insert_id();
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int delete_by_bno(BoardVO boardvo);
	
	public int update(BoardVO boardvo);
	
	
	public int update_title_content_updatedate(BoardVO boardvo);
	
	public int update_boardreply_count_by_bno(BoardVO boardvo);
	
	public int update_boardlikecount_by_bno(BoardVO boardvo);
	
	public int update_boarddislikecount_by_bno(BoardVO boardvo);
	
	public int update_viewcount_by_bno(BoardVO boardvo);
	
	public int getTotalCount(Criteria cri);
	
	public int getTotalCount_with_boardmanage(@Param("boardmanagevo") BoardManageVO boardmanagevo,@Param("cri") Criteria cri);

	public int getTotalCount_with_boardmanage_by_bno_and_boardlikecount_bigger_than_ten(@Param("boardmanagevo") BoardManageVO boardmanagevo,@Param("cri") Criteria cri);
	
	public int getTotalCount_with_boardmanage_boardattachimage_get_allpost(@Param("boardmanagevo") BoardManageVO boardmanagevo,@Param("cri") Criteria cri);
	
//	home.jsp에서 now() - 1 부터 now() 까지 새로운글이 한개라도 존재하면 카테고리에 new 버튼을 띄어주는 함수입니다.
	public int getExists_by_board_id_and_regdate_yesterday_to_today(Long board_id);
	
	public int getExists_by_board_id_and_regdate_yesterday_to_today_allpost();
	
/////////////////////
//AdminBoard용    //
/////////////////////
	
	public List<BoardVO> getList_limit_0_300();
	
	public List<BoardVO> getboardnoticeList_limit_0_300();
	
	public int update_board_id_title_content_notice(BoardVO boardvo);
}
