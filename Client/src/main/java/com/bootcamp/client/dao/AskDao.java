package com.bootcamp.client.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AskDao {
	
	DataSource dataSource;
	
	public AskDao() {
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}//constructor
	
	
	
//	public  setRegcamp(String regName) {
//		
//	}
	
	
	
	
	public void AsktoHost(int cHostSeq, String clientId ) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into book (boPrice, boDate, boCheckindate, boGroup, boCount, ";
			String query2 = "pay_cid, pay_room_roseq, pay_room_regcamp_regSeq, pay_room_regcamp_host_hSeq, pay_client_cid ) values ";
//			
//			preparedStatement.setInt(1, boPrice);
//			preparedStatement.setString(2, boCheckindate);
//			preparedStatement.setInt(3, boGroup);
//			preparedStatement.setInt(4, boCount);
//			preparedStatement.setString(5, "asdf");
//			preparedStatement.executeUpdate();
//			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	} //insertbook
	
	

}// class end 
