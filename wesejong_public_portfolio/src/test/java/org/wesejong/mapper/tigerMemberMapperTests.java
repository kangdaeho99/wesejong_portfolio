package org.wesejong.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.wesejong.config.RootConfig;
import org.wesejong.domain.MemberVO;
import org.wesejong.mapper.MemberMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
@Log4j
public class tigerMemberMapperTests {
	
	@Setter(onMethod_=@Autowired)
	private MemberMapper mapper;
	
	
	@Test
	public void testRead() {
		MemberVO vo = mapper.read("admin");
		log.info(vo);
		vo.getMem_authorityList().forEach(authVO -> log.info(authVO));
	}
	
	
	/*
	@Test
	public void testRead() {
		MemberVO vo = mapper.read("test1");
		log.info(vo);
		vo.getMem_authorityList().forEach(AuthorityVO -> log.info(AuthorityVO));
	}
	*/
	/*
	@Test
	public void testGetAllMember() {
		List<MemberVO> vo = mapper.getmemberList();
		for(int i=0;i<vo.size();i++) {
			log.info(vo.get(i));
			vo.get(i).getMem_authorityList().forEach(AuthorityVO -> log.info(AuthorityVO));
		}
	}
	*/
	/*
	@Test
	public void testInsert() {
		int mem_seq;
		MemberVO var_member = new MemberVO();
		MemberVO member = new MemberVO();
		member.setMem_userid("testMemberMapper1");
		member.setMem_password("1234");
		member.setMem_nickname("nickname");
		member.setMem_email("test@naver");
		
		mapper.insertMember(member);
		var_member = mapper.read(member.getMem_userid());
		log.info("the test"+ var_member.getMem_seq());

		mapper.insertMember_Authority(var_member);
		log.info(member);
	}
	*/
	
//	@Test
//	public void testidCheck() {
//		int result = mapper.idCheck("test02");
//		log.info("result is="+result);
//	}

}
