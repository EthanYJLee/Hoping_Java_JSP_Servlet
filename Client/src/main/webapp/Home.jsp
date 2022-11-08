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

<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800'); 
@import url('https://fonts.googleapis.com/css2?family=Ubuntu&display=swap');

body{
	font-family: 'Nanum Gothic';
	
}

.mybtn {
	transition: background-color .5s;
	border-radius: 15px;
}

.mybtn:hover {
	border: 0 solid black;
	background-color: #E94560;
}

.myscontainer {
	margin-bottom: 25px;
}

.mysearch {
	border-radius: 15px;
	border: 0.5px solid #808080;
	box-shadow: 1px 1px 3px 2px #E6E6E6;
	height: 33px;
	width: 500px;
}


.mytitle{
	font-family: 'Ubuntu', sans-serif;
	color: #E94560;
	font-size: 20px;	
	font-weight: bold;
}

.mysvg{
	margin-right: 5px;
	color: #E94560;
}

.mycard{
	border: 0px solid black;
	margin-bottom: 20px;
}


.mycbody{
	padding: 20px 0 0 0;
}

.myimage {
	border-radius: 15px;
	width: 250px;
	height: 250px;
}

.myctitle{
	font-size: 15px;
	font-weight: 600;
}

.myctext{
	font-weight:100;
	color: gray;
	
}

.mymcontainer{
	margin-bottom: 50px;
}
</style>

</head>
<body>
 <%@ include file = "Nav.jsp" %>

<%-- 카드 --%>
<div class="box container mymcontainer">
	<div class="row">

		<c:forEach items="${RegCamp}" var="dto">
		  <div class="col-md">
		    <div class="card mycard">
		    <a href="detailView.do?regSeq=${dto.regSeq}">
		      <img src="https://a0.muscache.com/im/pictures/7fde1672-2160-4593-90cd-00bd75da732a.jpg?im_w=1200" class="card-img-top myimage" alt="...">
		    </a> 
		      <div class="card-body mycbody">
				<p class="card-text">${dto.regDetailaddress}</p>
				<h5 class="card-title myctitle">${dto.regName}</h5>
				<p class="card-text myctext">${dto.regTel}</p>
					<button type="button"
						class="btn btn-sm btn-outline-secondary">
						<a href="detailView.do?reqSeq=${dto.regSeq}">View</a>
					</button>
		      </div>
		    </div>
		  </div>


		</c:forEach>
		<form action="list.do" method="post">
			<div class="album py-5 bg-light">
				<div class="container">
				<div class="row justify-container-center">

					</div>
				</div>
			</div>
		</form>
</div>
</div>



	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>