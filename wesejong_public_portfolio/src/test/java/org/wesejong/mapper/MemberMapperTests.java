package org.wesejong.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.wesejong.config.RootConfig;
import org.wesejong.domain.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@Log4j
public class MemberMapperTests {
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Test
	public void testRead() {
		MemberVO membervo = mapper.read("admin");
		log.info(membervo);
		membervo.getMem_authorityList().forEach(AuthorityVO -> log.info(AuthorityVO));
	}
}
