package com.bootcamp.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.dto.KeyDto;
import com.bootcamp.host.dao.KeyDao;
import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

public class HostInfoKeySelectCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		int hSeq = (int) session.getAttribute("HSEQ");
		int regSeq = (int) session.getAttribute("REGSEQ");

		KeyDao dao = new KeyDao();

		ArrayList<KeyDto> dtos = dao.selectKeyword(regSeq, hSeq);

		request.setAttribute("keywords", dtos);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
