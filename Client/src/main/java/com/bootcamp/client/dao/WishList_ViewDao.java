package com.bootcamp.client.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bootcamp.dto.WishList_ViewDto;

public class WishList_ViewDao {
	
	DataSource dataSource;
	
	public WishList_ViewDao() {
		try {
			
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/camping");
		}catch(Exception e) {
			e.printStackTrace();
			
		}
			
	}
	
	
	public ArrayList<WishList_ViewDto> wishList_view(String cId){
		
		ArrayList<WishList_ViewDto> dtos = new ArrayList<WishList_ViewDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select r.regSeq, r.regImage1, r.regDetailaddress, r.regName, r.regTel from wish w, regcamp r ";
			String query2 = "where w.client_cId = '"+ cId+"' and w.regcamp_regSeq = r.regSeq ";
			preparedStatement = connection.prepareStatement(query+query2);
			resultSet = preparedStatement.executeQuery();
			
			
			while(resultSet.next()) {
				int regSeq = resultSet.getInt("regSeq");
				String regImage1 = resultSet.getString("regImage1");
				String regDetailaddress = resultSet.getString("regDetailaddress");
				String regName = resultSet.getString("regName");
				String regTel = resultSet.getString("regTel");
				
				WishList_ViewDto dto = new WishList_ViewDto(regSeq, regImage1, regDetailaddress, regName, regTel);
				dtos.add(dto);
				
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null)connection.close();
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		
		return dtos;

	}//list
	
	

}
