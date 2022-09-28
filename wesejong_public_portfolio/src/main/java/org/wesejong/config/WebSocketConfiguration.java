//package org.wesejong.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//import org.wesejong.controller.EchoHandler_WebSocket;
//
//@Configuration
//@EnableWebSocket
//public class WebSocketConfiguration implements WebSocketConfigurer {
//	
//	@Bean
//	public EchoHandler_WebSocket echoHandler() {
//		return new EchoHandler_WebSocket();
//	}
//	
//	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//		registry.addHandler(echoHandler(), "/echo"); 
//		System.out.println("checkd"); 
//	}
//}
