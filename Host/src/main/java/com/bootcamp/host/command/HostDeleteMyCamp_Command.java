package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.host.dao.HostRegDDao;


public class HostDeleteMyCamp_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		int regSeq = (int)session.getAttribute("REGSEQ");
		
		HostRegDDao dao = new HostRegDDao();
		dao.deleteRegcamp(regSeq);
		
		session.removeAttribute("REGSEQ");
		
		System.out.println(session.getAttribute("REGSEQ"));	// null
		// regSeq 세션에 저장된 정보 초기화
		// invalidate하면 hSeq까지 초기화됨 주의.
	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
