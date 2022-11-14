package com.bootcamp.client.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.dto.AskDto;

import com.bootcamp.client.dao.HInfoDao;
import com.bootcamp.joindto.HostClientDto;
import com.mysql.cj.Session;

public class ClientToHostCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

//		HttpSession session = request.getSession();
//
//		HInfoDao dao = new HInfoDao();
//		int hSeq = Integer.parseInt(request.getParameter("hSeq"));
//		String cId = (String) session.getAttribute("CID");
//		String hId = request.getParameter("hId");
//
//		HostClientDto dtos = dao.arHost1(cId);
//		
//		session.setAttribute("HID", hId);
//		session.setAttribute("HSEQ", hSeq);
//
//		System.out.println("ClienttoHostcommand: cid : " + cId);
//		System.out.println("ClienttoHostcommand: hid : " + hId);
//		System.out.println("ClienttoHostcommand: hseq : " + hSeq);
		
		
	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		String cId = (String) session.getAttribute("CID");

		HInfoDao dao = new HInfoDao();
		Boolean Result = dao.arHost(cId);

//		session.setAttribute("HID", hId);
//		session.setAttribute("HSEQ", hSeq);

		System.out.println("ClienttoHostcommand: cid : " + cId);
		//System.out.println("ClienttoHostcommand: hid : " + hId);
		//System.out.println("ClienttoHostcommand: hseq : " + hSeq);
		if(Result == true) {
			return true;
		}else {
			return false;
		}
	}

}
