package com.bootcamp.host.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.dto.AskDto;
import com.bootcamp.host.dao.HAskDao;

public class askListCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HAskDao dao = new HAskDao();
		ArrayList<AskDto> dtos = dao.askList();
		request.setAttribute("list", dtos);

	}

}
