package com.bootcamp.host.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bootcamp.joindto.BookListDto;


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
	public ArrayList<BookListDto> list(int hSeq, int startRow, int pageRow){
		
		ArrayList<BookListDto> dtos = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "select boGroup, regName, pay_client_cId, total, boDate, ";
			String query2 = "roNum, min(checkin) as mcheckin, max(checkout) as mcheckout, boCount ";
			String query3 = "from booklist where pay_room_regcamp_host_hSeq = ? ";
			String query4 = "group by boGroup, regName, pay_client_cId, total, boDate, roNum, boCount limit ?, ? ";
			
			preparedStatement = connection.prepareStatement(query + query2 + query3 + query4);
			preparedStatement.setInt(1, hSeq);
			preparedStatement.setInt(2, startRow);
			preparedStatement.setInt(3, pageRow);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int boGroup = resultSet.getInt("boGroup");
				String regName = resultSet.getString("regName");
				String pay_client_cId = resultSet.getString("pay_client_cId");
				String total = resultSet.getString("total").replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
				Timestamp boDate = resultSet.getTimestamp("boDate");
				int roNum = resultSet.getInt("roNum");
				Timestamp mcheckin = resultSet.getTimestamp("mcheckin");
				Timestamp checkout = resultSet.getTimestamp("mcheckout");
				int boCount = resultSet.getInt("boCount");
				
				BookListDto dto = new BookListDto(boGroup, regName, pay_client_cId, total, boDate, roNum, mcheckin, checkout, boCount);
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
	
	//예약 row 총 개수
	public int countRow(int hSeq){
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int rowcount = 0;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "select count(*) as rowcount from pagecount where pay_room_regcamp_host_hSeq = ? ";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, hSeq);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				
				rowcount = resultSet.getInt("rowcount");
				
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
		
		return rowcount;
	}//list
	
	//예약 목록 검색 (날짜, 텍스트) -----------
	public ArrayList<BookListDto> bookListCon(int hSeq, String startDate, String endDate, String strSearch, int startRow, int pageRow){
		
		ArrayList<BookListDto> dtos = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "select boGroup, regName, pay_client_cId, total, boDate, ";
			String query2 = "roNum, min(checkin) as mcheckin, max(checkout) as mcheckout, boCount ";
			String query3 = "from booklist where pay_room_regcamp_host_hSeq = ? ";
			String query4 = "and regName like '%"+strSearch+"%' and boDate between ? and ? ";
			String query5 = "group by boGroup, regName, pay_client_cId, total, boDate, roNum, boCount limit ?, ? ";
			
			
			preparedStatement = connection.prepareStatement(query + query2 + query3 + query4 + query5);
			preparedStatement.setInt(1, hSeq);
			preparedStatement.setString(2, startDate);
			preparedStatement.setString(3, endDate);
			preparedStatement.setInt(4, startRow);
			preparedStatement.setInt(5, pageRow);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int boGroup = resultSet.getInt("boGroup");
				String regName = resultSet.getString("regName");
				String pay_client_cId = resultSet.getString("pay_client_cId");
				String total = resultSet.getString("total").replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
				Timestamp boDate = resultSet.getTimestamp("boDate");
				int roNum = resultSet.getInt("roNum");
				Timestamp mcheckin = resultSet.getTimestamp("mcheckin");
				Timestamp checkout = resultSet.getTimestamp("mcheckout");
				int boCount = resultSet.getInt("boCount");
				
				BookListDto dto = new BookListDto(boGroup, regName, pay_client_cId, total, boDate, roNum, mcheckin, checkout, boCount);
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
	}//bookListCon
	
	//예약 목록 검색 (텍스트) -----------
	public ArrayList<BookListDto> bookListName(int hSeq, String strSearch){
		
		ArrayList<BookListDto> dtos = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "select boGroup, regName, pay_client_cId, total, boDate, ";
			String query2 = "roNum, min(checkin) as mcheckin, max(checkout) as mcheckout, boCount ";
			String query3 = "from booklist where pay_room_regcamp_host_hSeq = ? ";
			String query4 = "and regName like '%"+strSearch+"%' ";
			String query5 = "group by boGroup, regName, pay_client_cId, total, boDate, roNum, boCount ";
			
			
			preparedStatement = connection.prepareStatement(query + query2 + query3 + query4 + query5);
			preparedStatement.setInt(1, hSeq);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int boGroup = resultSet.getInt("boGroup");
				String regName = resultSet.getString("regName");
				String pay_client_cId = resultSet.getString("pay_client_cId");
				String total = resultSet.getString("total").replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
				Timestamp boDate = resultSet.getTimestamp("boDate");
				int roNum = resultSet.getInt("roNum");
				Timestamp mcheckin = resultSet.getTimestamp("mcheckin");
				Timestamp checkout = resultSet.getTimestamp("mcheckout");
				int boCount = resultSet.getInt("boCount");
				
				BookListDto dto = new BookListDto(boGroup, regName, pay_client_cId, total, boDate, roNum, mcheckin, checkout, boCount);
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
	public BookListDto detailBook(String sBoSeq){
		
		BookListDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "select boGroup, regName, pay_client_cId, total, boDate, boPrice, ";
			String query2 = "roNum, min(checkin) as mcheckin, max(checkout) as mcheckout, boCount ";
			String query3 = "from booklist where boGroup = ? ";
			String query4 = "group by boGroup, regName, pay_client_cId, total, boDate, roNum, boCount, boPrice ";
			
			preparedStatement = connection.prepareStatement(query + query2 + query3 + query4);
			preparedStatement.setString(1, sBoSeq);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				String boPrice = resultSet.getString("boPrice").replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
				int boGroup = resultSet.getInt("boGroup");
				String regName = resultSet.getString("regName");
				String pay_client_cId = resultSet.getString("pay_client_cId");
				String total = resultSet.getString("total").replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
				Timestamp boDate = resultSet.getTimestamp("boDate");
				int roNum = resultSet.getInt("roNum");
				Timestamp mcheckin = resultSet.getTimestamp("mcheckin");
				Timestamp checkout = resultSet.getTimestamp("mcheckout");
				int boCount = resultSet.getInt("boCount");
				
				dto = new BookListDto(boPrice, boGroup, regName, pay_client_cId, total, boDate, roNum, mcheckin, checkout, boCount);
				
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
