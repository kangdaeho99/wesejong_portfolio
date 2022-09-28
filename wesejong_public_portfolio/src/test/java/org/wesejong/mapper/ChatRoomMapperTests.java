package org.wesejong.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wesejong.domain.ChatRoomVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		org.wesejong.config.RootConfig.class,
		org.wesejong.config.SecurityConfig.class,
		org.wesejong.config.MailConfig.class
})
@Log4j
public class ChatRoomMapperTests {
	
	@Setter(onMethod_=@Autowired)
	private ChatRoomMapper chatroommapper;
	
	@Test
	public void testGetList() {
		chatroommapper.getList().forEach(chatroom->log.info(chatroom));
	}
	
	@Test
	public void testInsertSelectKey() {
		ChatRoomVO chatroomvo = new ChatRoomVO();
		
		
		chatroommapper.insertSelectKey(chatroomvo);
//		chatroomvo+1 해야합니다.
		System.out.println(chatroomvo);
		
	}
}
