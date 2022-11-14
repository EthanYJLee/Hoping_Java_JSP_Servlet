package com.bootcamp.command;



import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.dto.ClientDto;
import com.bootcamp.host.dao.HInfoDao;

public class HInfoCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(); 

		//나중에 client랑 연결되면 세션으로 받기
		String cId = (String) session.getAttribute("CID");
		HInfoDao dao = new HInfoDao();
		ClientDto dto = dao.joinView(cId);
		//hId session으로 넘겨주기(호스트 가입 시)
		
		
		session.setAttribute("HID", cId);
		
		request.setAttribute("mypage", dto);
		
		System.out.println("HID ; " + cId);
		
		
	}
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
