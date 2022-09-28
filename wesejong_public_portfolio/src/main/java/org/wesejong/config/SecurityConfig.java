package org.wesejong.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.wesejong.security.CustomLoginSuccessHandler;
import org.wesejong.security.CustomUserDetailsService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Configuration
@EnableWebSecurity
@Log4j
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Setter(onMethod_= {@Autowired})
	private DataSource dataSource;	
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		log.info("configure.................");

		auth.userDetailsService(customUserService()).
		passwordEncoder(passwordEncoder());
		
	}
	
	@Bean
	public UserDetailsService customUserService() {
		return new CustomUserDetailsService();
	}
	
	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}	
	
//	https://ch4njun.tistory.com/219
//	Configuration에서 생성된 bean은 @Configuration 어노테이션 내에서만 사용할 수 있음.
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	public CustomAccessDeniedHandler customAccessdeninedhandler() {
//		return new CustomAccessDeniedHandler();
//	}
	
    @Override
    public void configure(WebSecurity web) throws Exception {
        // resources 모든 접근을 허용하는 설정을 해버리면
        // HttpSecurity 설정한 ADIM권한을 가진 사용자만 resources 접근가능한 설정을 무시해버린다.
//        web.ignoring()
//                .antMatchers("/meetmatch/event/explanation");
    }
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
//		http.requiresChannel()
//			.antMatchers("/**").requiresSecure();
		
//		http.portMapper().http(8080).mapsTo(8443);
		
//		http.authorizeRequests()
//		.antMatchers("/sample/all").permitAll()
//		.antMatchers("/sample/admin").access("hasRole('ROLE_ADMIN')")
//		.antMatchers("/sample/member").access("hasRole('ROLE_MEMBER')");
		
//		when deploy wesejong
		http.authorizeRequests()
		
		
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/member/mypage", "/member/secession", "/member/info/**").access("hasRole('ROLE_MEMBER')")
		.antMatchers("/board/**").access("hasRole('ROLE_MEMBER')")
		.antMatchers("/socket/**").access("hasRole('ROLE_MEMBER')")
		.antMatchers("/meetmatch/event/apply", "/meetmatch/event/applyresult", "/meetmatch/event/applicationhistory", "/meetmatch/event/applicationdetails").access("hasRole('ROLE_MEMBER')")
		.antMatchers("/","/**").permitAll();
		
//		.and()
//		.requiresChannel()
//		.antMatchers("/**").requiresSecure();
		
		http
		.formLogin()
		.loginPage("/member/login")
		.loginProcessingUrl("/login")
		.successHandler(loginSuccessHandler())
		.usernameParameter("mem_userid")
		.passwordParameter("mem_password");
		
		http
		.logout()
	    .logoutUrl("/customLogout")
	    .logoutSuccessUrl("/")
	    .invalidateHttpSession(true)
	    .deleteCookies("remember-me","JSESSION_ID");
	      
	}

}
