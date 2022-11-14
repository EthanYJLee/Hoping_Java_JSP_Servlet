package com.bootcamp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.bootcamp.client.dao.ClientDao;
import com.bootcamp.client.dao.wish_writeDao;

public class wish_write_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String regSeq = request.getParameter("regSeq");
		String host_hSeq = request.getParameter("host_hSeq");
		String cId = request.getParameter("cId");
		
		
		wish_writeDao dao = new wish_writeDao();
		dao.wish_write(regSeq,host_hSeq,cId);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}