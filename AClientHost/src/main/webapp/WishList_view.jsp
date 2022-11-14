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
    <%@ include file = "Nav2.jsp" %>
    <!-- Header End --> 

 <div class="box container mymcontainer">
	<div class="row">

		<c:forEach items="${wishList_view}" var="dto">
		  <div class="col-md">
		    <div class="card mycard">
		    
		    <img src="./images/${dto.regImage1}" class="card-img-top myimage" alt="...">
		      <div class="card-body mycbody">
				<p class="card-text">
					${dto.regDetailaddress}
				</p>
				<h5 class="card-title myctitle">${dto.regName}</h5>
				<p class="card-text myctext">${dto.regTel}</p>
		      </div>
		    </div>
		  </div>


		</c:forEach>
</div>
</div>


    
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>	
<!-- Foot -->
<%@ include file = "Foot.jsp" %>
<!-- Foot End -->
</body>


</head>
</html>