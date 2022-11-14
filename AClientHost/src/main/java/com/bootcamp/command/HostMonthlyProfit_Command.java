package com.bootcamp.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.host.dao.HostMonthlyDao;

public class HostMonthlyProfit_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int hSeq = (int) session.getAttribute("HSEQ");

		HostMonthlyDao dao = new HostMonthlyDao();
		int[] mp = new int[12];
		mp = dao.monthlyProfit(hSeq);
		request.setAttribute("mp", mp);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
