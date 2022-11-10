package com.bootcamp.host.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.HostRegMDao;

public class HostInfoImages1UpCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HostRegMDao dao = new HostRegMDao();
		String filename = (String) request.getAttribute("FILENAME");
		dao.upImage1(filename);
		
	}

}
