package com.bootcamp.client.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.client.dao.CampDao;

public class BCInsertBookCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		System.out.println("BCInsertBookCommand");
	
		String startdate = (String)session.getAttribute("startdate");		
		String stopdate = (String)session.getAttribute("stopdate");
		String cId = (String)session.getAttribute("cId");
		int boPrice = (int) request.getAttribute("boPrice");
		
		System.out.println(cId);
		System.out.println(boPrice);
		System.out.println("BCInsertBookCommand ------");

		// InputBook 의 Dao 를 생성함.  		
		CampDao dao = new CampDao();
		// 체크인 날짜와 체크 아웃 날짜의 날 수를 계산.
		int intdiff = dao.diffDate(startdate, stopdate);
		System.out.println("intdiff:"+intdiff+":");
		// 체크인 날짜의 예약을 추가한다.
		dao.insertBook(boPrice, startdate, 0, 3, cId, 1);
		// 체크인 날짜의 예약의 Seq를 읽어온다.
		int maxBookSeq = dao.readMaxSeq();
		System.out.println("maxBookSeq"+maxBookSeq);
		// boGroup 의 
		dao.updateBook(maxBookSeq);
				
		// 예약 날짜가 하루 이상이면
		if (intdiff > 1) {
			// 체크인 날짜 다음 날짜를 구한다.
			String nextdate = dao.Nextday(startdate);
			// boPrice(가격정보), boCheckindate(체크인 날짜), boGroup(예약그룹의 Seq Number), boCount(예약인원), Client Id,intdiff(예약한기간)ß, regcap의 regSeq, HostSeq
			for(int i=0; i<intdiff;i++) {
				// 다음 체크인 날짜의 예약을 추가한다.
				dao.insertBook(boPrice, nextdate, maxBookSeq, 3, cId, 1);
				// 체크인 날짜 다음 날짜를 구한다.
				nextdate = dao.Nextday(nextdate);
			}
		}
	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}

