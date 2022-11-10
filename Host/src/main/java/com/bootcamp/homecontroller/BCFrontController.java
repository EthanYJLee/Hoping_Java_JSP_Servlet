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
import com.bootcamp.host.command.HImageCommand;
import com.bootcamp.host.command.HInfoCommand;
import com.bootcamp.host.command.HInfoInsertCommand;
import com.bootcamp.host.command.HostBookListCommand;
import com.bootcamp.host.command.HostBookSearchCommand;
import com.bootcamp.host.command.HostCampNameList_Command;
import com.bootcamp.host.command.HostCampProfileList_Command;
import com.bootcamp.host.command.HostInfoFaInDelCommand;
import com.bootcamp.host.command.HostInfoFaSelectCommand;
import com.bootcamp.host.command.HostInfoKeyInDelCommand;
import com.bootcamp.host.command.HostInfoKeySelectCommand;
import com.bootcamp.host.command.HostInfoLMoCommand;
import com.bootcamp.host.command.HostInfoLSelectCommand;
import com.bootcamp.host.command.HostInfoNCTMoCommand;
import com.bootcamp.host.command.HostInfoNCTSelectCommand;
import com.bootcamp.host.command.HostMainReservationStatus_Command;
import com.bootcamp.host.command.HostMonthlyProfit_Command;
import com.bootcamp.host.command.HostMonthlyReservation_Command;
import com.bootcamp.host.command.HostReviewContentView_Command;
import com.bootcamp.host.command.HostReviewList_Command;
import com.bootcamp.host.command.HostSendReviewReply_Command;
import com.bootcamp.host.command.HostTermsAD;
import com.bootcamp.host.command.MyHostBookDetailCommand;
import com.bootcamp.host.command.RegCampCommand;
import com.bootcamp.host.command.RegCampRoomCommand;
import com.bootcamp.host.command.askDetailCommand;
import com.bootcamp.host.command.askListCommand;

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

		// --------------------주현: 약관동의 후 호스트 가입(호스트 정보 insert)--------------------

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

		case ("/host_main.do"):
			command = new HostCampProfileList_Command();
		case ("/regcamp.do"):
			System.out.println("Controller regcamp.do");
			command = new RegCampCommand();
			command.execute(request, response);
			// 자리 지정 페이지로 가야되지만 아직 완성물이 없어서 우선 메인페이지로 이동
			viewPage = "HostMain.jsp";
			break;

		// ---------------------영진: 메인페이지 -----------------------------------


			
			
		case ("/host_main.do"): // 로그인 화면에서 => host_main.do?hSeq= 로 이동할 예정임
		         command = new HostCampProfileList_Command(); // 호스트 소유 모든 캠핑장의 이름, 사진, 주소 (썸네일용)
		         command.execute(request, response);
		         command = new HostMonthlyProfit_Command(); // 월별 총수익 차트에 표시 (올해분)
		         command.execute(request, response);
		         command = new HostMonthlyReservation_Command(); // 월별 총예약건수 차트에 표시 (올해분)
		         command.execute(request, response);
		         command = new HostMainReservationStatus_Command(); // 오늘의 신규 예약건수, 올해 체크인/체크아웃 예정건수
		         command.execute(request, response);
		         viewPage = "HostMain.jsp";
		         break;

		      case ("/host_review_list.do"):
		         command = new HostReviewList_Command(); // 호스트 소유 캠핑장에 달린 리뷰의 리스트
		         command.execute(request, response);

		         command = new HostCampNameList_Command(); // 호스트 소유 캠핑장 이름 리스트 (검색을 위한 콤보박스용)
		         command.execute(request, response);

		         viewPage = "HostReviewList.jsp";
		         break;

		      case ("/host_review_content_view.do"):
		         command = new HostReviewContentView_Command(); // 리뷰 정보 (작성자, 제목, 내용 등등) 받아오기
		         command.execute(request, response);
		         viewPage = "HostReviewContentView.jsp";
		         break;

		      case ("/send_review_reply.do"):
		         command = new HostSendReviewReply_Command(); // 호스트가 후기에 작성한 답글 insert하고 댓글 그룹 업데이트
		         command.execute(request, response);
		         viewPage = "/host_review_list.do";
		         break;

		      

		// --------------------------호스트 마이페이지에 정보 불러오기--------------------------

		// --------------------------주현 : 고객문의 리스트 페이지--------------------------
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

		// 정보 수정 메인페이지 열기
		case ("/HostRInfo.do"):
			viewPage = "HostInfoMMain.jsp";
			break;
			
			
		// ------------예진 : 캠핑장 정보수정 페이지 ------------------------------------
		// 정보 수정 메인페이지에서 위치, 설명 수정 페이지로
		case ("/HostInfoMLoView.do"):
			command = new HostInfoLSelectCommand();
			command.execute(request, response);
			viewPage = "HostInfoMLo.jsp";
			break;

		// 위치, 설명 수정
		case ("/HostInfoMLo.do"):
			command = new HostInfoLMoCommand();
			command.execute(request, response);
			viewPage = "HostInfoMMain.jsp";
			break;

		// 정보 수정 메인페이지에서 이름, 카테고리, 전화번호 수정 페이지로
		case ("/HostInfoMNCTView.do"):
			command = new HostInfoNCTSelectCommand();
			command.execute(request, response);
			viewPage = "HostInfoMNameCategoryTel.jsp";
			break;

		// 이름, 카테고리, 전화번호 수정
		case ("/HostInfoMNCT.do"):
			command = new HostInfoNCTMoCommand();
			command.execute(request, response);
			viewPage = "HostInfoMMain.jsp";
			break;

		// 정보 수정 메인페이지에서 키워드 수정 페이지로
		case ("/HostInfoKeyView.do"):
			command = new HostInfoKeySelectCommand();
			command.execute(request, response);
			viewPage = "HostInfoMKeyword.jsp";
			break;

		// 키워드 삭제와 인서트
		case ("/HostInfoKeyInDel.do"):
			command = new HostInfoKeyInDelCommand();
			command.execute(request, response);
			viewPage = "HostInfoMMain.jsp";
			break;

		// 정보 수정 메인페이지에서 키워드 수정 페이지로
		case ("/HostInfoFaciView.do"):
			command = new HostInfoFaSelectCommand();
			command.execute(request, response);
			viewPage = "HostInfoMFacility.jsp";
			break;

		// 키워드 삭제와 인서트
		case ("/HostInfoFaInDel.do"):
			command = new HostInfoFaInDelCommand();
			command.execute(request, response);
			viewPage = "HostInfoMMain.jsp";
			break;

		}

	RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);dispatcher.forward(request,response);
}}
