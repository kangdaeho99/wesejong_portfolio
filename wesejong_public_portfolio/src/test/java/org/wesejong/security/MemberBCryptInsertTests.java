package org.wesejong.security;

import java.sql.Connection;

import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wesejong.domain.MemberVO;
import org.wesejong.mapper.MemberMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {
		org.wesejong.config.RootConfig.class,
		org.wesejong.config.SecurityConfig.class
})
@Log4j
public class MemberBCryptInsertTests {

	@Setter(onMethod_=@Autowired)
	private PasswordEncoder pwEncoder;
	
	@Setter(onMethod_=@Autowired)
	private DataSource ds;
	
	@Setter(onMethod_=@Autowired)
	private MemberMapper MemberMapper;
	
	@Test
	public void testInsertMember() {
		String sql = "insert into member(mem_userid, mem_password) values (?,?)";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			//admin 1234, test 1234 test1 1234 test2 1234
			pstmt.setString(1, "admin");
//			pstmt.setString(1, "member");
			pstmt.setString(2, pwEncoder.encode("admin"));
//			pstmt.setString(2, pwEncoder.encode("member"));
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try {pstmt.close();} catch(Exception e) {}}
			if(con!=null) {try {con.close();} catch(Exception e) {}}
		}
		
//		for(int i=0;i<100;i++) {
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			try {
//				con = ds.getConnection();
//				pstmt = con.prepareStatement(sql);
//				
//				pstmt.setString(2, pwencoder.encode("pw"+i));
//				
//				if(i<80) {
//					pstmt.setString(1, "user"+i);
//				}else if(i<90) {
//					pstmt.setString(1, "manager"+i);
//				}else {
//					pstmt.setString(1, "admin"+i);
//				}
//				pstmt.executeUpdate();
//			} catch(Exception e) {
//				e.printStackTrace();
//			} finally {
//				if(pstmt!=null) {try {pstmt.close();} catch(Exception e) {}}
//				if(con!=null) {try {con.close();} catch(Exception e) {}}
//			}
//		}
	}
	
	@Test
	public void testInsertAuth() {
		String sql = "insert into member_authority (mem_seq,mem_userid,mem_auth) values (?,?,?)";
		
		MemberVO MemberVO = new MemberVO();
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			//admin / admin , member / member , 1234, test 1234 test1 1234 test2 1234
//			MemberVO = MemberMapper.read("admin");
			MemberVO = MemberMapper.read("member");
			
			pstmt.setLong(1, MemberVO.getMem_seq());
//			pstmt.setString(2, "admin");
			pstmt.setString(2, "member");
//			pstmt.setString(3, "ROLE_ADMIN");
			pstmt.setString(3, "ROLE_MEMBER");
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try {pstmt.close();} catch(Exception e) {}}
			if(con!=null) {try {con.close();} catch(Exception e) {}}
		}
		
		
//		for(int i=0; i<100;i++) {
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			try {
//				con = ds.getConnection();
//				pstmt = con.prepareStatement(sql);
//				
//				if(i<80) {
//					MemberVO=MemberMapper.read("user"+i);
//					pstmt.setLong(1, MemberVO.getMem_seq());
//					pstmt.setString(2, "user"+i);
//					pstmt.setString(3, "ROLE_USER");
//				}else if(i<90){
//					MemberVO=MemberMapper.read("manager"+i);
//					pstmt.setLong(1, MemberVO.getMem_seq());
//					pstmt.setString(2, "manager"+i);
//					pstmt.setString(3, "ROLE_MEMBER");
//				}else {
//					MemberVO=MemberMapper.read("admin"+i);
//					pstmt.setLong(1, MemberVO.getMem_seq());
//					pstmt.setString(2, "admin"+i);
//					pstmt.setString(3, "ROLE_ADMIN");
//				}
//				
//				pstmt.executeUpdate();
//			} catch(Exception e) {
//				e.printStackTrace();
//			}finally {
//				if(pstmt!=null) {try {pstmt.close();} catch(Exception e) {}}
//				if(con!=null) {try {con.close();} catch(Exception e) {}}				
//			}
//		}
	}
	
}
