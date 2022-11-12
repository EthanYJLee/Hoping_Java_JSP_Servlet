package com.bootcamp.host.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bootcamp.dto.MyregcampDto;

public class HostRegMDao {
	
	DataSource dataSource;
	
	public HostRegMDao() {
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}//생성자
	
	//1. ------------------------------캠핑장 추가 등록------------------------------
	//위치, 설명, 이름, 전화번호, 카테고리 insert ---------
	public void inCampLo(String regDetailaddress, String regSummary, String regName, String regTel, String regCategory, int hSeq) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "insert into regcamp (regDetailaddress, regSummary, regName, regDate, regTel, regCategory, host_hSeq) ";
			String query2 = "values(?, ?, ?, curdate(), ?, ?, ?) ";
			
			preparedStatement = connection.prepareStatement(query + query2);
			preparedStatement.setString(1, regDetailaddress);
			preparedStatement.setString(2, regSummary);
			preparedStatement.setString(3, regName);
			preparedStatement.setString(4, regTel);
			preparedStatement.setString(5, regCategory);
			preparedStatement.setInt(6, hSeq);
			
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
	} //inCampLo
	
	//위에서 입력한 값을 토대로 regSeq select하기
	public int selectRegSeq(String regDetailaddress, String regSummary, String regName, String regTel, String regCategory, int hSeq) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int regSeq = 0;
		
		try {

			connection = dataSource.getConnection();
			String query = "select regSeq from regcamp where regDetailaddress = ? and regSummary = ? and regName = ? ";
			String query2 = "and regTel = ? and regCategory = ? and host_hSeq = ? ";
			
			preparedStatement = connection.prepareStatement(query + query2);
			preparedStatement.setString(1, regDetailaddress);
			preparedStatement.setString(2, regSummary);
			preparedStatement.setString(3, regName);
			preparedStatement.setString(4, regTel);
			preparedStatement.setString(5, regCategory);
			preparedStatement.setInt(6, hSeq);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				
				regSeq = resultSet.getInt("regSeq");
				
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
		return regSeq;
	}//selectRegSeq
	
	//위치, 설명 select ---------
	public MyregcampDto selectInfoLS(int regSeq, int hSeq) {
		
		MyregcampDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {

			connection = dataSource.getConnection();
			String query = "select regDetailaddress, regSummary from regcamp rc, host h ";
			String query2 = "where rc.host_hSeq = h.hSeq and regSeq = ? and host_hSeq = ? ";
			
			preparedStatement = connection.prepareStatement(query + query2);
			preparedStatement.setInt(1, (regSeq));
			preparedStatement.setInt(2, (hSeq));
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				//하나니까 if로. 
				String regDetailaddress = resultSet.getString("regDetailaddress");
				String regSummary = resultSet.getString("regSummary");
				
				dto = new MyregcampDto(regDetailaddress, regSummary);
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
	}//selectInfoLS
		
	//위치, 설명 update ---------
	public void upInfoLS(String regDetailaddress, String regSummary, int regSeq) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "update regcamp set regDetailaddress = ?, regSummary = ? where regSeq = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, regDetailaddress);
			preparedStatement.setString(2, regSummary);
			preparedStatement.setInt(3, regSeq);
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
	} //upInfoLS
	
	//이름, 카테고리, 전화번호 select ---------
	public MyregcampDto selectInfoNCT(int regSeq, int hSeq) {
		
		MyregcampDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {

			connection = dataSource.getConnection();
			String query = "select regName, regCategory, regTel from regcamp rc, host h ";
			String query2 = "where rc.host_hSeq = h.hSeq and regSeq = ? and host_hSeq = ? ";
			
			preparedStatement = connection.prepareStatement(query + query2);
			preparedStatement.setInt(1, (regSeq));
			preparedStatement.setInt(2, (hSeq));
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				//하나니까 if로. 
				String regName = resultSet.getString("regName");
				String regCategory = resultSet.getString("regCategory");
				String regTel = resultSet.getString("regTel");
				
				dto = new MyregcampDto(regName, regCategory, regTel);
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
	}//selectInfoNCT
	
	//이름, 카테고리, 전화번호 수정 ---------
	public void upInfoNCT(String regName, String regCategory, String regTel, int regSeq) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "update regcamp set regName = ?, regCategory = ?, regTel = ? where regSeq = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, regName);
			preparedStatement.setString(2, regCategory);
			preparedStatement.setString(3, regTel);
			preparedStatement.setInt(4, regSeq);
			
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
	
	//약도 이미지 select
	public MyregcampDto selectInfoRoughMap(int regSeq) {
		
		MyregcampDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {

			connection = dataSource.getConnection();
			String query = "select regImage4 from regcamp where regSeq = ?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, regSeq);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				//하나니까 if로. 
				String regImage4 = resultSet.getString("regImage4");
				
				dto = new MyregcampDto(regImage4);
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
	}//selectInfoRoughMap
		
	//약도 이미지 업데이트
	public int upRoughMap(String fileName, int regSeq) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int returnValue = 0;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "update regcamp set regImage4 = ? where regSeq = ? ";
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, fileName);
			preparedStatement.setInt(2, regSeq);
			
			returnValue = preparedStatement.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return returnValue;
	}//upRoughMap
	
		//캠핑장 이미지 select
		public MyregcampDto selectCampImages(int regSeq) {
			
			MyregcampDto dto = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {

				connection = dataSource.getConnection();
				String query = "select regImage1, regImage2, regImage3 from regcamp where regSeq = ? ";
				
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, (regSeq));
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					//하나니까 if로. 
					String regImage1 = resultSet.getString("regImage1");
					String regImage2 = resultSet.getString("regImage2");
					String regImage3 = resultSet.getString("regImage3");
					
					dto = new MyregcampDto(regImage1, regImage2, regImage3);
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
		}//selectCampImages
				
		//캠핑장 이미지1 업데이트
		public int upImage1(String fileName) {
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			int returnValue = 0;
			
			//rs랑 arraylist 필요 x 인서트만 하니까
			
			try {
				
				connection = dataSource.getConnection();
				
				String query = "update regcamp set regImage1 = ? where regSeq = 1 ";
				
				preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setString(1, fileName);
				
				returnValue = preparedStatement.executeUpdate();
				
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				try {
					
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			return returnValue;
		}//upRoughMap
		
		//캠핑장 이미지2 업데이트
		public int upImage2(String fileName) {
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			int returnValue = 0;
			
			//rs랑 arraylist 필요 x 인서트만 하니까
			
			try {
				
				connection = dataSource.getConnection();
				
				String query = "update regcamp set regImage2 = ? where regSeq = 1 ";
				
				preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setString(1, fileName);
				
				returnValue = preparedStatement.executeUpdate();
				
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				try {
					
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			return returnValue;
		}//upRoughMap
		
		//캠핑장 이미지2 업데이트
		public int upImage3(String fileName) {
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			int returnValue = 0;
			
			//rs랑 arraylist 필요 x 인서트만 하니까
			
			try {
				
				connection = dataSource.getConnection();
				
				String query = "update regcamp set regImage3 = ? where regSeq = 1 ";
				
				preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setString(1, fileName);
				
				returnValue = preparedStatement.executeUpdate();
				
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				try {
					
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			return returnValue;
		}//upRoughMap
	
	
	

}//END
