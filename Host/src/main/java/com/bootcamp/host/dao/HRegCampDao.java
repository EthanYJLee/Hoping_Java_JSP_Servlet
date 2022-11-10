package com.bootcamp.host.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bootcamp.dto.regroomDto;


public class HRegCampDao {
		
	DataSource dataSource;
	
	public HRegCampDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
		//상품입력
	public void regcamp( String regTel, String regCategory, String regDetailaddress, String regName, String regSummary,
			int host_hSeq) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into regcamp (regTel, regCategory, regDetailaddress, regName, regSummary, regDate, host_hSeq) values (?,?,?,?,?,now(),?) ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, regTel);
			preparedStatement.setString(2, regCategory);
			preparedStatement.setString(3, regDetailaddress);
			preparedStatement.setString(4, regName);
			preparedStatement.setString(5, regSummary);
			preparedStatement.setInt(6, host_hSeq);
			
		
			preparedStatement.executeUpdate();
			System.out.println(query);
						
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	} //write
	
	public ArrayList<regroomDto> camproomlist(){
		ArrayList<regroomDto> dtos = new ArrayList<regroomDto>();
		Connection connection = null; //데이터 접근을 위한 객체
		PreparedStatement preparedStatement = null; //쿼리문 실행을 위한 객체
		ResultSet resultSet = null; //데이터를 가져와 결과값을 얻기 위한 객체
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select roNum, roPrice, roMax, regcamp_regSeq from room";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int roNum = resultSet.getInt("roNum");
				int roPrice = resultSet.getInt("roPrice");
				int roMax = resultSet.getInt("roMax");
				int regcamp_regSeq = resultSet.getInt("regcamp_regSeq");
				
				System.out.println(query);
				System.out.println(roPrice);
				System.out.println(roMax);
				
				
				regroomDto dto = new regroomDto(roNum, roPrice, roMax, regcamp_regSeq);
				dtos.add(dto);
			}
			
		}catch(Exception e) {
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
		return dtos;
	}
	
	public void regcamproom( int roNum, int roPrice, int roMax, int regcamp_regSeq, int regcamp_host_hSeq) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into room (roNum, roPrice, roMax, regcamp_regSeq, regcamp_host_hSeq) values (?,?,?,?,?) ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, roNum);
			preparedStatement.setInt(2, roPrice);
			preparedStatement.setInt(3, roMax);
			preparedStatement.setInt(4, regcamp_regSeq);
			preparedStatement.setInt(5, regcamp_host_hSeq);
			
		
			preparedStatement.executeUpdate();
			System.out.println(query);
						
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}


	
	
}
	
	
	
	
	
	
	

