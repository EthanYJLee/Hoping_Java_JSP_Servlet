package com.bootcamp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.client.dao.CampDao;
import com.bootcamp.joindto.campDto;

public class BCCampListCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		System.out.println("BCCampListCommand--------------------------------------------");
		//String cId = (String)session.getAttribute("cId");
		String regSeq = request.getParameter("regSeq");
		session.setAttribute("regSeq", regSeq);
		System.out.println("BCCampListCommand------------------------------session.setAttribute(\"regSeq\", regSeq);"+regSeq);
		//String startdate = request.getParameter("startdate");
		//String stopdate = request.getParameter("stopdate");
	
		//session.setAttribute("startdate", startdate);
		//session.setAttribute("stopdate", stopdate);
	
		//System.out.println("startdate:"+startdate);
		//System.out.println("stopdate:"+stopdate);		
		System.out.println("regSeq:"+regSeq+":");
		CampDao dao = new CampDao();
		ArrayList<campDto> dtos = dao.listCamp(regSeq);
		request.setAttribute("Camp", dtos);

	}
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}
}

