<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hoping에 로그인 하기</title>
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
    <!-- Main Start -->
    <main >
		<div  class="container-md d-flex justify-content-center">
		 	<div class="row">
		 	<div class="col">

		 <form action="login.do" method="post">
			    <h1 class="h3 mb-3 fw-normal">로그인</h1>
			
			    <div class="form-floating">
			      <input type="text" class="form-control" id="floatingInput" name="cId" placeholder="ID" >
			    </div>
			    <div class="form-floating">
			      <input type="password" class="form-control" id="floatingPassword" name="cPw" placeholder="PW">
			    </div>
			
			    <div class="checkbox mb-3">
			    </div>
			    <button class="w-100 btn btn-lg btn-primary" type="submit" >로그인</button>
			  	
			  	<div class="links" style="text-decoration: none">
		            <a href="ClientSignupView.jsp" style="text-decoration: none">회원가입</a>
		            <a href="#" style="text-decoration: none">아이디 찾기</a>
		            <a href="#" style="text-decoration: none">비밀번호 찾기</a>
		        </div>
			  
		  </form>
    	     </div><!-- DIV row End -->
		    </div><!-- DIV row End -->
	    </div> <!-- DIV container End -->
    </main> 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>	
<!-- Foot -->
<%@ include file = "Foot.jsp" %>
<!-- Foot End -->
</body>


</head>
</html>