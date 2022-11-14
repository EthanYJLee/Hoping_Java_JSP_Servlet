package com.bootcamp.host.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class HostReviewStatusDao {
	DataSource dataSource;

	public HostReviewStatusDao() {
		try {
			Context context = new InitialContext(); // javax.naming
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int mainReviewCount(int hSeq) { // 오늘 달린 후기 갯수 전체
		PreparedStatement ps = null;
		Connection connection = null;
		ResultSet rs = null;
		int todayR = 0;

		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from review rv inner join regcamp reg on ";
			String query2 = "rv.regcamp_regSeq = reg.regSeq where date(rv.rvTime) = curdate() "
					+ "and rv.rvDtime is null and reg.host_hSeq = ?";

			ps = connection.prepareStatement(query + query2);
			ps.setInt(1, hSeq);

			rs = ps.executeQuery();

			while (rs.next()) {
				todayR = rs.getInt(1); // 리뷰 수 (오늘 날짜 기준)
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
		return todayR;
	}

	public int mainReviewRepliedCount(int hSeq) { // 오늘 문의글 중 답변 완료된 수 카운트
		PreparedStatement ps = null;
		Connection connection = null;
		ResultSet rs = null;
		int todayRepliedR = 0;

		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from rcomment rc inner join review rv on rc.review_rvSeq = rv.rvSeq ";
			String query2 = "where date(rv.rvTime) = curdate() and date(rc.rcTime) = curdate() and rv.regcamp_host_hSeq = ?";

			ps = connection.prepareStatement(query + query2);
			ps.setInt(1, hSeq);

			rs = ps.executeQuery();

			while (rs.next()) {
				todayRepliedR = rs.getInt(1); // 문의글 답변완료 수 (오늘 날짜 기준)
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
		return todayRepliedR;

	}

}
