package com.bootcamp.client.dao;

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
import com.bootcamp.joindto.HostClientDto;

public class HInfoDao {

	DataSource dataSource;

	public HInfoDao() {

		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ---------------------호스트 정보(마이페이지)-----------------------------

	// 마이페이지 디테일 정보
	public ClientDto joinView(String scId) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ClientDto dto = null;

		try {
			connection = dataSource.getConnection();

			String query = "select cId, cName, cPhone, cEmail, cImage from client where cId=? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, scId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String cId = resultSet.getString("cId");
				String cName = resultSet.getString("cName");
				String cPhone = resultSet.getString("cPhone");
				String cEmail = resultSet.getString("cEmail");
				String cImage = resultSet.getString("cImage");

				dto = new ClientDto(cId, cName, cPhone, cEmail, cImage);
				System.out.println("hID:" + cId);
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
	} // write

	// 호스트 사진 이미 인서트한 정보에 update
	public void imageUpdate(String hImage, String hId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();

			String query = "update host set hImage=? where hId=? ";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, hImage);
			preparedStatement.setString(2, hId);

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
	}

	// file 보여주깅------호스트 모든 정보 show 하기
	// 상세페이지 출력
	public HostDto fileView(String shId) {
		HostDto dto = null;
		Connection connection = null;

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "select hId, hSummary, hImage from host where hId=? ";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, shId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				// 하나니까 if로.
				String hId = resultSet.getString("hId");
				String hSummary = resultSet.getString("hSummary");
				String hImage = resultSet.getString("hImage");

				dto = new HostDto(hId, hSummary, hImage);
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
	}// detail_view

	// 호스트 정보 수정
	// 마이페이지 디테일 정보
	public HostClientDto myPageView(String hcId) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		HostClientDto dto = null;

		try {
			connection = dataSource.getConnection();

			String query = "select hId, cName, cPhone, cEmail, hImage, hSummary from host, client where hId=cId and hId=? ";
			preparedStatement = connection.prepareStatement(query);
			// preparedStatement.setString(1, hcId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String hId = resultSet.getString("hId");
				String cName = resultSet.getString("cName");
				String cPhone = resultSet.getString("cPhone");
				String cEmail = resultSet.getString("cEmail");
				String hImage = resultSet.getString("hImage");
				String hSummary = resultSet.getString("hSummary");

				dto = new HostClientDto(hId, cName, cPhone, cEmail, hImage, hSummary);

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
	} // Content

	public void mypageUpdate(String hSummary, String hImage, String hId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();

			String query = "update host set hSummary=?, hImage=? where hId=? ";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, hSummary);
			preparedStatement.setString(2, hImage);
			preparedStatement.setString(3, hId);

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

	}
	// 호스트모드 넘어갈 때 호스트 가입 여부 확인 
		public Boolean arHost(String scId) {

			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			HostClientDto dto = null;
			boolean Result=true;

			try {
				connection = dataSource.getConnection();

				String query = "select count(*) from client, host where cId=hId and cId=? ";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, scId);
				resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					String count = resultSet.getString("count(*)"); //count(*)값을 가져와야 하기때문에
					Result = count.equals("1");//1이면 host 계정 있음>호스트 메인페이지, 0이면 없음>호스트가입을 위한 약관 
					
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
			return Result;
		} // Content

		
		//클라이언트>호스트 넘길 때 세션 (아이디, 호스트아이디, hseq)
		public HostClientDto arHost1(String shId) {
			HostClientDto dto = null;
			Connection connection = null;

			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;

			try {
				connection = dataSource.getConnection();
				String query = "select hSeq, hId, cId from client, host where cId=hId and cId=? ";

				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, shId);
				resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					// 하나니까 if로.
					int hSeq = resultSet.getInt("hSeq");
					String hId = resultSet.getString("hId");
					String cId = resultSet.getString("cId");

					dto = new HostClientDto(hSeq, hId, cId);
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
		}// detail_view

}
