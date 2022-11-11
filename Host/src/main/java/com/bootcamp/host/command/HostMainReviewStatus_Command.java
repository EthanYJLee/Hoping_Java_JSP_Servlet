package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.host.dao.HostReviewStatusDao;

public class HostMainReviewStatus_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		int hSeq = (int) session.getAttribute("hSeq");

		HostReviewStatusDao dao = new HostReviewStatusDao();
		int todayR = dao.mainReviewCount(hSeq);
		int todayRepliedR = dao.mainReviewRepliedCount(hSeq);
		int todayNotRepliedR = todayR - todayRepliedR;

		request.setAttribute("tr", todayR);
		request.setAttribute("trr", todayRepliedR);
		request.setAttribute("tnrr", todayNotRepliedR);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
