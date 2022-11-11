package com.bootcamp.host.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class HostCheckDao {
	DataSource dataSource;

	public HostCheckDao() {
		try {
			Context context = new InitialContext(); // javax.naming
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int clientToHost(String cId) {
		// 호스트 이미 등록되어있는 클라이언트가 호스트모드로 전환할 때
		// 처음 등록하는 호스트일 경우 room 등록 => 빈 jsp 화면 (hSeq set) => HostMain.jsp
		PreparedStatement ps = null;
		Connection connection = null;
		ResultSet rs = null;
		int hSeq = 0;

		try {
			connection = dataSource.getConnection();
			String query = "select h.hSeq from host h inner join client c on h.hId = c.cId where c.cId = ?";
			ps = connection.prepareStatement(query);

			ps.setString(1, cId);

			rs = ps.executeQuery();

			while (rs.next()) {
				hSeq = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return hSeq;
	}

	public int checkHostLogin(String cId, String cPw) { // 호스트용 로그인 페이지가 따로 있다면 이런 모양일 것.
		PreparedStatement ps = null;
		Connection connection = null;
		ResultSet rs = null;
		int hSeq = 0;

		try {
			connection = dataSource.getConnection();
			String query = "select h.hSeq from host h inner join client c on h.hId = c.cId where c.cId = ? and c.cPw = ?";
			ps = connection.prepareStatement(query);

			ps.setString(1, cId);
			ps.setString(2, cPw);

			rs = ps.executeQuery();

			while (rs.next()) {
				hSeq = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return hSeq;

	}

}
