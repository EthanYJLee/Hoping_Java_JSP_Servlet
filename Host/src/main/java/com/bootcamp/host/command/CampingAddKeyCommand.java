package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.KeyDao;

public class CampingAddKeyCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String[] keys = request.getParameterValues("keys");
		KeyDao dao = new KeyDao();
		dao.deleteKey(1, 1);

		// 선택한 키워드 개수만큼 for문 돌려서 insert
		for (int i = 0; i < keys.length; i++) {
			dao.insertKey(keys[i], 1, 1);
		}

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
