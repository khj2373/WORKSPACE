package com.kh.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDB {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rset = null;
	
	public MemberDB(String title, String author, String genre) {
		String sql = "INSERT INTO TB_MEMBER VALUES('" + title + "', '" + author + "', '" + genre + "')";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //ojdbc.jar 파일을 추가하지 않거나 오타가 있으면 -> 에러
			
			//2) Connection 생성(url, 계정명, 비밀번호)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			//3) Statement 생성
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			
			//4, 5) SQL문 전달하면서 실행 후 결과 받기
			int result = stmt.executeUpdate(sql);
			//6)
			//내가 실행할 SQL문이 DML(INSERT, UPDATE, DELETE) -> stmt.excuteUpdate(SQL문) : int
			//내가 실행할 SQL문이 SELECT문 -> stmt.executeQuery(SELECT문) : ResultSet
			
			if(result > 0) { //요청성공
				conn.commit();
			} else { //요청실패
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//7) 다 사용한 JDBC용 객체를 반드시 자원 반납(close) -> 생성된 역순으로
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setTitle(String title) {
		String sql = "UPDATE TABLE";
	}
}
