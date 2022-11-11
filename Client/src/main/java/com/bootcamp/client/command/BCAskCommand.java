package com.bootcamp.client.command;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.client.dao.AskDao;
import com.bootcamp.dto.regcampDto;

public class BCAskCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
			
		int hostSeq = Integer.parseInt( request.getParameter("regSeq"));
		System.out.println(hostSeq);
		AskDao dao = new AskDao();
		dao.AskHost(hostSeq); // 다오한테 받은 bId를 dto에 보냄 

		request.setAttribute("DetailView", dto);
	}   // 여기서 다오한테 넣어야 될꺼 넣고 다오 인설트 시키는거 완성시키고 나서 입력해서확인해보면 됨 
	
	
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

}
