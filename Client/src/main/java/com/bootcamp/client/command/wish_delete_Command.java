package com.bootcamp.client.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.client.dao.countDao;
import com.bootcamp.client.dao.wish_delete_Dao;

public class wish_delete_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String regSeq = request.getParameter("regSeq");
		String cId = request.getParameter("cId");
		
		
		wish_delete_Dao dao = new wish_delete_Dao();
		dao.wish_delete(regSeq,cId);
		
		
		

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
