package com.bootcamp.host.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.dao.BookJoinDao;
import com.bootcamp.host.dao.HostBookPagingDao;
import com.bootcamp.joindto.BookListDto;

public class HostBookListCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		BookJoinDao bookJoinDao = new BookJoinDao();
		String hSeq = request.getParameter("hSeq");
		String strSearch = request.getParameter("strSearch");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		//선택한 페이지
		int page = Integer.parseInt(request.getParameter("page"));

		//한 페이지당 row 개수 지정
		int pageRow = 8;
		
		//페이지 시작점
		int startRow = pageRow * (page - 1);
		
		if(startDate == null) {
		
			//전체 row 개수
			int countRow = bookJoinDao.countRow("1");
			
			//총 페이지 개수
			int pageCount = (countRow / 8) + 1;
			request.setAttribute("pageCount", pageCount);
	
			ArrayList<BookListDto> dtos = bookJoinDao.list("1", startRow, pageRow);
	
			request.setAttribute("list", dtos);
			
		}else {
			
			System.out.println("blcommand else");
			ArrayList<BookListDto> dtos = bookJoinDao.bookListCon("1", startDate.replace("-", ""), endDate.replace("-", ""), strSearch, startRow, pageRow);
			request.setAttribute("list", dtos);
			
		}

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
