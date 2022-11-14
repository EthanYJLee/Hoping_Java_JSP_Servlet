package com.bootcamp.client.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class wish_delete_Dao {

	
DataSource dataSource;
	
	public wish_delete_Dao() {
		try {
			
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/camping");
		}catch(Exception e) {
			e.printStackTrace();
			
		}
			
	}
	
	public void wish_delete(String regSeq, String cId) {	
		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	
	
	try {
		connection = dataSource.getConnection();
		
		String query = "delete from wish  where regcamp_regSeq = ? and client_cId =?";
	
			
		preparedStatement = connection.prepareStatement(query);
	
		preparedStatement.setString(1, regSeq);
		preparedStatement.setString(2, cId);
		
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
	
	}	
	
	
	
	
	
}
