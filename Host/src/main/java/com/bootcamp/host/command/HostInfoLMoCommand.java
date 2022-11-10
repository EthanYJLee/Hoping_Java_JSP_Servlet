package com.bootcamp.host.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.HostRegMDao;

public class HostInfoLMoCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String regDetailaddress = request.getParameter("regDetailaddress");
		String regSummary = request.getParameter("regSummary");
		
		HostRegMDao dao = new HostRegMDao();
		dao.upInfoLS(regDetailaddress, regSummary, 1);
		
	}

}//END
