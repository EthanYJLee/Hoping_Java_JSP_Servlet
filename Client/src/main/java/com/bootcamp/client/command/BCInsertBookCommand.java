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

/*		
 * 삭제할 문장 필요한 정보를 확인하기 위해서 SQL문을 체크중
 
		String query = "insert into book (boPrice, boDate, boCheckindate, boGroup, boCount, ";
		String query2 = "pay_cid, pay_room_roseq, pay_room_regcamp_regSeq, pay_room_regcamp_host_hSeq, ";
		String query3 = "pay_client_cid ) values (?,now(),?,?,?,?,?,?,?,?,?)";
*/		
		System.out.println("BCInsertBookCommand ------");
// InputBook 		
		
		CampDao dao = new CampDao();
		
		int maxBookSeq = dao.readMaxSeq(); // 마지막 날짜를불러 와줌 
		System.out.println("maxBookSeq"+maxBookSeq);
		int intdiff = dao.diffDate(startdate, stopdate); // 시작, 끝 날자 비교해서 일수계산 +1까지 포함되서 return 됨 
		System.out.println("intdiff"+intdiff);
		//Calendar cal = Calendar.getInstance();
		

		dao.insertBook(80000, "2022-11-11", maxBookSeq+1, 3, "kevininthewood", intdiff, 1);
		//request.setAttribute("Camp", dtos);
		
/*
 * searchSiteView(가격, 캠핑장 관련 위치 정보)
searchRegCampImageView(캠핑장 이미지)
searchCampWish(찜관련 정보)
searchReview(별점 읽어오기)
searchReviewCount(후기 갯수 읽어오기)
 * 		
 */
		
	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}

