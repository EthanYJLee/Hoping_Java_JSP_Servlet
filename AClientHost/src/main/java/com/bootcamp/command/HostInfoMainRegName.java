package com.bootcamp.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.host.dao.HostRegMDao;

public class HostInfoMainRegName implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		HostRegMDao dao = new HostRegMDao();
		
		int regSeq = (int) session.getAttribute("REGSEQ");
		String regName = dao.selectRegName(regSeq);
		
		request.setAttribute("regName", regName);
		
	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
