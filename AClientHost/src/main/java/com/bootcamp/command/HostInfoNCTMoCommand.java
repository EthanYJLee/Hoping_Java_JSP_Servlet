package com.bootcamp.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.host.dao.HostRegMDao;

public class HostInfoNCTMoCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		
		String regName = request.getParameter("regName");
		System.out.println("regName: " + regName);
		String regCategory = request.getParameter("regCategory");
		String regTel = request.getParameter("regTel");
		int regSeq = (int) session.getAttribute("REGSEQ");
		
		HostRegMDao dao = new HostRegMDao();
		dao.upInfoNCT(regName, regCategory, regTel, regSeq);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
