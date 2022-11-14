package com.bootcamp.command;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.client.dao.CampDao;
import com.bootcamp.dto.roomDto;

public class BCInsertPayCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		System.out.println("BCInsertPayCommand______________________________________________________");
	
		String cId = (String)session.getAttribute("CID");
		String roNum = (String)session.getAttribute("roNum");
		String regSeq = (String)session.getAttribute("regSeq");
		// InputPay 의 Dao 를 생성함.  		
		CampDao dao = new CampDao();
		roomDto dto = dao.readRoom(regSeq, roNum);
		// 	public int insertPay(int room_roSeq, int room_regcamp_regSeq, int room_regcamp_host_hseq, String client_cId) {
		// Pay 할 때 필요한 cId가 랜덤3자를 포함해서 생성되도록 작성함.
		String strRandom = randomCharacter(3);

		dao.insertPay(strRandom,dto.getRoSeq(), dto.getRegcamp_regSeq(), dto.getRegcamp_host_hSeq(), cId);
		session.setAttribute("roSeq", dto.getRoSeq());
		session.setAttribute("regcamp_host_hSeq", dto.getRegcamp_host_hSeq());
		session.setAttribute("strcId", strRandom+dto.getRoSeq()+cId+dto.getRegcamp_regSeq()+dto.getRegcamp_host_hSeq());
	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String randomCharacter(int range) {
	    StringBuilder sb = new StringBuilder();
	    Random rd = new Random();

	    for(int i=0;i<range;i++){
	        sb.append((char)(rd.nextInt(26)+65));
	    }

	    return sb.toString();
	}
	
}

