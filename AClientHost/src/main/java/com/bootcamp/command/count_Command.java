package com.bootcamp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.client.dao.countDao;
import com.bootcamp.client.dao.wish_writeDao;

public class count_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String regSeq = request.getParameter("regSeq");
		String cId = request.getParameter("cId");
		Boolean result = false;
		
		countDao dao = new countDao();
		result = dao.count(regSeq,cId);
		
		return result;
	}

}
