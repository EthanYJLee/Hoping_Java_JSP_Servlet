package com.bootcamp.homecontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.bootcamp.command.*;
import com.bootcamp.dto.HostRegcampDto;
import com.bootcamp.host.dao.HInfoDao;
import com.bootcamp.host.dao.HostCheckDao;
import com.bootcamp.host.dao.HostRegDDao;
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
		HttpSession session = request.getSession();
		
		
		switch (com) {

		case ("/check.do"):

			command = new ClientToHostCommand();
			command.execute(request, response);
			command = new ClientToHostCommand();
			Boolean Result = command.execute1(request, response);
			
			System.out.println("clientcontroller: " + Result);
			if (Result == true) {
				viewPage = "/host_main.do";
			} else {
				viewPage = "/term.do";
			}
			break;

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
		case ("/booking.do"):
			System.out.println("List camp for Booking");
			command = new BCCampListCommand();
			command.execute(request, response);
			viewPage = "Calendar2.jsp";
			System.out.println("List camp End");
			break;
		// 예약기본루틴 3. 예약 가능한 방 리스트 보여주기 sanghyuk

		case ("/bookingdatecheck.do"):
			System.out.println("Date Check for Booking");
			command = new BCCampDateCheckCommand();
			command.execute(request, response);
			viewPage = "Calendar3.jsp";
			System.out.println("Date Check for Booking End");
			break;

		// sql book table 에 insert 하는 command 이후수정될 여지 많음
		case ("/pay.do"):
			System.out.println("pay for Booking");
			command = new BCInsertPayCommand();
			command.execute(request, response);
			System.out.println("insert for Booking");
			command = new BCInsertBookCommand();
			command.execute(request, response);
			viewPage = "bookingView.do";
			System.out.println(" controller case pay.do 에서 보내는 insert for Booking End");
			JOptionPane.showInternalMessageDialog(null, "예약이 완료되었습니다 ", "로그인", 0, null);
			break;

		case ("/bookingView.do"):
			System.out.println("view for Booking");
			command = new BCViewBookingCommand();
			command.execute(request, response);
			viewPage = "ViewBooking.jsp";
			System.out.println(" controller case bookingView.do 에서 보내는 select for bookingView End");
			break;

		// 로그인
		// 22-11-10 주현씨 수정함
		case ("/login.do"):
			command = new Clientlogin_Command();
			boolean result = command.execute1(request, response);
			//homecontroller host랑 client랑 합칠 때 겹치는 변수명 있어서 바꿈요 (cId>>cId4)
//			String cId4 = request.getParameter("cId");
//			String cPw = request.getParameter("cPw");
//
//			ClientDao dao = new ClientDao();
//			Boolean result = dao.login(cId4, cPw);

			if (result == false) {
				request.setAttribute("RESULT", result);
//				JOptionPane.showInternalMessageDialog(null, "아이디와 비밀번호를 확인해주세요 ", "로그인", 0, null);
				viewPage = "ClientLoginView.jsp";
			} else {

				//JOptionPane.showInternalMessageDialog(null, "환영합니다 ", "로그인", 0, null);

				// page = "ClientMainView.jsp";
				viewPage = "main.do";
			}
			break;

		//logout
		case("/ClientLogout.do"):
			session.invalidate();
			viewPage = "ClientLoginView.jsp";
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

		// // ------------호식 : 상세페이지, 문의하기 ------------------------------------
			
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

		// --- HyunSuk ----------------------------------------------------------------
//		case ("/Review_List.do"):
//			   command = new Review_List_Command();
//			   command.execute(request, response);
//			   viewPage = "Review_List.jsp";
//			   break;

			
			//wishList 등록 삭제 리스트
			
			case ("/wishList_View.do"):
				command = new WishList_View_Command();
				command.execute(request, response);
				viewPage = "WishList_view.jsp";
				break; 
					
					
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
			
			
			
			
		// --------------------주현: 약관동의 후 호스트 가입(호스트 정보 insert)--------------------

		// 약관보여주기
		case ("/term.do"):
			viewPage = "HostTerms.jsp";
			break;
		// 약관 동의/비동의
		case ("/termsAD.do"):
			command = new HostTermsADCommand();
			Boolean check2 = command.execute1(request, response);

			if (check2 == true) {
				viewPage = "TermsAgree.jsp";
			} else {
				// 나중에 클라이언트랑 연결되면 client 메인페이지로 이동
				viewPage = "main.do"; // 22-11-14 Hosik . list.jsp 있던거 #으로 바꿔놈

			}

			break;
		// 호스트 가입 (client 정보 >> host 테이블에 insert)
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
			System.out.println("사진 인서트 controller");
			command = new HImageCommand();
			command.execute(request, response);
			viewPage = "fileShow.jsp";
			break;

		// ——————————주현: 마이페이지 정보 수정(호스트 정보 update)——————————

		// 마이페이지 내정보 불러오기
		case ("/myPage.do"):
			command = new HmyInfoCommand();
			command.execute(request, response);
			command = new HImageCommand();
			command.execute(request, response);
			viewPage = "HostmyPage.jsp";
			break;
		// 마이페이지 내정보 수정
		case ("/modify.do"):
			command = new HmyInfoModifyCommand();
			command.execute(request, response);
			command = new HmyInfoCommand();
			command.execute(request, response);
			viewPage = "HostmyPage.jsp";
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
			command = new HostCampProfileList_Command(); // 호스트 소유 모든 캠핑장의 이름, 사진, 주소 (썸네일용)
			command.execute(request, response);
			command = new HostMonthlyProfit_Command(); // 월별 총수익 차트에 표시 (올해분)
			command.execute(request, response);
			command = new HostMonthlyReservation_Command(); // 월별 총예약건수 차트에 표시 (올해분)
			command.execute(request, response);
			command = new HostMainReservationStatus_Command(); // 오늘의 신규 예약건수, 올해 체크인/체크아웃 예정건수
			command.execute(request, response);
			command = new HostMainInquiryStatus_Command();
			command.execute(request, response);
			command = new HostMainReviewStatus_Command();
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
			viewPage = "host_review_list.do";
			break;

		case ("/host_login.do"): // 호스트용 로그인 화면 (임시용임!!!)
			viewPage = "HostLogin.jsp";
			break;

		case ("/host_check.do"):
			//homecontroller host랑 client랑 합칠 때 겹치는 변수명 있어서 바꿈요 (cPw>>cPw1)
			String cId = request.getParameter("cId");
			String cPw1 = request.getParameter("cPw");
			String hId = null;
			HostCheckDao dao3 = new HostCheckDao();
			int hSeq = dao3.checkHostLogin(cId, cPw1);
			if (hSeq != 0) {
				hId = cId;
				
				session.setAttribute("HID", hId);
				session.setAttribute("HSEQ", hSeq);
				viewPage = "host_main.do";
			} else {
				viewPage = "HostError.jsp";
			}
			break;

		case ("/host_modify_camp.do"):
			// 호스트 통합 메인 페이지에서 캠핑장 정보 수정 버튼 클릭시 hSeq와 regName 받아오기
			
			int myHSeq = (int) session.getAttribute("HSEQ");
			int myRegSeq = Integer.parseInt(request.getParameter("regSeq"));
			HostCheckDao myCamp = new HostCheckDao();
			int result1 = myCamp.checkHostCampInfoForMod(myHSeq, myRegSeq);

			if (result1 != 0) {
				session.setAttribute("REGSEQ", myRegSeq);
				viewPage = "HostRInfo.do";
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 접근입니다", "Error", JOptionPane.ERROR_MESSAGE);
				response.sendRedirect("HostError.jsp");
			}
			break;

		case ("/host_confirm_delete.do"): // 캠핑장 최종삭제 전 확인절차
			// 남은 예약이 있으면 삭제 불가
			//주현:HttpSession case문 밖으로 보내고 session 이름통일시킴 delsession>>>session
			
			int regSeq = (int) session.getAttribute("REGSEQ");
			HostRegDDao chkBook = new HostRegDDao();
			HostRegcampDto dto = chkBook.checkRemainingReservation(regSeq);
			if (dto == null) {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('남은 체크인 예정이 있는지 확인해주세요'); location.href='host_main.do'; </script>");
				out.flush();
			} else {
				request.setAttribute("CHECKDELETE", dto);
				viewPage = "HostMakeSureToDelete.jsp";
			}
			break;

		case ("/host_delete_camp.do"): // 캠핑장 정보 최종 삭제 (update regDdate=now())
			command = new HostDeleteMyCamp_Command();
			command.execute(request, response);
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('삭제되었습니다'); location.href='host_main.do'; </script>");
			out.flush();
			viewPage = "host_main.do";
			break;

		case ("/detail_stat_view.do"): // 차트 상세 (모든 캠핑장)
			command = new HostChartDetail_Command();
			command.execute(request, response);
			viewPage = "HostDetailStatView.jsp";
			break;

		// --------------------------호스트 마이페이지에 정보 불러오기--------------------------

		// --------------------------주현 : 고객문의 리스트 페이지--------------------------
		case ("/askList.do"):
			command = new askListCommand();
			command.execute(request, response);
//				command = new askListCommand();
//				command.execute1(request, response);
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
			viewPage = "askList.do";
			break;

		// ------------예진 : 예약 리스트 페이지 ------------------------------------
		// 예약 리스트 페이지 열기
		case ("/bookList.do"):
			command = new HostBookTotalPagingCommand();
			command.execute(request, response);
			viewPage = "bookList2.do?page=1";
			break;

		// 예약 리스트 페이지 열기
		case ("/bookList2.do"):
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

		// ------------예진 : 캠핑장 추가 페이지 ------------------------------------

		// 메뉴에서 등록 페이지로
		// 이름, 설명, 카테고리 등록
		case ("/campingAdd.do"):
			viewPage = "CampingAdd.jsp";
			break;

		// 이름, 설명, 카테고리 등록하고 -> 편의시설 등록 페이지로 이동

		case ("/campingAddLo.do"):
			command = new CampingAddCommand();
			command.execute(request, response);
			viewPage = "CampingAddFa.jsp";
			break;

		// 편의시설 등록 -> 키워드 등록 페이지로 이동

		case ("/campingAddFa.do"):
			command = new CampingAddFaCommand();
			command.execute(request, response);
			viewPage = "CampingAddKey.jsp";
			break;

		// 키워드 등록 -> 약도 등록 페이지

		case ("/campingAddKey.do"):
			command = new CampingAddKeyCommand();
			command.execute(request, response);
			viewPage = "CampingAddRoughMap.do";
			break;

		// 약도 이미지 보여주기
		// 페이지 처음 열 때는 디폴트 이미지 보여주고, 업로드 버튼 누르면 그걸 보여주기 위해서 select
		case ("/CampingAddRoughMap.do"):
			command = new HostInfoMRMSelectCommand();
			command.execute(request, response);
			viewPage = "CampingAddRoughMap.jsp";
			break;

		// 약도 이미지 업데이트
		case ("/addRoughMapUp.do"):
			command = new HostInfoMRMUpdateCommand();
			command.execute(request, response);
			viewPage = "CampingAddRoughMap.do";
			break;

		// 약도 -> 자리 select해서 보여주기
		case ("/campingAddSelRoom.do"):
			command = new HostInfoRoomSelectCommand();
			command.execute(request, response);
			viewPage = "CampingAddRoom.jsp";
			break;

		// 자리 인서트
		case ("/campingAddRoom.do"):
			command = new HostInfoRoomInCommand();
			command.execute(request, response);
			viewPage = "campingAddSelRoom.do";
			break;

		// 자리 delete
		case ("/campingAddRoomDel.do"):
			command = new HostInfoRoomDelCommand();
			command.execute(request, response);
			viewPage = "campingAddSelRoom.do";
			break;

		// 자리 등록 페이지 -> 이미지 등록 페이지
		case ("/campingAddImgView.do"):
			command = new HostInfoImagesSelectCommand();
			command.execute(request, response);
			viewPage = "CampingAddimages.jsp";
			break;

		// 캠핑장 이미지1 업데이트
		case ("/cImage1Up.do"):
			command = new HostInfoImages1UpCommand();
			command.execute(request, response);
			viewPage = "campingAddImgView.do";
			break;

		// 캠핑장 이미지2 업데이트
		case ("/cImage2Up.do"):
			command = new HostInfoImages2UpCommand();
			command.execute(request, response);
			viewPage = "campingAddImgView.do";
			break;

		// 캠핑장 이미지3 업데이트
		case ("/cImage3Up.do"):
			command = new HostInfoImages3UpCommand();
			command.execute(request, response);
			viewPage = "campingAddImgView.do";
			break;

		// ------------예진 : 캠핑장 정보수정 페이지 ------------------------------------

		// 정보 수정 메인페이지 열기
		case ("/HostRInfo.do"):
			command = new HostInfoMainRegName();
			command.execute(request, response);
			viewPage = "HostInfoMMain.jsp";
			break;

		// 정보 수정 메인페이지 -> 기존 정보 보기
		case ("/HostInfoRegView.do"):
			command = new HostInfoMainRegName();
			command.execute(request, response);
			command = new HostInfoImagesSelectCommand();
			command.execute(request, response);
			command = new HostInfoNCTSelectCommand();
			command.execute(request, response);
			command = new HostInfoKeySelectCommand();
			command.execute(request, response);
			command = new HostInfoFaSelectCommand();
			command.execute(request, response);
			command = new HostInfoRoomSelectCommand();
			command.execute(request, response);
			command = new HostInfoMRMSelectCommand();
			command.execute(request, response);
			command = new HostInfoLSelectCommand();
			command.execute(request, response);
			viewPage = "HostInfoCamp.jsp";
			break;

		// 정보 수정 메인페이지 -> 위치, 설명 수정 페이지
		case ("/HostInfoMLoView.do"):
			command = new HostInfoLSelectCommand();
			command.execute(request, response);
			viewPage = "HostInfoMLo.jsp";
			break;

		// 위치, 설명 수정
		case ("/HostInfoMLo.do"):
			command = new HostInfoLMoCommand();
			command.execute(request, response);
			viewPage = "HostRInfo.do";
			break;

		// 정보 수정 메인페이지 -> 이름, 카테고리, 전화번호 수정 페이지
		case ("/HostInfoMNCTView.do"):
			command = new HostInfoNCTSelectCommand();
			command.execute(request, response);
			viewPage = "HostInfoMNameCategoryTel.jsp";
			break;

		// 이름, 카테고리, 전화번호 수정
		case ("/HostInfoMNCT.do"):
			command = new HostInfoNCTMoCommand();
			command.execute(request, response);
			viewPage = "HostRInfo.do";
			break;

		// 정보 수정 메인페이지 -> 키워드 수정 페이지
		case ("/HostInfoKeyView.do"):
			command = new HostInfoKeySelectCommand();
			command.execute(request, response);
			viewPage = "HostInfoMKeyword.jsp";
			break;

		// 키워드 삭제와 인서트
		case ("/HostInfoKeyInDel.do"):
			command = new HostInfoKeyInDelCommand();
			command.execute(request, response);
			viewPage = "HostRInfo.do";
			break;

		// 정보 수정 메인페이지 -> 편의시설 수정 페이지로
		case ("/HostInfoFaciView.do"):
			command = new HostInfoFaSelectCommand();
			command.execute(request, response);
			viewPage = "HostInfoMFacility.jsp";
			break;

		// 편의시설 삭제와 인서트
		case ("/HostInfoFaInDel.do"):
			command = new HostInfoFaInDelCommand();
			command.execute(request, response);
			viewPage = "HostRInfo.do";
			break;

		// 정보 수정 메인페이지 -> 자리 수정 페이지
		case ("/HostInfoRoomView.do"):
			command = new HostInfoRoomSelectCommand();
			command.execute(request, response);
			viewPage = "HostInfoMRoom.jsp";
			break;

		// 자리 인서트
		case ("/HostInfoRoomIn.do"):
			command = new HostInfoRoomInCommand();
			command.execute(request, response);
			viewPage = "HostInfoRoomView.do";
			break;

		// 자리 delete
		case ("/HostInfoRoomDel.do"):
			command = new HostInfoRoomDelCommand();
			command.execute(request, response);
			viewPage = "HostInfoRoomView.do";
			break;

		// 정보 수정 메인페이지 -> 약도 수정 페이지
		case ("/HostInfoRoughView.do"):
			command = new HostInfoMRMSelectCommand();
			command.execute(request, response);
			viewPage = "HostInfoMRoughMap.jsp";
			break;

		// 약도 이미지 업데이트
		case ("/roughMapUp.do"):
			command = new HostInfoMRMUpdateCommand();
			command.execute(request, response);
			viewPage = "HostInfoRoughView.do";
			break;

		// 정보 수정 메인페이지 -> 이미지 수정 페이지
		case ("/HostInfoImagesView.do"):
			command = new HostInfoImagesSelectCommand();
			command.execute(request, response);
			viewPage = "HostInfoMImages.jsp";
			break;

		// 캠핑장 이미지1 업데이트
		case ("/image1Up.do"):
			command = new HostInfoImages1UpCommand();
			command.execute(request, response);
			viewPage = "HostInfoImagesView.do";
			break;

		// 캠핑장 이미지2 업데이트
		case ("/image2Up.do"):
			command = new HostInfoImages2UpCommand();
			command.execute(request, response);
			viewPage = "HostInfoImagesView.do";
			break;

		// 캠핑장 이미지3 업데이트
		case ("/image3Up.do"):
			command = new HostInfoImages3UpCommand();
			command.execute(request, response);
			viewPage = "HostInfoImagesView.do";
			break;

		}// switch End

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}// End
