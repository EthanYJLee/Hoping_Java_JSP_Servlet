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
	 		<div >기존 이름은 "${nct.regName }"</div>
	 		<input name="regName" value="${nct.regName }" type="text" class="form-control" aria-label="text">
	 	</div>
	 	<div class="row myhdrow">
	 		<h5 class="col-12" style="margin: 20px 0 20px 0">전화번호를 수정하기</h5>
	 		<div>기존 전화번호는 "${nct.regTel }"</div>
	 		<input name="regTel" value="${nct.regTel }" type="text" class="form-control" aria-label="text">
	 	</div>
	 	<div class="row myhdrow">
	 		<h5 class="col-12" style="margin: 20px 0 20px 0">카테고리를 수정하기</h5>
	 		<div>기존 카테고리는 "${nct.regCategory }"</div>
	 		<%-- 라디오버튼 --%>
	 		<div class="form-check">
			  <input class="form-check-input" type="radio" name="regCategory" value="숲 근처" id="flexRadioDefault1">
			  <label class="form-check-label" for="flexRadioDefault1">
			    숲 근처
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input" type="radio" name="regCategory" value="계곡 근처" id="flexRadioDefault2" checked>
			  <label class="form-check-label" for="flexRadioDefault2">
			    계곡 근처
			  </label>
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
		
		console.log("js");
	var regExTel = /^(02|0[3-6]{1}[1-5]{1})-?(15|16|18)[0-9]{2}-?[0-9]{4}$/
	
	var form = document.Member;
	
	let regTel = form.regTel.value;
	let regName = form.regName.value;
	
	//null 제한 
	if(regName == ""){
		alert("캠핑장 이름을 입력해주세요.")
		form.regName.focus();
		return false;
	}
	
	
	//전화번호 숫자만 입력
	if(!regExTel.test(regTel)){
		alert("전화번호는 숫자만 입력해주세요.")
		form.regTel.select();
		return
	}
	
	form.submit();
	
}

</script>





















</body>
</html>