package com.bootcamp.client.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.client.dao.ReviewDao;
import com.bootcamp.dto.reviewDto;


public class reviewDetailCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int bId =Integer.parseInt(request.getParameter("rvSeq"));
		System.out.println("reviewDetailCommand syso Check -hosik rvSeq = "+bId);
		ReviewDao dao = new ReviewDao();
		reviewDto dto = dao.reviewView(bId);
		
		request.setAttribute("reviewDetail", dto);
	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
