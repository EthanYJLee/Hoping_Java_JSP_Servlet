package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.HostMonthlyDao;

public class HostMonthlyReservation_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int hSeq = 1;
		// request.getparameter로 바꿀것

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
