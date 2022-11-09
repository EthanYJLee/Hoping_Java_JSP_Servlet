package com.bootcamp.client.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.client.dao.ClientDao;
import com.bootcamp.dto.ClientDto;

public class ClientmypageView_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String cId = (String) session.getAttribute("cId");
		ClientDao dao = new ClientDao();
		ClientDto dto = dao.mypageView(cId);
		
//		request.setAttribute("mypageview", dto);
		session.setAttribute("mypageview", dto);

	}

}