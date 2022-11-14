<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑장 정보</title>
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
</style>
</head>
<body>

<%-- nav include --%>
<%@ include file="hnav1.jsp"%>

<%-- 상세정보 --%>
 <div class="container myscontainer">
 	<h4>기존 정보</h4>
 	<br>
 	<%-- 이미지 --%>
 	<div class="mydtitle">이미지</div>
 	<div class="row justify-container-center">
			<div class="col-md">
				<img style="margin-bottom: 20px; border-radius: 5px; width: 18rem;"
					src="./images/${images.regName}" 
					class="card" alt="...">
			</div>
			<div class="col-md">
				<img style="margin-bottom: 20px; border-radius: 5px; width: 18rem;"
					src="./images/${images.regCategory}" 
					class="card" alt="...">
			</div>
			<div class="col-md">
				<img style="margin-bottom: 20px; border-radius: 5px; width: 18rem;"
					src="./images/${images.regTel}" 
					class="card" alt="...">
			</div>
			
	</div> 	
	<hr style="background-color: gray;">
	<%-- 이름, 카테고리, 전화번호 --%>
	<div class="row myhdrow myscontainer" style="padding-bottom: 25px;">
 		<div class="col ">
	 		<div class="card col-md" style="border: 0px solid black;">
	 			<div class="myhdth">캠핑장 이름</div><div class="myhdtd">${regName}</div>
	 		</div>
	 		<div class="card col-md" style="border: 0px solid black;">
	 			<div class="myhdth">카테고리</div><div class="myhdtd">${nct.regCategory }</div>
	 		</div>
	 		<div class="card col-md" style="border: 0px solid black;">
	 			<div class="myhdth">전화번호</div><div class="myhdtd">${nct.regTel }</div>
	 		</div>
 		</div>
 		<div class="col">
 			<div class="myhdth">약도</div>
 			
	 		<div class="col-md">
				<img style="margin-bottom: 20px; border-radius: 5px; width: 18rem;"
					src="./images/${roughMap.regImage4}" 
					class="card" alt="...">
			</div>
 		</div>
 		<div class="col">
 			<div class="myhdth">위치</div>
 			<div class="myhdtd">${detail.regDetailaddress }</div>
 			<%@ include file="hKaKaoMap.jsp"%>
 		</div>
 		<hr style="background-color: gray;">
 		<%-- 키워드 --%>
 		<div class="mydtitle">등록된 키워드</div>
 		<div class="container myscontainer">
	 		<c:forEach items="${keywords}" var="dto">
		 		<input type="checkbox" class="btn-check" name="keys" id="option1" value="조용한"  autocomplete="off">
				<label class="btn btn-secondary" for="option1" >${dto.kName }</label>
	 		</c:forEach>
	 	</div> 	

 		<hr style="background-color: gray;">
 		<%-- 편의시설 --%>
 		<div class="mydtitle">등록된 편의시설</div>
 		<div class="container myscontainer">
			<c:forEach items="${facility}" var="dto">
		 		<input type="checkbox" class="btn-check" name="keys" id="option1" value="조용한"  autocomplete="off">
				<label class="btn btn-secondary" for="option1" >${dto.fName }</label>
	 		</c:forEach>
 		</div>
 		<hr style="background-color: gray;">
 		<%-- 자리 --%>
 		<div class="mydtitle">등록된 자리</div>
 		<div class="row myscontainer justify-content-center">
			<div class="card col-5 myhcard" style="border-radius: 20px;">
				<table class="d-flex justify-content-center">
					<tr class="myhtr">
						<td class="myth">자리번호</td><td class="myth">지정가</td><td class="myth">최대인원</td>
					</tr>
					<%-- for문 돌리기 --%>
					<c:forEach items="${list}" var="dto">
						<tr class="myhtr ">
							<td class="mytd">${dto.roNum }</td>
							<td class="mytd">${dto.roPrice }</td>
							<td class="mytd">${dto.roMax }</td>
						</tr>
					</c:forEach>
				</table>	  
			</div>
		</div>
		
 	</div>
 	<hr style="background-color: gray;">
	<div class="d-flex justify-content-end">
		<a href="HostRInfo.do" type="button" style="border-radius: 15px; width:70px;" class="btn mybtns btn-secondary">확인</a>
	</div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>