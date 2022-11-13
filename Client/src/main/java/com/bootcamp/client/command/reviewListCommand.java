package com.bootcamp.client.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.client.dao.ReviewDao;
import com.bootcamp.dto.reviewDto;


public class reviewListCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int regSeq = Integer.parseInt(request.getParameter("regSeq"));
		
		
		
		ReviewDao dao = new ReviewDao();
		ArrayList<reviewDto> dtos = dao.reviewList(regSeq);
		
	
		request.setAttribute("reviewList", dtos);
		
		
		
		reviewDto dtos1 = dao.avgReview(regSeq);
		
		
		request.setAttribute("reviewAvg", dtos1);
		
		
		
		
	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
