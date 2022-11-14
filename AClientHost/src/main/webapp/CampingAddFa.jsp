<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑장 등록하기 - 편의시설</title>
<link rel="stylesheet" href="css/yjstyle.css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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

<%-- nav --%>
<%@ include file = "hnav1.jsp" %>
 
 <%-- 본문 --%>
 <div class="container myicontainer" >
 	<h5 class="col-12" style="margin: 20px 0 20px 0">캠핑장 주변의 편의시설 추가하기</h5>
 	<%-- 편의시설 select해서 for문 돌리기 --%>
 	<%-- 편의시설 채크박스, form start --%>
 	<form action="campingAddFa.do">
				<input type="checkbox" class="btn-check" name="facility" id="option1" value="전기"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option1" >전기</label>
			 	<input type="checkbox" class="btn-check" name="facility" id="option2" value="온수"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option2" >온수</label>
			 	<input type="checkbox" class="btn-check" name="facility" id="option3" value="용품 판매 및 대여"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option3" >용품 판매 및 대여</label>
			 	<input type="checkbox" class="btn-check" name="facility" id="option4" value="반려동물 동반 가능"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option4" >반려동물 동반 가능</label>
			 	<input type="checkbox" class="btn-check" name="facility" id="option5" value="개수대"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option5" >개수대</label>
			 	<input type="checkbox" class="btn-check" name="facility" id="option6" value="샤워장"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option6" >샤워장</label>
			 	<input type="checkbox" class="btn-check" name="facility" id="option7" value="화장실"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option7" >화장실</label>
			 	<input type="checkbox" class="btn-check" name="facility" id="option8" value="취사시설"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option8" >취사시설</label>
			 	<input type="checkbox" class="btn-check" name="facility" id="option9" value="주차장"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option9" >주차장</label>
			 	<input type="checkbox" class="btn-check" name="facility" id="option10" value="와이파이"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option10" >와이파이</label>
			 	<input type="checkbox" class="btn-check" name="facility" id="option11" value="운동시설"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option11" >운동시설</label>
			 	<input type="checkbox" class="btn-check" name="facility" id="option12" value="물놀이장"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option12" >물놀이장</label>
	 	<div class="d-flex justify-content-center">
	 		<div class="p-2">
	 		<%-- submit 버튼 --%>
	 		<button type="submit" style="border-radius: 15px; width:100px;" class="btn mybtns btn-secondary">등록</button>
	 		</div>
	 	</div>
 	</form>
 	
 	
 </div>

</body>
</html>