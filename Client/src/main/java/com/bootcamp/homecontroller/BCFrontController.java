package com.bootcamp.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.client.command.BCCommand;
import com.bootcamp.client.command.BCDetailCommand;
import com.bootcamp.client.command.ListMain_Command;
import com.bootcamp.client.command.SearchCamp_Command;


/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
public class BCFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BCFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request,response);

	}

	
	private void actionDo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String viewPage = null;
		BCCommand command = null;
		
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		switch (com) {
		
		
		
		
		
		 // SangHyuk
		// ListMain.do 코드 확인 시 타이핑을 줄이기 위해서 main.do로 수정함.
		case ("/main.do"):
			System.out.println("List Main");
			command = new ListMain_Command();
			command.execute(request, response);
			viewPage = "Home.jsp";
			//viewPage = "Home.jsp";
			break;
		// searchCamp.do 코드 확인 시 캠핑장을 검색어나 타입에 따라 검색하기 위한 메소.
		case ("/searchCamp.do"):
			command = new SearchCamp_Command();
			command.execute(request, response);
			// Test를 위해 Home2.jsp로 출력하게 함.
			viewPage = "Home.jsp";
			break;


		// 로그인
		case ("/login.do"):
			command = new Clientlogin_Command();
			command.execute(request, response);
			break;
		// 회원등록
		case ("/Clientwrite.do"):
			command = new Clientwrite_Command();
			command.execute(request, response);
			viewPage = "login.jsp";
			break;
		// 마이페이지
		case ("/mypageView.do"):
			command = new ClientmypageView_Command();
			command.execute(request, response);
			viewPage = "mypage.jsp";
			break;
		// 수정하기
		case ("/ClientModify.do"):
			command = new Clientmodify_Command();
			command.execute(request, response);
			viewPage = "/main.jsp";
			break;
		// 삭제하기
		case ("/ClientDelete.do"):
			command = new Clientdelete_Command();
			command.execute(request, response);
			viewPage = "/login.jsp";
			break;
//		case ("/checkId.do"):
//			command = new Checkid_Command();
//			command.execute(request, response);
//			break;
		}



		
		// Hosik
			// 상세 페이지 보기 
		case("/detailView.do"):
			System.out.println("View Detail");
			command = new BCDetailCommand();
			command.execute(request, response);
			viewPage = "DetailView.jsp";
			System.out.println("View Detail End");
			break;

		
		
		
		}// switch End
		
				



		}
				

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request,response);
	}
}// End
