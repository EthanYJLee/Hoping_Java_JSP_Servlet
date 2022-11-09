package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HostTermsAD implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("utf-8");
		

		String agree = request.getParameter("agree");
		String disagree = request.getParameter("disagree");
		
		if(agree.equals("agree")){
			request.getRequestDispatcher("list.jsp");
	   		
		}else{
			
			// 모달 
			request.getRequestDispatcher("HostTermsAD.jsp");
	   
		
		}
	}

}
