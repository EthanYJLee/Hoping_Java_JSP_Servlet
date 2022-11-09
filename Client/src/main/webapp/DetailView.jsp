<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail View - ${DetailView.regName}</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/navbar-fixed/">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" 
	 rel="stylesheet" >

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
	<!-- Header Start -->
    <%@ include file = "Nav.jsp" %>
    <!-- Header End --> 
    <!-- Main Start -->
    <main >
		<div  class="container-md d-flex justify-content-center">
		 <div class="row">
		 <div class="col">
		
			<div><h3>${DetailView.regName}</h3></div>
		<hr class="featurette-divider">
		
		<!-- 캐러셀 시작  -->
			<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
			  	<div class="carousel-indicators">
				    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
				    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
				    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
			  </div>
			 <%--  <div class="carousel-inner">
				   	 <div class="carousel-item active">
				    	 <img src="${DetailView.regImage1}" class="d-block w-100" alt="Img_1"  height="300" width="700">
				    </div>
				    <div class="carousel-item">
				   		 <img src="${DetailView.regImage2}" class="d-block w-100" alt="Img_2" height="300"  width="700">
				    </div>
				    <div class="carousel-item">
				     	 <img src="${DetailView.regImage3}" class="d-block w-100" alt="Img_1" height="300"  width="700">
				    </div>
			  </div> --%>
			  
			  <div class="container">
  				 <div class="carousel-inner">
				   	 <div class="carousel-item active" style="align-content: center;">
				    	 <img src="./images/${DetailView.regImage1}" class="d-block" alt="Img_1"  height="400" width="100%">
				    </div>
				    <div class="carousel-item">
				   		 <img src="./images/${DetailView.regImage2}" class="d-block " alt="Img_2" height="400"  width="100%">
				    </div>
				    <div class="carousel-item">
				     	 <img src="./images/${DetailView.regImage3}" class="d-block  " alt="Img_1" height="400"  width="100%">
				    </div>
			 	 </div>
			  </div>	 
			 	 
				<!-- 이전 이미지 보여주 -->
				  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
				    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Previous</span>
				  </button>
				  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
				    <span class="carousel-control-next-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Next</span>
				  </button>
				</div>
		  	<!-- 캐러셀 끝 -->
		<hr class="featurette-divider">  	
		   <!-- 캠핑장 설명 --> 
		    <div>
		    	<h4> 캠핑장 설명</h4>
		   		 ${DetailView.regSummary}
		    </div>   <!-- 캠핑장 설명 끝  --> 
		<hr class="featurette-divider">    
		     <div>	<!-- 캠핑장카테고리 -->
		       	<h4> 편의시설 </h4>
		   		 ${DetailView.regCategory}
		    </div><!-- 캠핑장카테고리 끝 -->
		    <hr class="featurette-divider"> 
		    
		    <!-- 카카오 맵 시작 --> 
		        <%@ include file = "kakaoMap.jsp" %>
		    <!-- 카카오 맵 끝 -->    
  		<hr class="featurette-divider">
  		  <div class="justify-content-center">	<!-- camp site -->
		       	<h4> 캠핑장 배치도 </h4>
		   	 <img src="./images/${DetailView.regImage4}"  alt="CampSite=${DetailView.regName}"  height="100%" width="100%">
		    </div><!-- camp site end  -->
		     <hr class="featurette-divider"> 
		    
  		<%-- <div>
  		<form action="post" method="post">
  		  <input type="hidden" name="regSeq" value="${DetailView.regSeq}">
		    <button type="submit">예약하러 가기</button>
		    </form>
		    </div>
		    <div> --%>
		    
		    <a href="booking.do?regSeq=${DetailView.regSeq}">예약하러 가기</a>
		    <!-- 예약 페이지로 이동 되도록 수정 --> 
  		<form action="checkBook.do" method="post">
  		  <input type="text" name="rbookSeq" value="1">
		    <button type="submit">예약정보 확인하러 가기</button>
		    </form>
		    </div>
		    	     <hr class="featurette-divider"> 
		    	     <div> 
		    	     	이 캠핑장이랑 비슷한 캠핑장 둘러보기!
		    	     </div>
    	     </div><!-- DIV row End -->
		    </div><!-- DIV row End -->
	    </div> <!-- DIV container End -->
	    </main> 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>	
<!-- Foot -->
<%@ include file = "Foot.jsp" %>
<!-- Foot End -->
</body>


</html>
