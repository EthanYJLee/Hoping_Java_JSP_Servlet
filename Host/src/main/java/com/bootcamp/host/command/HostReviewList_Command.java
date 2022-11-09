package com.bootcamp.host.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.HostReviewListDao;
import com.bootcamp.joindto.HostReplyReviewDto;

public class HostReviewList_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
//		int hSeq = Integer.parseInt(request.getParameter("hSeq"));
		int hSeq = 1; // 로그인 화면 완성 후 hSeq값 받아올 것

		HostReviewListDao dao = new HostReviewListDao();
		ArrayList<HostReplyReviewDto> dtos = dao.reviewList(hSeq);
		request.setAttribute("review_list", dtos);

	}

}
