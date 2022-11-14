package com.bootcamp.client.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.client.dao.ClientDao;
import com.bootcamp.client.dao.ReviewDao;
import com.bootcamp.dto.ClientDto;
import com.bootcamp.dto.reviewDto;
import com.bootcamp.joindto.checkdate2Dto;


public class BCClientHistory implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		/*22-11-14 호식
			클라이언트의 예약내역 확인 페이지 생성
		*/
		HttpSession session = request.getSession();
		String CID = (String)session.getAttribute("cId");
		System.out.println("BCClientHistory session id check CID = "+CID);
		ClientDao dao = new ClientDao();
		ArrayList<checkdate2Dto> dtos = dao.clientHistory(CID);
		
		request.setAttribute("history", dtos);
	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
