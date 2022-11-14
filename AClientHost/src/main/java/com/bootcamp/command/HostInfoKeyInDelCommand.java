package com.bootcamp.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.host.dao.KeyDao;

public class HostInfoKeyInDelCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		int hSeq = (int) session.getAttribute("HSEQ");
		int regSeq = (int) session.getAttribute("REGSEQ");

		String[] keys = request.getParameterValues("keys");
		KeyDao dao = new KeyDao();
		dao.deleteKey(regSeq, hSeq);

		// 선택한 키워드 개수만큼 for문 돌려서 insert
		for (int i = 0; i < keys.length; i++) {
			dao.insertKey(keys[i], regSeq, hSeq);
		}

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
