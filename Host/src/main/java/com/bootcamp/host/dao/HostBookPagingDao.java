package com.bootcamp.host.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bootcamp.joindto.BookListDto;

public class HostBookPagingDao {
	
	DataSource dataSource;
	
	public HostBookPagingDao() {
		
		try {
			
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}//constructor
	
	//예약 row 총 개수
	public int countRow(int hSeq, String strSearch, String startDate, String endDate){
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int rowcount = 0;
		
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "select count(*) as rowcount from (select boGroup, regName, pay_client_cId, total, boDate, ";
			String query2 = "roNum, min(checkin) as mcheckin, max(checkout) as mcheckout, boCount  ";
			String query3 = "from booklist where pay_room_regcamp_host_hSeq = ? and regName like '%" +strSearch+ "%' ";
			String query4 = "and boDate between ? and ? ";
			String query5 = "group by boGroup, regName, pay_client_cId, total, boDate, roNum, boCount) as a ";
			
			preparedStatement = connection.prepareStatement(query + query2 + query3 + query4 + query5);
			preparedStatement.setInt(1, hSeq);
			preparedStatement.setString(2, startDate);
			preparedStatement.setString(3, endDate);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				
				rowcount = resultSet.getInt("rowcount");
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return rowcount;
	}//list

	
	

}
