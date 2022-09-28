package org.wesejong.persistence;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wesejong.domain.BoardVO;
import org.wesejong.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.wesejong.config.RootConfig.class})
@Log4j
public class BoardServiceTests {
	
	@Setter(onMethod_= {@Autowired})
	private BoardService boardservice;
	
	@Test
	public void testExist() {
		log.info(boardservice);
		assertNotNull(boardservice);
	}
	
	@Test
	public void test_register_with_boardattachimage() {
		
		String content="testwhat<img alt=\"\" src=\"/ckupload/2021/08/16/89687916-7f63-4161-a761-f455a00b4006_notice.PNG\" style=\"height:198px; width:496px\" />123";
		BoardVO boardvo = new BoardVO();
		boardvo.setTitle("test_register_with_boardattachimage");
		boardvo.setContent(content);
		boardvo.setWriter("test");
		
		boardservice.register_with_boardattachimage(boardvo);
	}
	
}
