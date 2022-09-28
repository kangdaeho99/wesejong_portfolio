package org.wesejong.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
		org.wesejong.config.RootConfig.class,
		org.wesejong.config.ServletConfig.class,
		org.wesejong.config.SecurityConfig.class,
		org.wesejong.config.MailConfig.class,
		org.wesejong.config.WebSocketStompConfiguration.class
})
//ControllerTests 같은경우 전체 Bean 을 모두 스캔하기 때문에 Configuration을 모두 가져와야함
@Log4j
public class MemberControllerTests {
	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testmembergetList() throws Exception{
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/member/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap()
				);
	}
	
	@Test
	public void mem_email_duplication_Check() throws Exception{
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.get("/member/mem_email_certification_check")
				.param("mem_email","eoghdhdls@naver.com"))
				.andReturn()
				.getModelAndView()
				.getViewName();
		log.info(resultPage);
	}
}
