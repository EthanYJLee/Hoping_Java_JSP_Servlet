package com.bootcamp.host.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.BookJoinDao;
import com.bootcamp.joindto.BookJoinDto;


public class HostBookListCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BookJoinDao dao = new BookJoinDao();
		
		String hSeq = request.getParameter("hSeq");
			System.out.println("hSeq: " +hSeq);
		
		ArrayList<BookJoinDto> dtos = dao.list("1");
		
		request.setAttribute("list", dtos);
		
	}

}
