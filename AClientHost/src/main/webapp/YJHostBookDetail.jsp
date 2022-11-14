<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 상세</title>
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
<%@ include file = "hnav1.jsp" %>
 
 <%-- 상세정보 --%>
 <div class="container myscontainer">
 	<h4>예약 상세</h4>
 	<br>
 	<div class="row">
 		<div class="col-6 mydtitle">예약 번호 ${bookDetail.boGroup }</div>
 		<div class="col-6 mydtitle">${bookDetail.regName }</div>
 	</div>
 	<div class="row myhdrow">
 		<div class="card col-md-6" style="border: 0px solid black;">
 			<div class="myhdth">예약자ID</div><div class="myhdtd">${bookDetail.pay_client_cId }</div>
 		</div>
 		<div class="card col-md-6" style="border: 0px solid black;">
 			<div class="myhdth">자리</div><div class="myhdtd">${bookDetail.roNum }</div>
 		</div>
 	</div>
 	<div class="row myhdrow">
 		<div class="card col-md-6" style="border: 0px solid black;">
 			<div class="myhdth">날짜</div><div class="myhdtd">${bookDetail.checkin } ~ ${bookDetail.checkout }</div>
 		</div>
 		<div class="card col-md-6" style="border: 0px solid black;">
 			<div class="myhdth">총인원</div><div class="myhdtd">${bookDetail.boCount }명</div>
 		</div>
 	</div>
 	<div class="row myhdrow">
 		<div class="card col-md-6" style="border: 0px solid black;">
 			<div class="myhdth">결제일</div><div class="myhdtd">${bookDetail.boDate }</div>
 		</div>
 		<div class="card col-md-6" style="border: 0px solid black;">
 			<div class="myhdth">요금 정보</div><div class="myhdtd">₩${bookDetail.boPrice} x ${bookDetail.boCount }명 = 총 ₩${bookDetail.total }</div>
 		</div>
 	</div>
 	<div class="d-flex flex-row-reverse">
 		<div class="p-2">
 		<a href="bookList.do" type="button" style="border-radius: 15px; width:70px;" class="btn mybtns btn-secondary">확인</a>
 		</div>
 	</div>
 	<hr style="background-color: gray;">
</div>
 



</body>
</html>