package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.HAskDao;


public class AskCommentCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		
		String acTitle = request.getParameter("acTitle");
		String acContent = request.getParameter("acContent");
		String acTime = request.getParameter("acTime");
		int ask_aSeq = Integer.parseInt(request.getParameter("ask_aSeq"));
		int host_hSeq = Integer.parseInt(request.getParameter("host_hSeq"));
		
		
    	
		HAskDao dao = new HAskDao();
		dao.aWrite(acTitle, acContent, acTime, ask_aSeq, host_hSeq);
	}

}
