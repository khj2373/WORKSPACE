package com.kh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Member;

//DAO(Data Access Object) : db에 직접적으로 접근해서 사용자의 요청에 맞는 sql문 실행 후 결과 반환(JDBC)
public class MemberDao {
	
	//로그인 판별 메소드
	public Member loginMember(Connection conn, Member m) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USER_ID = ? AND USER_PWD = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				return m;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 
	 * @param Member m : 사용자가 입력한 값들이 담겨있는 Member객체
	 * @return : insert문 실행 후 처리된 행 수
 	 */
	public int insertMember(Connection conn, Member m) {
		//insert문 => 처리된 행 수(int) => 트랜잭션
		
		//필요한 변수 먼저 세팅
		int result = 0; //처리된 결과를 받아줄 변수
		//Statement stmt = null; //완성된 sql문 전달해서 곧바로 실행 후 결과를 받는 객체
		PreparedStatement pstmt = null; //미완성된 sql문을 통해 객체생성 후 객체의 메소드를 이용해 완성가능
		
		//미완성 sql문
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		
		try {
			
			//3) Statement 객체 생성
			//미완성 sql문을 전달(필요한 요소 중 일부가 ?로 채워져있음)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());		
			
			//4, 5) sql로 전달하면서 실행 후 값 받아오기
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return result;
	}
	
	public List<Member> selectMemberList(Connection conn) {
		//select문(여러 행 조회) -> ResultSet 객체 -> ArrayList<Member>에 담기
		
		//필요한 변수들 세팅
		List<Member> list = new ArrayList<>(); //비어있는상태
		
		Statement stmt = null;
		ResultSet rset = null; //select문 실행시 조회된 경과값들이 최초로 담기는 공간
		
		//실행할 sql
		String sql = "SELECT * FROM MEMBER";
		
		try {
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				Member m = new Member();
				m.setUserNo(rset.getInt("USER_NO"));
				m.setUserId(rset.getString("USER_ID"));
				m.setUserPwd(rset.getString("USER_PWD"));
				m.setUserName(rset.getString("USER_NAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
				//현재 참고하고 있는 행에 대한 모든 컬럼의 데이터들을 한 Member 객체에 담기
				
				list.add(m);
			}
			
			//반복문이 끝난 시점
			//조회된 데이터가 없다면 list -> null
			//조회될 데이터가 있다면 전부 list에 담겨있음
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return list;
	}
	
	public int updateMember(Connection conn, Member m) {
		//update문 ->처리된 행 수(int)
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		/*
		 * update member
		 * set user_pwd = 'xxxx', email = 'xxxx' ....
		 * where user_id = 'xxxx'
		 */
		
		String sql = "UPDATE MEMBER "
					+ "SET USER_PWD = ?,"
					+ "EMAIL = ?,"
					+ "PHONE = ?,"
					+ "ADDRESS = ?"
					+ " WHERE USER_ID = ?";


		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserPwd());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getUserId());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int deleteMember(Connection conn, String userId) {
		int result = 0;
		Statement stmt = null;
		
		String sql = "DELETE FROM MEMBER WHERE USER_ID = '" + userId + "'";
		
		try {
			
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(stmt);
		}
		return result;
		
	}
	
	public Member searchMemberById(Connection conn, String userId) {
		//select문 -> ResultSt -> Member 객체
		
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member();
				m.setUserNo(rset.getInt("USER_NO"));
				m.setUserId(rset.getString("USER_ID"));
				m.setUserPwd(rset.getString("USER_PWD"));
				m.setUserName(rset.getString("USER_NAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}
	
	public List<Member> searchMemberByName(Connection conn, String keyword) {
		
		List<Member> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USER_NAME LIKE '%" + keyword + "%'";
		//prepared일때
		//String sql = "SELECT * FROM MEMBER WHERE USER_NAME LIKE '%' || ? || '%'";
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				Member m = new Member();
				m.setUserNo(rset.getInt("USER_NO"));
				m.setUserId(rset.getString("USER_ID"));
				m.setUserPwd(rset.getString("USER_PWD"));
				m.setUserName(rset.getString("USER_NAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
				
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return list;
	}

}
