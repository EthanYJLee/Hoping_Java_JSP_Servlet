package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.HostRegMDao;

public class CampingAddCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String regDetailaddress = request.getParameter("regDetailaddress");
		String regSummary = request.getParameter("regSummary");
		String regName = request.getParameter("regName");
		String regTel = request.getParameter("regTel");
		String regCategory = request.getParameter("regCategory");
		
		HostRegMDao dao = new HostRegMDao();
		dao.inCampLo(regDetailaddress, regSummary, regName, regTel, regCategory, 1);
		
	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
