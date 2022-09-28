//package org.wesejong.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import lombok.extern.log4j.Log4j;
//
//@Log4j
//@Controller
//public class EchoHandler_WebSocket  extends TextWebSocketHandler{
//	List<WebSocketSession> sessions = new ArrayList<>();
//	
//	  @Override 
//	  public void afterConnectionEstablished(WebSocketSession session) 
//			  throws Exception{ 
//		  System.out.println("afteronnectionEstablisehd:"+session);
//		  session.sendMessage(new TextMessage("connection ESTABLISEHD"));
//		  sessions.add(session);
//	  }
//	  
//	  @Override 
//	  protected void handleTextMessage(WebSocketSession session,TextMessage message) 
//			  throws Exception{
//		  System.out.println("handleTextMessage:"+session +":"+message); 
//		  String msg = message.getPayload(); session.sendMessage(new TextMessage("RECEIVED:"+msg));
//		  String senderId = session.getId(); 
//		  for(WebSocketSession sess:sessions){
//			  sess.sendMessage(new TextMessage(senderId + ": "+message.getPayload())); 
//		  }
//	  }
//	  
//	  
//	  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) 
//			  throws Exception{ 
//		  System.out.println("afteronnectionCLOSED:"+session+":"+status);
//	  }
//	  
//
//}
