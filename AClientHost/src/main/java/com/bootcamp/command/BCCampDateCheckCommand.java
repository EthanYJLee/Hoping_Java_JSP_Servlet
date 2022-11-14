package com.bootcamp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.client.dao.CampDao;
import com.bootcamp.joindto.campDto;

public class BCCampDateCheckCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		String startdate = request.getParameter("startdate");
		String stopdate = request.getParameter("stopdate");
				
		session.setAttribute("STARTDATE",startdate);
		session.setAttribute("STOPDATE",stopdate);
		System.out.println("STARTDATE:"+startdate);
		System.out.println("STOPDATE:"+stopdate);	
		String regSeq = (String)session.getAttribute("REGSEQ");
		
		CampDao dao = new CampDao();
		ArrayList<campDto> dtos = dao.dateCheck(regSeq,startdate,stopdate);
		request.setAttribute("Camp", dtos);
	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}

