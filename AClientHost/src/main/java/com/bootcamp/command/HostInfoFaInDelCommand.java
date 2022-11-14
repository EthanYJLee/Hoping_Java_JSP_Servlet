package com.bootcamp.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.host.dao.FacilityDao;
import com.bootcamp.host.dao.KeyDao;

public class HostInfoFaInDelCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		
		int hSeq = (int) session.getAttribute("HSEQ");
		int regSeq = (int) session.getAttribute("REGSEQ");
		
		String[] facilities = request.getParameterValues("facility");
		FacilityDao dao = new FacilityDao();
		dao.deleteFacility(regSeq, hSeq);

		// 선택한 편의시설 개수만큼 for문 돌려서 insert
		for (int i = 0; i < facilities.length; i++) {
			dao.insertFacility(facilities[i], hSeq, regSeq);
		}

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
