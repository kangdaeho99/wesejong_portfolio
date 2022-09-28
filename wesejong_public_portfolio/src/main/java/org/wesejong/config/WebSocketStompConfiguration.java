package org.wesejong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@ComponentScan
public class WebSocketStompConfiguration  implements WebSocketMessageBrokerConfigurer{
//	2.SubScribe
//	ws.subscribe('/topic/echo', onMessageReceived);
//	/topic은 브로커가 /topic/~은 구독하는것이다 라고 알려주는 prefix입니다.
//	실제로 구독하는 것은 /echo를 구독하는 것입니다.
//	WebSocketStompConfiguration의 configureMessageBroker의
//	registry.enableSimpleBroker("/topic")을 통해 설정합니다.
//
//	3.SEND
//	ws.send('/echo', {}, JSON.stringify({message:message}));
//	첫번째 인자는 spring controller mapping("/~")은 spring controller로 보낸다는
//	stomp prefix 규칙입니다. 즉,/~/echo에서 echo가 진짜 mapping 주소입니다. 
//	/~/echo인 이유는
//	WebSocketStompConfiguration의 configureMessageBroker의
//	registry.setApplicationDestinationPrefixes("/");을 통해 설정했습니다.
//	(여기서 "/"로 설정한 이유는 tomcat 서버에서 [modules]설정에서 /로 설정했기 떄문입니다.)
//	EchoHandler에서 @MessageMapping("/~/echo")로 되어있는 함수로 메시지가 보내집니다.
//	또한 만약에 registry.setApplicationDestinationPrefixes("/app")이라면
//	@MessageMapping("/app/echo")가 되겠습니다. /app이 spring으로 흘러가도록 설정해두었기에
//	@MessageMapping("/생략/echo")가 될수도 있습니다.
//	두번째 인자는 서버로 보낼떄 추가하고 싶은 stomp 헤더입니다.
//	세번째 인자는 서버로 보낼떄 추가하고싶은 stomp바디입니다.
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/topic");
		registry.setApplicationDestinationPrefixes("/app");
	}
	
	
//	1.Connection
//	var sock = new SockJS("/echo-endpoint");
//	ws = Stomp.over(sock);
//	를 보면 처음 소켓을 생성할때 
//	클라이언트가 서버에 "/echo-endpoint라는 이름으로 connect를 보내고
//	서버쪽의 브로커는 
//	WebSocketStompConfiguration의 registerStompEndpoints의
//	registry.addEndpoint("/echo-endpoint").setAllowedOrigins("*").withSockJS();
//	를 통해 connect를 받게됩니다.
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/echo-endpoint").setAllowedOrigins("*").withSockJS();
	}
	
//	@Bean
//	public SimpMessagingTemplate simpMessagingTemplate() {
//		return new SimpMessagingTemplate(null);
//	}

}
