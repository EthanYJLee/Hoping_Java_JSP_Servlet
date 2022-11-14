package com.bootcamp.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.HRegCampDao;

public class RegCampRoomCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		int roNum = Integer.parseInt(request.getParameter("roNum"));
		int roPrice = Integer.parseInt(request.getParameter("roPrice"));
		int roMax = Integer.parseInt(request.getParameter("roMax"));
		int regcamp_regSeq = 10;
		int regcamp_host_hSeq = 1;

		HRegCampDao dao = new HRegCampDao();
		dao.regcamproom(roNum, roPrice, roMax, regcamp_regSeq, regcamp_host_hSeq);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
