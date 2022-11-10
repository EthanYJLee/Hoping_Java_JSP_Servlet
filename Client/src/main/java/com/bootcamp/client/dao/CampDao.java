package com.bootcamp.client.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bootcamp.joindto.campDto;



public class CampDao {
	
	DataSource dataSource;

	public CampDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
		}catch(Exception e){
			e.printStackTrace();
		}
	}	
	// 

	public ArrayList<campDto> listCamp(String strregSeq){
		ArrayList<campDto> dtos = new ArrayList<campDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		campDto dto;
		
		try {
			connection = dataSource.getConnection();
			System.out.println("Query start");
			String query = "select * from camp where regSeq = "+strregSeq;;
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println("Query Execute");
			
			while(resultSet.next()) {
				int regSeq = resultSet.getInt("regSeq");
				String regName = resultSet.getString("regName");
				String regCategory = resultSet.getString("regCategory");
				
				int roNum = resultSet.getInt("roNum");
				int roPrice = resultSet.getInt("roPrice");
				int roMax = resultSet.getInt("roMax");
				

				System.out.println("regSeq:"+strregSeq+":");

				dto = new campDto(regSeq, regName, regCategory, roNum, roPrice, roMax);
				dtos.add(dto);
				System.out.println("DTO Add");
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
		return dtos;
	} // listCamp	

	
	public ArrayList<campDto> dateCheck(String startdate, String stopdate){
		ArrayList<campDto> dtos = new ArrayList<campDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		campDto dto;
		
		
		int result = 0;
		
		try {
			connection = dataSource.getConnection();
			System.out.println("Query start");
			String query = "select distinct regSeq, regName, regCategory, roNum, roPrice, roMax from checkDate2 where boCheckindate is null or boCheckindate not between '"+startdate+"' and '"+stopdate+"'";;
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println("Query Execute");
			
			while(resultSet.next()) {
				int regSeq = resultSet.getInt("regSeq");
				String regName = resultSet.getString("regName");
				String regCategory = resultSet.getString("regCategory");
				
				int roNum = resultSet.getInt("roNum");
				int roPrice = resultSet.getInt("roPrice");
				int roMax = resultSet.getInt("roMax");
				

				System.out.println("startdate:"+startdate+":");
				System.out.println("stoptdate:"+stopdate+":");
				
				dto = new campDto(regSeq, regName, regCategory, roNum, roPrice, roMax);
				dtos.add(dto);
				System.out.println("DTO Add");

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
		return dtos;
	} // DateCheck	

	public ArrayList<campDto> BookCheck(String strroNum, String startdate, String stopdate){
		ArrayList<campDto> dtos = new ArrayList<campDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		campDto dto;
 		
		int result = 0;
		try {
			connection = dataSource.getConnection();
			System.out.println("Before Query start");
			String query = "select distinct regSeq, regName, regCategory, roNum, roPrice, roMax from checkDate2 where boCheckindate between '"+startdate+"' and '"+stopdate+"'";;
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println("Query Execute");
			
			while(resultSet.next()) {
				int regSeq = resultSet.getInt("regSeq");
				int roNum = resultSet.getInt("roNum");
				System.out.println("startdate:"+startdate+":");
				System.out.println("stoptdate:"+stopdate+":");

				System.out.println("dateCheck Add");

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
		
		
		
		try {
			connection = dataSource.getConnection();
			System.out.println("Query start");
			String query = "select distinct regSeq, regName, regCategory, roNum, roPrice, roMax from checkDate2 where boCheckindate is null or boCheckindate not between '"+startdate+"' and '"+stopdate+"'";;
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println("Query Execute");
			
			while(resultSet.next()) {
				int regSeq = resultSet.getInt("regSeq");
				String regName = resultSet.getString("regName");
				String regCategory = resultSet.getString("regCategory");
				
				int roNum = resultSet.getInt("roNum");
				int roPrice = resultSet.getInt("roPrice");
				int roMax = resultSet.getInt("roMax");
				

				System.out.println("startdate:"+startdate+":");
				System.out.println("stoptdate:"+stopdate+":");
				
				dto = new campDto(regSeq, regName, regCategory, roNum, roPrice, roMax);
				dtos.add(dto);
				System.out.println("DTO Add");

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
		return dtos;
	} // BookCheck	
	
	
	
	public void insertBook(String bName, String bTitle, String bContent) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into book (bName, bTitle, bContent, bDate) values (?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
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
	} //write
	
}