package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.dto.HostDto;
import com.bootcamp.host.dao.HInfoDao;
import com.bootcamp.joindto.HostClientDto;

public class HmyInfoCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession(); 
		String hId = (String) session.getAttribute("HID");
		HInfoDao dao = new HInfoDao();
		HostClientDto dto = dao.myPageView(hId);
		
		request.setAttribute("hInfo", dto);

		System.out.println("hmyinfocommand:" + hId);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
