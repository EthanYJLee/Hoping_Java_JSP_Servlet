package com.bootcamp.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.host.command.AskCommentCommand;
import com.bootcamp.host.command.BCCommand;
import com.bootcamp.host.command.HFileViewCommand;
import com.bootcamp.host.command.HImageCommand;
import com.bootcamp.host.command.HInfoCommand;
import com.bootcamp.host.command.HInfoInsertCommand;
import com.bootcamp.host.command.HostBookListCommand;
import com.bootcamp.host.command.HostBookSearchCommand;
import com.bootcamp.host.command.HostCampNameList_Command;
import com.bootcamp.host.command.HostCampProfileList_Command;
import com.bootcamp.host.command.HostReviewContentView_Command;
import com.bootcamp.host.command.HostReviewList_Command;
import com.bootcamp.host.command.HostSendReviewReply_Command;
import com.bootcamp.host.command.HostTermsAD;
import com.bootcamp.host.command.MyHostBookDetailCommand;
import com.bootcamp.host.command.RegCampCommand;
import com.bootcamp.host.command.askDetailCommand;
import com.bootcamp.host.command.askListCommand;
import com.bootcamp.host.command.listCommand;

/**
 * Servlet implementation class homeController
 */
@WebServlet("*.do")
public class BCFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public BCFrontController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String viewPage = null;
		BCCommand command = null;

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		switch (com) {

		// --------------------약관동의 후 호스트 가입(호스트 정보 insert)--------------------

		case ("/show.do"):
			command = new HInfoCommand();
			command.execute(request, response);
			viewPage = "hostJoin.jsp";
			break;

		// 호스트에 인서트
		case ("/insert.do"):
			command = new HInfoInsertCommand();
			command.execute(request, response);
			viewPage = "uploadImage.jsp";
			break;
		// 호스트 이미지 넣기
		case ("/fileUp.do"):
			command = new HImageCommand();
			command.execute(request, response);
			viewPage = "fileShow.jsp";
			break;

		// ---------------------상준 : 캠핑장 등록 -----------------------------------

		case ("/regcamp.do"):
			System.out.println("Controller regcamp.do");
			command = new RegCampCommand();
			command.execute(request, response);
			// 자리 지정 페이지로 가야되지만 아직 완성물이 없어서 우선 메인페이지로 이동
			viewPage = "HostMain.jsp";
			break;

		// ---------------------영진: 메인페이지 -----------------------------------

		case ("/host_main.do"):
			command = new HostCampProfileList_Command();
			command.execute(request, response);
			viewPage = "HostMain.jsp";
			break;

		case ("/host_review_list.do"):
			command = new HostReviewList_Command();
			command.execute(request, response);

			command = new HostCampNameList_Command();
			command.execute(request, response);

			viewPage = "HostReviewList.jsp";
			break;

		case ("/host_review_content_view.do"): // 리뷰 정보 (작성자, 제목, 내용 등등) 받아오기
			command = new HostReviewContentView_Command();
			command.execute(request, response);
			viewPage = "HostReviewContentView.jsp";
			break;

		case ("/send_review_reply.do"):
			command = new HostSendReviewReply_Command();
			command.execute(request, response);
			viewPage = "/host_review_list.do";
			break;

		// --------------------------호스트 마이페이지에 정보 불러오기--------------------------

		// --------------------------고객문의 리스트 페이지--------------------------
		case ("/askList.do"):
			command = new askListCommand();
			command.execute(request, response);
			viewPage = "askList.jsp";
			break;
		case ("/askDetail.do"):
			command = new askDetailCommand();
			command.execute(request, response);
			viewPage = "AskDetail.jsp";
			break;
		case ("/aComment.do"):
			command = new AskCommentCommand();
			command.execute(request, response);
			viewPage = "AskDetail.jsp";
			break;

		// ------------예진 : 예약 리스트 페이지 열기 ------------------------------------
		case ("/bookList.do"):
			command = new HostBookListCommand();
			command.execute(request, response);
			viewPage = "HostTotalBookManage.jsp";
			break;

		// 예약 리스트 테이블에서 row 클릭시 디테일 페이지
		case ("/YJHostBookDetail.do"):
			command = new MyHostBookDetailCommand();
			command.execute(request, response);
			viewPage = "YJHostBookDetail.jsp";
			break;

		// 예약 리스트 페이지에서 검색
		case ("/bookSearch.do"):
			command = new HostBookSearchCommand();
			command.execute(request, response);
			viewPage = "HostTotalBookManage.jsp";
			break;

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
