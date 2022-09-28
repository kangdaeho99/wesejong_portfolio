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
})
@Log4j
public class AdminMeetMatchManageControllerTests {

		@Setter(onMethod_ = {@Autowired})
		private WebApplicationContext ctx;
		
		private MockMvc mockMvc;
		
		@Before
		public void setup() {
			this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		}
		
		@Test
		public void testList() throws Exception{
			log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/admin/meetmatchmanage/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
		}
	
}


//
//StackOverflow:SimpMessagingTemplate bean
//https://stackoverflow.com/questions/22925951/could-not-autowire-no-beans-of-simpmessagingtemplate-type-found
//
//검색어:SimpMessagingTemplate' bean error
//https://stackoverflow.com/questions/63030475/simpmessagingtemplate-no-qualifying-bean-of-type
//
//도움받은사이트:https://liante0904.tistory.com/113
//*중요*
//MeetMatchManageControllerTests 작업중 
//
//이spring bean 생성
//junit SimpMessagingTemplate
//failed to load applicationCotnext
//1. org.springframework.test.context.TestContextManager - Caught exception while allowing TestExecutionListener [org.springframework.test.context.web.ServletTestExecutionListener@5025a98f] to prepare test instance [org.wesejong.controller.MeetMatchManageControllerTests@2f9a01c1]
//java.lang.IllegalStateException: Failed to load ApplicationContext
//
//2.Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'chatRoomController': Unsatisfied dependency expressed through method 'setSimpmessagingtemplate' parameter 0; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'org.springframework.messaging.simp.SimpMessagingTemplate' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {}
//
//3. org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'org.springframework.messaging.simp.SimpMessagingTemplate' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {}
//
//라는 오류가 발생하였습니다.
//
//기본적인 bean에 대한 이해가 부족해보여서 발생한 문제같습니다.
//
//simpmessagingtemplate은 websocketStompConfiguration에서
//@EnableWebSocketMessageBroker을 어노테이션하면 자동으로 빈으로 등록된다고하니
//빈 에러가 어디서 나는것일지 나중에 생각하고 일단 기본적인것들을 해결해봅니다.