package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.host.dao.HostReservationStatusDao;

public class HostMainReservationStatus_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int hSeq = (int) session.getAttribute("hSeq");

		HostReservationStatusDao dao = new HostReservationStatusDao();
		int nr = dao.mainReservationCount(hSeq);
		int todayIn = dao.mainCheckinCount(hSeq);
		int todayOut = dao.mainCheckoutCount(hSeq);
		request.setAttribute("nr", nr);
		request.setAttribute("todayIn", todayIn);
		request.setAttribute("todayOut", todayOut);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
