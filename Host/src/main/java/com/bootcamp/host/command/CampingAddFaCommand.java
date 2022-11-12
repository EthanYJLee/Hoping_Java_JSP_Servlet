package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.FacilityDao;

public class CampingAddFaCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String[] facilities = request.getParameterValues("facility");
		FacilityDao dao = new FacilityDao();
		dao.deleteFacility(1, 1);
		
		// 선택한 편의시설 개수만큼 for문 돌려서 insert
		for (int i = 0; i < facilities.length; i++) {
			dao.insertFacility(facilities[i], 1, 1);
		}
		
	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
