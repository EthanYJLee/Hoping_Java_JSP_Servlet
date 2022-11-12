package com.bootcamp.host.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bootcamp.dto.FacilityDto;

public class FacilityDao {
	
	DataSource dataSource;
	
	public FacilityDao() {
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}//생성자
	
	//편의시설 select ---------
	public ArrayList<FacilityDto> selectFacility(int regSeq, int hSeq){
		
		ArrayList<FacilityDto> dtos = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "select fName from facility f, regcamp rc where f.regcamp_regSeq = rc.regSeq ";
			String query2 = "and regcamp_regSeq = ? and regcamp_host_hSeq = ? ";
			
			preparedStatement = connection.prepareStatement(query + query2);
			preparedStatement.setInt(1, regSeq);
			preparedStatement.setInt(2, hSeq);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				String fName = resultSet.getString("fName");
				
				FacilityDto dto = new FacilityDto(fName);
				
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
	}//selectFacility
	
	//편의시설 delete --------
	//regSeq 받아서 싹 delete
	public void deleteFacility(int regSeq, int hSeq) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "delete from facility where regcamp_regSeq = ? and regcamp_host_hSeq = ? ";
			
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
		
	} //delete
	
	//insert---------
	public void insertFacility(String fName, int hSeq, int regSeq) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "insert into facility (fName, regcamp_regSeq, regcamp_host_hSeq) values (?,?,?) ";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, fName);
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
		
	} //insertFacility
	
}//END
