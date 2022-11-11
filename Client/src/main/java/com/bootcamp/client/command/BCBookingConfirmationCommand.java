package com.bootcamp.client.command;

import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.client.dao.BCBookDao;
import com.bootcamp.client.dao.CampDao;
import com.bootcamp.client.dao.MainDao;
import com.bootcamp.dto.regcampDto;
import com.bootcamp.joindto.campDto;
import com.bootcamp.joindto.checkdate2Dto;

public class BCBookingConfirmationCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String regName = request.getParameter("regName");
		int roNum = Integer.parseInt(request.getParameter("roNum"));
		System.out.println("BCBookingConfirmationCommand 에서 regName : "+regName);
		System.out.println("BCBookingConfirmationCommand 에서 roNum : "+roNum);
		BCBookDao dao = new BCBookDao();
		checkdate2Dto dto = dao.confirmation(roNum, regName);
		request.setAttribute("bookingInfo", dto);
	}
	
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

}//class end 