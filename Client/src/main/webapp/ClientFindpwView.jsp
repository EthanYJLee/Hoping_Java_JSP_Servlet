<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/navbar-fixed/">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" 
	 rel="stylesheet" >
<link href="css/style.css" rel="stylesheet" >
<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800'); 
@import url('https://fonts.googleapis.com/css2?family=Ubuntu&display=swap');
</style>
		
</head>
<body>
	<!-- Header Start -->
    <%@ include file = "Nav2.jsp" %>
    <!-- Header End --> 

		<main class="form-signin w-50 m-auto">
	<div align="center">
			<form action="pwsearch.do" method="post">
				<h1 class="h3 mb-3 fw-normal">비밀번호 찾기</h1>

				<div class="form-floating" style="margin: 5px;">
				아이디를 입력해 주세요
					<input type="text" class="form-control" id="floatingInput"
						name="cId" placeholder="아이디를 적어주세요">
				</div>
				
				<div class="form-floating" style="margin: 5px;">
				이름을 입력해 주세요 				
					<input type="text" class="form-control" id="floatingInput"
						name="cName" placeholder="이름을 적어주세요">
				</div>
				
				<div class="form-floating" style="margin: 5px;"> 
				이메일을 입력해 주세요
					<input type="email" class="form-control" id="floatingPassword"
						name="cEmail" placeholder="이메일을 적어주세요">
				</div>

				<div class="checkbox mb-3" style="margin: 10px;">
					<button class="w-100 btn btn-lg btn-primary" type="submit"
					style="WIDTH: 100pt; HEIGHT: 40pt">확인</button>
				</div>
			</form>
				<div class="checkbox mb-3" style="margin: 10px;">
					<a href="ClientLoginView.jsp">
						<button class="w-100 btn btn-lg btn-primary" type="submit"
						style="WIDTH: 100pt; HEIGHT: 40pt">
						로그인 페이지로 가기</button>
					</a>
				</div>

	</div>
		</main>


	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>	
<!-- Foot -->
<%@ include file = "Foot.jsp" %>
<!-- Foot End -->
</body>


</head>
</html>