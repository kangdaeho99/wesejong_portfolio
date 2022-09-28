package org.wesejong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.wesejong.domain.MemberVO;
import org.wesejong.mapper.AlarmMapper;
import org.wesejong.mapper.MemberMapper;
import org.wesejong.security.domain.CustomUser;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {


	
//	@Setter(onMethod_=@Autowired)
//	private JavaMailSender mailsender;
	
	@Setter(onMethod_=@Autowired)
	private PasswordEncoder passwordEncoder;
	
	@Setter(onMethod_=@Autowired)
	private MemberMapper membermapper;
	
	@Setter(onMethod_=@Autowired)
	private AlarmService alarmservice;

	@Override
	public List<MemberVO> getmemberList() {
		// TODO Auto-generated method stub
		log.info(" ");
		return membermapper.getmemberList();
	}	
	
	@Override
	public void join(MemberVO vo) {
		// TODO Auto-generated method stub
		log.info("join......."+vo);
		MemberVO var_member = new MemberVO();
		vo.setMem_email(vo.getMem_email()+"@sju.ac.kr");
		vo.setMem_email_certified(1);
		vo.setMem_password(passwordEncoder.encode(vo.getMem_password()));
		membermapper.insertMember(vo);
		var_member = membermapper.read(vo.getMem_userid());
		membermapper.insertMember_Authority(var_member);
		
		alarmservice.register_welcome_join(var_member.getMem_seq());
		
	}

	@Override
	public MemberVO get_by_mem_userid(MemberVO membervo) {
		// TODO Auto-generated method stub
		log.info("get by mem_userid");
		return membermapper.get_by_mem_userid(membervo);
	}
	
	@Override
	public MemberVO get_by_mem_seq(MemberVO membervo) {
		// TODO Auto-generated method stub
		log.info("get by mem_seq");
		return membermapper.get_by_mem_seq(membervo);
	}
	
	@Override
	public MemberVO get_by_mem_email(MemberVO membervo) {
		// TODO Auto-generated method stub
		log.info("get by mem_email");
		return membermapper.get_by_mem_email(membervo);
	}
	
	@Override
	public int mem_userid_duplication_check(String mem_userid) {
		// TODO Auto-generated method stub
		int result = membermapper.mem_userid_duplication_check(mem_userid);
		return result;
	}

	@Override
	public int mem_email_duplication_check(String mem_email) {
		int result = membermapper.mem_email_duplication_check(mem_email);
		return result;
	}
	
	@Override
	public int mem_nickname_duplication_check(String mem_nickname) {
		int result = membermapper.mem_nickname_duplication_check(mem_nickname);
		return result;
	}

	@Override
	public int mypage_mem_nickname_mem_password_modify(MemberVO membervo) {
		// TODO Auto-generated method stub
		System.out.println(membervo);
		if(membervo.getMem_nickname() != null && membervo.getMem_password() != null) {
//			System.out.println("update_mem_nickname_mem_password");
//			System.out.println(membervo.getMem_password());
			membervo.setMem_password(passwordEncoder.encode(membervo.getMem_password()));
//			System.out.println(membervo.getMem_password());
			membermapper.update_mem_nickname_mem_password(membervo);
		} else if(membervo.getMem_nickname() != null && membervo.getMem_password() == null) {
//			System.out.println("update_mem_nickname");
			membermapper.update_mem_nickname(membervo);
		}
		return 0;
	}

	@Override
	public int mem_password_modify(MemberVO membervo) {
		// TODO Auto-generated method stub
		System.out.println("mem_password_modify:"+membervo);
		membervo.setMem_seq(membermapper.get_by_mem_email(membervo).getMem_seq());
		membervo.setMem_password(passwordEncoder.encode(membervo.getMem_password()));
		if(membermapper.update_mem_password(membervo) == 1) {
			return 1;
		}else {
			return 0;
		}
		
	}

	@Override
	public int mem_password_check(MemberVO membervo, Authentication authentication) {
		// TODO Auto-generated method stub
		CustomUser customuser = (CustomUser) authentication.getPrincipal();
		MemberVO authentication_membervo = customuser.getMember();
		
		if(passwordEncoder.matches(membervo.getMem_password(), authentication_membervo.getMem_password())) {
			return 1;
		}else {
			return -1;
		}
		
	}
	
	@Override
	public int remove_by_mem_seq(MemberVO membervo, Authentication authentication) {
		// TODO Auto-generated method stub
		CustomUser customuser = (CustomUser) authentication.getPrincipal();
		MemberVO authentication_membervo = customuser.getMember();
		
		if(passwordEncoder.matches(membervo.getMem_password(), authentication_membervo.getMem_password())) {
			membermapper.delete_by_mem_seq(authentication_membervo);
			return 1;
		}else {
			return -1;
		}
	}

}
