package com.bootcamp.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.bootcamp.client.dao.AskDao;
import com.bootcamp.joindto.checkdate2Dto;

public class BCAskCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String cId = (String) session.getAttribute("cId");
		String aTitle = (String) request.getParameter("aTitle");
		String aContent = (String)request.getParameter("aContent");
		String aRegSeq = request.getParameter("aRegSeq");
		System.out.println("BCAskCommand 에서 보내는 받아온 값들 : "+cId);
		System.out.println("BCAskCommand 에서 보내는 받아온 값들 : "+aTitle);
		System.out.println("BCAskCommand 에서 보내는 받아온 값들 : "+aContent);
		System.out.println("BCAskCommand 에서 보내는 받아온 값들 : "+aRegSeq);
		
		AskDao dao = new AskDao();
		dao.AsktoHost(cId, aTitle, aContent, aRegSeq );
		JOptionPane.showMessageDialog(null, "문의가 등록되었습니다.");
		
		
		
	}   // 여기서 다오한테 넣어야 될꺼 넣고 다오 인설트 시키는거 완성시키고 나서 입력해서확인해보면 됨 
	
	
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

}
