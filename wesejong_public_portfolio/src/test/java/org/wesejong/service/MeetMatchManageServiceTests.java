package org.wesejong.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.wesejong.config.RootConfig.class})
@Log4j
public class MeetMatchManageServiceTests {
	
	@Setter(onMethod_= {@Autowired})
	private MeetMatchManageService meetmatchmanageservice;
	
	@Test
	public void testExist() {
		log.info(meetmatchmanageservice);
		assertNotNull(meetmatchmanageservice);
	}
	
	@Test
	public void testGet() {
		log.info(meetmatchmanageservice.get(1L));
	}
}
