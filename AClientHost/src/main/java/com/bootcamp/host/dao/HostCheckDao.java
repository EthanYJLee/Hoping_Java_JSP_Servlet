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

	public int checkHostLogin(String cId, String cPw) { // 호스트용 로그인 페이지가 따로 있다면 이런 모양일 것. (임시용임!!!)
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

	public int checkHostCampInfoForMod(int hSeq, int regSeq) {	
		// 호스트와 캠핑장 정보가 모두 일치하는지 확인 후 regSeq를 세션에 넣기 위한 작업
		// 수정 or 삭제 작업이 완료되면 regSeq만 invalidate 시킬 것.
		PreparedStatement ps = null;
		Connection connection = null;
		ResultSet rs = null;
		int result = 0;

		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from regcamp reg inner join host h "
					+ "on reg.host_hSeq = h.hSeq ";
			String query2 = "where reg.regSeq = ? and h.hSeq = ? and reg.regDdate is null";
			ps = connection.prepareStatement(query + query2);

			ps.setInt(1, regSeq);
			ps.setInt(2, hSeq);

			rs = ps.executeQuery();

			while (rs.next()) {
				result = rs.getInt(1);
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
		return result;
	}

}
