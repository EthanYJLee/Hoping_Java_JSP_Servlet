package com.bootcamp.host.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bootcamp.dto.HostRegcampDto;

public class HostCampListDao { // 호스트 각각이 보유한 캠핑장 리스트
	DataSource dataSource;

	public HostCampListDao() {
		try {
			Context context = new InitialContext(); // javax.naming
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> myCampNameList(int hSeq) { // 내 소유 캠핑장 이름 (콤보박스용)
		ArrayList<String> arr = new ArrayList<String>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = dataSource.getConnection();
			String query = "select regName from regcamp where host_hSeq = ? and regDdate is null";
			ps = connection.prepareStatement(query);

			ps.setInt(1, hSeq);

			rs = ps.executeQuery();

			while (rs.next()) {
				String regName = rs.getString("regName");
				arr.add(regName);
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
		return arr;
	}

	public ArrayList<HostRegcampDto> myCampProfileList(int hSeq) {
		ArrayList<HostRegcampDto> dtos = new ArrayList<HostRegcampDto>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = dataSource.getConnection();
			String query = "select regSeq, regImage1, regName, regDetailaddress from regcamp ";
			String query2 = "where host_hSeq = ? and regDdate is null";
			ps = connection.prepareStatement(query + query2);

			ps.setInt(1, hSeq);

			rs = ps.executeQuery();

			while (rs.next()) {
				int regSeq = rs.getInt("regSeq");
				String regImage1 = rs.getString("regImage1");
				String regName = rs.getString("regName");
				String regDetailaddress = rs.getString("regDetailaddress");
				HostRegcampDto dto = new HostRegcampDto(regSeq, regImage1, regName, regDetailaddress);
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

}
