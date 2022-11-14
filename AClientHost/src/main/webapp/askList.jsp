<%@page import="com.bootcamp.host.dao.HAskDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

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

<head>
<meta charset="UTF-8">
<title>문의리스트</title>
<script type="text/javascript">
$(document).ready(function(){
	
	$('.input-daterange').datepicker({
	    format: 'yyyy-mm-dd',
	    autoclose: true
	});

});
</script>
  
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>



</head>
<body>

	<%-- nav --%>
	<%@ include file="hnav1.jsp"%>

	<%--search바 --%>
<div class="container myscontainer">
	<div class="row myhtitle">
		<div><b>문의 관리</b></div>
	</div>
	<div class="row">
		
		<select class="col-2 form-select form-select-sm" aria-label=".form-select-sm example">
		  <option selected>문의검색</option>
		  <option value="1">캠핑장</option>
		  <option value="1">날짜</option>
		  <option value="1">답변완료</option>
		  <option value="1">답변미완료</option>
		</select>
		
		<form class="col-10" action="bookList.do?page=1">
			<div class="row">
			<div class="col-4" autocomplete="off">
					<div class="input-group input-daterange">
						<input name="startDate" value="start" type="text" style="background-color: white; border-radius: 13px; height: 33px; font-size: 13px;" class="mydinput form-control" placeholder="Start" readonly>
						<input name="endDate" type="text" style="border-radius: 13px; height: 33px; font-size: 13px;" class="secondary form-control" placeholder="End" readonly>
					</div>
			</div>
			
			<div class="col-7" role="search">
				<input name="strSearch" style="width: 450px;" type="search" class="mysearch " aria-label="Search">
			</div>
			<button type="submit" class="text-decoration-none col-1" style="background-color:transparent; border: 0px solid black;">
				<svg class="mysvg" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
					  <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
				</svg>
			</button>
	        </div>
	    </form>
        </div>
	</div>

	<%-- 테이블 --%>
	<div class="container">
		<div class="card myhcard" style="border-radius: 20px;">
			<table>
				<tr class="myhtr">
					<td class="myth">문의번호</td>
					<td class="myth">작성자ID</td>
					<td class="myth">제목</td>
					<td class="myth">작성날짜</td>
					<td class="myth">답변여부</td>
				</tr>
				<%-- 예약 내역 list for문 돌리기 --%>
				<c:forEach items="${list}" var="dto">

					<tr class="myhtr">
						<td class="mytd">${dto.aSeq}</td>
						<td class="mytd">${dto.aCId}</td>
						<td class="mytd"><a href="askDetail.do?aSeq=${dto.aSeq}">${dto.aTitle}</a></td>
						<td class="mytd">${dto.aTime}</td>				
						<td class="mytd">${dtosAnswer}</td>
						<!-- 22-11-15 AM 2:40 Hosik -->
						
						


					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>