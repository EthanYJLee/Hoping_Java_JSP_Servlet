package com.bootcamp.host.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class HostMonthlyDao {
	DataSource dataSource;

	public HostMonthlyDao() {
		try {
			Context context = new InitialContext(); // javax.naming
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int[] monthlyProfit(int hSeq) {
		int[] arr = new int[12];
		PreparedStatement ps = null;
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			String query = "select month(boDate) as m, sum(boPrice) as mp from book ";
			String query2 = "where year(boDate) = year(now()) and pay_room_regcamp_host_hSeq = ? group by m";
			ps = connection.prepareStatement(query + query2);
			ps.setInt(1, hSeq);

			rs = ps.executeQuery();

			while (rs.next()) {
				int m = rs.getInt("m");
				int mp = rs.getInt("mp");
				arr[m - 1] = mp;
			}
			for (int i = 0; i < 12; i++) {
				if (arr[i] == 0) {
					arr[i] = 0;
				}
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
		return arr;
	}

	public int[] monthlyReservation(int hSeq) {
		int[] arr = new int[12];
		PreparedStatement ps = null;
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			String query = "select month(boDate) as m, count(distinct boGroup) as mr from book ";
			String query2 = "where year(boDate) = year(now()) and pay_room_regcamp_host_hSeq = ? group by m";
			ps = connection.prepareStatement(query + query2);
			ps.setInt(1, hSeq);

			rs = ps.executeQuery();

			while (rs.next()) {
				int m2 = rs.getInt("m");
				int mr = rs.getInt("mr");
				arr[m2 - 1] = mr;
			}
			for (int i = 0; i < 12; i++) {
				if (arr[i] == 0) {
					arr[i] = 0;
				}
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
		return arr;
	}

}
