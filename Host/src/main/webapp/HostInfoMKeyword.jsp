<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
 	<h5 class="col-12" style="margin: 20px 0 20px 0">캠핑장의 키워드를 수정하기</h5>
 	<%-- 키워드 select해서 for문 돌리기 --%>
 	<div class="myscontainer">기존 키워드는 
	 	<c:forEach items="${keywords}" var="dto">
	 		"${dto.kName }" , 
	 	</c:forEach>이에요 
 	</div>
 	<%-- 키워드 채크박스 --%>
 	<form action="HostInfoKeyInDel.do">
	 	<div class="row">
			<div class="col-2 form-check">
				<input class="form-check-input" name="keys" type="checkbox" value="안락" id="flexCheckDefault">
				<label class="form-check-label" for="flexCheckDefault">안락</label>
			</div>
			<div class="col-2 form-check">
				<input class="form-check-input" name="keys" type="checkbox" value="편안" id="flexCheckChecked">
				<label class="form-check-label" for="flexCheckChecked">편안</label>
			</div>
			<div class="col-2 form-check">
				<input class="form-check-input" name="keys" type="checkbox" value="화려" id="flexCheckDefault">
				<label class="form-check-label" for="flexCheckDefault">화려</label>
			</div>
			<div class="col-2 form-check">
				<input class="form-check-input" name="keys" type="checkbox" value="깔끔" id="flexCheckDefault">
				<label class="form-check-label" for="flexCheckDefault">깔끔</label>
			</div>
		</div>
		
		<%-- 완료 버튼 --%>
	 	<div class="d-flex flex-row-reverse">
	 		<div class="p-2">
	 		<button type="submit" style="border-radius: 15px; width:100px;" class="btn mybtns btn-secondary">완료</button>
	 		</div>
	 	</div>
 	</form>
</div>

</body>
</html>