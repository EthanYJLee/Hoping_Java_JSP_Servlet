package com.bootcamp.client.command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.bootcamp.client.dao.ClientDao;

public class Clientlogin_Command implements Client_Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cId = request.getParameter("cId");
		String cPw = request.getParameter("cPw");
		String page = null;
		
		ClientDao dao = new ClientDao();
		boolean result =dao.login(cId, cPw);
				
			
		if(result == false) {
			JOptionPane.showInternalMessageDialog(null, "아이디와 비밀번호를 확인해주세요 ", "로그인", 0, null);
			page = "ClientLogin.jsp";
		}if(result == true) {
			JOptionPane.showInternalMessageDialog(null, "환영합니다 ", "로그인", 0, null);
			page = "ClientMain.jsp";
		
		
//			request.setAttribute("cId", cId);
			
			HttpSession session = request.getSession();
			session.setAttribute("cId", cId);

		}

		
		{
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();

		}
}

}	
		
}
