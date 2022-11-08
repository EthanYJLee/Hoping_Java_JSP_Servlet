package com.bootcamp.host.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.HostCampListDao;

public class HostCampNameList_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
//		int hSeq = Integer.parseInt(request.getParameter("hSeq"));
		// 로그인 화면 완성되면 hSeq값 받아오도록 바꿀 예정
		int hSeq = 1;

		HostCampListDao dao = new HostCampListDao();
		ArrayList<String> list = dao.myCampNameList(hSeq);

		request.setAttribute("host_regName_list", list);

	}

}
