package com.bootcamp.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.HostSendReviewReplyDao;

public class HostSendReviewReply_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int rvSeq = Integer.parseInt(request.getParameter("rvSeq"));
		String replyContent = request.getParameter("replyContent");
		HostSendReviewReplyDao dao = new HostSendReviewReplyDao();
		String rvCId = dao.selectReview(rvSeq).getRvCId();
		int regSeq = dao.selectReview(rvSeq).getRegcamp_regSeq();
		int hSeq = dao.selectReview(rvSeq).getRegcamp_host_hSeq();

		dao.replyReview(replyContent, rvSeq, rvCId, regSeq, hSeq);
		// rcomment 테이블에 후기에 남긴 답글 insert

		dao.setReviewCommentGroup(); // 그룹(rcGroup)을 해당 댓글 (rcomment)의 Seq와 같게 업데이트

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
