package com.bootcamp.client.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.bootcamp.client.dao.ClientDao;

public class Clientwrite_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String cId = request.getParameter("cId");
		String cPw = request.getParameter("cPw");
		String cName = request.getParameter("cName");
		String cPhone = request.getParameter("cPhone");
		String cEmail = request.getParameter("cEmail");
		String zonecode = request.getParameter("zonecode");
		String address = request.getParameter("address");
		String buildingName = request.getParameter("buildingAddress");
		String detailAddress = request.getParameter("detailAddress");
		
		ClientDao dao = new ClientDao();
		dao.Clientwrite(cId, cPw, cName, cPhone, cEmail, zonecode,address,buildingName,detailAddress);
		JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
		
	}
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		return null;
		
		
	}

}
