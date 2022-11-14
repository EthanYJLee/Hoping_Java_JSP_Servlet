package com.bootcamp.host.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bootcamp.dto.roomDto;


public class RoomDao {
	
	DataSource dataSource;
	
	public RoomDao() {
		
		try {
			
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
	}//constructor
	
	//room select ---------
	//regSeq, hSeq 받아오기
	public ArrayList<roomDto> selectRoom(int regSeq, int hSeq){
		
		ArrayList<roomDto> dtos = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "select roNum, roPrice, roMax, roOccupied, roSeq from room r, regcamp rc, host h ";
			String query2 = "where r.regcamp_regSeq = rc.regSeq and r.regcamp_host_hSeq = h.hSeq ";
			String query3 = "and regcamp_regSeq = ? and regcamp_host_hSeq = ? and roDdate is null ";
			
			preparedStatement = connection.prepareStatement(query + query2 + query3);
			preparedStatement.setInt(1, regSeq);
			preparedStatement.setInt(2, hSeq);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int roNum = resultSet.getInt("roNum");
				String roPrice = resultSet.getString("roPrice").replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
				int roMax = resultSet.getInt("roMax");
				int roOccupied = resultSet.getInt("roOccupied");
				int roSeq = resultSet.getInt("roSeq");
				
				roomDto dto = new roomDto(roSeq, roNum, roPrice, roMax, roOccupied);
				
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
	}//selectRoom
	
	//insertRoom---------
	public void insertRoom(int roNum, int roPrice, int roMax, int hSeq, int regSeq) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "insert into room (roNum, roPrice, roMax, roDate, regcamp_regSeq, regcamp_host_hSeq) ";
			String query2 = "values(?, ?, ?, curdate(), ?, ?) ";
			
			preparedStatement = connection.prepareStatement(query + query2);
			preparedStatement.setInt(1, roNum);
			preparedStatement.setInt(2, roPrice);
			preparedStatement.setInt(3, roMax);
			preparedStatement.setInt(4, hSeq);
			preparedStatement.setInt(5, regSeq);
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
	
	//deleteRoom-------------
	public void deleteRoom(String roSeq) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "update room set roDdate = curdate() where roSeq = ?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, roSeq);
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
	
	
	

}//END
