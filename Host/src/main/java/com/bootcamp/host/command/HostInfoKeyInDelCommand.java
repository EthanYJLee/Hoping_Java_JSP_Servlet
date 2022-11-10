package com.bootcamp.host.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.KeyDao;

public class HostInfoKeyInDelCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String regSeq = request.getParameter("regSeq");
		String hSeq = request.getParameter("hSeq");
		
		String[] keys = request.getParameterValues("keys");
		KeyDao dao = new KeyDao();
		dao.deleteKey(1, 1);
		
		//선택한 키워드 개수만큼 for문 돌려서 insert
		for(int i=0; i < keys.length; i++) {
			dao.insertKey(keys[i], 1, 1);
		}

	}

}
