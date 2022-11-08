package com.bootcamp.host.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.HostReviewListDao;
import com.bootcamp.joindto.HostReplyReviewDto;

public class HostReviewContentView_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int rvSeq = Integer.parseInt(request.getParameter("rvSeq"));
		HostReplyReviewDto dto = new HostReplyReviewDto();
		HostReviewListDao dao = new HostReviewListDao();
		dto = dao.reviewContentView(rvSeq);
		request.setAttribute("review_content_view", dto);
		request.setAttribute("rvSeq", Integer.toString(rvSeq));
	}

}
