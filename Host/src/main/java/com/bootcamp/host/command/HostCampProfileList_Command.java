package com.bootcamp.host.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.dto.regcampDto;
import com.bootcamp.host.dao.HostCampListDao;

public class HostCampProfileList_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int hSeq = (int) session.getAttribute("HSEQ");

		HostCampListDao dao = new HostCampListDao();

		ArrayList<regcampDto> dtos = dao.myCampProfileList(hSeq);

		request.setAttribute("host_camp_profile_list", dtos);

		// Host Main 화면에서 썸네일 담아줌 (사진, 캠핑장이름, 주소)

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
