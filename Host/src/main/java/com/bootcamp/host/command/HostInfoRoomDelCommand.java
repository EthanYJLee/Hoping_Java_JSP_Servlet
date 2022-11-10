package com.bootcamp.host.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.RoomDao;

public class HostInfoRoomDelCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String roSeq = request.getParameter("roSeq");
		RoomDao dao = new RoomDao();
		
		dao.deleteRoom(roSeq);

	}

}
