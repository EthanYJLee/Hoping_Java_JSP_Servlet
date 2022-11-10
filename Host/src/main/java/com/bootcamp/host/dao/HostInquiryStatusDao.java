package com.bootcamp.host.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class HostInquiryStatusDao {
	DataSource dataSource;

	public HostInquiryStatusDao() {
		try {
			Context context = new InitialContext(); // javax.naming
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int mainInquiryCount(int hSeq) { // 오늘 기준 작성된 전체 캠핑장 문의글 카운트
		PreparedStatement ps = null;
		Connection connection = null;
		ResultSet rs = null;
		int todayQ = 0;

		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from ask a inner join regcamp r on a.aRegSeq = r.regSeq ";
			String query2 = "where date(a.aTime) = curdate() and a.aDtime is null and r.host_hSeq = 1";

			ps = connection.prepareStatement(query + query2);
			ps.setInt(1, hSeq);

			rs = ps.executeQuery();

			while (rs.next()) {
				todayQ = rs.getInt(1); // 문의글 수 (오늘 날짜 기준)
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
		return todayQ;
	}

	public int mainInquiryRepliedCount(int hSeq) { // 오늘 문의글 중 답변 완료된 수 카운트
		PreparedStatement ps = null;
		Connection connection = null;
		ResultSet rs = null;
		int todayRepliedQ = 0;

		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from acomment where date(acTime) = curdate() ";
			String query2 = "and acDtime is null and host_hSeq = ?";

			ps = connection.prepareStatement(query + query2);
			ps.setInt(1, hSeq);

			rs = ps.executeQuery();

			while (rs.next()) {
				todayRepliedQ = rs.getInt(1); // 문의글 답변완료 수 (오늘 날짜 기준)
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
		return todayRepliedQ;
	}

}
