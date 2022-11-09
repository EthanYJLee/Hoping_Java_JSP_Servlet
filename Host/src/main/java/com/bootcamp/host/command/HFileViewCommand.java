package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.dto.HostDto;
import com.bootcamp.host.dao.HInfoDao;

public class HFileViewCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HInfoDao dao = new HInfoDao();
		HostDto dto = dao.fileView();
		
		request.setAttribute("fileView", dto);
	}

}
