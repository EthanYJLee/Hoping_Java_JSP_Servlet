package com.bootcamp.client.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.client.dao.ClientDao;
import com.mysql.cj.xdevapi.Client;

public class ClientloginView_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cId = request.getParameter("cId");
		String cPw = request.getParameter("cPw");
		
		ClientDao dao = new ClientDao();
		
		
	}

}
