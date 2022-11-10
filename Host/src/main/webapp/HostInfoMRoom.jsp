<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<link rel="stylesheet" href="css/yjstyle.css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap-responsive.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script src="https://https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.js"></script>

<style type="text/css">

.mybtns {
	border: 0 solid black;
	transition: background-color .5s;
	border-radius: 15px;
}

.mybtns:hover {
	background-color: #E94560;
}

.mbtn {
	background-color: #E94560;
	color: white;
}

.myinfoinput{
	
	width: 150px;
	border: 0.5px solid gray;
	border-radius: 10px;
	height: 30px;
	padding: 0px 10px 0px 10px;
	
}

</style>

</head>
<body>
<%-- nav --%>
<div class="container">
   <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
     <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
		<svg class="mysvg" xmlns="http://www.w3.org/2000/svg" width="28" height="28" fill="currentColor" class="bi bi-house-heart" viewBox="0 0 16 16">
			<path d="M8 6.982C9.664 5.309 13.825 8.236 8 12 2.175 8.236 6.336 5.309 8 6.982Z"/>
			<path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.707L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.646a.5.5 0 0 0 .708-.707L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5ZM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5 5 5Z"/>
		</svg>
       <span class="mytitle"><b>Hoping Host</b></span>
     </a>
     
     <ul class="nav nav-pills">
     	<li class="nav-item">
			<svg class="dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" xmlns="http://www.w3.org/2000/svg" width="28" height="28" fill="currentColor" class="bi bi-person-lines-fill" viewBox="0 0 16 16">
				<path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm-5 6s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zM11 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5zm.5 2.5a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1h-4zm2 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2zm0 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2z"/>
			<ul class="dropdown-menu">
		    <li><a class="dropdown-item" href="#">내 정보</a></li>
		    <li><a class="dropdown-item" href="#">예약 목록</a></li>
		    <li><a class="dropdown-item" href="#">문의 목록</a></li>
		    <li><a class="dropdown-item" href="#">수입 및 예약건 통계</a></li>
		    <li><a class="dropdown-item" href="#">후기 관리</a></li>
		    <li><a class="dropdown-item" href="#">로그아웃</a></li>
		  </ul>
		</li>
     </ul>
   </header>
 </div>

<%-- 본문 --%>
<%-- 테이블 --%>
<div class="container d-flex mycontainer justify-content-center myscontainer" style="width: 100%">
<div class="align-self-center">
	<h5 class="col-12" style="margin: 20px 0 20px 0">캠핑장의 자리를 수정하기</h5>
	<%-- 자리 테이블 --%>
	<div class="row myscontainer justify-content-center">
		<div class="card col-8 myhcard" style="border-radius: 20px;">
			<table>
				<tr class="myhtr">
					<td class="myth">자리번호</td><td class="myth">지정가</td><td class="myth">최대인원</td>
					<td class="myth"></td>
				</tr>
				<%-- for문 돌리기 --%>
				<c:forEach items="${list}" var="dto">
					<%-- modal 열리는 버튼 --%>
					<tr class="myhtr ">
						<td class="mytd">${dto.roNum }</td>
						<td class="mytd">${dto.roPrice }</td>
						<td class="mytd">${dto.roMax }</td>
						<td class="mytd">
							<a href="HostInfoRoomDel.do?roSeq=${dto.roSeq }" type="button" class="btn btn-secondary" style="height: 30px; font-size: 13px;" >
								삭제 
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>	  
		</div>
	</div>
	<%-- 등록 폼 --%>
	<div class="container justify-content-center">
		<form action="HostInfoRoomIn.do">
			<table class="myscontainer" style="width: 500px; margin-right: 0px">
				<tr class="row">
					<td class="col-3">자리 번호</td>
					<td class="col-3"><input name="roNum" type="text" class="form-control myinfoinput" placeholder="숫자만 입력해주세요" aria-label="text"></td>
				</tr>
				<tr class="row">
					<td class="col-3">지정가</td>
					<td class="col-3"><input name="roPrice" type="text" class="form-control myinfoinput" aria-label="text"></td>
				</tr>
				<tr class="row">
					<td class="col-3">최대 인원</td>
					<td class="col-3"><input name="roMax" type="text" class="form-control myinfoinput" aria-label="text"></td>
				</tr>
			</table>
			<%-- 추가, 완료 버튼 --%>
			<div class="row myscontainer ">
				<button type="submit" style="border-radius: 15px; width:100px;" class=" col-2 btn mybtns btn-secondary">추가</button>
			</div>
		</form>
		<div class="row justify-content-end">
			<a href="HostInfoMMain.jsp" type="submit" style="border-radius: 15px; width:100px;" class="col-2 btn mbtn">완료</a>
		</div>
	</div>
</div>
</div>
    


 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>