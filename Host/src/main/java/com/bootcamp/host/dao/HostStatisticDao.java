package com.bootcamp.host.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bootcamp.joindto.DetailStatDto;

public class HostStatisticDao {
	DataSource dataSource;

	public HostStatisticDao() {
		try {
			Context context = new InitialContext(); // javax.naming
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<DetailStatDto> allStatDataView(int hSeq){	// 캠핑장의 모든 매출/예약 데이터 (regDate부터 현재까지)
		ArrayList<DetailStatDto> dtos = new ArrayList<DetailStatDto>();
		PreparedStatement ps = null;
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			String query = "select date_format(bo.boDate, '%Y-%m-%d'), sum(bo.boPrice), count(distinct(bo.boGroup)) from book bo ";
			String query2 = "inner join regcamp reg on bo.pay_room_regcamp_regSeq = reg.regSeq ";
			String query3 = "where reg.host_hSeq = ? and reg.regDdate is null group by bo.boDate";
			ps = connection.prepareStatement(query + query2 + query3);
			ps.setInt(1, hSeq);

			rs = ps.executeQuery();

			while (rs.next()) {
				Date boDate = rs.getDate(1);
				int boPrice = rs.getInt(2);
				int boGroup = rs.getInt(3);

				DetailStatDto dto = new DetailStatDto(boDate, boPrice, boGroup);
				dtos.add(dto);
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
		return dtos;
		
	}
}
