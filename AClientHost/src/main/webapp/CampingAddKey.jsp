<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑장 등록하기 - 키워드</title>
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

<%-- nav include --%>
<%@ include file = "hnav1.jsp" %>
 
 <%-- 본문 --%>
 <div class="container myicontainer" >
 	<h5 class="col-12" style="margin: 20px 0 20px 0">캠핑장에 어울리는 키워드를 추가하기</h5>
 	
 	<form action="campingAddKey.do">
		<input type="checkbox" class="btn-check" name="keys" id="option1" value="조용한"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option1" >조용한</label>
			 	<input type="checkbox" class="btn-check" name="keys" id="option2" value="자연 속"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option2" >자연 속</label>
			 	<input type="checkbox" class="btn-check" name="keys" id="option3" value="가까운"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option3" >가까운</label>
			 	<input type="checkbox" class="btn-check" name="keys" id="option4" value="탁 트인"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option4" >탁 트인</label>
			 	<input type="checkbox" class="btn-check" name="keys" id="option5" value="관광지 많은"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option5" >관광지 많은</label>
			 	<input type="checkbox" class="btn-check" name="keys" id="option6" value="편리한"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option6" >편리한</label>
			 	<input type="checkbox" class="btn-check" name="keys" id="option7" value="친구들과"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option7" >친구들과</label>
			 	<input type="checkbox" class="btn-check" name="keys" id="option8" value="가족끼리"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option8" >가족끼리</label>
			 	<input type="checkbox" class="btn-check" name="keys" id="option9" value="커플끼리"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option9" >커플끼리</label>
			 	<input type="checkbox" class="btn-check" name="keys" id="option10" value="아이들과 함께"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option10" >아이들과 함께</label>
			 	<input type="checkbox" class="btn-check" name="keys" id="option11" value="여유로운"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option11" >여유로운</label>
			 	<input type="checkbox" class="btn-check" name="keys" id="option12" value="장기숙박"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option12" >장기숙박</label>
	 	<div class="d-flex justify-content-center">
	 		<div class="p-2">
	 		<button type="submit" style="border-radius: 15px; width:100px;" class="btn mybtns btn-secondary">등록</button>
	 		</div>
	 	</div>
 	</form>
 	
 </div>

</body>
</html>