<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약하기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/style.css">
<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800'); 
@import url('https://fonts.googleapis.com/css2?family=Ubuntu&display=swap');
</style>
</head>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<body>
<%-- nav --%>
<%@ include file = "Nav2.jsp" %>

<%-- 카드 --%>

<div class="box container mymcontainer">								
	<div style="margin-bottom: 20px; font-weight: 500; font-size: 25px;">${bookingInfo.regName}</div>
	
	<div class="row row-cols-1 row-cols-md-2 g-4">
														<!-- Img좌석표로 들어갈 수 있도록 체크 해야댐 --> 
	      <img class="col-md" style="height:300px; border-radius:20px;" 
	      src="${bookingInfo.regImage4}" 
	      
	      alt="${bookingInfo.regName}캠핑장 약도">
	 
	  <div class="col-md">
	    <div class="card myhcard h-100">
	      <div class="card-body ">
	        <h5 class="card-title myctitle">선택하신 날짜  ></h5>
				<input type="text" name="startdate" style="background-color: white; border-radius: 13px; height: 33px; font-size: 13px;" class="mydinput form-control" placeholder="Start" readonly value=" ${startdate}">
				<input type="text" name="stopdate"  style="border-radius: 13px; height: 33px; font-size: 13px;" class="secondary form-control" placeholder="End" readonly  value=" ${stopdate}">
	      </div>
	    </div>
	  </div>
	  <div class="col-md">
	    <div class="card myhcard h-100">
	      <div class="card-body">
	        <h5 class="card-title myctitle">인원</h5>
	        <hr>
		      	<table class="container">
		      		<tr><td class="col-6 mytdtext">성인</td>
		      			<td class="col-6 mytdtext">
			      			<span class="mysn">
			      			<select class="adult" name="adult">	
						    	<optgroup label="성인 인원">
						    	<c:forEach var="cnt" begin="1" end="${bookingInfo.roMax}">
						      		<option >${cnt}</option>
						      		</c:forEach>
						      		</optgroup>
						    	</select>
			      			</span>
			      			명
	      				</td>
	      			</tr>
	      			
	      			<tr><td class="col-6 mytdtext">어린이</td>
		      			<td class="col-6 mytdtext">
			      			<span class="mysn">
			      			<select class="adult" name="adult">	
						    	<optgroup label="성인 인원">
						    	<c:forEach var="cnt" begin="0" end="${bookingInfo.roMax}">
						      		<option >${cnt}</option>
						      		</c:forEach>
						      		</optgroup>
						    	</select>
			      			</span>
			      			명
	      				</td>
	      			</tr>
		      	</table>
	      
	      </div>
	      
	    </div>
	  </div>
	  <div class="col-md">
	    <div class="card myhcard h-100">
	      <div class="card-body">
	        <h5 class="card-title myctitle">요금</h5>
	       
	      <hr>
	      <table class="container">
	      		<tr><td class="col-6 mytdtext">	
	      		<fmt:formatNumber value="${bookingInfo.roPrice}" pattern="#,###"/>원</td>
	      		<tr><td>${countDate}</td></tr>
	      	</table>
	      </div>
	    </div>
	  </div>
	  위치 확1
	</div>
		  위치 확2
</div>
	  위치 확3


<!-- Foot -->
<%@ include file = "Foot.jsp" %>
<!-- Foot End -->

</body>
</html>