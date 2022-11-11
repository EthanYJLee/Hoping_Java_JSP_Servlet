package com.bootcamp.client.command;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.bootcamp.client.dao.ClientDao;
import com.mysql.cj.Session;

public class Clientlogin_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {

		String cId = request.getParameter("cId");
		String cPw = request.getParameter("cPw");

		ClientDao dao = new ClientDao();
		boolean result = dao.login(cId, cPw);

		HttpSession session = request.getSession();
		session.setAttribute("cId", cId);
		System.out.println("clientlogin_command에서 보내는 session = " + session.getAttribute(cId));

		return null;
	}

}
