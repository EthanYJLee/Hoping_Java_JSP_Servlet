package com.bootcamp.host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.BookJoinDao;
import com.bootcamp.host.dao.HostBookPagingDao;

public class HostBookTotalPagingCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HostBookPagingDao dao = new HostBookPagingDao();
		
		String hSeq = request.getParameter("hSeq");
		String strSearch = request.getParameter("strSearch");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		System.out.println(startDate);
		System.out.println(strSearch);
		
		if(startDate != null) {
			
			strSearch = "";		
			//전체 row 개수
			int countRow = dao.countRow("1", strSearch, startDate, endDate);
			
			System.out.println("strSearch: " +strSearch);
			
			//총 페이지 개수
			int pageCount = (countRow / 10) +1;
			request.setAttribute("pageCount", pageCount);
			
		}else {
			
			BookJoinDao bookJoinDao = new BookJoinDao();
			int countRow = bookJoinDao.countRow("1");
				System.out.println("countRow: " +countRow);
			int pageCount = (countRow / 10) + 1;
				System.out.println("pageCount: " +pageCount);
			request.setAttribute("pageCount", pageCount);
		}
		
		
	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
