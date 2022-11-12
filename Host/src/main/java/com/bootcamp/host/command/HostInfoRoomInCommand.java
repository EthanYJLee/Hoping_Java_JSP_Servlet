package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.host.dao.RoomDao;

public class HostInfoRoomInCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		
		int roNum = Integer.parseInt(request.getParameter("roNum"));
		int roPrice = Integer.parseInt(request.getParameter("roPrice"));
		int roMax = Integer.parseInt(request.getParameter("roMax"));
		int regSeq = Integer.parseInt(request.getParameter("regSeq")); 
		int hSeq = (int) request.getAttribute("HSEQ");
		
		
		RoomDao dao = new RoomDao();
		dao.insertRoom(roNum, roPrice, roMax, hSeq, regSeq);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
