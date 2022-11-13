package com.bootcamp.client.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.client.dao.CampDao;

public class BCInsertBookCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		System.out.println("BCInsertBookCommand______________________________________________________");
	
		String startdate = (String)session.getAttribute("startdate");
		System.out.println("1."+startdate);
		String stopdate = (String)session.getAttribute("stopdate");
		System.out.println(stopdate);
		String cId = (String)session.getAttribute("cId");
		System.out.println("2."+cId);
		String roPrice = (String)session.getAttribute("roPrice");
		System.out.println("3.request:roPrice:"+request.getAttribute("roPrice"));
		System.out.println("4.session:roPrice:"+session.getAttribute("roPrice"));
		System.out.println("5.session:roNum:"+session.getAttribute("roNum"));
		String roNum = (String)session.getAttribute("roNum");
		String regSeq = (String)session.getAttribute("regSeq");
		// InputBook 의 Dao 를 생성함.  		
		CampDao dao = new CampDao();
		// 체크인 날짜와 체크 아웃 날짜의 날 수를 계산.
		int intdiff = dao.diffDate(startdate, stopdate);
		System.out.println("6.intdiff:"+intdiff+":");
		// 체크인 날짜의 예약을 추가한다.
		System.out.println("7.roPrice:"+roPrice+":");
		int roomPrice = dao.readRoomPrice(regSeq, roNum);
		System.out.println("7.1.-------------------roomPrice:"+roomPrice+"-------------------");
		System.out.println("7.2.-------------------startdate:"+startdate+"-------------------");
		System.out.println("7.3.-------------------cId:"+cId+"-------------------");
		System.out.println("7.4.-------------------regSeq:"+regSeq+"-------------------");
		int regcamp_host_hSeq = (int)session.getAttribute("regcamp_host_hSeq");
		System.out.println("7.5.-------------------Integer.parseInt(regcamp_host_hSeq):"+regcamp_host_hSeq+"-------------------");		
		int roSeq = (int)session.getAttribute("roSeq");
		System.out.println("7.6.-------------------Integer.parseInt(roSeq):"+roSeq+"-------------------");
		String strcId = (String)session.getAttribute("strcId");
		System.out.println("7.7.-------------------strcId:"+strcId+"-------------------");
		int result = dao.insertBook(roomPrice, startdate, 0, 3, strcId, roSeq, cId,Integer.parseInt(regSeq), regcamp_host_hSeq);
		System.out.println("7.8.-----dao.insertBook(roomPrice, startdate, 0, 3, strcId, Integer.parseInt(regSeq), cId, Integer.parseInt(regSeq), Integer.parseInt(host_hSeq))result:"+result+"-------------------");
		if (result == 1) {
			// 체크인 날짜의 예약의 Seq를 읽어온다.
			int maxBookSeq = dao.readMaxSeq();
			System.out.println("8.maxBookSeq:"+maxBookSeq+":");
			// boGroup 의 
			dao.updateBook(maxBookSeq);				
			// 예약 날짜가 하루 이상이면
			if (intdiff > 1) {
				// 체크인 날짜 다음 날짜를 구한다.
				String nextdate = dao.Nextday(startdate);
				// boPrice(가격정보), boCheckindate(체크인 날짜), boGroup(예약그룹의 Seq Number), boCount(예약인원), Client Id,intdiff(예약한기간), regcamp의 regSeq, HostSeq
				for(int i=0; i<intdiff;i++) {
					// 다음 체크인 날짜의 예약을 추가한다.
					System.out.println("9.-------------------roomPrice:"+roomPrice+"-------------------");
					System.out.println("9.-------------------nextdate:"+nextdate+"-------------------");
					System.out.println("9.-------------------maxBookSeq:"+maxBookSeq+"-------------------");					
					System.out.println("9.-------------------cId:"+cId+"-------------------");
					System.out.println("9.-------------------roSeq:"+roSeq+"-------------------");
					System.out.println("9.-------------------Integer.parseInt(regSeq):"+Integer.parseInt(regSeq)+"-------------------");
					System.out.println("9.-------------------regcamp_host_hSeq:"+regcamp_host_hSeq+"-------------------");	
					System.out.println("9.-------------------strcId:"+strcId+"-------------------");
					dao.insertBook(roomPrice, nextdate, maxBookSeq, 3, strcId, roSeq,cId,Integer.parseInt(regSeq), regcamp_host_hSeq);
					// 체크인 날짜 다음 날짜를 구한다.
					nextdate = dao.Nextday(nextdate);
				}
			}
		}
	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}

