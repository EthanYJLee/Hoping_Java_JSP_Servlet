package com.bootcamp.host.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.dto.FacilityDto;
import com.bootcamp.host.dao.FacilityDao;

public class HostInfoFaSelectCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String regSeq = request.getParameter("regSeq");
		String hSeq = request.getParameter("hSeq");

		FacilityDao dao = new FacilityDao();

		ArrayList<FacilityDto> dtos = dao.selectFacility(1, 1);

		request.setAttribute("facility", dtos);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
