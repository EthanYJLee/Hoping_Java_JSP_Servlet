	package com.bootcamp.host.command;
	
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	public interface BCCommand {
		public void execute(HttpServletRequest request, HttpServletResponse response);
	}
