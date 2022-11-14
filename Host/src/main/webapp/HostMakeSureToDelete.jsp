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

<%-- nav include --%>
<%@ include file = "hnav2.jsp" %>

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