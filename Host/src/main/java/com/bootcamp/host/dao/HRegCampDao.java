package com.bootcamp.host.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class HRegCampDao {
		
	DataSource dataSource;
	
	public HRegCampDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
		//상품입력
	public void regcamp( String regTel, String regCategory, String regDetailaddress, String regName, String regSummary,
			int host_hSeq) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into regcamp (regTel, regCategory, regDetailaddress, regName, regSummary, regDate, host_hSeq) values (?,?,?,?,?,now(),?) ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, regTel);
			preparedStatement.setString(2, regCategory);
			preparedStatement.setString(3, regDetailaddress);
			preparedStatement.setString(4, regName);
			preparedStatement.setString(5, regSummary);
			preparedStatement.setInt(6, host_hSeq);
			
			System.out.println(query);
		
			preparedStatement.executeUpdate();
						
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	} //write
	
	
}
	
	
	
	
	
	
	

