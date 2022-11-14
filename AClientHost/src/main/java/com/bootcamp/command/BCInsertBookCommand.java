package com.bootcamp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.client.dao.CampDao;

public class BCInsertBookCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
						System.out.println("BCInsertBookCommand______________________________________________________");
	
		String startdate = (String)session.getAttribute("STARTDATE");
		String startdate2 = request.getParameter("startdate");
						System.out.println("1.startdate:"+startdate);
						System.out.println("1-2.startdate2:"+startdate2);
		String stopdate = (String)session.getAttribute("STOPDATE");
						System.out.println(stopdate);
		String cId = (String)session.getAttribute("CID");
		/*
		System.out.println("2.cId:"+cId);
		String cId2 = (String)session.getAttribute("CID");
						System.out.println("2-1.cId2:"+cId2);
		String cId3 = (String)request.getAttribute("cId");
						System.out.println("2-1.cId3:"+cId3);
		*/
		String roPrice = (String)session.getAttribute("ROPRICE");
		String roPrice2 =request.getParameter("roPrice");
		System.out.println("3.request:roPrice:"+request.getAttribute("roPrice"));
		System.out.println("4.session:roPrice:"+session.getAttribute("ROPRICE"));
		System.out.println("roPrice2 리퀘스트 파라미터"+roPrice2);
		System.out.println("5.session:roNum:"+session.getAttribute("RONUM"));
		String roNum = (String)session.getAttribute("RONUM");
		String regSeq = (String)session.getAttribute("REGSEQ");
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
		int regcamp_host_hSeq = (int)session.getAttribute("REGCAMP_HOST_HSEQ");
		System.out.println("7.5.-------------------Integer.parseInt(regcamp_host_hSeq):"+regcamp_host_hSeq+"-------------------");		
		int roSeq = (int)session.getAttribute("ROSEQ");
		System.out.println("7.6.-------------------Integer.parseInt(roSeq):"+roSeq+"-------------------");
		String strcId = (String)session.getAttribute("STRCID");
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
				for(int i=1; i<intdiff;i++) {
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
				}//for end
			}//if intdiff >1 end 
		}//if(result ==1 end 
	}//excute end 

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}//class end 

