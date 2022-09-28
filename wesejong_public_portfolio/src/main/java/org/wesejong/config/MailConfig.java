package org.wesejong.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import lombok.extern.log4j.Log4j;

@Configuration
@Log4j
public class MailConfig {

	
//	검색어:microsoft outlook smtp (마이크로소프트 아웃룩용 메일계정입니다.) 
//	https://support.microsoft.com/en-us/office/pop-imap-and-smtp-settings-for-outlook-com-d088b986-291d-42b8-9564-9c414e2aa040
  @Bean
  public static JavaMailSender javamailSender(){


//	cafe24 활용하여 진행할시.
	Properties properties = new Properties(); 
//	properties.put("mail.stmp.host","smtp.cafe24.com"); 
	properties.put("mail.smtp.auth", true);
	properties.put("mail.transport.protocol", "smtp");
	properties.put("mail.smtp.starttls.enable", true);
	properties.put("mail.smtp.starttls.required", true);
	properties.put("mail.debug", true);      
	
	JavaMailSenderImpl javamailSender = new JavaMailSenderImpl();
	javamailSender.setHost("smtp.gmail.com");
    javamailSender.setPort(587);
    javamailSender.setUsername("wesejong@gmail.com");
    javamailSender.setPassword("htndmbzqudibnnpb");
    javamailSender.setDefaultEncoding("utf-8");
    javamailSender.setJavaMailProperties(properties);

      return javamailSender;
  }
  
  
  	
	
}
