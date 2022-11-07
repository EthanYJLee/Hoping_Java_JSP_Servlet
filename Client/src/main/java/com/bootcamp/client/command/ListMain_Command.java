package com.bootcamp.client.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import com.bootcamp.client.dao.MainDao;
import com.bootcamp.dto.regcampDto;

public class ListMain_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String cId = (String)session.getAttribute("cId");
		/*		BCustomerDao dao = new BCustomerDao();
		BCustomerDto dto = dao.contentCustomerView(cId);
		
		request.setAttribute("content_view", dto);
*/
		MainDao dao = new MainDao();
		ArrayList<regcampDto> dtos = dao.listRegCampview();
		request.setAttribute("RegCamp", dtos);
		
/*
 * searchSiteView(가격, 캠핑장 관련 위치 정보)
searchRegCampImageView(캠핑장 이미지)
searchCampWish(찜관련 정보)
searchReview(별점 읽어오기)
searchReviewCount(후기 갯수 읽어오기)
 * 		
 */

		
		
		
		
		
		
	}

}
