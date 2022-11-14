<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Boot Camp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/style.css">
<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800'); 
@import url('https://fonts.googleapis.com/css2?family=Ubuntu&display=swap');
</style>

</head>
<body>
<!-- Header -->
 <%@ include file = "Nav.jsp" %>
<!-- Header End -->
<%-- 카드 --%>
<div class="box container mymcontainer">
	<div class="row">

		<c:forEach items="${history}" var="dto">
		  <div class="col-md">
		    <div class="card mycard">
		    <%-- <a href="detailView.do?regSeq=${dto.regSeq}"> --%>
		      <img src="./images/${dto.regImage1}" class="card-img-top myimage" alt="..."> 
		    <!-- </a>  -->
		      <div class="card-body mycbody">
				<p class="card-text">
					<%-- ${dto.regDetailaddress} --%>
				</p>
				<h5 class="card-title myctitle">${dto.regName}</h5>
				<p class="card-text myctext">${dto.roNum}</p>
		      </div>
		    </div>
		  </div>


		</c:forEach>
</div>
</div>

<!-- Foot -->
<%@ include file = "Foot.jsp" %>
<!-- Foot End -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>