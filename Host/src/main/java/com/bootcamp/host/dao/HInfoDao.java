package com.bootcamp.host.dao;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import com.bootcamp.dto.AskDto;
import com.bootcamp.dto.ClientDto;
import com.bootcamp.dto.HostDto;

public class HInfoDao {
	
	DataSource dataSource;
	
	public HInfoDao() {
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//---------------------호스트 정보(마이페이지)-----------------------------
	// 전체 리스트
		public ArrayList<ClientDto> List(){
			ArrayList<ClientDto> dtos = new ArrayList<ClientDto>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = dataSource.getConnection();
				
				String query = "select cId, cName, cPhone, cEmail, cImage from client";
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					String cId = resultSet.getString("cId");
					String cName = resultSet.getString("cName");
					String cPhone = resultSet.getString("cPhone");
					String cEmail = resultSet.getString("cEmail");
					String cImage = resultSet.getString("cImage");
					
					
					ClientDto dto = new ClientDto(cId, cName, cPhone, cEmail, cImage);
					dtos.add(dto);
					
				
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
		} // list
		
		
	//마이페이지 디테일 정보
	public ClientDto myPageView(String scId){
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ClientDto dto = null; 
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select cId, cName, cPhone, cEmail, cImage from client where cId='anna' ";
			preparedStatement = connection.prepareStatement(query);
			//preparedStatement.setString(1, scId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				String cId = resultSet.getString("cId");
				String cName = resultSet.getString("cName");
				String cPhone = resultSet.getString("cPhone");
				String cEmail = resultSet.getString("cEmail");
				String cImage = resultSet.getString("cImage");
				
				
				dto = new ClientDto(cId, cName, cPhone, cEmail, cImage);
				
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
		return dto;
	} // Content
	
	
	// 호스트 정보 테이블에 insert 
	public void insert(String hId, String hSummary) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into host (hId, hDate, hSummary) values (?,curdate(),?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, hId);
			preparedStatement.setString(2, hSummary);
			
			
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
	
	
	
	//호스트 사진  이미 인서트한 정보에 update
	public void imageUpdate(String hImage) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update host set hImage=? where hId='anna' ";
			preparedStatement = connection.prepareStatement(query);
			
			
			preparedStatement.setString(1, hImage);
			
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
	}
	
	//file 보여주깅------호스트 모든 정보 show 하기
		//상세페이지 출력 
			public HostDto fileView() {
				HostDto dto = null;
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				
				
				try {
					connection = dataSource.getConnection();
					String query = "select hId, hSummary, hImage from host where hId='anna' ";
					
					preparedStatement = connection.prepareStatement(query);
					resultSet = preparedStatement.executeQuery();
					
					if(resultSet.next()) {
						//하나니까 if로. 
						String hId = resultSet.getString("hId");
						String hSummary = resultSet.getString("hSummary");
						String hImage = resultSet.getString("hImage");
						
						dto = new HostDto(hId, hSummary, hImage);
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
			}//detail_view
	
			
			
			
	
}
