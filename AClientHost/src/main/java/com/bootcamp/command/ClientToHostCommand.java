package com.bootcamp.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.dto.AskDto;

import com.bootcamp.host.dao.HInfoDao;
import com.bootcamp.joindto.HostClientDto;
import com.mysql.cj.Session;

public class ClientToHostCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		
		String cId = (String) session.getAttribute("CID");
		String hId = (String) session.getAttribute("CID");
		
		
		HInfoDao dao = new HInfoDao();
		int hSeq = dao.arHost1(cId);
		
		

		System.out.println("ClienttoHostcommand: cid : " + cId);
		System.out.println("ClienttoHostcommand: hid : " + hId);
		System.out.println("ClienttoHostcommand: hseq : " + hSeq);

		session.setAttribute("CID", cId);
		session.setAttribute("HID", hId);
		session.setAttribute("HSEQ", hSeq);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {

	
		String cId = request.getParameter("cId");
		

		HInfoDao dao = new HInfoDao();

		Boolean Result = dao.arHost(cId);

		// System.out.println("ClienttoHostcommand: hid : " + hId);
		// System.out.println("ClienttoHostcommand: hseq : " + hSeq);
		if (Result == true) {
			return true;
		} else {
			return false;
		}
	}

}
