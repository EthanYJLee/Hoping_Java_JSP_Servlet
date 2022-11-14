package com.bootcamp.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.host.dao.HostRegDDao;


public class HostDeleteMyCamp_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		int hSeq = (int)session.getAttribute("HSEQ");
		int regSeq = (int)session.getAttribute("REGSEQ");
		HostRegDDao dao = new HostRegDDao();
		dao.deleteRegcamp(hSeq, regSeq);
		session.removeAttribute("REGSEQ");
	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
