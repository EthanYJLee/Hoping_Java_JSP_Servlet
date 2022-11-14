package com.bootcamp.client.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import com.bootcamp.dto.reviewDto;


public class ReviewDao {
	DataSource dataSource;

	public ReviewDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<reviewDto> reviewList(int regSeq) {
		ArrayList<reviewDto> dtos = new ArrayList<reviewDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
System.out.println("/reviewDao 에 reviewList reSeq = "+regSeq);
		ResultSet resultSet = null;

		reviewDto dto;

		try {
			connection = dataSource.getConnection();

			String query = "select * from review, regcamp where regcamp_regSeq = regseq and regSeq=? ";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, regSeq);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println("ReviewDao - reviewList - in while sysoCheck");
				int rvSeq = resultSet.getInt("rvSeq");
				String rvCId = resultSet.getString("rvCId");
				String rvCName = resultSet.getString("rvCName");
				String rvTitle = resultSet.getString("rvTitle");
				String rvContent = resultSet.getString("rvContent");
				int rvStar = resultSet.getInt("rvStar");
				Timestamp rvTime = resultSet.getTimestamp("rvTime");
				
				
				
				dto = new reviewDto(rvSeq, rvCId, rvCName, rvTitle, rvContent, rvStar, rvTime);
				dtos.add(dto);
				System.out.println("다오 캠핑장" + regSeq);
				System.out.println(rvCId);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
	} // searchSiteView
	
	
	//리뷰상세
	public reviewDto reviewView(int sbId){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		reviewDto dto = null; 
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from review, regcamp where regcamp_regSeq = regseq and regSeq=? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, sbId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int rvSeq = resultSet.getInt("rvSeq");
				String rvCId = resultSet.getString("rvCId");
				String rvCName = resultSet.getString("rvCName");
				String rvTitle = resultSet.getString("rvTitle");
				String rvContent = resultSet.getString("rvContent");
				int rvStar = resultSet.getInt("rvStar");
				Timestamp rvTime = resultSet.getTimestamp("rvTime");
				Timestamp rvMtime = resultSet.getTimestamp("rvMtime");
				Timestamp rvDtime = resultSet.getTimestamp("rvDtime");
				int regcamp_regSeq = resultSet.getInt("regcamp_regSeq");
				int regcamp_host_hSeq = resultSet.getInt("regcamp_host_hSeq");
				
				dto = new reviewDto(rvSeq, rvCId, rvCName, rvTitle, rvContent, rvStar, rvTime, rvMtime, rvDtime, regcamp_regSeq, regcamp_host_hSeq);
			}
			
		}catch (Exception e) {
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
		return dto;
	} // Content
	
	
	
	//리뷰 별점 캠핑장별 평균
	public reviewDto avgReview(int sbId){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		reviewDto dto = null; 
		try {
			connection = dataSource.getConnection();
			
			String query = "select avg(rvStar) as rvStaravg from review, regcamp where regcamp_regSeq = regseq and regcamp_regSeq=? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, sbId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int rvStar = resultSet.getInt("rvStaravg");
			
				
				dto = new reviewDto(rvStar);
			}
			
		}catch (Exception e) {
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
		return dto;
	} // Content
	
	//리뷰 작성
	public void write(String rvCId, String rvCName, String rvTitle, String rvContent, int rvStar, int regcamp_regSeq, int regcamp_host_hSeq) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into review (rvCId, rvCName, rvTitle, rvContent, rvStar, rvTime, regcamp_regSeq, regcamp_host_hSeq) ";
			String query2 = "values (?,?,?,?,?,now(),?,?) ";
			
			preparedStatement = connection.prepareStatement(query+query2);
			
			
			preparedStatement.setString(1, rvCId);
			preparedStatement.setString(2, rvCName);
			preparedStatement.setString(3, rvTitle);
			preparedStatement.setString(4, rvContent);
			preparedStatement.setInt(5, rvStar);
			preparedStatement.setInt(6, regcamp_regSeq);
			preparedStatement.setInt(7, regcamp_host_hSeq);
			preparedStatement.executeUpdate();
			
			
		}catch (Exception e) {
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
	
	//작성자 이름
	//리뷰 별점 캠핑장별 평균
		public reviewDto reviewerName(String sbId){
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			reviewDto dto = null; 
			try {
				connection = dataSource.getConnection();
				
				String query = "select cName as rvCName from client where cId=? ";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, sbId);
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					String rvCName = resultSet.getString("rvCName");
				
					
					dto = new reviewDto(rvCName);
				}
				
			}catch (Exception e) {
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
			return dto;
		} // Content
}
