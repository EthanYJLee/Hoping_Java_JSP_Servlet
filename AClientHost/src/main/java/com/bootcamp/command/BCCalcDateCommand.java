package com.bootcamp.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.client.dao.CampDao;


public class BCCalcDateCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	/* 22-11-11 호식
	  		startdate, enddate 가져와서 일수 구할거임. 그런다음에 합쳐서 총 요금계산할꺼임
	*/
		HttpSession session = request.getSession();
			System.out.println("BCCalcDateCommand___________________________________");
		String startdate = (String)session.getAttribute("STARTDATE");
		String stopdate = (String)session.getAttribute("STOPDATE");
	
		CampDao dao = new CampDao();
		int result = dao.diffDate(startdate, stopdate);
		
		
		
		request.setAttribute("Days", result);
	
	}
	
	
	
	
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		return null;
		
	}
	

}//class end 
