package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.host.dao.HostRegMDao;

public class HostInfoLMoCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		
		String regDetailaddress = request.getParameter("regDetailaddress");
		String regSummary = request.getParameter("regSummary");
		
		int regSeq = (int) session.getAttribute("REGSEQ");

		HostRegMDao dao = new HostRegMDao();
		dao.upInfoLS(regDetailaddress, regSummary, regSeq);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}// END
