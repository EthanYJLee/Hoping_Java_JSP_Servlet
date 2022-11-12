<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑장 삭제 확인 페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link rel="stylesheet" href="css/Design.css">
<link rel="stylesheet" href="css/HostCard.css">
<link rel="stylesheet" href="css/TableCenter.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/carousel.css">


<script src="https://cdn.jsdelivr.net/npm/chart.js@3.9.1/dist/chart.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

</head>

<body>

<div class="container py-2">
<nav class="navbar navbar-expand-md bg-light">
	<div class="container-fluid">
		<a class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
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
		
		<ul class="dropdown-menu dropdown-menu-end">
			<li><a class="dropdown-item" href="#">내 정보</a></li>
			<li><a class="dropdown-item" href="bookList.do">예약목록</a></li>
			<li><a class="dropdown-item" href="askList.do">문의목록</a></li>
            <li><a class="dropdown-item" href="#">수입 및 예약건 통계</a></li>
            <li><a class="dropdown-item" href="host_review_list.do">후기관리</a></li>
            <li><a class="dropdown-item" href="#">캠핑장 추가</a></li>
            <li><a class="dropdown-item" href="#">로그아웃</a></li>
		</ul>
		
		</svg>
		</li>
     </ul>
		
	</div>
</nav>
</div>

<main>
<div class="container-md d-flex justify-content-center">
		<div class="h-100 p-5 bg-light border rounded-3" style="text-align:center">
			<h2>캠핑장 정보를 확인해주세요</h2>
			<br>
			<p>캠핑장명 : ${CHECKDELETE.regName}</p>
			<p>전화번호 : ${CHECKDELETE.regTel}</p>
			<p>주소 : ${CHECKDELETE.regDetailaddress}</p>
			<p>소개글 : ${CHECKDELETE.regSummary}</p>
			<p>등록날짜 : ${CHECKDELETE.regDate}</p>
			<br>
			<div class="form-row float-right">
			<p>정말 삭제하시겠습니까?</p>
			<button type="button" class="btn btn-danger" onclick="location.href='host_delete_camp.do'">삭제하기</button>
			</div>
		</div>
	</div>


</main>

</body>
</html>