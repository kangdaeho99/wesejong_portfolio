package org.wesejong.service;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.wesejong.domain.MailVO;
import org.wesejong.domain.MemberVO;
import org.wesejong.mapper.MemberMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MailServiceImpl implements MailService {
	
//	Controller단에서만 	
//	@Setter(onMethod_=@Autowired)
//	private JavaMailSender javamailsender;
//	를 사용가능했던 것을 해결했습니다.
//	WebConfig에서는 RootConfig.class에 MailConfig가 스캔되고있지않아서 Service단에서 빈으로 작동하지 않고있었습니다.
	@Setter(onMethod_=@Autowired)
	private JavaMailSender javamailsender;
	
	@Setter(onMethod_=@Autowired)
	private MemberMapper membermapper;
	
	  String from = "wesejong@wesejong.cafe24.com";
	  String subject = "세종대커뮤니티 위세종에서 발송된 메일입니다.";
	
	
	@Override
	public void mem_email_duplication_certification_check(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void forgot_sendEmail_mem_userid_by_mem_email(MemberVO membervo, MailVO mailvo) {
		// TODO Auto-generated method stub
		
		membervo = membermapper.get_by_mem_email(membervo);
		
		mailvo.setTo(membervo.getMem_email());
		mailvo.setFrom(from);
		mailvo.setSubject(subject);

		try {
			MimeMessage message = javamailsender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setTo(mailvo.getTo());
			messageHelper.setText("등록된 이메일로 저장된 아이디는 "+membervo.getMem_userid()+"입니다.");
			messageHelper.setFrom(mailvo.getFrom());
			messageHelper.setSubject(mailvo.getSubject());
			javamailsender.send(message);
			
		}catch(Exception e) {
			System.out.println(e);
			return ;
		}
		return ;
	}


	@Override
	public void forgot_sendEmail_certificationnumber_by_mem_email(MemberVO membervo, HttpServletRequest request) {
		// TODO Auto-generated method stub
		MailVO mailvo = new MailVO();
		
		membervo = membermapper.get_by_mem_email(membervo);
		
		mailvo.setTo(membervo.getMem_email());
		mailvo.setFrom(from);
		mailvo.setSubject(subject);
		
		int random = (int)(Math.random() * 10000000); System.out.println(random);
		try{
			MimeMessage message = javamailsender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setTo(mailvo.getTo());
			messageHelper.setText("세종대 커뮤니티 위세종에서 온 인증번호 ["+random+"] 입니다.");
			messageHelper.setFrom(from); 
			messageHelper.setSubject(mailvo.getSubject());
			javamailsender.send(message);
			
			HttpSession session = request.getSession(true);
			session.setAttribute("forgot_sendEmail_certificationnumber_by_email", random);
		}catch(Exception e) {
			System.out.println(e);
			return ;
		}
		
		return ;
	
	}


	@Override
	public int forgot_check_sendEmail_certificationnumber_by_mem_email(String cor_mem_email, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		int Integer_cor_mem_email = Integer.parseInt(cor_mem_email);
		
		HttpSession session = request.getSession(true);
		int mem_email_random_ceritification_number = (Integer) session.getAttribute("forgot_sendEmail_certificationnumber_by_email");

		if( mem_email_random_ceritification_number == Integer_cor_mem_email) {
			return 1;
		} else {
			return -1;
		}
		
	}

	
	

}
