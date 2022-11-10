package com.bootcamp.client.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.client.dao.CampDao;
import com.bootcamp.client.dao.MainDao;
import com.bootcamp.dto.regcampDto;
import com.bootcamp.joindto.campDto;

public class BCCampListCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String cId = (String)session.getAttribute("cId");
		String regSeq = request.getParameter("regSeq");
		CampDao dao = new CampDao();
		ArrayList<campDto> dtos = dao.listCamp(regSeq);
		request.setAttribute("Camp", dtos);
		
/*
 * searchSiteView(가격, 캠핑장 관련 위치 정보)
searchRegCampImageView(캠핑장 이미지)
searchCampWish(찜관련 정보)
searchReview(별점 읽어오기)
searchReviewCount(후기 갯수 읽어오기)
 * 		
 */
		
		
		
		
		
	}
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		return null;
		
		
	}

}

