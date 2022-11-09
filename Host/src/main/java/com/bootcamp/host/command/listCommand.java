package com.bootcamp.host.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.dto.ClientDto;
import com.bootcamp.host.dao.HInfoDao;



public class listCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HInfoDao dao = new HInfoDao();
		ArrayList<ClientDto> dtos = dao.List();
		request.setAttribute("list", dtos);

	}

}
