package com.bootcamp.host.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bootcamp.joindto.HostReplyReviewDto;

public class HostReviewListDao {
	DataSource dataSource;

	public HostReviewListDao() {
		try {
			Context context = new InitialContext(); // javax.naming
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<HostReplyReviewDto> reviewList(int hSeq) { // 내 소유 캠핑장의 리뷰 가져옴
		ArrayList<HostReplyReviewDto> dtos = new ArrayList<HostReplyReviewDto>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = dataSource.getConnection();
			String query = "select rv.rvSeq, reg.regName, rv.rvCId, rv.rvCName, rv.rvTitle, rv.rvTime ";
			String query2 = "from review rv inner join regcamp reg ";
			String query3 = "on rv.regcamp_regSeq = reg.regSeq where rv.rvDtime is null and reg.host_hSeq = ?";
			ps = connection.prepareStatement(query + query2 + query3);

			ps.setInt(1, hSeq);

			rs = ps.executeQuery();

			while (rs.next()) {
				int rvSeq = rs.getInt("rvSeq");
				String regName = rs.getString("regName");
				String rvCId = rs.getString("rvCId");
				String rvCName = rs.getString("rvCName");
				String rvTitle = rs.getString("rvTitle");
				Timestamp rvTime = rs.getTimestamp("rvTime");
				HostReplyReviewDto dto = new HostReplyReviewDto(rvSeq, regName, rvCId, rvCName, rvTitle, rvTime);
				dtos.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
	}

	public HostReplyReviewDto reviewContentView(int rvSeq) {
		HostReplyReviewDto dto = new HostReplyReviewDto();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = dataSource.getConnection();
			String query = "select reg.regName, rv.rvCName, rv.rvCId, rv.rvTitle, rv.rvTime, rv.rvContent ";
			String query2 = "from regcamp reg inner join review rv on reg.regSeq = rv.regcamp_regSeq ";
			String query3 = "where rv.rvSeq = ?";
			ps = connection.prepareStatement(query + query2 + query3);

			ps.setInt(1, rvSeq);

			rs = ps.executeQuery();

			while (rs.next()) {
				String regName = rs.getString("regName");
				String rvCName = rs.getString("rvCName");
				String rvCId = rs.getString("rvCId");
				String rvTitle = rs.getString("rvTitle");
				Timestamp rvTime = rs.getTimestamp("rvTime");
				String rvContent = rs.getString("rvContent");
				dto = new HostReplyReviewDto(regName, rvCName, rvCId, rvTitle, rvTime, rvContent);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

}
