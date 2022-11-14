package com.bootcamp.client.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bootcamp.dto.ClientDto;

public class countDao {
	

	DataSource dataSource;
	
	public countDao() {
		try {
			
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/camping");
		}catch(Exception e) {
			e.printStackTrace();
			
		}
			
	}
	
	
	public boolean count(String regSeq, String cId){
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		ClientDto dto = null;
		
		boolean Result=false;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select count(*) from wish where regcamp_regSeq = ? and client_cId =? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, regSeq);
			preparedStatement.setString(2, cId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				String count = resultSet.getString("count(*)");
				
				Result = count.equals("1"); // 위시리스트에 해당 캠프가 있으면 count(*)가 1이 되면서 true가 됨.
											//위시리스트에 해당 캠프가 없으면 count(*)가 0이 되면서 false가 됨.
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return Result;  //있으면 true 없으면 false
	} 
	

}
