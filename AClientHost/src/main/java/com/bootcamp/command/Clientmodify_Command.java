package com.bootcamp.command;


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
		String cName = request.getParameter("cName");
		String cPw = request.getParameter("cPw");
		String zonecode = request.getParameter("zonecode");
		String address= request.getParameter("address");
		String buildingName= request.getParameter("buildingName");
		String detailAddress= request.getParameter("detailAddress");

		
		
		ClientDao dao = new ClientDao();
		dao.ClientModify(cId, cPw, cName, cPhone, cEmail, zonecode, address, buildingName, detailAddress);
		JOptionPane.showMessageDialog(null, "회원정보 수정이 완료되었습니다.");

		
		
	}
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}


}
