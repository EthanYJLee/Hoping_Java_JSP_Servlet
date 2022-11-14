package com.bootcamp.client.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.client.dao.CampDao;
import com.bootcamp.joindto.BookJoinDto;


public class BCViewBookingCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		System.out.println("BCViewBookingCommand--------------------------------------------");
		String cId = (String)session.getAttribute("cId");
		System.out.println("BCViewBookingCommand------------------------------session.setAttribute(\"cId\", cId);"+cId);

		CampDao dao = new CampDao();

		ArrayList<BookJoinDto> dtos = dao.ViewBooking(cId);

		request.setAttribute("Booking", dtos);

	}
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}
}

