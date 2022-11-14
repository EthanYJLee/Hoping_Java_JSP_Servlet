package com.bootcamp.command;

import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.client.dao.MainDao;
import com.bootcamp.dto.regcampDto;
import com.bootcamp.dto.roomDto;

public class SearchCamp_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String query = request.getParameter("query");
		String content = request.getParameter("content");
		System.out.println("query :"+query+":");
		MainDao dao = new MainDao();
		ArrayList<regcampDto> dtos = dao.searchRegCamp(query,content);
		request.setAttribute("RegCamp", dtos);

	}
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}


}
