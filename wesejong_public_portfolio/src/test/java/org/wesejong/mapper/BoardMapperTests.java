package org.wesejong.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wesejong.domain.BoardManageVO;
import org.wesejong.domain.BoardVO;
import org.wesejong.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		org.wesejong.config.RootConfig.class,
		org.wesejong.config.SecurityConfig.class,
		org.wesejong.config.MailConfig.class
})
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_=@Autowired)
	private BoardMapper boardmapper;
	
	@Test
	public void testGetList() {
		boardmapper.getList().forEach(board->log.info(board));
	}
	
//	처음에 Could not autowire org.springframework.mail.javamail.JavaMailSender
//	오류가 잇엇는데 boardmappertest의 @Contextconfiguration에 MailConfig.class를 추가해줍니다.
	@Test
	public void testgetListWithPaging_with_boardmanage_boardattachimage() {
		BoardManageVO boardmanagevo = new BoardManageVO();
		BoardVO boardvo = new BoardVO();
		Criteria cri = new Criteria();
		
		boardmanagevo.setBoard_id((long) 1);
		
		cri.setFirst(0);
		cri.setAmount(5);
		
		cri.setType("TC");
		cri.setKeyword("내가");
		
		System.out.println(boardmanagevo);
		System.out.println(cri);
		
		boardmapper.getListWithPaging_with_boardmanage_boardattachimage(boardmanagevo, cri);
	}
	
	@Test
	public void testgetListWithPaging_with_boardmanage_boardattachimage_get_allpost() {
		BoardManageVO boardmanagevo = new BoardManageVO();
		BoardVO boardvo = new BoardVO();
		Criteria cri = new Criteria();
		
		boardmanagevo.setBoard_id((long) 999);
		
		cri.setFirst(0);
		cri.setAmount(15);
		
		cri.setType("TCW");
		cri.setKeyword("test");
		
		System.out.println(boardmanagevo);
		System.out.println(cri);
		
		boardmapper.getListWithPaging_with_boardmanage_boardattachimage_get_allpost(boardmanagevo, cri);
	}
	
	@Test
	public void testInsert() {
		BoardVO boardvo = new BoardVO();
		boardvo.setTitle("test");
		boardvo.setBoard_id((long)1);
		boardvo.setContent("test");
		boardvo.setWriter("test");
		
		boardmapper.insertSelectKey(boardvo);
		log.info(boardvo);
	}
	
	@Test
	public void insertSelectKey_with_boardmanage(){

		BoardVO boardvo = new BoardVO();
		boardvo.setTitle("test");
		boardvo.setBoard_id((long)1);
		boardvo.setContent("test");
		boardvo.setWriter("test");
		
		BoardManageVO boardmanagevo = new BoardManageVO();
		boardmanagevo.setBoard_id((long)1);
		
		boardmapper.insertSelectKey_with_boardmanage(boardmanagevo, boardvo);
		
		log.info(boardvo);
		
	}
}
