<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 내 정보 수정 </title>
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
    <%@ include file = "Nav.jsp" %>
    <!-- Header End --> 
    <!-- Main Start -->
    <main >
		<div  class="container-md d-flex justify-content-center">
		 	<div class="row">
		 	<div class="col">
					<h1>마이페이지</h1>
					<form action="ClientModify.do" method="post">
					<table>
					<tr><td> ID :</td> <td><input type="text" size="15" name="cId" value="${mypageview.cId}" readonly="readonly" ><br></td></tr> 
					<tr><td> 전화번호 :</td> <td><input type="text" size="15" name="cPhone" value="${mypageview.cPhone}"><br></td></tr> 
					<tr><td> 이메일 :</td> <td><input type="text" size="15" name="cEmail" value="${mypageview.cEmail}"><br></td></tr> 
					<tr><td> 비밀번호 :</td> <td><input type="password" size="15" name="cPw" value="${mypageview.cPw }"><br></td></tr> 
					<tr><td></td><td><input type="submit" value="수정">
					<a href="ClientDelete.do?cId=${mypageview.cId}" type="submit" class="btn btn-primary">탈퇴</a>
					<a href="ClientMainView.jsp">메인</a>
					
					</table>
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