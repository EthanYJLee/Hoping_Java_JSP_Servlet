package com.bootcamp.host.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.HostRegMDao;

public class HostInfoNCTMoCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String regName = request.getParameter("regName");
			System.out.println("regName: " +regName);
		String regCategory = request.getParameter("regCategory");
		String regTel = request.getParameter("regTel");
		String regSeq = request.getParameter("regSeq");
		
		HostRegMDao dao = new HostRegMDao();
		dao.upInfoNCT(regName, regCategory, regTel, 1);
		
	}

}
