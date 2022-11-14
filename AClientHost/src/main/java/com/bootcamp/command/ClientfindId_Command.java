package com.bootcamp.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.bootcamp.client.dao.ClientDao;

public class ClientfindId_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cName = request.getParameter("cName");
		String cEmail = request.getParameter("cEmail");
		String page = null;

		ClientDao dao = new ClientDao();
		String cId = dao.idsearch(cName, cEmail);

		if (cId != null) {
			JOptionPane.showInternalMessageDialog(null, cName + "님의" + " 아이디는 " + cId + " 입니다", "아이디 찾기", 0, null);
			page = "ClientLoginView.jsp";

		} else {
			JOptionPane.showInternalMessageDialog(null, "입력하신 정보가 없습니다");
			page = "ClientFindidView.jsp";

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
