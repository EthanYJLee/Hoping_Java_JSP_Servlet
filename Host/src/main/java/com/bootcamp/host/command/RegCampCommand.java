package com.bootcamp.host.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.HRegCampDao;

public class RegCampCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String address1 =request.getParameter("regDetailaddress");
		String address2 =request.getParameter("regStreetaddress");
		
		String regTel = request.getParameter("regTel");
		String regCategory = request.getParameter("regCategory");
		String regDetailaddress = address2 + " " + address1;
		String regName = request.getParameter("regName");
		String regSummary = request.getParameter("regSummary");
		int host_hSeq = 1;
		
		HRegCampDao dao = new HRegCampDao();
		dao.regcamp(regTel, regCategory, regDetailaddress, regName, regSummary, host_hSeq);
		

	}

}
