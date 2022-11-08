package com.bootcamp.host.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bootcamp.joindto.HostReplyReviewDto;

public class HostSendReviewReplyDao {
	DataSource dataSource;

	public HostSendReviewReplyDao() {
		try {
			Context context = new InitialContext(); // javax.naming
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HostReplyReviewDto selectReview(int rvSeq) {
		// 선택한 리뷰의 [작성자id, 내 캠핑장 번호, 내 host Seq] 가져옴
		// 후기에 답변 남기기 위한 필요정보들임 (HostSendReviewReplyDao => replyReview)
		HostReplyReviewDto dto = new HostReplyReviewDto();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = dataSource.getConnection();
			String query = "select rvCId, regcamp_regSeq, regcamp_host_hSeq ";
			String query2 = "from review where rvSeq = ?";
			ps = connection.prepareStatement(query + query2);

			ps.setInt(1, rvSeq);

			rs = ps.executeQuery();

			while (rs.next()) {
				String rvCId = rs.getString("rvCId");
				int regSeq = rs.getInt("regcamp_regSeq");
				int hSeq = rs.getInt("regcamp_host_hSeq");
				dto = new HostReplyReviewDto(rvCId, regSeq, hSeq);
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

	public void replyReview(String replyContent, int rvSeq, String rvCId, int regSeq, int hSeq) {
		// rcomment 테이블에 해당 리뷰의 답장 작성
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = dataSource.getConnection();
			String query = "insert into rcomment (rcContent, rcTime, client_cId, review_rvSeq, "
					+ "review_regcamp_regSeq, review_regcamp_host_hSeq) ";
			String query2 = "values (?,now(),?,?,?,?)";
			ps = connection.prepareStatement(query + query2);

			ps.setString(1, replyContent);
			ps.setString(2, rvCId);
			ps.setInt(3, rvSeq);
			ps.setInt(4, regSeq);
			ps.setInt(5, hSeq);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (connection != null)
					connection.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void setReviewCommentGroup() {
		// 리뷰 답장 작성 직후 바로 답변 group 지정 (그룹은 해당 답변의 pk와 동일)
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = dataSource.getConnection();
			String query = "update rcomment set rcGroup = rcSeq where rcGroup is null";
			ps = connection.prepareStatement(query);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (connection != null)
					connection.close();

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

}
