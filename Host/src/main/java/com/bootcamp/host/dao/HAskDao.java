package com.bootcamp.host.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bootcamp.dto.AskDto;
import com.bootcamp.dto.ClientDto;

public class HAskDao {
	
	DataSource dataSource;
	
	public HAskDao() {
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
		}catch(Exception e){
			e.printStackTrace();
		}
	
		
	}
	
	
	//---------------ask------------------
	
	
	
	// 전체 검색
	public ArrayList<AskDto> askList(){
	ArrayList<AskDto> dtos = new ArrayList<AskDto>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select aSeq, aCId, aTitle, aContent, aTime, aRegSeq from ask ";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int aSeq = resultSet.getInt("aSeq");
				String aCId = resultSet.getString("aCId");
				String aTitle = resultSet.getString("aTitle");
				String aContent = resultSet.getString("aContent");
				String aTime = resultSet.getString("aTime");
				int aRegSeq = resultSet.getInt("aRegSeq");
				
				
				AskDto dto = new AskDto(aSeq, aCId, aTitle, aContent, aTime, aRegSeq);
				dtos.add(dto);
				
			
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
		return dtos;
	} // list
	
	//해당 문의 상세 검색
	public AskDto askDetail(String askSeq){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		AskDto dto = null; 
		try {
			connection = dataSource.getConnection();
			
			String query = "select aSeq, aCId, aTitle, aContent, aTime, aRegSeq from ask where aSeq=? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, askSeq);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int aSeq = resultSet.getInt("aSeq");
				String aCId = resultSet.getString("aCId");
				String aTitle = resultSet.getString("aTitle");
				String aContent = resultSet.getString("aContent");
				String aTime = resultSet.getString("aTime");
				int aRegSeq = resultSet.getInt("aRegSeq");
				
				dto = new AskDto(aSeq, aCId, aTitle, aContent, aTime, aRegSeq);
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
	} 
	
	//문의 답변 write 
	public void aWrite(String acTitle, String acContent, String acTime, int ask_aSeq, int host_hSeq) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into acomment (acTitle, acContent, acTime, ask_aSeq, host_hSeq) values (?,?,now(),?,?) ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, acTitle);
			preparedStatement.setString(2, acContent);
			preparedStatement.setInt(3, ask_aSeq);
			preparedStatement.setInt(4, host_hSeq);
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
	} 	

	
	//문의 답변 완료 여부 확인(미완성 ㅠㅠ) 
	public boolean commentCheck(int aSeq){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean Result=true;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select count(*) from acomment, ask where ask_aSeq=aSeq and aSeq=? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, aSeq); // 위에 커리문에 물음표 갯수 만큼 작성
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				String count = resultSet.getString("count(*)"); //count(*)값을 가져와야 하기때문에
				Result = count.equals("1"); // 답변완료= 1, 답변미완료 = 0
			
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
		return Result;
	} // 
	
}
