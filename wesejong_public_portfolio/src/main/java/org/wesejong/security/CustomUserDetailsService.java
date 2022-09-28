package org.wesejong.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.wesejong.domain.MemberVO;
import org.wesejong.mapper.MemberMapper;
import org.wesejong.security.domain.CustomUser;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService{
	
	@Setter(onMethod_= {@Autowired})
	private MemberMapper memberMapper;
	
//	출처:https://okky.kr/article/382738
//		UserDetailsService에서 loaduserbyusername을 한 후 패스워드처리는 AuthenticationProvider 구현체에서 진행합니다.
//		우리가 직접 구현하지 않아 눈으로 확인불가능합니다.
//
//
//	추천검색어:
//	-spring security authenticationprovider 구현
//	-spring security userdetailsservice 구현
	
//	spring security 에서 authentiocation.getPrincipal 같은 행위를 했을때 UserDetails 타입인 CustomUser(vo)가 반환됩니다. 그안에서 member객체를 가져오는방식으로 진행합니다.
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		log.warn("Load User By UserName:"+userName);
		
		MemberVO vo = memberMapper.read(userName);
		
		log.warn("queried by member mapper:"+vo);
//		return vo == null ?  null : new CustomUser(vo);
//		if(vo==null) {
//			log.warn("not login success");
//		} else {
//			log.warn("CustomUserDetailsService working");
//		}
		return vo == null ?  null : new CustomUser(vo);
	}
	
}
