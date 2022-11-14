package com.bootcamp.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.client.dao.BCBookDao;
import com.bootcamp.client.dao.CampDao;
import com.bootcamp.joindto.checkdate2Dto;

public class BCBookingConfirmationCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();		
		System.out.println("BCBookingConfirmationCommand___________________________________");
		String regName = request.getParameter("regName");
		String roNum = request.getParameter("roNum");
		session.setAttribute("RONUM",roNum);
		String roPrice = request.getParameter("roPrice");
		session.setAttribute("ROPRICE",roPrice);
		System.out.println("BCBookingConfirmationCommand 에서 regName : "+regName);
		System.out.println("BCBookingConfirmationCommand 에서 roNum : "+roNum);
		BCBookDao dao = new BCBookDao();
		checkdate2Dto dto = dao.confirmation(roNum, regName);
		request.setAttribute("bookingInfo", dto);
		request.setAttribute("startdate",session.getAttribute("SATARTDATE"));
		request.setAttribute("stopdate",session.getAttribute("STOPDATE"));
		
//		22-11-11 호식 
//		세션값으로 start,end date가져와서 일수 구한다음에 요금에 곱하려고 
//		했던건데 여기에 안할거 같음 booking.jsp에 일수x요금 나오면 지워도 됨
//		
//		HttpSession session = request.getSession();
//		String startdate = (String)session.getAttribute("startdate");		
//		String stopdate = (String)session.getAttribute("stopdate");	
//		
//		CampDao Cdao = new CampDao();
//		int days = Cdao.diffDate(startdate, stopdate);
//		
//		request.setAttribute("days", days);
//		
	}
	
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

}//class end 