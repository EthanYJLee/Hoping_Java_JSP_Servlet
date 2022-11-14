package com.bootcamp.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.dto.AskDto;
import com.bootcamp.host.dao.HAskDao;

public class askDetailCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String askSeq = request.getParameter("aSeq");
		HAskDao dao = new HAskDao();
		AskDto dto = dao.askDetail(askSeq);

		request.setAttribute("askDetail", dto);
	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
