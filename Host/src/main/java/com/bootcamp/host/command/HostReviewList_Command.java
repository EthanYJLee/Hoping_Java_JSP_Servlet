package com.bootcamp.host.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.host.dao.HostReviewListDao;
import com.bootcamp.joindto.HostReplyReviewDto;

public class HostReviewList_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int hSeq = (int) session.getAttribute("HSEQ");

		HostReviewListDao dao = new HostReviewListDao();
		ArrayList<HostReplyReviewDto> dtos = dao.reviewList(hSeq);
		request.setAttribute("review_list", dtos);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
