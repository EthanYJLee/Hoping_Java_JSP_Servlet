package com.bootcamp.host.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class HostReservationStatusDao {
	DataSource dataSource;

	public HostReservationStatusDao() {
		try {
			Context context = new InitialContext(); // javax.naming
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int mainReservationCount(int hSeq) { // 오늘 신규 예약건수
		PreparedStatement ps = null;
		Connection connection = null;
		ResultSet rs = null;
		int nr = 0;
		try {
			connection = dataSource.getConnection();
			String query = "select count(distinct (boGroup)) as nr from book "
					+ "where boDate = curdate() and pay_room_regcamp_host_hSeq = ?";
			ps = connection.prepareStatement(query);

			ps.setInt(1, hSeq);

			rs = ps.executeQuery();

			while (rs.next()) {
				nr = rs.getInt("nr"); // new reservation (금일 기준 신규 예약 수)
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
		return nr;
	}

	public int mainCheckinCount(int hSeq) {
		PreparedStatement ps = null;
		Connection connection = null;
		ResultSet rs = null;
		int todayIn = 0;
		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from book where boSeq = boGroup "
					+ "and boCheckindate = curdate() and pay_room_regcamp_host_hSeq = ?";

			ps = connection.prepareStatement(query);
			ps.setInt(1, hSeq);

			rs = ps.executeQuery();

			while (rs.next()) {
				todayIn = rs.getInt(1); // checkin (금일 기준 체크인 수)
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
		return todayIn;
	}

	public int mainCheckoutCount(int hSeq) {
		PreparedStatement ps = null;
		Connection connection = null;
		ResultSet rs = null;
		int todayOut = 0;
		try {
			connection = dataSource.getConnection();
			String query = "select count(checkout) from (select max(boCheckindate) as checkout ";
			String query2 = "from book where boCheckindate = curdate() group by boGroup) as result";
			ps = connection.prepareStatement(query + query2);
			ps.setInt(1, hSeq);

			rs = ps.executeQuery();

			while (rs.next()) {
				todayOut = rs.getInt(1); // checkout (금일 기준 체크아웃 수)
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
		return todayOut;
	}

}
