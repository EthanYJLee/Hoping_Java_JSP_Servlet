package com.bootcamp.host.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bootcamp.joindto.BookJoinDto;


public class BookJoinDao {
	
	DataSource dataSource;
	
	public BookJoinDao() {
		
		try {
			
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
	}//constructor
	
	//예약 목록 리스트 -----------
	public ArrayList<BookJoinDto> list(String hSeq){
		
		ArrayList<BookJoinDto> dtos = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "select boSeq, regName, c.cId, boPrice*boCount, boDate, r.roNum, boCheckindate, boCheckoutdate, boCount from book b, pay p, room r, client c, regcamp rc ";
			String query2 = "where b.pay_cid = p.cid and b.pay_room_roSeq = r.roSeq and b.pay_room_regcamp_regSeq = p.room_regcamp_regSeq ";
			String query3 = "and b.pay_room_regcamp_regSeq = rc.regSeq and b.pay_room_regcamp_host_hSeq = p.room_regcamp_host_hSeq ";
			String query4 = "and b.pay_client_cId = c.cId and b.pay_room_regcamp_host_hSeq = ?";
			
			preparedStatement = connection.prepareStatement(query + query2 + query3 + query4);
			preparedStatement.setString(1, hSeq);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int boSeq = resultSet.getInt("boSeq");
				String regName = resultSet.getString("regName");
				String pay_cid = resultSet.getString("c.cId");
				int total = resultSet.getInt("boPrice*boCount");
				Timestamp boDate = resultSet.getTimestamp("boDate");
				int roNum = resultSet.getInt("r.roNum");
				Timestamp boCheckindate = resultSet.getTimestamp("boCheckindate");
				Timestamp boCheckoutdate = resultSet.getTimestamp("boCheckoutdate");
				int boCount = resultSet.getInt("boCount");
				
				BookJoinDto dto = new BookJoinDto(boSeq, regName, pay_cid, total, boDate, roNum, boCheckindate, boCheckoutdate, boCount);
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
	}//list
	
	//예약 목록 검색 -----------
	public ArrayList<BookJoinDto> bookListCon(String hSeq, String start, String end, String strSearch){
		
		ArrayList<BookJoinDto> dtos = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "select boSeq, regName, c.cId, boPrice*boCount, boDate, r.roNum, boCheckindate, boCheckoutdate, boCount from book b, pay p, room r, client c, regcamp rc ";
			String query2 = "where b.pay_cid = p.cid and b.pay_room_roSeq = r.roSeq and b.pay_room_regcamp_regSeq = p.room_regcamp_regSeq ";
			String query3 = "and b.pay_room_regcamp_regSeq = rc.regSeq and b.pay_room_regcamp_host_hSeq = p.room_regcamp_host_hSeq ";
			String query4 = "and b.pay_client_cId = c.cId and b.pay_room_regcamp_host_hSeq = ? ";
			String query5 = "and regName like '%" +strSearch+ "%' and boDate between ? and ? ";
			
			
			preparedStatement = connection.prepareStatement(query + query2 + query3 + query4 + query5);
			preparedStatement.setString(1, hSeq);
			preparedStatement.setString(2, start);
			preparedStatement.setString(3, end);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int boSeq = resultSet.getInt("boSeq");
				String regName = resultSet.getString("regName");
				String pay_cid = resultSet.getString("c.cId");
				int total = resultSet.getInt("boPrice*boCount");
				Timestamp boDate = resultSet.getTimestamp("boDate");
				int roNum = resultSet.getInt("r.roNum");
				Timestamp boCheckindate = resultSet.getTimestamp("boCheckindate");
				Timestamp boCheckoutdate = resultSet.getTimestamp("boCheckoutdate");
				int boCount = resultSet.getInt("boCount");
				
				BookJoinDto dto = new BookJoinDto(boSeq, regName, pay_cid, total, boDate, roNum, boCheckindate, boCheckoutdate, boCount);
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
	}//list
	
	//예약 세부 페이지-----------
	public BookJoinDto detailBook(String sBoSeq){
		
		BookJoinDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "select boSeq, regName, c.cId, boPrice*boCount, boDate, r.roNum, boCheckindate, boCheckoutdate, boCount, boPrice from book b, pay p, room r, client c, regcamp rc ";
			String query2 = "where b.pay_cid = p.cid and b.pay_room_roSeq = r.roSeq and b.pay_room_regcamp_regSeq = p.room_regcamp_regSeq ";
			String query3 = "and b.pay_room_regcamp_regSeq = rc.regSeq and b.pay_room_regcamp_host_hSeq = p.room_regcamp_host_hSeq ";
			String query4 = "and b.pay_client_cId = c.cId and b.boSeq = ?";
			
			preparedStatement = connection.prepareStatement(query + query2 + query3 + query4);
			preparedStatement.setString(1, sBoSeq);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int boSeq = resultSet.getInt("boSeq");
				String regName = resultSet.getString("regName");
				String pay_cid = resultSet.getString("c.cId");
				int total = resultSet.getInt("boPrice*boCount");
				Timestamp boDate = resultSet.getTimestamp("boDate");
				int roNum = resultSet.getInt("r.roNum");
				Timestamp boCheckindate = resultSet.getTimestamp("boCheckindate");
				Timestamp boCheckoutdate = resultSet.getTimestamp("boCheckoutdate");
				int boCount = resultSet.getInt("boCount");
				int boPrice = resultSet.getInt("boPrice");
				
				dto = new BookJoinDto(boSeq, regName, pay_cid, total, boDate, roNum, boCheckindate, boCheckoutdate, boCount, boPrice);
				
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
		
		return dto;
	}//list

	

}//END
