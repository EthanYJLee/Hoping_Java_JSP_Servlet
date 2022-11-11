package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.HostInquiryStatusDao;

public class HostMainInquiryStatus_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		int hSeq = Integer.parseInt(request.getParameter("hSeq"));
		int hSeq = 1;
		HostInquiryStatusDao dao = new HostInquiryStatusDao();
		int todayQ = dao.mainInquiryCount(hSeq);
		int todayRepliedQ = dao.mainInquiryRepliedCount(hSeq);
		int todayNotRepliedQ = todayQ - todayRepliedQ;

		request.setAttribute("tq", todayQ); // 오늘 작성된 전체 캠핑장의 전체 문의글
		request.setAttribute("trq", todayRepliedQ); // 답변 완료
		request.setAttribute("tnrq", todayNotRepliedQ); // 답변 미완료
	}
	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}
}
