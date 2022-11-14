<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 네비게이션바 2 </title>
<link href="css/style.css" rel="stylesheet" >
<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800'); 
@import url('https://fonts.googleapis.com/css2?family=Ubuntu&display=swap');

</style>


<script type="text/javascript">
    
    function confirmLogout() {
        if( confirm("정말 로그아웃 하시겠습니까?") ) {
            location.href = "<c:url value ='ClientLogout.do'/>";
        }
    }
    
</script>


</head>
<body>
	<!-- 2022-11-8 Hosik - Hoping svg 클릭시 메인화면으로 링크 달았음 --> 
	<!-- 2022-11-9 Hosik - 성연씨 코드 받고 회원메뉴 부분 수정함.
						 - 로그인이 안되어 있을시 로그인 및 회원가입 메뉴 
						 - 로그인 세션이 있을경우 메뉴가 회원정보수정-탈퇴 , 로그아웃 그리고 예약정보확인 페이지 등록예정 
		2022-11-10 Hosik - Created Navbar2 기존 Navbar에서 검색기능을 없앤 navbar의 필요성을 느껴서 생성 					 	
						 
							 --> 
							 
<%-- nav --%>
	<div class="container">
	   <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
	     <a href="main.do" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
	       <svg class="mysvg" xmlns="http://www.w3.org/2000/svg" width="28" height="28" fill="currentColor" class="bi bi-house-heart" viewBox="0 0 16 16">
		  <path d="M8 6.982C9.664 5.309 13.825 8.236 8 12 2.175 8.236 6.336 5.309 8 6.982Z"/>
		  <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.707L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.646a.5.5 0 0 0 .708-.707L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5ZM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5 5 5Z"/>
		</svg>
	       <span class="mytitle"><b>Hoping</b></span>
	     </a>
	     
	     <ul class="nav nav-pills">
	     	<li class="nav-item" style="font-size: 14px;">
	     			<% if (session.getAttribute("CID") != null) { %>
	     		<a href="check.do?cId=<%=session.getAttribute("CID").toString() %>" class="link-dark nav-link">호스트 모드로 전환하기</a>
	     			  <% } %>	
	     	</li>
	     	
	     	<li class="nav-item">
				<svg class="dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" xmlns="http://www.w3.org/2000/svg" width="28" height="28" fill="currentColor" class="bi bi-person-lines-fill" viewBox="0 0 16 16">
					<path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm-5 6s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zM11 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5zm.5 2.5a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1h-4zm2 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2zm0 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2z"/>
				<ul class="dropdown-menu">
				<% if (session.getAttribute("CID") == null) { %>
			    <li><a class="dropdown-item" href="ClientLoginView.jsp">로그인</a></li>
			    <li><a class="dropdown-item" href="ClientSignupView.jsp">회원가입</a></li>
			       <% } else { 
			       %>
			    <li><%=session.getAttribute("CID")  %> 님 환영합니다 </li>
			    <li><a class="dropdown-item" href="bookingView.do">예약 정보 관리</a></li>
			    <li><a class="dropdown-item" href="wishList_View.do">위시 리스트</a></li>
			    <li><a class="dropdown-item" href="mypageView.do">마이페이지</a></li>
			    <li><a class="dropdown-item" href="javascript:void(0);" onclick="confirmLogout();">로그아웃</a></li>
        <% } %>
			  </ul>
			</li>
	     </ul>
	   </header>
 	</div>

	
	
</body>
</html>