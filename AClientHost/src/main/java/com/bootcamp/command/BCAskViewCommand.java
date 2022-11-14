package com.bootcamp.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.client.dao.AskDao;
import com.bootcamp.client.dao.BCBookDao;
import com.bootcamp.dto.regcampDto;
import com.bootcamp.joindto.checkdate2Dto;

public class BCAskViewCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String cId = (String) session.getAttribute("cId");
		String regName = (String) request.getParameter("regName");
		String regSeq = request.getParameter("regSeq");
		
		System.out.println("BCAskViewCommand에서 보내는 session cId 값 : "+cId);
		System.out.println("BCAskViewCommand에서 보내는 parameter regName 값 : "+regName);
//		
		
		BCBookDao BCBdao = new BCBookDao();
		regcampDto dto = BCBdao.DetailView(regSeq); // regSeq 들어가야댐 
		//detailView에서 사용한 값을 불러오는 Dao재활용 
		request.setAttribute("DetailView", dto);

	}   
	
	
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

}
