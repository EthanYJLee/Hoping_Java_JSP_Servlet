package com.bootcamp.client.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
		
		try {
			connection = dataSource.getConnection();
			System.out.println("Query start");
			
			// 특정일 사이에 방이 예약가능한지 알아보는 SQL 문 (특정일 사이의 방번호를 제외하고 방번호 중에서 그 값을 제외하고 출력) - 상혁
			// 캠핑장에 따라 인자 값 추가 필요 - 상혁
			
			String query = "select distinct * from checkDate2 where roNum not in ( select distinct roNum from checkDate2 where boCheckindate between '"+startdate+"' and '"+stopdate+"')";; 
			
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
	
	
	public int readMaxSeq() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int result = 0;
		try {
			connection = dataSource.getConnection();
			
			String query = "select max(boSeq) from book";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println("Query readMaxSeq Execute");
			
			if(resultSet.next()) {
				result = resultSet.getInt("max(boSeq)");
			}
			
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
		return result;
	} //readMaxSeq
	
	public int diffDate(String Startdate, String Stopdate) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int result = 0;
		try {
			connection = dataSource.getConnection();
			
			String query = "select TimeStampdiff(day,'"+Startdate+"','"+Stopdate+"') as diff";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println(query);
			System.out.println("Query diffDate Execute");
			
			if(resultSet.next()) {
				result = resultSet.getInt("diff");
			}
			
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
		return result+1;
	} //diffDate

	
	public void insertBook(int boPrice, String boCheckindate, int boGroup, int boCount, String cId, int intdiff, int regSeq) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			// 현재 1개의 insert는 동작하지만 날짜가 여러날 일경우 날짜별 insert가 동작하지 않는 상태임.
			String query = "insert into book (boPrice, boDate, boCheckindate, boGroup, boCount, ";
			String query2 = "pay_cid, pay_room_roseq, pay_room_regcamp_regSeq, pay_room_regcamp_host_hSeq, pay_client_cid ) values ";
			String query3 = "";
			//String query4  = "";
			for (int j=0;j<intdiff;j++) {
				query3 = query3 + "(?,now(),?,?,?,?,?,?,?,?) ";
			}
			preparedStatement = connection.prepareStatement(query+query2+query3);
			System.out.println(query+query2+query3);
			for (int j=0;j<intdiff;j++) {
				preparedStatement.setInt((j*9)+1, boPrice);
				preparedStatement.setString((j*9)+2, boCheckindate);
				preparedStatement.setInt((j*9)+3, boGroup);
				preparedStatement.setInt((j*9)+4, boCount);
				preparedStatement.setString((j*9)+5, "asdf");
				preparedStatement.setInt((j*9)+6, 13);
				preparedStatement.setInt((j*9)+7, regSeq);
				preparedStatement.setInt((j*9)+8, 1);
				preparedStatement.setString((j*9)+9, cId);
			}
			System.out.println(boPrice);
			System.out.println(intdiff);
			System.out.println(cId);
			System.out.println(query);
			System.out.println(query2);
			System.out.println(query3);
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
	} //insertbook
	
/*	
	public static String getNextDate(String currentDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getStringToDate(currentDate));
		cal.add(cal.DATE, +1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(cal.getTime());
		
	}
	
	public static Date getStringToDate(String dateString) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
				Date date = sdf.parse(dateString);
				return date;
		} catch(ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
*/	
}
