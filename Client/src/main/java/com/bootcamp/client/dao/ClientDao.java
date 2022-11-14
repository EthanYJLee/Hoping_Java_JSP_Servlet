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
import com.bootcamp.dto.regcampDto;
import com.bootcamp.joindto.checkdate2Dto;

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

	/// 아이디 중복검사
	public int checkId(String cId) { // 유저가 입력한 값을 매개변수로 한다
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
//		int idCheck = 0;

		try {
			connection = dataSource.getConnection();

			String sql = "select * from client where cId = ? "; // 입력값이 테이블에 있는지 확인

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cId);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next() || cId.equals("")) {
				return 0; // 이미 존재하는 경우, 생성 불가능
			} else {
				return 1; // 존재하지 않는 경우, 생성 가능
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1;

	}

	
	/*
	 22-11-12 Hosik - 성연씨가 작업해 주신거.
	 				아이디와 비밀번호 찾기는 email 로 시도해 볼 예정, 안되면 아래꺼 사용하고 되면은 아래껀 사용 안할꺼입니다 
	  
	 */
	// 아이디 찾기
	public String idsearch(String cName, String cEmail) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String cId = null;

		try {
			connection = dataSource.getConnection();

			String query = "select cId from client where cDdate is null and cName=? and cEmail=?; ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, cName);
			preparedStatement.setString(2, cEmail);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				cId = resultSet.getString("cId");

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
		return cId;

	}

	// 비밀번호 찾기
	public String pwsearch(String cId, String cName, String cEmail) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String cPw = null;

		try {
			connection = dataSource.getConnection();

			String query = "select cPw from client where cDdate is null and cId=? and cName=? and cEmail=? ; ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, cId);
			preparedStatement.setString(2, cName);
			preparedStatement.setString(3, cEmail);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				cPw = resultSet.getString("cPw");

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
		return cPw;
	}//pwsearch End 
	
	
	
	/*22-11-14 hosik 
			고객이 예약한 목록들을 불러오는 Dao. 일단 미완성 하나하나 하면서 추가예정 임 
			추가할것 : 일정, 금액, 이름, 메인사진1개 
	
	*/
	public ArrayList<checkdate2Dto> clientHistory(String CID) {
		ArrayList<checkdate2Dto> dtos = new ArrayList<checkdate2Dto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		checkdate2Dto dto;
		
		try {
			String query = "select boSeq, roNum, regName, regImage1 from checkdate2 where pay_client_cId = '"+CID+"'";
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int boSeq = Integer.parseInt(resultSet.getString("boSeq"));
				int roNum = Integer.parseInt(resultSet.getString("roNum"));
				String regName = (String)resultSet.getString("regName");
				String regImage1 = (String)resultSet.getString("regImage1");
				
				dto = new checkdate2Dto(boSeq,roNum,regName,regImage1);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
	
	}//clientHistory ENd
	
	
	
}// Class end 

	

