package com.bootcamp.client.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mysql.cj.Session;

public class wish_writeDao {

	
	DataSource dataSource;
	
	public wish_writeDao() {
		try {
			
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/camping");
		}catch(Exception e) {
			e.printStackTrace();
			
		}
			
	}
	
	
	public void wish_write(String regSeq, String host_hSeq, String cId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int regSeq1 = Integer.parseInt(regSeq);
		int host_hSeq1 = Integer.parseInt(host_hSeq);
		
		try {
			connection = dataSource.getConnection();
			String query = "SET foreign_key_checks =0; ";
			String query2 = "insert into wish (wDate, client_cId, regcamp_regSeq, regcamp_host_hSeq) ";
			String query3 = "select now(), ?, r.regSeq, 1 ";
			String query4 = "from regcamp r, host h ";
			String query5 = "where r.host_hSeq = h.hSeq and r.regSeq = "+ regSeq1 +" and h.hSeq = "+ host_hSeq1;
			
			preparedStatement = connection.prepareStatement(query+query2+query3+query4+query5);
			
			preparedStatement.setString(1, cId);
			
			preparedStatement.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null)connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
			
		
}//write
	
	
	
		
}
