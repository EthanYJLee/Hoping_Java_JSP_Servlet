package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.dto.HostDto;
import com.bootcamp.host.dao.HInfoDao;

public class HImageCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String hImage = (String)request.getAttribute("FILENAME");

		HInfoDao dao = new HInfoDao();
		dao.imageUpdate(hImage);
		
		
		
		System.out.println("file" + hImage);
		
		
		
		
		//파일 보여주기
		HostDto dto = dao.fileView();
		
		request.setAttribute("fileView", dto);
	}

}
