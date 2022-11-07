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
<%-- nav --%>
<div class="container">
   <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
     <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
       <svg class="mysvg" xmlns="http://www.w3.org/2000/svg" width="28" height="28" fill="currentColor" class="bi bi-house-heart" viewBox="0 0 16 16">
	  <path d="M8 6.982C9.664 5.309 13.825 8.236 8 12 2.175 8.236 6.336 5.309 8 6.982Z"/>
	  <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.707L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.646a.5.5 0 0 0 .708-.707L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5ZM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5 5 5Z"/>
	</svg>
       <span class="mytitle"><b>Hoping</b></span>
     </a>
     
     <ul class="nav nav-pills">
     	<li class="nav-item" style="font-size: 14px;">
     		<a href="#" class="link-dark nav-link">호스트 모드</a>
     	</li>
     	
     	<li class="nav-item">
			<svg class="dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" xmlns="http://www.w3.org/2000/svg" width="28" height="28" fill="currentColor" class="bi bi-person-lines-fill" viewBox="0 0 16 16">
				<path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm-5 6s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zM11 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5zm.5 2.5a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1h-4zm2 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2zm0 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2z"/>
			</a>
			<ul class="dropdown-menu">
		    <li><a class="dropdown-item" href="#">Action</a></li>
		    <li><a class="dropdown-item" href="#">Another action</a></li>
		    <li><a class="dropdown-item" href="#">Something else here</a></li>
		  </ul>
		</li>
     </ul>
   </header>
 </div>

<%--search --%>
<div class="container myscontainer">
      <div class="d-flex align-items-center justify-content-center justify-content-lg-center">

        <form action="searchCamp.do"class="col-12 col-lg-auto mb-4 mb-lg-0 me-lg-4" role="search">
		검색 선택:
		<select name="query">
			<option value="name">이름</option>
			<option value="address" selected="selected">주소</option>
		</select>&nbsp;&nbsp;&nbsp;
          <input class="mysearch" type="search" class="form-control" aria-label="Search" name="content">
        </form>

        <div class="text-conter">
        <a href="searchCamp.do" class="text-decoration-none">
		<svg class="mysvg" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
			  <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
		</svg>
		</a>
        </div>
        
      </div>
    </div>

		<form action="searchCamp.do">
					<div class="album py-5 bg-light">
				<div class="container">
				<div class="row justify-container-center">
		검색 선택:
		<select name="query">
			<option value="name">이름</option>
			<option value="tel">전화번호</option>
			<option value="address" selected="selected">주소</option>
		</select>&nbsp;&nbsp;&nbsp;
		<input type="text" name="content" size="30">
		<input type="submit" value="검색">
							</div>
				</div>
			</div> 
	</form>

<%-- 카드 --%>
<div class="box container mymcontainer">
	<div class="row">

		<c:forEach items="${RegCamp}" var="dto">
		  <div class="col-md">
		    <div class="card mycard">
		    <a href="detailView.do?reqSeq=${dto.regSeq}">
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




	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>