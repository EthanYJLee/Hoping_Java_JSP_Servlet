package com.bootcamp.host.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.dto.KeyDto;
import com.bootcamp.host.dao.KeyDao;
import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

public class HostInfoKeySelectCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String regSeq = request.getParameter("regSeq");
		String hSeq = request.getParameter("hSeq");

		KeyDao dao = new KeyDao();

		ArrayList<KeyDto> dtos = dao.selectKeyword(1, 1);

		request.setAttribute("keywords", dtos);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
