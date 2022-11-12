package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.host.dao.HostMonthlyDao;

public class HostMonthlyReservation_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int hSeq = (int) session.getAttribute("HSEQ");

		HostMonthlyDao dao = new HostMonthlyDao();
		int[] mr = new int[12];
		mr = dao.monthlyReservation(hSeq);
		request.setAttribute("mr", mr);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
