package com.bootcamp.client.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.client.dao.ReviewDao;

public class ReviewWriteCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		String rvCId = (String)session.getAttribute("cId");
		String rvCName = request.getParameter("rvCName");
		String rvTitle = request.getParameter("rvTitle");
		String rvContent = request.getParameter("rvContent");
		int rvStar = Integer.parseInt(request.getParameter("rvStar"));
		int regcamp_regSeq = Integer.parseInt(request.getParameter("regSeq"));
		int regcamp_host_hSeq = Integer.parseInt(request.getParameter("host_hSeq"));
		
		ReviewDao dao = new ReviewDao();
		dao.write(rvCId, rvCName, rvTitle, rvContent, rvStar, regcamp_regSeq, regcamp_host_hSeq);
		
		
		System.out.println("리뷰작성아이디 : " + rvCId);
		System.out.println("리뷰작성별점 : " + rvStar);
		System.out.println("리뷰작성이름 : " + rvCName);
	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
