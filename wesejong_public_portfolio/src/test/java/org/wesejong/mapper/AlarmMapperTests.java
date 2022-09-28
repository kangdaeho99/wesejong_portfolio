package org.wesejong.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wesejong.domain.AlarmVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.wesejong.config.RootConfig.class})
@Log4j
public class AlarmMapperTests {
	@Setter(onMethod_=@Autowired)
	private AlarmMapper alarmmapper;
	
	@Test
	public void testGetList() {
		alarmmapper.getList().forEach(alarm->log.info(alarm));
	}
	
	@Test
	public void testInsert() {
		AlarmVO alarmvo = new AlarmVO();
		alarmvo.setAlarm_title("alarm_title");
		alarmvo.setAlarm_writer("alarm_writer");
		alarmvo.setAlarm_content("alarm_content");
		alarmvo.setAlarm_type("alarm_type");
		alarmvo.setAlarm_readcheck((long) 0);
		alarmvo.setMem_seq((long)3);
		alarmmapper.insertSelectKey(alarmvo);
	}
}
