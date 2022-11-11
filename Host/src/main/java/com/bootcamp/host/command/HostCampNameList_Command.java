package com.bootcamp.host.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.host.dao.HostCampListDao;

public class HostCampNameList_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int hSeq = (int) session.getAttribute("hSeq");

		HostCampListDao dao = new HostCampListDao();
		ArrayList<String> list = dao.myCampNameList(hSeq);

		request.setAttribute("host_regName_list", list);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
