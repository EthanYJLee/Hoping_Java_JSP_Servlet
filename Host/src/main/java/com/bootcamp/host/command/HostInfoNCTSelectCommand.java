package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.dto.MyregcampDto;
import com.bootcamp.host.dao.HostRegMDao;

public class HostInfoNCTSelectCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String regSeq = request.getParameter("regSeq");
		String hSeq = request.getParameter("hSeq");

		HostRegMDao dao = new HostRegMDao();
		MyregcampDto dto = dao.selectInfoNCT(1, 1);

		request.setAttribute("detail", dto);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
