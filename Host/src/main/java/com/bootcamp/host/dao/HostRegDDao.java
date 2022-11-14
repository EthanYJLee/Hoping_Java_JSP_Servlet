package com.bootcamp.host.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bootcamp.dto.HostRegcampDto;

public class HostRegDDao {
	DataSource dataSource;

	public HostRegDDao() {
		try {
			Context context = new InitialContext(); // javax.naming
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public HostRegcampDto checkRemainingReservation(int regSeq) {	// 삭제하기 전에 남은 예약이 있는지 확인
		HostRegcampDto dto = new HostRegcampDto();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			String query = "select reg.regName, reg.regTel, reg.regDetailaddress, reg.regSummary, "
					+ "reg.regImage1, reg.regImage2, reg.regImage3, reg.regImage4, reg.regDate "
					+ "from regcamp reg inner join book bo on "
					+ "reg.regSeq = bo.pay_room_regcamp_regSeq where (select count(*) from book "
					+ "where boCheckindate>=curdate() and pay_room_regcamp_regSeq=1)=0 and "
					+ "reg.regSeq = ? and reg.regDdate is null group by reg.regSeq";
			
			ps = connection.prepareStatement(query);

			ps.setInt(1, regSeq);

			rs = ps.executeQuery();

			while (rs.next()) {
				String regName = rs.getString(1);
				String regTel = rs.getString(2);
				String regDetailaddress = rs.getString(3);
				String regSummary = rs.getString(4);
				String regImage1 = rs.getString(5);
				String regImage2 = rs.getString(6);
				String regImage3 = rs.getString(7);
				String regImage4 = rs.getString(8);
				Timestamp regDate = rs.getTimestamp(9);
				
				dto = new HostRegcampDto(regName, regTel, regDetailaddress, regSummary, regImage1, regImage2, regImage3, regImage4, regDate);
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
		return dto;
	}
	
	public void deleteRegcamp(int hSeq, int regSeq) {
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = dataSource.getConnection();
			String query = "update regcamp set regDdate = now() where hSeq = ? and regSeq = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, hSeq);
			ps.setInt(2, regSeq);
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
