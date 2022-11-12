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
	
	
	
	public void AsktoHost(String askCID, String askTITLe, String askCONTENT, String askREGSEQ) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query1 = "insert into ask (aCId, aTitle, aContent, aTime, aRegSeq) ";
			String query2 = " values(?,?,?,now(),?); ";
			preparedStatement = connection.prepareStatement(query1+query2);
			preparedStatement.setString(1, askCID);
			preparedStatement.setString(2, askTITLe);
			preparedStatement.setString(3, askCONTENT);
			preparedStatement.setString(4, askREGSEQ);
			preparedStatement.executeUpdate();
			
			
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
	} //AsktoHost
	
	

}// class end 
