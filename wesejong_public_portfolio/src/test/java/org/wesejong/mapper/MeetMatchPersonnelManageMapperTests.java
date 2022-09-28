package org.wesejong.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.wesejong.config.RootConfig;
import org.wesejong.domain.MeetMatchPersonnelManageVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class MeetMatchPersonnelManageMapperTests {
	
	@Setter(onMethod_=@Autowired)
	private MeetMatchPersonnelManageMapper meetmatchpersonnelmanagemapper;
	
	@Test
	public void testRead() {
		MeetMatchPersonnelManageVO meetmatchpersonnelmanagevo = meetmatchpersonnelmanagemapper.read((long)1);
		log.info(meetmatchpersonnelmanagevo);
	}
	
	@Test
	public void testInsert() {
		MeetMatchPersonnelManageVO meetmatchpersonnelmanagevo = new MeetMatchPersonnelManageVO();
		
		
		meetmatchpersonnelmanagevo.setMeetmatchmanage_seq((long) 1);
		meetmatchpersonnelmanagevo.setMeetmatchpersonnelmanage_personnel((long) 4);

		
		meetmatchpersonnelmanagemapper.insertSelectKey(meetmatchpersonnelmanagevo);
//		meetmatchpersonnelmanagevo.setMeetmatchpersonnelmanagevoList(meetmatchpersonnelmanagevoList);
	}
	
	
	
}
