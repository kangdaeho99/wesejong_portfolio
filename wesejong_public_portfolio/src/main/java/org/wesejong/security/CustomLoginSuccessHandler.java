package org.wesejong.security;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.sun.media.jfxmedia.logging.Logger;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		
		log.warn("Login Success");
		
		List<String> roleNames = new ArrayList<>();
		
		authentication.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});
		log.warn("check cuistom login");
		log.warn("Role NAEMS:"+roleNames);
		
		/*
		 * if(roleNames.contains("ROLE_ADMIN")) {
		 * response.sendRedirect("/sample/admin"); return; }
		 */
		
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/admin/index"); 
			return; 
		}
		
		if(roleNames.contains("ROLE_MEMBER")) {
//			Logger.debug("ROLE_MEMBER");
			response.sendRedirect("/index");
			return;
		}
		response.sendRedirect("/");
		
	}

}
