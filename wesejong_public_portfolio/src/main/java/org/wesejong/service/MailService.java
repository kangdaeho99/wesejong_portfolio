package org.wesejong.service;

import javax.servlet.http.HttpServletRequest;

import org.wesejong.domain.MailVO;
import org.wesejong.domain.MemberVO;

public interface MailService {
	
	public void mem_email_duplication_certification_check(HttpServletRequest request);
	
	public void forgot_sendEmail_mem_userid_by_mem_email(MemberVO membervo, MailVO mailvo);
	
	public void forgot_sendEmail_certificationnumber_by_mem_email(MemberVO membervo, HttpServletRequest request);
	
	public int forgot_check_sendEmail_certificationnumber_by_mem_email(String cor_mem_email, HttpServletRequest request);
}
