package com.bootcamp.client.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.bootcamp.dto.ClientDto;

public class ClientDao {

	DataSource dataSource;

	public ClientDao() {

		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//마이페이지
	public ClientDto mypageView(String scId) {

		ClientDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();

			String query = "select cId,cName, cPhone, cEmail, cPw , zonecode, address, buildingName, detailAddress from client where cId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, scId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String cId = resultSet.getString("cId");
				String cPhone = resultSet.getString("cPhone");
				String cEmail = resultSet.getString("cEmail");
				String cPw = resultSet.getString("cPw");
				String cName = resultSet.getString("cName");
				String zonecode = resultSet.getString("zonecode");
				String address = resultSet.getString("address");
				String buildingName = resultSet.getString("buildingName");
				String detailAddress = resultSet.getString("detailAddress");

				dto = new ClientDto(cId, cPw,cName, cPhone, cEmail,zonecode,address,buildingName,detailAddress);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return dto;
	}

	// 회원등록
		public void Clientwrite(String cId, String cPw, String cName, String cPhone, String cEmail, String zonecode, String address, String buildingName, String detailAddress) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			try {
				connection = dataSource.getConnection();

				String query = "insert into client (cId,cPw,cName,cPhone,cEmail,cDate,zonecode,address,buildingName,detailAddress) values(?,?,?,?,?,now(),?,?,?,?) ";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, cId);
				preparedStatement.setString(2, cPw);
				preparedStatement.setString(3, cName);
				preparedStatement.setString(4, cPhone);
				preparedStatement.setString(5, cEmail);
				preparedStatement.setString(6, zonecode);
				preparedStatement.setString(7, address);
				preparedStatement.setString(8, buildingName);
				preparedStatement.setString(9, detailAddress);

				preparedStatement.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
					if (connection != null)
						connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}// 등록

	// Login
		public boolean login(String scId, String scPw){
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			ClientDto dto = null;
			boolean Result=false;
			try {
				connection = dataSource.getConnection();
				
				String query = "select count(*) from client where cDdate is null and cId=? and cPw=? " ; //
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, scId); // 위에 커리문에 물음표 갯수 만큼 작성
				preparedStatement.setString(2, scPw);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					String count = resultSet.getString("count(*)"); //count(*)값을 가져와야 하기때문에
					Result = count.equals("1"); // 아이디와 패스워드가 같고 삭제일자가 없으면 1
				
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
			return Result;
		} // login
			
	
	//삭제하기
	public void ClientDelete(String cId, String cPw, String cName, String cPhone, String cEmail) {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			String query = "update client set cDdate=now() where cId=?";
	
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, cId);
			preparedStatement.executeUpdate(); //삭제 실행
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	}//delete End 

	//수정하기
	public void ClientModify(String cId, String cPw, String cName, String cPhone, String cEmail, String czonecode, String caddress, String cbuildingName, String cdetailAddress) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update client set cPhone=? , cEmail=? , cPw=?, cName=?, zonecode=?,address=?,buildingName=?, detailAddress=?, cMdate=now() where cId=?";
					
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, cPhone);
			preparedStatement.setString(2, cEmail);
			preparedStatement.setString(3, cPw);
			preparedStatement.setString(4, cName);
			preparedStatement.setString(5, czonecode);
			preparedStatement.setString(6, caddress);
			preparedStatement.setString(7, cbuildingName);
			preparedStatement.setString(8, cdetailAddress);
			preparedStatement.setString(9, cId);
			
		
			preparedStatement.executeUpdate(); //수정 실행
						
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}//ClientModify End 
	
	
	
	
}// Class end 

	

