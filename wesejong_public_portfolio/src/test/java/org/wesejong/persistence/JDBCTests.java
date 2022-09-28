package org.wesejong.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	
	static {
		try {
			Class.forName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
			/*Class.forName("com.mysql.cj.jdbc.Driver");*/
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//server Timezone Error
	@Test
	public void testConnection() {
		try(Connection conn = DriverManager.getConnection("jdbc:log4jdbc:mysql://127.0.0.1:3306/wesejong?serverTimezone=Asia/Seoul","root","root")){
		/*try(Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bigtiger?serverTimezone=Asia/Seoul","root","root")){*/
			log.info(conn);
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
