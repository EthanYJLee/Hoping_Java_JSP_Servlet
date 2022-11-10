package com.bootcamp.client.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.client.dao.BCBookDao;
import com.bootcamp.client.dao.MainDao;
import com.bootcamp.dto.regcampDto;
import com.bootcamp.dto.roomDto;

public class BCSelectDateCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
			
		String bId = request.getParameter("regSeq");
		BCBookDao dao = new BCBookDao();
		ArrayList<roomDto> dtos = dao.SelectDate(bId); // 다오한테 받은 bId를 dto에 보냄 
		
		request.setAttribute("SelectDateDto", dtos);
	}
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		return null;
		
		
	}

}
