package com.bootcamp.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.dto.regroomDto;
import com.bootcamp.host.dao.HRegCampDao;

public class ListCampRoomCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HRegCampDao dao = new HRegCampDao();
		ArrayList<regroomDto> dtos = dao.camproomlist();
		request.setAttribute("roomlist", dtos);
		System.out.println(dtos);
	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}

}
