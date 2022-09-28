package org.wesejong.controller;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.wesejong.domain.MailVO;
import org.wesejong.domain.MemberVO;
import org.wesejong.security.domain.CustomUser;
import org.wesejong.service.MailService;
import org.wesejong.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member/*")
@Log4j
public class MemberController {
	
	@Setter(onMethod_=@Autowired)
	private JavaMailSender javamailsender;
	
	@Setter(onMethod_= {@Autowired})
	private MailService mailservice;
	
	@Setter(onMethod_= {@Autowired})
	private MemberService memberservice;
	
	@GetMapping("/join")
	public void dojoinPage(Model model) {
//		mailservice.sendEmail(new MailVO());
		log.info("gotojoin....");
	}
	
	@PostMapping("/join")
	public String memberJoin(MemberVO membervo, RedirectAttributes rttr, HttpServletRequest request) {
		log.info("join:"+membervo);
		memberservice.join(membervo);
		
		System.out.println(membervo);
		
		rttr.addFlashAttribute("result",membervo.getMem_seq());
		
		
		return "redirect:/index";
	}

	@GetMapping("/login")
	public void dologinPage(Model model) {
		log.info("gotologin....");
	}
	
	@RequestMapping(value = "/mem_userid_duplication_check", method = RequestMethod.GET)
	@ResponseBody
	public String mem_userid_duplication_check(HttpServletRequest request) {
		
		String mem_userid = request.getParameter("mem_userid");
		int mem_userid_duplication_check = memberservice.mem_userid_duplication_check(mem_userid);
		if(mem_userid_duplication_check > 0) {
			return String.valueOf(-1);
		}
		return String.valueOf(mem_userid_duplication_check);
	}
	
	
	  @RequestMapping(value ="/mem_email_duplication_certification_check", method = RequestMethod.GET)
	  @ResponseBody 
	  public String mem_email_duplication_certification_check(HttpServletRequest request) {
	  
	  String mem_email = request.getParameter("mem_email");
	  mem_email+="@sju.ac.kr";
//	  System.out.println(mem_email);
	  if(memberservice.mem_email_duplication_check(mem_email) > 0) { 
		  return String.valueOf(-1);
	  }
	  

	  String from = "wesejong@wesejong.cafe24.com";
	  String subject = "세종대커뮤니티 위세종에서 발송된 메일입니다.";
	  int random = (int)(Math.random() * 10000000); System.out.println(random); 
	  try {
		  MimeMessage message = javamailsender.createMimeMessage(); 
		  MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
		   
		  messageHelper.setTo(mem_email);
		  messageHelper.setText("세종대학교커뮤니티 위세종에서 온 인증번호 ["+random+"] 입니다.");
		  messageHelper.setFrom(from); messageHelper.setSubject(subject);
		  javamailsender.send(message);
		  System.out.println(javamailsender);
		  System.out.println(message);
		  
		  HttpSession session = request.getSession(true);
		  session.setAttribute("mem_email_random_ceritification_number",random);
		  
	  }catch(Exception e) {
		  System.out.println(e);
		  return String.valueOf(-2);
	  }
	  
	  	return String.valueOf(1); 
	  }
	 
	
	@RequestMapping(value ="/mem_email_certification_check", method = RequestMethod.GET)
	@ResponseBody
	public String mem_email_certification_check(HttpServletRequest request) {
		String cor_mem_email = request.getParameter("cor_mem_email");
		int Integer_cor_mem_email = Integer.parseInt(cor_mem_email);
		
		HttpSession session = request.getSession(true);
		if(session.getAttribute("mem_email_random_ceritification_number") != null) {
			int mem_email_random_ceritification_number = (Integer) session.getAttribute("mem_email_random_ceritification_number");
			if( mem_email_random_ceritification_number == Integer_cor_mem_email) {
				return String.valueOf(1);
			}else {
				return String.valueOf(-1);
			}
		}
		
		return String.valueOf(-1);
		

	}
	
	@RequestMapping(value = "/mem_nickname_duplication_check", method = RequestMethod.GET)
	@ResponseBody
	public String mem_nickname_duplication_check(HttpServletRequest request) {
		String mem_nickname = request.getParameter("mem_nickname");
		if(mem_nickname.contentEquals("익명")) { 
			return String.valueOf(99);
		}
		int mem_nickname_duplication_check = memberservice.mem_nickname_duplication_check(mem_nickname);
		if(mem_nickname_duplication_check > 0) {
			return String.valueOf(-1);
		}
		return String.valueOf(mem_nickname_duplication_check);
	}
	
	@GetMapping("/mypage")
	public void domypagePage(Model model, Authentication authentication) {
		if(authentication != null) {
			CustomUser customuser = (CustomUser) authentication.getPrincipal();
			MemberVO membervo = customuser.getMember();
			
			membervo = memberservice.get_by_mem_seq(membervo);
			model.addAttribute("membervo",membervo);
		}
		log.info("gotomypage...");
	}
	
	@PostMapping("/mypage/modify")
	public String mypage_modify(MemberVO membervo, Authentication authentication) {
		if(authentication != null) {
			CustomUser customuser = (CustomUser) authentication.getPrincipal();
			membervo.setMem_seq(customuser.getMember().getMem_seq());
			memberservice.mypage_mem_nickname_mem_password_modify(membervo);
			System.out.println("logined");
			return "redirect:/member/mypage";
		}
		
		return "redirect:/index";
		
	}
	
	@RequestMapping(value ="/mypage/mem_password_confirm_check", method = RequestMethod.POST)
	@ResponseBody
	public String mem_password_confirm_check(@RequestBody MemberVO membervo, Authentication authentication) {
		BCryptPasswordEncoder pwencoder = new BCryptPasswordEncoder();
		if(authentication!=null) {
			CustomUser customuser = (CustomUser) authentication.getPrincipal();
			MemberVO updated_membervo = memberservice.get_by_mem_seq(customuser.getMember());
			
			String encodedPassword = updated_membervo.getMem_password();
			CharSequence rawPassword = membervo.getMem_password();
			if(pwencoder.matches(rawPassword, encodedPassword)) {
				return String.valueOf(1);
			}
		}
		return String.valueOf(-1);
	}
	
///////////////
//  	     //
// secession //
//	         //
///////////////	

	@GetMapping("/secession")
	public void mypage_secession() {
		log.info("go to member/secession page...");
		
	}
	
	@RequestMapping(value = "/member/secession_mem_password_check", method = RequestMethod.POST)
	@ResponseBody
	public String secession_mem_password_check(@RequestBody MemberVO membervo, Authentication authentication) {
		
		if(authentication != null) {
			if(memberservice.mem_password_check(membervo, authentication) == 1) {
				return String.valueOf(1);
			}else {
				return String.valueOf(-1);
			}
		}
		
		return String.valueOf(-1);
	}
	
	@PostMapping("/secession")
	public String secession(MemberVO membervo, Authentication authentication) {
		
		if(authentication!=null) {
			memberservice.remove_by_mem_seq(membervo, authentication);
			return "redirect:/index";
		}
		
		return "redirect:/index";
		
	}
	
/////////////
//		   //
//	forgot //
//	   	   //
/////////////
	
	@GetMapping("/forgot")
	public void doforgotPage() {
		log.info("gotoforgotpage...");
	}
	
//	iloveyou@sju.ac.kr 을 예시로들면 @(특수문자)가 넘어가서 값이 읽히지 않고있어서 GET -> Post 방식으로 바꿔서 해결
//	https://blog.naver.com/PostView.naver?blogId=geewonjung&logNo=221347758535&redirect=Dlog&widgetTypeCall=true&directAccess=false
	@RequestMapping(value = "/forgot/sendEmail_mem_userid_by_mem_email", method = RequestMethod.POST)
	@ResponseBody
	public String forgot_sendEmail_mem_userid_by_mem_email(@RequestBody MemberVO membervo) {
		System.out.println(membervo);
		MailVO mailvo = new MailVO();
		if(memberservice.get_by_mem_email(membervo) != null) {
			System.out.println("exist member_email");
			mailservice.forgot_sendEmail_mem_userid_by_mem_email(membervo, mailvo);
			return String.valueOf(1);
		}
		
		System.out.println("not exist member_email");
		return String.valueOf(-1);
	}

	
//	iloveyou@sju.ac.kr 을 예시로들면 @(특수문자)가 넘어가서 값이 읽히지 않고있어서 GET -> Post 방식으로 바꿔서 해결
	@RequestMapping(value = "/forgot/sendEmail_certificationnumber_by_mem_email", method = RequestMethod.POST)
	@ResponseBody
	public String forgot_sendEmail_certificationnumber_by_mem_email(@RequestBody MemberVO membervo, HttpServletRequest request) {
		System.out.println(membervo);
		MailVO mailvo = new MailVO();
		if(memberservice.get_by_mem_email(membervo) != null) {
//			System.out.println("exist member_email");
			mailservice.forgot_sendEmail_certificationnumber_by_mem_email(membervo, request);
			return String.valueOf(1);
		}
		
//		System.out.println("not exist member_email");
		return String.valueOf(-1);
	}
	
	@RequestMapping(value ="/forgot/check_sendEmail_certificationnumber_by_mem_email", method = RequestMethod.GET)
	@ResponseBody
	public String forgot_check_mem_email_certification_check(HttpServletRequest request) {
		String cor_mem_email = request.getParameter("cor_mem_email");
		
		int result = mailservice.forgot_check_sendEmail_certificationnumber_by_mem_email(cor_mem_email, request);
		return String.valueOf(result);
	}
	
	
	
//	https://okky.kr/article/578596 okky 에러페이지 alert error
//	탈퇴시 패스워드가 옳지 않을시 다른 사이트로 이동하게 할려고했지만, 그냥 ajax 사용해서 진행합니다. (ajax 사용해서 하면 코드가 난잡해져서 컨트롤하기 복잡해지는것같습니다.)
	@PostMapping("/forgot/mem_password_modify")
	public String forgotmodify(MemberVO membervo) {
		System.out.println(membervo);
		if(memberservice.get_by_mem_email(membervo) != null) {
			System.out.println("membervo is not null");
			memberservice.mem_password_modify(membervo);
		}
		System.out.println("membervo is null");
		return "redirect:/member/login";
		
	}
	

	
}
