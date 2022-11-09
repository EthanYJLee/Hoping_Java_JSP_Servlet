package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.HInfoDao;

public class HInfoInsertCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String hId = request.getParameter("cId");
		System.out.println("hID" + hId);
		
		String hSummary = request.getParameter("hSummary");
		System.out.println("hsummary" + hSummary);
		

		
		HInfoDao dao = new HInfoDao();
		dao.insert(hId, hSummary);
		

	}

}
