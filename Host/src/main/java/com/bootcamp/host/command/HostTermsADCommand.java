package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HostTermsADCommand implements BCCommand {

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		

		String agree = request.getParameter("agree");
//		String disagree = request.getParameter("disagree");
		if(agree.equals("agree")){
			return true;
		}else {
			return false;
		}
	}
	
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
	}
}
