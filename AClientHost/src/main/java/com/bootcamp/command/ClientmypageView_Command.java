package com.bootcamp.command;

import java.text.ParseException;

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
		System.out.println("ClientmypageView_Command 에서 보내는 cId : "+cId);
		ClientDao dao = new ClientDao();
		ClientDto dto = dao.mypageView(cId);
		
//		request.setAttribute("mypageview", dto);
		session.setAttribute("mypageview", dto);

	}
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

}