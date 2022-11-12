package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.host.dao.HostRegMDao;

public class HostInfoMRMUpdateCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		int regSeq = (int) request.getAttribute("regSeq");
		
		HostRegMDao dao = new HostRegMDao();
		
		String checkNull = (String) request.getAttribute("FILENAME");
		String filename;
		
		//file 등록 안 하고 업로드하면 defaultimage 나오도록 null을 defaultimage.png로 바꿔주기
		if(checkNull == null) {
			filename = "defaultimage.png";
		}else {
			filename = checkNull;
		}
		
		dao.upRoughMap(filename, regSeq);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
