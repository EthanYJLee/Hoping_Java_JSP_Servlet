package com.bootcamp.host.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.BookJoinDao;
import com.bootcamp.joindto.BookJoinDto;

public class HostBookListCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		BookJoinDao dao = new BookJoinDao();

		String hSeq = request.getParameter("hSeq");
		System.out.println("hSeq: " + hSeq);

		ArrayList<BookJoinDto> dtos = dao.list("1");

		request.setAttribute("list", dtos);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
