package org.wesejong.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.wesejong.config.RootConfig.class})
@Log4j
public class ChatMessageServiceTests {
	@Setter(onMethod_= {@Autowired})
	private ChatMessageService chatservice;
	
}
