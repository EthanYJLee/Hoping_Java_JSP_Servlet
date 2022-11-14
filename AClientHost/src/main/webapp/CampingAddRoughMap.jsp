<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>캠핑장 등록하기 - 약도</title>
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

<%-- nav include --%>
<%@ include file = "hnav1.jsp" %>


<%-- 본문 --%>
<%-- 테이블 --%>
<div class="container">

<%-- ----------------------------- 캠핑장 약도 등록하기----------------------------- --%>
	<div class="row myhdrow">
 		<h5 class="col-12" style="margin: 20px 0 20px 0">캠핑장의 약도를 등록하기</h5>
 	</div>
 	
 	<%-- 약도 디폴트 이미지 불러오기 --%>
 	<div class="row">
 		<div class="card col-md-5" style="border: 0px;">
 			<img class="myscontainer" alt="약도" src="./images/${roughMap.regImage4 }">
 		</div>
 	</div>
 	
 	<%-- 수정할 약도 업로드 --%>
	<p style="font-size: 13px; color: blue;">*사진을 선택 후 Upload 버튼을 눌러 주세요.</p>
	<%-- map form --%>
 	<form action = "hiddenImgUp.jsp?link=addRoughMapUp.do" method = "post" enctype = "multipart/form-data">
		<input type = "file" name = "file" size = "50" />
		<br>
		<input type = "submit" value = "Upload" size="50" />
		<input type="hidden" name="link" value="addRoughMapUp.do">
	</form>
	
	<div class="d-flex flex-row-reverse">
 		<form class="p-2">
 			<a href="campingAddSelRoom.do" style="border-radius: 15px; width:100px;" class="btn mybtns btn-secondary">다음</a>
 		</form>
 	</div>
	
</div>
</body>
</html>