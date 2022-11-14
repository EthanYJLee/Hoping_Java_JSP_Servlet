package com.bootcamp.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.client.dao.BCBookDao;
import com.bootcamp.dto.regcampDto;

public class BCDetailCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
			
		String bId = request.getParameter("regSeq");
		BCBookDao dao = new BCBookDao();
		regcampDto dto = dao.DetailView(bId); // 다오한테 받은 bId를 dto에 보냄 

		request.setAttribute("DetailView", dto);
	}
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

}
