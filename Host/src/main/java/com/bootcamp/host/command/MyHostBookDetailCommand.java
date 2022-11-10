package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.BookJoinDao;
import com.bootcamp.joindto.BookJoinDto;

public class MyHostBookDetailCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String sBoSeq = request.getParameter("boSeq");

		BookJoinDao dao = new BookJoinDao();
		BookJoinDto dto = dao.detailBook(sBoSeq);

		request.setAttribute("bookDetail", dto);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
