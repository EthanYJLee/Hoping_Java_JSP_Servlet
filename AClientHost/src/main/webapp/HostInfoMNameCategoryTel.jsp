<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑장 정보 수정 - 이름, 전화번호, 카테고리</title>
<link rel="stylesheet" href="css/yjstyle.css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap-responsive.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style type="text/css">
.mybtns {
	border: 0 solid black;
	transition: background-color .5s;
	border-radius: 15px;
}

.mybtns:hover {
	background-color: #E94560;
}

.myinputtext{
	height: 300px;
	margin: 0 30px 0 15px;
}
</style>
</head>
<body>

<%-- nav include --%>
<%@ include file = "hnav1.jsp" %>
 
 <div class="container">
 	<form name="Member" action="HostInfoMNCT.do">
	 	<div class="row myhdrow">
	 		<h5 class="col-12" style="margin: 20px 0 20px 0">이름을 수정하기</h5>
	 		<div class="container">
	 			<div>기존 이름 <b>"${nct.regName }"</b></div>
	 			<input name="regName" value="${nct.regName }" type="text" class="form-control" aria-label="text">
	 		</div>
	 	</div>
	 	<div class="row myhdrow">
	 		<h5 class="col-12" style="margin: 20px 0 20px 0">전화번호를 수정하기</h5>
	 		<div class="container">
	 			<div>기존 전화번호 <b>"${nct.regTel }"</b></div>
	 			<input name="regTel" value="${nct.regTel }" type="text" class="form-control" aria-label="text">
	 		</div>
	 	</div>
	 	<div class="row myhdrow">
	 		<h5 class="col-12" style="margin: 20px 0 20px 0">카테고리를 수정하기</h5>
	 		<div class="container">
		 		<div>기존 카테고리 <b>"${nct.regCategory }"</b></div>
		 		<%-- 라디오버튼 --%>
		 	<div class="container myscontainer">
		 		<input type="radio" class="btn-check" name="regCategory" id="option1" value="글램핑장"  autocomplete="off">
				<label class="btn btn-outline-primary" for="option1" >글램핑장</label>

				<input type="radio" class="btn-check" name="regCategory" id="option2"value="카라반" autocomplete="off">
				<label class="btn btn-outline-primary" for="option2">카라반</label>
				
				<input type="radio" class="btn-check" name="regCategory" id="option3" value="캠핑장" autocomplete="off">
				<label class="btn btn-outline-primary" for="option3" >캠핑장</label>
				
			</div>
	 	</div>
	 	</div>
	 	<div class="d-flex flex-row-reverse">
	 		<div class="p-2">
	 		<input onclick="checkMember()" type="button" style="border-radius: 15px; width:100px;" value="완료" class="btn mybtns btn-secondary">
	 		</div>
	 	</div>
 	</form>
 </div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script src="https://https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.js"></script>

<script type="text/javascript">

function checkMember(){
		
	var regExTel = /^\d{3}-\d{3,4}-\d{4}$/;
	
	var form = document.Member;
	
	let regTel = form.regTel.value;
	let regName = form.regName.value;
	
	//null 제한 
	if(regName == ""){
		alert("캠핑장 이름을 입력해주세요.")
		form.regName.focus();
		return false;
	}
	
	if(regTel == ""){
		alert("전화번호를 입력해주세요.")
		form.regTel.focus();
		return false;
	}
	
	
	//전화번호 숫자만 입력
	if(!regExTel.test(regTel)){
		alert("전화번호 형식으로 입력해주세요. \nex.02-000-0000")
		form.regTel.select();
		return
	}
	
	alert("수정되었습니다.")
	form.submit();
	
}

</script>





















</body>
</html>