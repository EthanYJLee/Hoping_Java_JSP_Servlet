	package com.bootcamp.client.command;
	
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	public interface BCCommand {
		public void execute(HttpServletRequest request, HttpServletResponse response);
		public Boolean execute1(HttpServletRequest request, HttpServletResponse response);
	}
