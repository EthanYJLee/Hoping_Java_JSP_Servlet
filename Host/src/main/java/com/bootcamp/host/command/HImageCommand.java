package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.dto.HostDto;
import com.bootcamp.host.dao.HInfoDao;

public class HImageCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		String hId = (String) session.getAttribute("HID");
		String hImage = (String) request.getAttribute("FILENAME");

		HInfoDao dao = new HInfoDao();
		dao.imageUpdate(hImage, hId);

		
		
		
		// 파일 보여주기
		HostDto dto = dao.fileView(hId);

		request.setAttribute("fileView", dto);
	System.out.println(hImage);
	
	}

	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}
}
