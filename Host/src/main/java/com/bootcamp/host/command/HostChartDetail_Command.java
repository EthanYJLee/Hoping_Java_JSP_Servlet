package com.bootcamp.host.command;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.host.dao.HostStatisticDao;
import com.bootcamp.joindto.DetailStatDto;

public class HostChartDetail_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		int hSeq = (int)session.getAttribute("HSEQ");
		
		HostStatisticDao dao = new HostStatisticDao();
		ArrayList<DetailStatDto> dtos = dao.allStatDataView(hSeq);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date min = dtos.get(0).getBoDate();
		String mindate = simpleDateFormat.format(min);
		Date max = dtos.get((dtos.size()-1)).getBoDate();
		String maxdate = simpleDateFormat.format(max);
		
		request.setAttribute("STATLIST", dtos);
		request.setAttribute("MINDATE", mindate);
		request.setAttribute("MAXDATE", maxdate);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
