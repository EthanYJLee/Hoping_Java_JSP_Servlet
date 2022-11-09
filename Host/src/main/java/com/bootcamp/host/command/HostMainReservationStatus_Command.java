package com.bootcamp.host.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.HostReservationStatusDao;

public class HostMainReservationStatus_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
//		int hSeq = Integer.parseInt(request.getParameter("hSeq"));
		int hSeq = 1;
		HostReservationStatusDao dao = new HostReservationStatusDao();
		int nr = dao.mainReservationCount(hSeq);
		int todayIn = dao.mainCheckinCount(hSeq);
		int todayOut = dao.mainCheckoutCount(hSeq);
		request.setAttribute("nr", nr);
		request.setAttribute("todayIn", todayIn);
		request.setAttribute("todayOut", todayOut);

	}

}
