package com.bootcamp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.client.dao.ReviewDao;
import com.bootcamp.client.dao.WishList_ViewDao;
import com.bootcamp.dto.WishList_ViewDto;
import com.bootcamp.dto.reviewDto;

public class WishList_View_Command implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		WishList_ViewDao dao = new WishList_ViewDao();
		
		
		ArrayList<WishList_ViewDto> dtos = dao.wishList_view((String)session.getAttribute("cId"));
		
	
		request.setAttribute("wishList_view", dtos);
			

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
