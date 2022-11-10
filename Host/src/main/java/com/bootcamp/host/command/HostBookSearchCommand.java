package com.bootcamp.host.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.BookJoinDao;
import com.bootcamp.joindto.BookJoinDto;

public class HostBookSearchCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String hSeq = request.getParameter("hSeq");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String strSearch = request.getParameter("strSearch");

		BookJoinDao dao = new BookJoinDao();

		ArrayList<BookJoinDto> dtos = dao.bookListCon("1", start, end, strSearch);

		request.setAttribute("list", dtos);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
