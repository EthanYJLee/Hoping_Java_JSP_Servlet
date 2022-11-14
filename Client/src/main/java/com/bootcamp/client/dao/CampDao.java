package com.bootcamp.client.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bootcamp.joindto.campDto;
import com.bootcamp.dto.roomDto;
import com.bootcamp.joindto.BookJoinDto;


public class CampDao {
	
	DataSource dataSource;

	public CampDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
		}catch(Exception e){
			e.printStackTrace();
		}
	}	

	
	
	/* 22-11-14 호식 
				room table에 roNum이 없음. roNum 주석처리 
				쿼리문 수정 
				select * from regcamp where regSeq = "+strregSeq;;
			->> select * from camp where regSeq = "+strregSeq;;	
	*/
	public ArrayList<campDto> listCamp(String strregSeq){
		ArrayList<campDto> dtos = new ArrayList<campDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		campDto dto;
		
		try {
			connection = dataSource.getConnection();
			System.out.println("Query start");
			String query = "select distinct * from rch where regSeq = "+strregSeq;;
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println("Query Execute");
			
			while(resultSet.next()) {
				int regSeq = resultSet.getInt("regSeq");
				String regName = resultSet.getString("regName");
				String regCategory = resultSet.getString("regCategory");

				int roNum = resultSet.getInt("roNum");  //-호식 주석처리 
				int roPrice = resultSet.getInt("roPrice");
				int roMax = resultSet.getInt("roMax");

				System.out.println("regSeq:"+strregSeq+":");

				dto = new campDto(regSeq, regName, regCategory,roNum, roPrice, roMax); // 
				dtos.add(dto);
				System.out.println("DTO Add");
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
	} // listCamp	

	
	public ArrayList<campDto> dateCheck(String strregSeq, String startdate, String stopdate){
		ArrayList<campDto> dtos = new ArrayList<campDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		System.out.println("dateCheck---------------------------------------------------------");
		System.out.println("strregSeq:"+strregSeq+":");
		System.out.println("startdate:"+startdate+":");
		System.out.println("stopdate:"+stopdate+":");
		campDto dto;
		
		try {
			connection = dataSource.getConnection();
			System.out.println("Query start");
			
			// 특정일 사이에 방이 예약가능한지 알아보는 SQL 문 (특정일 사이의 방번호를 제외하고 방번호 중에서 그 값을 제외하고 출력) - 상혁
			// 캠핑장에 따라 인자 값 추가 필요 - 상혁
			String query = "select distinct * from rch where regSeq='"+strregSeq+"' and roNum not in ( select distinct roNum from BPRCH where boCheckindate between '"+startdate+"' and '"+stopdate+"')";; 
			System.out.println("dateCheck startdate:"+startdate+"stopdate:"+stopdate);
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println("Query Execute");
			
			while(resultSet.next()) {
				int regSeq = resultSet.getInt("regSeq");
				String regName = resultSet.getString("regName");
				String regCategory = resultSet.getString("regCategory");
				
				int roNum = resultSet.getInt("roNum");
				int roPrice = resultSet.getInt("roPrice");
				int roMax = resultSet.getInt("roMax");
				

				System.out.println("startdate:"+startdate+":");
				System.out.println("stoptdate:"+stopdate+":");
				
				dto = new campDto(regSeq, regName, regCategory, roNum, roPrice, roMax);
				dtos.add(dto);
				System.out.println("DTO Add");

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
	} // DateCheck	
	public int readMaxSeq() {
		// Debug를 위한 주석 추가.room Seqence Number를 읽어옴.
		System.out.println("readMaxSeq_______________________________________________");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int result = 0;
		try {
			connection = dataSource.getConnection();
			
			// Max Seq 읽는 SQL문 - alias로 읽히도록 수정함. - 상혁
			String query = "select max(boSeq) as result from book ";
			preparedStatement = connection.prepareStatement(query);
			System.out.println("Query:"+query);
			
			resultSet = preparedStatement.executeQuery();
			System.out.println("Query readMaxSeq Execute");
			
			if(resultSet.next()) {
				result = resultSet.getInt("result");
			}
			
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
		return result;
	} //readMaxSeq
	
	/* 2022-11-11 hosik - 주석추가	
						  첫날짜와 끝 날짜로 일수를 계산해줌 
	*/
	public int diffDate(String Startdate, String Stopdate) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int result = 0;
		try {
			connection = dataSource.getConnection();
			
			String query = "select TimeStampdiff(day,'"+Startdate+"','"+Stopdate+"') as result";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println(query);
			System.out.println("Query diffDate Execute");
			
			if(resultSet.next()) {
				result = resultSet.getInt("result");
			}
			
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
		return result+1;
	} //diffDate

	
	// 예약을 위해 다음날 구하는 메소드 상혁
	public String Nextday(String Startdate) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String result = null;
		try {
			connection = dataSource.getConnection();
			
			String query = "select adddate('"+Startdate+"',1) as result;";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println(query);
			System.out.println("Query diffDate Execute");
			
			if(resultSet.next()) {
				result = resultSet.getString("result");
			}
			
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
		return result;
	} //diffDate
	
	// 예약에 앞서 Pay를 추가하는 메소드 상혁
	public int insertPay(String strRd,int room_roSeq, int room_regcamp_regSeq, int room_regcamp_host_hseq, String client_cId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = dataSource.getConnection();
			String query = "insert into pay (cid, room_roSeq, room_regcamp_regSeq, room_regcamp_host_hseq, client_cId) ";
			String query2 = " values ";
			String query3 = "('"+strRd+(room_roSeq+client_cId+room_regcamp_regSeq+room_regcamp_host_hseq)+"', "+room_roSeq+","+room_regcamp_regSeq+","+room_regcamp_host_hseq+",'"+client_cId+"') ";
			System.out.println("room_roSeq"+room_roSeq);
			System.out.println("room_regcamp_regSeq"+room_regcamp_regSeq);
			System.out.println("room_regcamp_host_hseq"+room_regcamp_host_hseq);
			System.out.println("client_cId"+client_cId);
			preparedStatement = connection.prepareStatement(query+query2+query3);

			System.out.println(query+query2+query3);
			result = preparedStatement.executeUpdate(query+query2+query3);
			System.out.println("insertPay executeUpdate---------------------------"+result);	
			
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
		return result;
	} //insertPay

	// 예약에 앞서 Pay를 추가하는 메소드 상혁
	public int pay(int room_roSeq, int room_regcamp_regSeq, int room_regcamp_host_hseq, String client_cId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = dataSource.getConnection();
			String query = "select cid, room_roSeq, room_regcamp_regSeq, room_regcamp_host_hseq, client_cId from pay where client_cId = '"+client_cId +"' and cid = ";
			System.out.println("room_roSeq"+room_roSeq);
			System.out.println("room_regcamp_regSeq"+room_regcamp_regSeq);
			System.out.println("room_regcamp_host_hseq"+room_regcamp_host_hseq);
			System.out.println("client_cId"+client_cId);
			result = preparedStatement.executeUpdate(query);
			System.out.println("insertpay executeUpdate---------------------------"+result);	
			
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
		return result;
	} //insertpay	
	
	
	
	// 하루를 예약하는 메소드 상혁
	public int insertBook(int boPrice, String boCheckindate, int boGroup, int boCount, String cId, int roseq, String client_cId, int regSeq, int host_hSeq) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = dataSource.getConnection();
			String query = "insert into book (boPrice, boDate, boCheckindate, boGroup, boCount, ";
			String query2 = "pay_cid, pay_room_roseq, pay_room_regcamp_regSeq, pay_room_regcamp_host_hSeq, pay_client_cid ) values ";
			String query3 = "("+boPrice+",now(),'"+boCheckindate+"',"+boGroup+","+boCount+",'"+cId+"', "+roseq+","+regSeq+","+host_hSeq+",'"+client_cId+"') ";
			System.out.println("boPrice"+boPrice);
			System.out.println("boCheckindate"+boCheckindate);
			System.out.println("boGroup"+boGroup);
			System.out.println("boCount"+boCount);
			System.out.println("cId"+cId);
			System.out.println("regSeq"+regSeq);
			System.out.println("host_hSeq"+host_hSeq);
			preparedStatement = connection.prepareStatement(query+query2+query3);

			System.out.println(query);
			System.out.println(query2);
			System.out.println(query3);
			result = preparedStatement.executeUpdate(query+query2+query3);
			System.out.println("insertBook executeUpdate---------------------------"+result);	
			
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
		return result;
	} //insertbook

	// 예약 그룹 생성을 위해서 첫번째날 예약에 예약 그룹 번호에 첫번째 예약날의 예약번호로 변경하는 메소드 
	public void updateBook(int boGroup) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// SQL 문 사용시 PreparedStatement setString
		try {
			connection = dataSource.getConnection();
			String query = "update book set boGroup = "+boGroup+" where boSeq="+boGroup;
			preparedStatement = connection.prepareStatement(query);
			System.out.println(boGroup);
			System.out.println(query);
			preparedStatement.executeUpdate(query);
			System.out.println("update Book executeUpdate---------------------------");				
			
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
	} //updateBook
	
	// RoomPrice가 읽혀오지 않는 문제가 있어서 SQL문에서 읽어오도록 수정함. 상혁	
	public int readRoomPrice(String regcamp_regSeq, String roNum) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int result = 0;
		System.out.println("readRoomPrice__________________________________________________________");
		try {
			connection = dataSource.getConnection();
			String query = "select roPrice from room where regcamp_regSeq = "+regcamp_regSeq+" and roNum = "+roNum+";";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery(query);
			System.out.println(query);
			System.out.println("Query readRoomPrice Execute");
			
			if(resultSet.next()) {
				result = resultSet.getInt("roPrice");
			}
			System.out.println("readRoomPrice executeUpdate------------result:"+result+":");				
			
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
		return result;
	} //readRoomPrice
	// ReadRoom가 Pay를 입력하기 위해 읽어옴. 상혁	
	public roomDto readRoom(String strregcamp_regSeq, String strroNum) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		roomDto dto = null;
		System.out.println("readRoom__________________________________________________________");
		try {
			connection = dataSource.getConnection();
			String query = "select * from room where regcamp_regSeq = "+strregcamp_regSeq+" and roNum = "+strroNum+";";
			System.out.println("readRoom____regcamp_regSeq"+strregcamp_regSeq);
			System.out.println("readRoom____roNum"+strroNum);
			preparedStatement = connection.prepareStatement(query);

			resultSet = preparedStatement.executeQuery(query);
			System.out.println(query);
			System.out.println("Query readRoom Execute");
			
			if(resultSet.next()) {
				int roSeq = resultSet.getInt("roSeq");
				System.out.println("roSeq"+roSeq);
				int roNum = resultSet.getInt("roNum");
				System.out.println("roNum"+roNum);
				int roPrice = resultSet.getInt("roPrice");
				System.out.println("roPrice"+roPrice);
				int roMax = resultSet.getInt("roMax");
				System.out.println("roMax"+roMax);
				int roOccupied = resultSet.getInt("roOccupied");
				System.out.println("roOccupied"+roOccupied);
				int regcamp_regSeq = resultSet.getInt("regcamp_regSeq");
				System.out.println("regcamp_regSeq"+regcamp_regSeq);
				int regcamp_host_hSeq = resultSet.getInt("regcamp_host_hSeq");
				System.out.println("regcamp_host_hSeq"+regcamp_host_hSeq);
					
				dto = new roomDto(roSeq, roNum, roPrice, roMax, roOccupied, regcamp_regSeq, regcamp_host_hSeq);
			}
			System.out.println("readRoom executeUpdate---------------------------------");				
			
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
		return dto;
	} //readRoomPrice	
	public ArrayList<BookJoinDto> ViewBooking(String cId){
		ArrayList<BookJoinDto> dtos = new ArrayList<BookJoinDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		BookJoinDto dto;
		
		try {
			connection = dataSource.getConnection();
			System.out.println("Query start");

			//String query = "select distinct regSeq, regName, regCategory, roNum, roPrice, boCheckindate, boGroup, client_cId, regImage2 from BPRCH where boCheckindate > now() and client_cId = '"+cId+"'";
			//select distinct regSeq, regName, regCategory, roNum, roPrice, boCheckindate,boCheckindate+max(boSeq)-boGroup-1 as boCheckoutdate, boGroup, max(boSeq)-boGroup, client_cId, regImage2 from BPRCH where boCheckindate > now() and client_cId = 'pisal' group by boGroup
			
			// Checkout 계산해서 boCheckoutdate 컬럼을 추가함. 상혁
			String query = "select distinct regSeq, regName, regCategory, roNum, roPrice, boCheckindate,adddate(boCheckindate,max(boSeq)-boGroup-1) as boCheckoutdate, boGroup, (max(boSeq)-boGroup+1) as days, client_cId, regImage2 from BPRCH where boCheckindate > now() and client_cId = '"+cId+"' group by boGroup";
			
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println("Query Execute");
			
			while(resultSet.next()) {

				String regSeq = resultSet.getString("regSeq");
				String regName = resultSet.getString("regName");
				String regCategory= resultSet.getString("regCategory");
				int roNum = resultSet.getInt("roNum");
				int roPrice = resultSet.getInt("roPrice");	
				Timestamp boCheckindate = resultSet.getTimestamp("boCheckindate");
				System.out.println("boCheckindate"+boCheckindate);
				int boGroup = resultSet.getInt("boGroup");
				Timestamp boCheckoutdate = resultSet.getTimestamp("boCheckoutdate");
				System.out.println("boCheckoutdate"+boCheckoutdate);
				String client_cId = resultSet.getString("client_cId");
				String regImage2 = resultSet.getString("regImage2");
				int days = resultSet.getInt("days");
				
				System.out.println("cId:"+cId+":");

				dto = new BookJoinDto(regSeq, regName, regCategory, roNum, roPrice, boCheckindate, boCheckoutdate, boGroup, client_cId, regImage2,days);
				dtos.add(dto);
				System.out.println("DTO bookingView Add");
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
	} // ViewBooking	
}
