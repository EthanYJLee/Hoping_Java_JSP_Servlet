package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.RoomDao;

public class HostInfoRoomInCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int roNum = Integer.parseInt(request.getParameter("roNum"));
		int roPrice = Integer.parseInt(request.getParameter("roPrice"));
		int roMax = Integer.parseInt(request.getParameter("roMax"));

		String regSeq = request.getParameter("regSeq");
		String hSeq = request.getParameter("hSeq");

		RoomDao dao = new RoomDao();
		dao.insertRoom(roNum, roPrice, roMax, 1, 1);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
