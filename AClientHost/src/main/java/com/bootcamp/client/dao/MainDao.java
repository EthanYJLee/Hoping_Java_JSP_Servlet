package com.bootcamp.client.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bootcamp.dto.regcampDto;
import com.bootcamp.dto.reviewDto;
import com.bootcamp.dto.roomDto;
import com.bootcamp.dto.wishDto;

public class MainDao {
	
	DataSource dataSource;

	public MainDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
		}catch(Exception e){
			e.printStackTrace();
		}
	}	
	// regcamp 관련 searchRegCampview

	public ArrayList<regcampDto> listRegCampview(){
		ArrayList<regcampDto> dtos = new ArrayList<regcampDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		regcampDto dto;
		
		try {
			connection = dataSource.getConnection();
			System.out.println("Query start");                     //<<<<<<<<<<<<<<<<<<<<syso
			String query = "select * from regcamp";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println("Query Execute");                     //<<<<<<<<<<<<<<<<<<<<syso
			
			while(resultSet.next()) {
				int regSeq = resultSet.getInt("regSeq");
				String regTel = resultSet.getString("regTel");
				String regDetailaddress = resultSet.getString("regDetailaddress");
				String regName = resultSet.getString("regName");
				Timestamp regDate = resultSet.getTimestamp("regDate");
				Timestamp regMdate = resultSet.getTimestamp("regMdate");
				Timestamp regDdate = resultSet.getTimestamp("regDdate");
				String regSummary =  resultSet.getString("regSummary");
				String regCategory =  resultSet.getString("regCategory");
				String regImage1 =  resultSet.getString("regImage1");
				String regImage2 =  resultSet.getString("regImage2");
				String regImage3 =  resultSet.getString("regImage3");
				String regImage4 =  resultSet.getString("regImage4");
				int host_hSeq = resultSet.getInt("host_hSeq");
				System.out.println("regSeq:"+regSeq+":");                     //<<<<<<<<<<<<<<<<<<<<syso

				dto = new regcampDto(regSeq, regTel, regDetailaddress, regName, regDate, regMdate, regDdate, regSummary, regCategory, regImage1,regImage2,regImage3,regImage4, host_hSeq);
				dtos.add(dto);
				System.out.println("DTO Add");                     //<<<<<<<<<<<<<<<<<<<<syso
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
	} // searchRegCampview	

	// 
	public ArrayList<regcampDto> searchRegCamp(String strQuery, String strContent){
		ArrayList<regcampDto> dtos = new ArrayList<regcampDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		regcampDto dto;
		
		try {
			connection = dataSource.getConnection();
			System.out.println("Query start");                     //<<<<<<<<<<<<<<<<<<<<syso
			String query = "select * from regcamp where "+strQuery+" like '%"+strContent+ "%' ";
			System.out.println(query);                     //<<<<<<<<<<<<<<<<<<<<syso
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println("Query Execute");                     //<<<<<<<<<<<<<<<<<<<<syso

			while(resultSet.next()) {
				int regSeq = resultSet.getInt("regSeq");
				String regTel = resultSet.getString("regTel");
				String regDetailaddress = resultSet.getString("regDetailaddress");
				String regName = resultSet.getString("regName");
				Timestamp regDate = resultSet.getTimestamp("regDate");
				Timestamp regMdate = resultSet.getTimestamp("regMdate");
				Timestamp regDdate = resultSet.getTimestamp("regDdate");
				String regSummary =  resultSet.getString("regSummary");
				String regCategory =  resultSet.getString("regCategory");
				String regImage1 =  resultSet.getString("regImage1");
				String regImage2 =  resultSet.getString("regImage2");
				String regImage3 =  resultSet.getString("regImage3");
				String regImage4 =  resultSet.getString("regImage4");
				int host_hSeq = resultSet.getInt("host_hSeq");
				System.out.println("regSeq:"+regSeq+":");

				dto = new regcampDto(regSeq, regTel, regDetailaddress, regName, regDate, regMdate, regDdate, regSummary, regCategory, regImage1,regImage2,regImage3,regImage4, host_hSeq);
				dtos.add(dto);
				System.out.println("DTO Add");                     //<<<<<<<<<<<<<<<<<<<<syso
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
	} // searchSiteView	
	
	
	// room 관련 searchSiteView
	public ArrayList<roomDto> searchSiteView(String strQuery){
		ArrayList<roomDto> dtos = new ArrayList<roomDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		roomDto dto;
		
		try {
			connection = dataSource.getConnection();
			System.out.println("Query start");                     //<<<<<<<<<<<<<<<<<<<<syso
			String query = "select * from room where '%"+strQuery+ "%' ";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println("MainDao 에 있는 searchSiteView      Query Select * from room where Execute");                     //<<<<<<<<<<<<<<<<<<<<syso
			
			while(resultSet.next()) {
				int roSeq = resultSet.getInt("roSeq");
				int roNum = resultSet.getInt("roNum");
				String roPrice = resultSet.getString("roPrice").replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
				int roMax = resultSet.getInt("roMax");
				int roOccupied = resultSet.getInt("roOccupied");
				int regcamp_regSeq = resultSet.getInt("regcamp_regSeq");
				int regcamp_host_hSeq = resultSet.getInt("regcamp_host_hSeq");
				System.out.println("roSeq:"+roSeq+":");                     //<<<<<<<<<<<<<<<<<<<<syso

				dto = new roomDto(roSeq, roNum, roPrice, roMax, roOccupied, regcamp_regSeq, regcamp_host_hSeq);
				dtos.add(dto);
				System.out.println("Room DTO Add");                     //<<<<<<<<<<<<<<<<<<<<syso
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
	} // searchSiteView	
	
	
	// room 관련 searchCampWish
	public ArrayList<wishDto> searchCampWish(){
		ArrayList<wishDto> dtos = new ArrayList<wishDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		wishDto dto;
		
		try {
			connection = dataSource.getConnection();
			System.out.println("Query start");                     //<<<<<<<<<<<<<<<<<<<<syso
			String query = "select * from wish";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println("Query Select * from wish Execute");
			
			while(resultSet.next()) {
				int wSeq = resultSet.getInt("wSeq");
				Timestamp wDate = resultSet.getTimestamp("wDate");
				String client_cId = resultSet.getString("client_cId");
				int host_hSeq = resultSet.getInt("host_hSeq");
				System.out.println("wSeq:"+wSeq+":");                     //<<<<<<<<<<<<<<<<<<<<syso

				dto = new wishDto(wSeq, wDate, client_cId, host_hSeq);
				dtos.add(dto);
				System.out.println("MainDao에 있는 searchCampWish Room DTO Add");                         //<<<<<<<<<<<<<<<<<<<<syso
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
	} // searchCampWish	
	
	// room 관련 searchReview
	public ArrayList<reviewDto> searchReview(){
		ArrayList<reviewDto> dtos = new ArrayList<reviewDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		reviewDto dto;
		
		try {
			connection = dataSource.getConnection();
			System.out.println("Query start");                     //<<<<<<<<<<<<<<<<<<<<syso
			String query = "select * from review";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println("Query Select * from review Execute");                     //<<<<<<<<<<<<<<<<<<<<syso
			
			while(resultSet.next()) {
				int rvSeq = resultSet.getInt("rvSeq");
				String rvId = resultSet.getString("rvId");
				String rvName = resultSet.getString("rvName");
				String rvTitle = resultSet.getString("rvTitle");
				String rvContent = resultSet.getString("rvContent");
				int rvStar = resultSet.getInt("rvStar");
				Timestamp rvTime = resultSet.getTimestamp("rvTime");
				Timestamp rvMtime = resultSet.getTimestamp("rvMtime");
				Timestamp rvDtime = resultSet.getTimestamp("rvDtime");
				System.out.println("rvSeq:"+rvSeq+":");                     //<<<<<<<<<<<<<<<<<<<<syso

				dto = new reviewDto(rvSeq, rvId, rvName, rvTitle, rvContent, rvStar, rvTime, rvMtime, rvDtime);
				dtos.add(dto);
				System.out.println("MainDao에 있는 searchReview Review DTO Add");                         //<<<<<<<<<<<<<<<<<<<<syso
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
	} // searchReview	
	
	// room 관련 searchReviewCount
	public ArrayList<reviewDto> searchReviewCount(){
		ArrayList<reviewDto> dtos = new ArrayList<reviewDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		reviewDto dto;
		
		try {
			connection = dataSource.getConnection();
			System.out.println("Query start");                     //<<<<<<<<<<<<<<<<<<<<syso
			String query = "select count(*) from review";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println("Query Select * from review Execute");
			
			while(resultSet.next()) {
				int rvSeq = resultSet.getInt("rvSeq");
				String rvId = resultSet.getString("rvId");
				String rvName = resultSet.getString("rvName");
				String rvTitle = resultSet.getString("rvTitle");
				String rvContent = resultSet.getString("rvContent");
				int rvStar = resultSet.getInt("rvStar");
				Timestamp rvTime = resultSet.getTimestamp("rvTime");
				Timestamp rvMtime = resultSet.getTimestamp("rvMtime");
				Timestamp rvDtime = resultSet.getTimestamp("rvDtime");
				System.out.println("rvSeq:"+rvSeq+":");                     //<<<<<<<<<<<<<<<<<<<<syso

				dto = new reviewDto(rvSeq, rvId, rvName, rvTitle, rvContent, rvStar, rvTime, rvMtime, rvDtime);
				dtos.add(dto);
				System.out.println("MainDao에 있는 searchReviewCount   Room DTO Add");                         //<<<<<<<<<<<<<<<<<<<<syso
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
	} // searchReviewCount	
	
	
	
}
