package com.bootcamp.homecontroller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.bootcamp.client.command.BCAskCommand;
import com.bootcamp.client.command.BCAskViewCommand;
import com.bootcamp.client.command.BCBookingConfirmationCommand;
import com.bootcamp.client.command.BCCalcDateCommand;
import com.bootcamp.client.command.BCCampDateCheckCommand;
import com.bootcamp.client.command.BCCampListCommand;
import com.bootcamp.client.command.BCClientHistory;
import com.bootcamp.client.command.BCCommand;
import com.bootcamp.client.command.BCDetailCommand;
import com.bootcamp.client.command.BCInsertBookCommand;
import com.bootcamp.client.command.BCInsertPayCommand;
//import com.bootcamp.client.command.BCSelectDateCommand;
import com.bootcamp.client.command.Clientdelete_Command;
import com.bootcamp.client.command.ClientfindId_Command;
import com.bootcamp.client.command.ClientfindPw_Command;
import com.bootcamp.client.command.Clientlogin_Command;
import com.bootcamp.client.command.Clientmodify_Command;
import com.bootcamp.client.command.ClientmypageView_Command;
import com.bootcamp.client.command.Clientwrite_Command;
import com.bootcamp.client.command.ListMain_Command;
import com.bootcamp.client.command.ReviewWriteCommand;
import com.bootcamp.client.command.ReviewerNameCommand;
import com.bootcamp.client.command.SearchCamp_Command;
import com.bootcamp.client.command.count_Command;
import com.bootcamp.client.command.BCViewBookingCommand;
import com.bootcamp.client.command.reviewDetailCommand;
import com.bootcamp.client.command.reviewListCommand;
import com.bootcamp.client.command.wish_delete_Command;
import com.bootcamp.client.command.wish_write_Command;
import com.bootcamp.client.dao.ClientDao;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			actionDo(request, response);
		} catch (ServletException | IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			actionDo(request, response);
		} catch (ServletException | IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		request.setCharacterEncoding("utf-8");

		String viewPage = null;
		BCCommand command = null;

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		switch (com) {

		// SangHyuk
		// 예약기본루틴 1. ListMain.do 코드 확인 시 타이핑을 줄이기 위해서 main.do로 수정함.
		case ("/main.do"):
			System.out.println("List Main");
			command = new ListMain_Command();
			command.execute(request, response);
			viewPage = "Home.jsp";
			break;
			
		// searchCamp.do 코드 확인 시 캠핑장을 검색어나 타입에 따라 검색하기 위한 메소드.
		case ("/searchCamp.do"):
			command = new SearchCamp_Command();
			command.execute(request, response);
			// Test를 위해 Home2.jsp로 출력하게 함.
			viewPage = "Home.jsp";
			break;

			// 예약기본루틴 2. 캠프장 선택 예약 페이지 예약 가능한 날짜 확인을 위한 날짜 체크 sanghyuk
		case("/booking.do"):
			System.out.println("List camp for Booking");
			command = new BCCampListCommand();
			command.execute(request, response);
			viewPage = "Calendar2.jsp";
			System.out.println("List camp End");
			break;
			// 예약기본루틴 3. 예약 가능한 방 리스트 보여주기 sanghyuk
			
		case("/bookingdatecheck.do"):
			System.out.println("Date Check for Booking");
			command = new BCCampDateCheckCommand();
			command.execute(request, response);
			viewPage = "Calendar3.jsp";
			System.out.println("Date Check for Booking End");
			break;
			
			// sql book table 에 insert 하는 command 이후수정될 여지 많음 
		case("/pay.do"):
			System.out.println("pay for Booking");
			command = new BCInsertPayCommand();
			command.execute(request, response);
			command = new BCInsertBookCommand();
			command.execute(request, response);
			viewPage = "bookingView.do";
			System.out.println(" controller case pay.do 에서 보내는 insert for Booking End");
			JOptionPane.showInternalMessageDialog(null, "예약이 완료되었습니다 ", "로그인", 0, null);
			break;			

		case("/bookingView.do"):
			System.out.println("view for Booking");
			command = new BCViewBookingCommand();
			command.execute(request, response);
			viewPage = "ViewBooking.jsp";
			System.out.println(" controller case bookingView.do 에서 보내는 select for bookingView End");
			break;	
			

			// 로그인
			//22-11-10 주현씨 수정함 
		case ("/login.do"):
			command = new Clientlogin_Command();
			command.execute1(request, response);
			String cId = request.getParameter("cId");
			String cPw = request.getParameter("cPw");

			ClientDao dao = new ClientDao();
			Boolean result = dao.login(cId, cPw);

			if (result == false) {
				JOptionPane.showInternalMessageDialog(null, "아이디와 비밀번호를 확인해주세요 ", "로그인", 0, null);
				viewPage = "ClientLoginView.jsp";
			} else {
				JOptionPane.showInternalMessageDialog(null, "환영합니다 ", "로그인", 0, null);
				// page = "ClientMainView.jsp";
				viewPage = "main.do";
			}
			break;

		// 회원등록
		case ("/Clientwrite.do"):
			command = new Clientwrite_Command();
			command.execute(request, response);
			viewPage = "ClientLoginView.jsp";
			break;
		// 마이페이지
		case ("/mypageView.do"):
			command = new ClientmypageView_Command();
			command.execute(request, response);
			viewPage = "ClientMypageView.jsp";
			break;
		// 수정하기
		case ("/ClientModify.do"):
			command = new Clientmodify_Command();
			command.execute(request, response);
			viewPage = "/main.do";
			break;
		// 삭제하기
		case ("/ClientDelete.do"):
			command = new Clientdelete_Command();
			command.execute(request, response);
			viewPage = "/ClientLoginView.jsp";
			break;
		// 아이디 찾기
		case ("/idsearch.do"):
			command = new ClientfindId_Command();
			command.execute(request, response);
			break;
		// 비밀번호 찾기
		case ("/pwsearch.do"):
			command = new ClientfindPw_Command();
			command.execute(request, response);
			break;

			
		// Hosik  ----------------------------------------------------------------
			// 상세 페이지 보기
		// 상세 페이지 보기
		case ("/detailView.do"):
			command = new BCDetailCommand();
			command.execute(request, response);
			System.out.println("controller Hosik detailVeiw execute check ");
			command = new reviewListCommand();
			System.out.println("controller Hosik reviewListCommand execute check ");
			command.execute(request, response);
			viewPage = "DetailView.jsp";
			break;
			
			
		case ("/confirmation.do"):
			command = new BCBookingConfirmationCommand();
			command.execute(request, response);
			command = new BCCalcDateCommand();
			command.execute(request, response);
			viewPage = "Booking.jsp";
			break;
			
			// 캠핑장에서 문의하기로 이동시켜주는 커맨드 
		case ("/askView.do"):
			command = new BCAskViewCommand();
			command.execute(request, response);
			viewPage = "ClientAsk.jsp";
			break;
			
			// 문의하는 페이지에서 문의등록 하는 커맨드 
		case ("/ask.do"):
			command = new BCAskCommand();
			command.execute(request, response);
			viewPage = "main.do";
			break;	
			
			// 문의하는 페이지에서 문의등록 하는 커맨드 
		case ("/history.do"):
			command = new BCClientHistory();
			command.execute(request, response);
			viewPage = "ClientCheckHistory.jsp";
			break;	
			
		// ———————————리뷰—————주현————————————

		// reviewList 상세 캠핑페이지에 보여주기
		case ("/reviewDetailView.do"):
			System.out.println("review detail");
			command = new reviewDetailCommand();
			command.execute(request, response);
			viewPage = "ClientReviewDetail.jsp";
			break;
		// review 사용자가 작성하러 가기
		case ("/writeReview.do"):
			System.out.println("review go to write");
			command = new BCDetailCommand();
			command.execute(request, response);
			command = new ReviewerNameCommand();
			command.execute(request, response);
			viewPage = "reviewWrite.jsp";
			break;
		// 작성한 리뷰 insert 하고 캠핑장 상세 페이지로 이동
		case ("/reviewWrite.do"):
			System.out.println("review write ");
			command = new ReviewWriteCommand();
			command.execute(request, response);
			viewPage = "/detailView.do";
			break;

		
			//--- HyunSuk ----------------------------------------------------------------
//		case ("/Review_List.do"):
//			   command = new Review_List_Command();
//			   command.execute(request, response);
//			   viewPage = "Review_List.jsp";
//			   break;
			 //위시리스트 등록
			
			
		   
		case ("/wish_write.do"): //wish리스트에 등록
			command = new wish_write_Command();
		command.execute(request, response);
		  break; //위시리스트 등록
		  
		  
		  
		case ("/wish_delete.do")://wish리스트에서 삭제
			command = new wish_delete_Command();
		command.execute(request, response);
		break;//위시리스트 삭제

		
		case ("/count.do"): // 먼저 wish리스트에 해당 캠핑장이 등록되어 있는지 확인
			   command = new count_Command();
			  Boolean check = command.execute1(request, response);
			   
			  	//만약 wish리스트에 등록이 되어있지 않다면 check값이 false가 되어 등록이 됨
				if (check == false) {
					JOptionPane.showInternalMessageDialog(null, "위시리스트에 등록됐습니다.", "위시리스트", 0, null);
					viewPage = "wish_write.do";
				} else {//만ㅇ냑 wish리스트에 등록이 되어있으면 check값이 true가 되어 삭제가 됨
					JOptionPane.showInternalMessageDialog(null, "위시리스트에서 삭제되었습니다 ", "위시리스트", 0, null);
					viewPage = "wish_delete.do";
				}
				break;// 위시리스트에 있는지 없는지 확인 후 등록 or 삭제 결정
			
		}// switch End

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}// End
