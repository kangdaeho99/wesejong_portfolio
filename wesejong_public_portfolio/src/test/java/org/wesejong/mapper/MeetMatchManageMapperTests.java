package org.wesejong.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.wesejong.config.MailConfig;
import org.wesejong.config.RootConfig;
import org.wesejong.config.SecurityConfig;
import org.wesejong.domain.MeetMatchManageVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {org.wesejong.config.RootConfig.class, org.wesejong.config.SecurityConfig.class, org.wesejong.config.MailConfig.class})
@Log4j
public class MeetMatchManageMapperTests {
	
	@Setter(onMethod_=@Autowired)
	private MeetMatchManageMapper meetmatchmanagemapper;
	
	@Test
	public void testRead() {
		MeetMatchManageVO meetmatchmanagevo = meetmatchmanagemapper.read((long)1);
		log.info(meetmatchmanagevo);
		meetmatchmanagevo.getMeetmatchpersonnelmanagevoList().forEach(meetmatchpersonnelmanageVO -> log.info(meetmatchpersonnelmanageVO));
	}
	
	@Test
	public void testGetListWith_meetmatchpersonnelmanage() {
//		List<MeetMatchManageVO> meetmatchmanagevo = meetmatchmanagemapper.getListWith_meetmatchpersonnelmanage();
//		log.info(meetmatchmanagevo);

	}
	
	@Test
	public void testInsert_mysql() {
		
		for(int i=1;i<100;i++) {
			
			if(i>1 && i<=20) {
				System.out.println("insert into meetmatchteam (meetmatchteam_gender, meetmatchmanage_seq, meetmatchpersonnelmanage_personnel) values ('male',1,1);");
				System.out.println("insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('male', 1,"+i+",1);");
			}else if(i <= 40) {
				System.out.println("insert into meetmatchteam (meetmatchteam_gender, meetmatchmanage_seq, meetmatchpersonnelmanage_personnel) values ('female',1,1);");
				System.out.println("insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('female', 1,"+i+",1);");				
			}else {
				System.out.println("insert into meetmatchteam (meetmatchteam_gender, meetmatchmanage_seq, meetmatchpersonnelmanage_personnel) values ('male',1,1);");
				System.out.println("insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('male', 1,"+i+",1);");
			}
			
			
			
		}
		
	}
	
	@Test
	public void testInsert() {
		MeetMatchManageVO meetmatchmanagevo = new MeetMatchManageVO();
		
		
		meetmatchmanagevo.setMeetmatchmanage_eventid((long) 123);
		meetmatchmanagevo.setMeetmatchmanage_eventtitle("testmeetmatchmanage_eventid");
		meetmatchmanagevo.setMeetmatchmanage_eventcontent("testmeetmatchmanage_eventcontent");

		
		Date date = new Date();
		System.out.println(date);
		meetmatchmanagevo.setMeetmatchmanage_eventstartdate(date);
		meetmatchmanagevo.setMeetmatchmanage_eventenddate(date);
		
		meetmatchmanagevo.setMeetmatchmanage_eventendflag((long) 0);
		
		meetmatchmanagemapper.insertSelectKey(meetmatchmanagevo);
//		meetmatchmanagevo.setMeetmatchpersonnelmanagevoList(meetmatchpersonnelmanagevoList);
	}
	
	
	
}
