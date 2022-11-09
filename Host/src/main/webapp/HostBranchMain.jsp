<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호스트 캠핑장 관리 페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap-responsive.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/Design.css">
<link rel="stylesheet" href="css/HostCard.css">
<link rel="stylesheet" href="css/TableCenter.css">
<link rel="stylesheet" href="css/HostStyle.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script src="https://https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.js"></script>

</head>

<body>

<body>
<div class="container">
   <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
     <a href="host_main.do" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
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

<main>
<div class="container py-4">
<div class="p-3 mb-4 bg-light rounded-3">
	<div class="container-fluid py-3">
		<h2 class="display-7 fw-bold">나의 캠핑장 정보</h2><br><br>
		<div class="row">
			<div class="col"><div class="card" style="width: 14rem;">
				<img src="https://www.incheonin.com/news/photo/202205/87828_122219_3711.jpg" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">1번 캠핑장</h5>
					<p class="card-text">캠핑장 주소</p>
					<a href="#" class="btn btn-primary">캠핑장 메인페이지로</a>
				</div>
			</div></div>
			
			<div class="col"><div class="card" style="width: 14rem;">
				<img src="https://www.incheonin.com/news/photo/202205/87828_122219_3711.jpg" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">2번 캠핑장</h5>
					<p class="card-text">캠핑장 주소</p>
					<a href="#" class="btn btn-primary">캠핑장 메인페이지로</a>
				</div>
			</div></div>
			
			<div class="col"><div class="card" style="width: 14rem;">
				<img src="https://www.incheonin.com/news/photo/202205/87828_122219_3711.jpg" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">3번 캠핑장</h5>
					<p class="card-text">캠핑장 주소</p>
					<a href="#" class="btn btn-primary">캠핑장 메인페이지로</a>
				</div>
			</div></div>
			
			<div class="col"><div class="card" style="width: 14rem;">
				<img src="https://www.incheonin.com/news/photo/202205/87828_122219_3711.jpg" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">4번 캠핑장</h5>
					<p class="card-text">캠핑장 주소</p>
					<a href="#" class="btn btn-primary">캠핑장 메인페이지로</a>
				</div>
			</div></div>
		</div>
	</div>
</div>
<div class="row align-items-md-stretch py-3">
	<div class="col-md-6">
		<div class="h-100 p-5 bg-light border rounded-3">
			<h2>금일 예약현황</h2>
			<br>
			<p>신규예약</p>
			<p>금일 체크인 예정</p>
			<p>금일 체크아웃 예정</p>
		</div>
	</div>
	<div class="col-md-6">
		<div class="h-100 p-5 bg-light border rounded-3">
			<h2>금일 문의현황</h2>
			<br>
			<p>총 문의개수</p>
			<p>답변 완료</p>
			<p>답변 미완료</p>
		</div>
	</div>
</div>

<div class="row align-items-md-stretch py-3">
	<div class="col-md-6">
		<div class="h-100 p-5 bg-light border rounded-3">
			<h2>월별 수입 및 예약건</h2>
			<br>
			<button class="btn btn-outline-secondary" type="button">Example button</button>
		</div>
	</div>
	<div class="col-md-6">
		<div class="h-100 p-5 bg-light border rounded-3">
			<h2>후기현황</h2>
			<br>
			<p>총 후기개수</p>
			<p>답변 완료</p>
			<p>답변 미완료</p>
			<p>평균 별점</p>
		</div>
	</div>
</div>
</div>

</main>










<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>