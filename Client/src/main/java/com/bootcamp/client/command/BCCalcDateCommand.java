package com.bootcamp.client.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BCCalcDateCommand implements BCCommand {

	@Override

//	public void execute2(HttpServletRequest request, HttpServletResponse response) throws ParseException {
//		// TODO Auto-generated method stub
//		System.out.println("BCCalcDateCommand execute2 실행 ");
//
//		HttpSession session = request.getSession();
//		System.out.println("BCCalcDateCommand session 바로 아래 실행 됨 ");
//		
//		String s1= (String)session.getAttribute("startdate");
//		String s2= (String)session.getAttribute("stopdate");
//		String Sstr1 = s1.substring(0,4);
//		String Sstr2 = s1.substring(5,7);
//		String Sstr3 = s1.substring(8,10);
//		
//		String Estr1 = s2.substring(0,4);
//		String Estr2 = s2.substring(5,7);
//		String Estr3 = s2.substring(8,10);
//		
//		String startDate = Sstr1+Sstr2+Sstr3;
//		String stopDate = Estr1+Estr2+Estr3;
//		
//		System.out.println("String s1 이랑 s2 를 더해서 출력 "+s1 + s2);
//
//		BCBookCalcDateDao dao = new BCBookCalcDateDao();
//		int countDate = dao.CalcDate(startDate,stopDate); //  짤라가지고 yyyyMMDD 형식
//	//	int countDate = dao.CalcDate(s1,s2);	// yyyy-MM-DD 형식 
//
//		request.setAttribute("countDate", countDate);
//	}
	
	
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		return null;
		
	}
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	}

}//class end 
