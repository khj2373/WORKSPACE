package com.kh.service;

import java.sql.Connection;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.LottoDao;
import com.kh.model.vo.Lotto;

public class LottoService {

	public int insertLotto(Lotto l) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new LottoDao().insertLotto(conn, l);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;	
		
	}
}
