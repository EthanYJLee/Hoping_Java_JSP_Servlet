package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.host.dao.HostRegMDao;

public class CampingAddCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		
		String regDetailaddress = request.getParameter("regDetailaddress");
		String regSummary = request.getParameter("regSummary");
		String regName = request.getParameter("regName");
		String regTel = request.getParameter("regTel");
		String regCategory = request.getParameter("regCategory");
		
		int hSeq = (int) session.getAttribute("HSEQ");
		
		HostRegMDao dao = new HostRegMDao();
		dao.inCampLo(regDetailaddress, regSummary, regName, regTel, regCategory, hSeq);
		
		//등록한 캠핑장의 regSeq session
		int regSeq = dao.selectRegSeq(regDetailaddress, regSummary, regName, regTel, regCategory, hSeq);
		
		session.setAttribute("REGSEQ", regSeq);
		System.out.println(regSeq);
		
	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
