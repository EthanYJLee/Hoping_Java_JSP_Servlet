package com.bootcamp.client.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.bootcamp.client.dao.ClientDao;

public class ClientfindPw_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cId = request.getParameter("cId");
		String cName = request.getParameter("cName");
		String cEmail = request.getParameter("cEmail");
		String page = null;

		ClientDao dao = new ClientDao();
		String cPw = dao.pwsearch(cId, cName, cEmail);

		if (cPw != null) {
			JOptionPane.showInternalMessageDialog(null, cName + "님의" + " 비밀번호는 " + cPw + " 입니다", "비밀번호 찾기", 0, null);
			page = "ClientLoginView.jsp";
		} else {
			JOptionPane.showInternalMessageDialog(null, "입력하신 정보가 없습니다");
			page = "ClientFindpwView.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(page);

		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
