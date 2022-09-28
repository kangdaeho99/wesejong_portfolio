package org.wesejong.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.wesejong.domain.MemberVO;

public interface MemberService {
	public List<MemberVO> getmemberList();
	
	public void join(MemberVO vo);
	
	public MemberVO get_by_mem_userid(MemberVO membervo);
	
	public MemberVO get_by_mem_seq(MemberVO membervo);
	
	public MemberVO get_by_mem_email(MemberVO membervo);
	
	//duplication check
	public int mem_userid_duplication_check(String mem_userid);
		
	public int mem_email_duplication_check(String mem_email);
	
	public int mem_nickname_duplication_check(String mem_nickname);
	
//	public boolean mailsend(String mem_email, HttpServletRequest request);
	
//	public Member_StudentidVO countstudentid();
	
//	mypage method
	public int mypage_mem_nickname_mem_password_modify(MemberVO membervo);
//	forgot method
	public int mem_password_modify(MemberVO membervo);
	
//	secession method
	public int mem_password_check(MemberVO membervo, Authentication authentication);
	
	public int remove_by_mem_seq(MemberVO membervo, Authentication authentication);
}
