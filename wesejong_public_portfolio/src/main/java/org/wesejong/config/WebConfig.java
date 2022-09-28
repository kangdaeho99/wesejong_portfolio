package org.wesejong.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		
		return new Class[] { RootConfig.class , SecurityConfig.class, MailConfig.class};
		//return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		
		return new Class[] { ServletConfig.class , WebSocketStompConfiguration.class /* , WebSocketConfiguration.class */};
		//return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
		
//		when studying
//		MultipartConfigElement multipartConfig = new MultipartConfigElement("C:\\upload\\temp",
//		https://sjucomme@sjucomme.cafe24.com/sjucomme/tomcat/webapps/ROOT/resources/upload/temp
//		when wesejong deploy
		MultipartConfigElement multipartConfig = new MultipartConfigElement("/wesejong/tomcat/webapps/ROOT/resources/upload/temp",
				
//		when sjucomme deploy
//		MultipartConfigElement multipartConfig = new MultipartConfigElement("/sjucomme/tomcat/webapps/ROOT/resources/upload/temp",
				20971520,
				41943040,
				20971520);
		registration.setMultipartConfig(multipartConfig);
	}
//	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		
		return new Filter[] { characterEncodingFilter };
	}
}
