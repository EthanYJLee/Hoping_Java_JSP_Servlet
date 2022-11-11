//package com.bootcamp.client.dao;
//
//import java.sql.Date;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Formatter;
//import java.util.Locale;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.sql.DataSource;
//
//
//	public class BCBookCalcDateDao {
//	
//			DataSource dataSource;
//		
//		public BCBookCalcDateDao() {
//			try {
//				Context context = new InitialContext();
//				dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
//				
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//	
//	
//	public int CalcDate(String startDATE , String stopDATE) throws ParseException { 
////		
////		int result = 0;
////		System.out.println("startDATE : "+startDATE+" and stopDATE : "+stopDATE);
////		DateFormat df = new SimpleDateFormat("yyyyMMdd");
////		//Date타입으로 변경
////
////		Date d1 =  (Date) df.parse(startDATE);
////		System.out.println(d1);
////		Date d2 = (Date) df.parse(stopDATE);
////		System.out.println("d1 : "+d1);
////		Calendar c1 = Calendar.getInstance();
////		Calendar c2 = Calendar.getInstance();
////
////		//Calendar 타입으로 변경 add()메소드로 1일씩 추가해 주기위해 변경
////		c1.setTime( d1 );
////		c2.setTime( d2 );
////System.out.println("c1 : "+c1);
////		//시작날짜와 끝 날짜를 비교해, 시작날짜가 작거나 같은 경우 출력
////
////		while( c1.compareTo( c2 ) !=1 ){
////
////		//출력	
////		System.out.printf("%tF\n",c1.getTime());
////		//시작날짜 + 1 일
////		c1.add(Calendar.DATE, 1);
////		result++;
////		System.out.println("CalcDate Dao 안의 result :"+result);
////		}
////		return result;
//	
//		
//		
//		final String DATE_PATTERN = "yyyyMMdd";
//		//final String DATE_PATTERN = "yyyy-MM-dd";
//				System.out.println(DATE_PATTERN);
//		int result = 0;
//		String inputStartDate = startDATE;
//														System.out.println("String inputStartDate : "+inputStartDate);
//		String inputEndDate = stopDATE;
//														System.out.println("String inputEndDate : "+stopDATE);		
//	
//														
//														
//			java.util.Date date = new java.util.Date();
//			java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 												
//														
//		java.util.Date utilStartDate = inputStartDate.getDate();
//		java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
//				
//			try {	
//				
//				SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN, Locale.KOREA);
//					System.out.println("sdf = "+sdf);
//				Date startDate = (Date) sdf.parse(inputStartDate);
//													System.out.println("try 안의 startDate : "+startDate);
//				Date endDate = (Date) sdf.parse(inputEndDate);
//													System.out.println("try 안의 endDate : "+endDate);
//				ArrayList<String> dates = new ArrayList<String>();
//				Date currentDate = startDate;
//				while (currentDate.compareTo(endDate) <= 0) {
//								System.out.println("while 진입 ");
//					dates.add(sdf.format(currentDate));
//					Calendar c = Calendar.getInstance();
//					c.setTime(currentDate);
//					c.add(Calendar.DAY_OF_MONTH, 1);
//					currentDate = (Date) c.getTime();
//				}
//				for (String date : dates) {
//												System.out.println("for 안에 date : "+date);
//					result++;
//				}
//												System.out.println(" try 안 for 밖의 result : "+result);
//				
//			}catch (Exception e) {
//				// TODO: handle exception
//				System.out.println("exception = " + e.getMessage());
//			}
//		
//			return result;
//		
//		
//		
//		
//		
//		
//		
//	} // DetailView  END
//	
//	
//	
//	
//}//BDao End
