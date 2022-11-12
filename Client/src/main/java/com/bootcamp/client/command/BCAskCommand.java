package com.bootcamp.client.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.client.dao.AskDao;
import com.bootcamp.joindto.checkdate2Dto;

public class BCAskCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String cId = (String) session.getAttribute("cId");
		String regName = (String) request.getParameter("regName");
		int hostSeq = Integer.parseInt( request.getParameter("regSeq"));
//		
//		checkdate2Dto dto = new checkdate2Dto();
//		dto(hostSeq,  cId, regName);
		
		
//		AskDao dao = new AskDao();
//		dao.AsktoHost(hostSeq,cId); // 다오한테 받은 bId를 dto에 보냄 

	}   // 여기서 다오한테 넣어야 될꺼 넣고 다오 인설트 시키는거 완성시키고 나서 입력해서확인해보면 됨 
	
	
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

}
