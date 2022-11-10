package com.bootcamp.host.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.dto.roomDto;
import com.bootcamp.host.dao.RoomDao;

public class HostInfoRoomSelectCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String regSeq = request.getParameter("regSeq");
		String hSeq = request.getParameter("hSeq");
		
		RoomDao dao = new RoomDao();
		
		ArrayList<roomDto> dtos = dao.selectRoom(1, 1);
		
		request.setAttribute("list", dtos);
		
		
	}

}
