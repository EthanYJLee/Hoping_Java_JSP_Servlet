package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.host.dao.HostRegMDao;

public class HostInfoImages2UpCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		HostRegMDao dao = new HostRegMDao();
		int regSeq = (int) session.getAttribute("regSeq");

		String checkNull = (String) request.getAttribute("FILENAME");
		String filename;
		
		if(checkNull == null) {
			filename = "defaultimage.png";
		}else {
			filename = checkNull;
		}
		
		dao.upImage2(filename, regSeq);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
