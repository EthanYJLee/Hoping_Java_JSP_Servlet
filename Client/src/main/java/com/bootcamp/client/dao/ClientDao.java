package com.bootcamp.client.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bootcamp.client.dto.ClientDto;

public class ClientDao {

	DataSource dataSource;

	public ClientDao() {

		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Client");
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

			String query = "select cId, cPhone, cEmail, cPw from Client where cId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, scId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String cId = resultSet.getString("cId");
				String cPhone = resultSet.getString("cPhone");
				String cEmail = resultSet.getString("cEmail");
				String cPw = resultSet.getString("cPw");

				dto = new ClientDto(cId, cPw, cPhone, cEmail);

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
	public void Clientwrite(String cId, String cPw, String cName, String cPhone, String cEmail) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();

			String query = "insert into Client (cId,cPw,cName,cPhone,cEmail,cDate) values(?,?,?,?,?,now()) ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, cId);
			preparedStatement.setString(2, cPw);
			preparedStatement.setString(3, cName);
			preparedStatement.setString(4, cPhone);
			preparedStatement.setString(5, cEmail);

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
				
				String query = "select count(*) from Client where cDdate is null and cId=? and cPw=? " ; //
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, scId); // 위에 커리문에 물음표 갯수 만큼 작성
				preparedStatement.setString(2, scPw);
				resultSet = preparedStatement.executeQuery();
//				System.out.println(query);
				if(resultSet.next()) {
					String count = resultSet.getString("count(*)"); //count(*)값을 가져와야 하기때문에
					Result = count.equals("1"); // 아이디와 패스워드가 같고 삭제일자가 없으면 1
//					System.out.println("result = " + count);

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
//		String query="delete from Client where cId=? ";
		String query = "update Client set cDdate=now() where cId=?";

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
	
}//delete

	//수정하기
	public void ClientModify(String cId, String cPw, String cPhone, String cEmail) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update Client set cPhone=? , cEmail=? , cPw=?, cMdate=now() where cId=?";
					
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, cPhone);
			preparedStatement.setString(2, cEmail);
			preparedStatement.setString(3, cPw);
			preparedStatement.setString(4, cId);
			
		
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
}
//	//아이디 중복검사
	public boolean checkId(String cId) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean check = false;
		try {
			connection = dataSource.getConnection();
			//DBMS 연결 객체 가져오기
			String query = "SELECT COUNT(cId) FROM Client WHERE cId = ?";
			//String으로 선언된 쿼리를 pstm객체에 전달하기
			preparedStatement = connection.prepareStatement(query);
			//SQL 쿼리에 ?가 있다면 알맞는 값으로 지정해주기
			preparedStatement.setString(1, cId);
			//쿼리 실행 후 결과를 rs객체에 담기
			resultSet = preparedStatement.executeQuery();
			
			//행가져오기
			resultSet.next();
			//위에서 가져온 행의 열을 타입에 맞춰서 가져오기
			check = resultSet.getInt(1) == 1;	//0일 때 중복 없음(false), 1일 때 중복 있음(true)
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return check;
//
	}
}