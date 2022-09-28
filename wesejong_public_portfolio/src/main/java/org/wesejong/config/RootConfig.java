package org.wesejong.config;



import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages="org.wesejong.service")
@MapperScan(basePackages= {"org.wesejong.mapper"})
@EnableTransactionManagement

public class RootConfig {
	
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		/*
		hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		//hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		hikariConfig.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/bigtiger?serverTimezone=Asia/Seoul");
		*/
		

		 
		 
//			 when deploy wesejong
		  hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
		  hikariConfig.setJdbcUrl(
		  "jdbc:mysql://127.0.0.1:3306/wesejong?serverTimezone=Asia/Seoul");
		  hikariConfig.setUsername("********");
		  hikariConfig.setPassword("********");		 
		
		 
		 
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		return (SqlSessionFactory) sqlSessionFactory.getObject();
	}
	 
	

}
