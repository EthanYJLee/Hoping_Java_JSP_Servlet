package com.bootcamp.client.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.bootcamp.client.dao.ClientDao;


public class Clientmodify_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cId = request.getParameter("cId");
		String cPhone = request.getParameter("cPhone");
		String cEmail = request.getParameter("cEmail");
		String cPw = request.getParameter("cPw");
		

		
		
		ClientDao dao = new ClientDao();
		dao.ClientModify(cId, cPw, cPhone, cEmail);
		JOptionPane.showMessageDialog(null, "회원정보 수정이 완료되었습니다.");

		
		
	}

}
