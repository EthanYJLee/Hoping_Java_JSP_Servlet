package com.bootcamp.host.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.dto.regcampDto;
import com.bootcamp.host.dao.HostCampListDao;

public class HostCampProfileList_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
<<<<<<< HEAD
	
=======
//		int hSeq = Integer.parseInt(request.getParameter("hSeq"));
		// 로그인 화면 완성되면 hSeq값 받아오도록 바꿀 예정
>>>>>>> 297c868fc1611749bdd771693317b53d2505fb70
		int hSeq = 1;
		HostCampListDao dao = new HostCampListDao();
		
		ArrayList<regcampDto> dtos = dao.myCampProfileList(hSeq);
		
		request.setAttribute("host_camp_profile_list", dtos);
		
		// Host Main 화면에서 썸네일 담아줌 (사진, 캠핑장이름, 주소)

	}

}
