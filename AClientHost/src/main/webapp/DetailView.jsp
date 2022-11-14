<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail View - ${DetailView.regName}</title>
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
		
			<div><h3>${DetailView.regName}</h3></div>
		<hr class="featurette-divider">
		
		<!-- 캐러셀 시작  -->
			<%-- <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
			  	<div class="carousel-indicators">
				    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
				    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
				    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
			  </div>
			  <div class="carousel-inner">
				   	 <div class="carousel-item active">
				    	 <img src="${DetailView.regImage1}" class="d-block w-100" alt="Img_1"  height="300" width="700">
				    </div>
				    <div class="carousel-item">
				   		 <img src="${DetailView.regImage2}" class="d-block w-100" alt="Img_2" height="300"  width="700">
				    </div>
				    <div class="carousel-item">
				     	 <img src="${DetailView.regImage3}" class="d-block w-100" alt="Img_1" height="300"  width="700">
				    </div>
			  </div>
			  
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
		<hr class="featurette-divider">  --%> 	
		
		<%-- carousel 대신 이미지 카드 넣기 --%>
		
		<%-- 이미지 카드 넣는 컨테이너 --%>
		<div class="row justify-container-center">
			
			<%-- forEach 여기서 돌리세요 --%>
			<div class="col-md">
				<img style="margin-bottom: 20px; border-radius: 5px; width: 18rem;"
					src="https://a0.muscache.com/im/pictures/prohost-api/Hosting-607458038229062130/original/1e20dfc7-ea12-44b2-a837-2bdcd8502133.jpeg?im_w=720" 
					class="card" alt="...">
			</div>
			<div class="col-md">
				<img style="margin-bottom: 20px; border-radius: 5px; width: 18rem;"
					src="https://a0.muscache.com/im/pictures/baf9b74b-edc9-409d-b15c-dbd48883486c.jpg?im_w=720" 
					class="card" alt="...">
			</div>
			<div class="col-md">
				<img style="margin-bottom: 20px; border-radius: 5px; width: 18rem;"
					src="https://a0.muscache.com/im/pictures/miso/Hosting-646814822102982021/original/a040ce6f-245b-42af-95db-7a5a7c59a272.jpeg?im_w=720" 
					class="card" alt="...">
			</div>
			
		</div>
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
		     
		    <!-- 예약하러 가기 --> 
	  		<div class="container-md d-flex justify-content-center" style="margin-top: 10px;">
	  		
	  		<% if (session.getAttribute("CID") == null) { %>
	  			<a href="ClientLoginView.jsp">
			    <button type="submit" class="btn btn-primary">로그인을 하셔야 예약이나 문의를 하실 수 있어요</button>
			    </a>
			       <% } else { %>
			       
			       <form action="booking.do" method="post"style="margin: 10px;">
	  				  <input type="hidden" name="regSeq" value="${DetailView.regSeq}" >
				      <button type="submit" class="btn btn-primary">예약하러 가기</button>
		    	</form>
		    	<form action="askView.do" method="post" style="margin: 10px;">
	  				  <input type="hidden" name="regSeq" value="${DetailView.regSeq}" >
	  				  <input type="hidden" name="regName" value="${DetailView.regName}" >
				      <button type="submit" class="btn btn-primary" <%-- onclick="<!-- /**/ -->" --%>>문의하러 가기</button>
		    	</form>
        <% } %>
	  		
		    </div>
		    
		    
		    	     <hr class="featurette-divider">


				<div>
					후기보기 &nbsp;&nbsp;&nbsp;
					<div>후기 평균 : ${reviewAvg.rvStar}</div>


					<div class="container">
						<div class="card myhcard" style="border-radius: 20px;">
							<table>
								<tr class="myhtr">
									<td class="myth">작성자</td>
									<td class="myth">제목</td>
									<td class="myth">작성 시간</td>
								</tr>
								<c:forEach items="${reviewList}" var="dto">
									<tr class="myhtr">
										<td class="mytd">${dto.rvCId}</td>
										<td class="mytd"><a href="reviewDetailView.do?rvSeq=${dto.rvSeq}">${dto.rvTitle}</a></td>
										<td class="mytd">${dto.rvTime}</td>
										<%--	<td class="mytd">${dto.regName}</td><td class="mytd"><a href="pay.do?roNum=${dto.roNum}">${dto.roNum}</a></td><td class="mytd">${dto.regCategory}</td><td class="mytd"><fmt:formatNumber value="${dto.roPrice}" pattern="#,###"/>원</td>><td class="mytd">${dto.roMax}명</td> --%>
									</tr>
								</c:forEach>
							</table>
							
						<a href="writeReview.do?regSeq=${DetailView.regSeq}">후기작성하기</a>
					</div>
				</div>
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
