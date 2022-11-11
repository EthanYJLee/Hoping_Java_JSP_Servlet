package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.HostRegMDao;

public class HostInfoMRMUpdateCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HostRegMDao dao = new HostRegMDao();
		
		String checkNull = (String) request.getAttribute("FILENAME");
		String filename;
		
		if(checkNull == null) {
			filename = "defaultimage.png";
		}else {
			filename = checkNull;
		}
		
		dao.upRoughMap(filename);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
