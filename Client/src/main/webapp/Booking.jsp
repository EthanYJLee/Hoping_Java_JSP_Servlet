<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


<div class="box container mymcontainer">								<!-- 선택한 캠프 이름이 들어오도록 수정해야 -->
	<div style="margin-bottom: 20px; font-weight: 500; font-size: 25px;">${regcamp_regSeq}</div>
	
	<div class="row row-cols-1 row-cols-md-2 g-4">
														<!-- Img좌석표로 들어갈 수 있도록 체크 해야댐 --> 
	      <img class="col-md" style="height:300px; border-radius:20px;" src="#" alt="...">
	  
	  <div class="col-md">
	  <a href="#" class="link-dark" style="text-decoration: none;">
	    <div class="card myhcard h-100">
	      <div class="card-body ">
	        <h5 class="card-title myctitle">선택하신 날짜</h5>
	        <!-- 앞에 datepicker 로 한 날짜 들어와야댐  -->
	        
	      </div>
	    </div>
	    </a>
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
						      		<option >각 캠핑사이트(Room)의 맥스값이 나오게끔 </option>
						      		<option >December</option>
						      		</optgroup>
						    	</select>
			      			</span>
			      			명
	      				</td>
	      			</tr>
		      		
		      		
		      		<tr>
			      		<td class="col-6 mytdtext">
			      			어린이
			      		</td>
			      		<td class="col-6 mytdtext">
				      		<span class="mysn">n
				      		</span>명 
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
	      		<tr><td class="col-6 mytdtext">총 문의 개수</td><td class="col-6 mytdtext"><span class="mysn">n</span>건</td></tr>
	      		<tr><td class="col-6 mytdtext">답변 미완료</td><td class="col-6 mytdtext"><span class="mysn">n</span>건</td></tr>
	      		<tr><td class="col-6 mytdtext">답변 완료</td><td class="col-6 mytdtext"><span class="mysn">n</span>건</td></tr>
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