package com.bootcamp.host.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.HostRegMDao;

public class HostInfoMRMUpdateCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String filename = (String) request.getAttribute("FILENAME");
		
		HostRegMDao dao = new HostRegMDao();
		dao.upRoughMap(filename);
		
	}

}
