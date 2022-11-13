package com.bootcamp.host.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.dto.roomDto;
import com.bootcamp.host.dao.RoomDao;

public class HostInfoRoomSelectCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		
		int regSeq = (int) session.getAttribute("REGSEQ");
		int hSeq = (int) session.getAttribute("HSEQ");
		
		
		RoomDao dao = new RoomDao();

		ArrayList<roomDto> dtos = dao.selectRoom(regSeq, hSeq);

		request.setAttribute("list", dtos);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
