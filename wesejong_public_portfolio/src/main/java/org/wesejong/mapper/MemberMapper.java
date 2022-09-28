package org.wesejong.mapper;

import java.util.List;

import org.wesejong.domain.MemberVO;

public interface MemberMapper {
		
	public MemberVO read(String mem_userid);
	
	public List<MemberVO> getmemberList();
	
	public void insertMember(MemberVO membervo);
	
	public void insertMember_Authority(MemberVO membervo);
	
	public MemberVO get_by_mem_userid(MemberVO membervo);
	
	public MemberVO get_by_mem_seq(MemberVO membervo);
	
	public MemberVO get_by_mem_email(MemberVO membervo);
	
	public int mem_userid_duplication_check(String mem_userid);
	
	public int mem_email_duplication_check(String mem_email);
	
	public int mem_nickname_duplication_check(String mem_nickname);
	
	public int countwholestudentid();
	
	public int countstudentid(int mem_studentid);
	
	public int update_mem_nickname(MemberVO membervo);
	
	public int update_mem_nickname_mem_password(MemberVO membervo);

	public int update_mem_password(MemberVO membervo);
	
	public int delete_by_mem_seq(MemberVO membervo);
	//	
}
