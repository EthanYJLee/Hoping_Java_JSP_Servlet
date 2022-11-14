<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑장의 정보 수정하기</title>
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
 
 <%-- 본문 --%>
 
 <div class="container">
 	<h4 style="margin: 50px 0 50px 0;">${regName}의 어떤 정보를 수정할까요?</h4>
 	<div class="row myhdrow">
 		<div class="col-12"><a href="HostInfoRegView.do" type="button" style="border-radius: 10px; width:400px; height: 60px; background-color: #E94560; border: 0px;" class="btn btn-secondary">기존 정보 보기</a></div>
 	</div>
 	<div class="row myhdrow">
 		<div class="col-6 "><a href="HostInfoMLoView.do" type="button" style="border-radius: 10px; width:400px; height: 60px;" class="btn mybtns btn-secondary">캠핑장 위치 / 설명</a></div>
 		<div class="col-6 "><a href="HostInfoMNCTView.do" type="button" style="border-radius: 10px; width:400px; height: 60px;" class="btn mybtns btn-secondary">이름 / 카테고리 / 전화번호</a></div>
 	</div>
 	<div class="row myhdrow">
 		<div class="col-6 "><a href="HostInfoKeyView.do" type="button" style="border-radius: 10px; width:400px; height: 60px;" class="btn mybtns btn-secondary">키워드</a></div>
 		<div class="col-6 "><a href="HostInfoFaciView.do" type="button" style="border-radius: 10px; width:400px; height: 60px;" class="btn mybtns btn-secondary">편의시설</a></div>
 	</div>
 	<div class="row myhdrow">
 		<div class="col-6 "><a href="HostInfoImagesView.do" type="button" style="border-radius: 10px; width:400px; height: 60px;" class="btn mybtns btn-secondary">이미지</a></div>
 		<div class="col-6 "><a href="HostInfoRoughView.do" type="button" style="border-radius: 10px; width:400px; height: 60px;" class="btn mybtns btn-secondary">약도</a></div>
 	</div>
 	<div class="row myhdrow">
 		<div class="col-6 "><a href="HostInfoRoomView.do" type="button" style="border-radius: 10px; width:400px; height: 60px;" class="btn mybtns btn-secondary">자리 수정</a></div>
 		<div class="col-6 "><a href="host_confirm_delete.do" type="button" style="border-radius: 10px; width:400px; height: 60px;" class="btn mybtns btn-secondary">캠핑장 삭제</a></div>
 	</div>
 </div>
 
 

</body>
</html>