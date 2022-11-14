package com.bootcamp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.client.dao.BCBookDao;
import com.bootcamp.client.dao.ReviewDao;
import com.bootcamp.dto.regcampDto;
import com.bootcamp.dto.reviewDto;

public class ReviewerNameCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String cId = (String) session.getAttribute("cId");
		
		ReviewDao dao = new ReviewDao();
		reviewDto dto = dao.reviewerName(cId); // 다오한테 받은 bId를 dto에 보냄 

		request.setAttribute("reviewer", dto);
		
	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
