package com.bootcamp.client.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Client_Command {
	
	public void execute(HttpServletRequest request, HttpServletResponse response);
	
}
