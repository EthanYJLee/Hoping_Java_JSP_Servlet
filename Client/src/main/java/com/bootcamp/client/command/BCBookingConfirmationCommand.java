package com.bootcamp.client.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.client.dao.BCBookDao;
import com.bootcamp.client.dao.CampDao;
import com.bootcamp.client.dao.MainDao;
import com.bootcamp.dto.regcampDto;
import com.bootcamp.joindto.campDto;

public class BCBookingConfirmationCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int roNum = Integer.parseInt(request.getParameter("roNum"));
		
		BCBookDao dao = new BCBookDao();
		dao.confirmation(roNum);
		
		request.setAttribute("RoomInfo", dao);
		System.out.println("booking Confirmation Command syso dao: "+dao);
		
		
		
		
//		HttpSession session = request.getSession();
//		String regSeq = request.getParameter("regSeq");
//
//		CampDao dao = new CampDao();
//		ArrayList<campDto> dtos = dao.listCamp(regSeq);
//		
//		request.setAttribute("Camp", dtos);
//		
		
		
		
	}
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		return null;
		
		
	}

}

