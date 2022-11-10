package com.bootcamp.host.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bootcamp.dto.KeyDto;

public class KeyDao {
	
	DataSource dataSource;
	
	public KeyDao() {
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}//생성자
	
	//keyword select
	public ArrayList<KeyDto> selectKeyword(int regSeq, int hSeq){
		
		ArrayList<KeyDto> dtos = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "select kName from keyword k, regcamp rc where k.regcamp_regSeq = rc.regSeq and regcamp_regSeq = ? and regcamp_host_hSeq = ? ";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, (regSeq));
			preparedStatement.setInt(2, (hSeq));
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				String kName = resultSet.getString("kName");
				
				KeyDto dto = new KeyDto(kName);
				
				dtos.add(dto);
				
			}
			
		}catch(Exception e){
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
		
		return dtos;
	}//selectKey
	
	
	//deleteKey 키워드 싹 지우기 
	public void deleteKey(int regSeq, int hSeq) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "delete from keyword where regcamp_regSeq = ? and regcamp_host_hSeq = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, regSeq);
			preparedStatement.setInt(2, hSeq);
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
	} //deleteKey
	
	//insertKey 키워드 insert
	public void insertKey(String kName, int regSeq, int hSeq) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "insert into keyword (kName, regcamp_regSeq, regcamp_host_hSeq) values (?, ?, ?) ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, kName);
			preparedStatement.setInt(2, regSeq);
			preparedStatement.setInt(3, hSeq);
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
	} //insertKey
	
	
	
	
	

}//END
