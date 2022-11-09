package com.bootcamp.host.command;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.dto.ClientDto;
import com.bootcamp.host.dao.HInfoDao;

public class HInfoCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cId = request.getParameter("cId");
		HInfoDao dao = new HInfoDao();
		ClientDto dto = dao.myPageView(cId);
		
		request.setAttribute("mypage", dto);
		
		
		System.out.println("cId : " + cId);
	}

}
