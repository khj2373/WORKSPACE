package com.kh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.model.vo.Lotto;

public class LottoDao {
	
	public int insertLotto(Connection conn, Lotto l) {
		int result = 0; //처리된 결과를 받아줄 변수
		
		PreparedStatement pstmt = null; //미완성된 sql문을 통해 객체생성 후 객체의 메소드를 이용해 완성가능
		
		//미완성 sql문
		String sql = "INSERT INTO LOTTO VALUES(?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, l.getUserId());
			pstmt.setString(2, l.getLottoNo());
			pstmt.setString(3, l.getResultNo());
			pstmt.setInt(4, l.getRank());
			
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

}
