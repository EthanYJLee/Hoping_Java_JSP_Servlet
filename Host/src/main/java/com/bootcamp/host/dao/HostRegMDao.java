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
	
	
	
	

}//END
