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
	  			<form action="booking.do" method="post"style="margin: 10px;">
	  				  <input type="hidden" name="regSeq" value="${DetailView.regSeq}" >
				      <button type="submit" class="btn btn-primary">예약하러 가기</button>
		    	</form>
		    	<form action="askView.do" method="post" style="margin: 10px;">
	  				  <input type="hidden" name="regSeq" value="${DetailView.regSeq}" >
	  				  <input type="hidden" name="regName" value="${DetailView.regName}" >
				      <button type="submit" class="btn btn-primary" <%-- onclick="<!-- /**/ -->" --%>>문의하러 가기</button>
		    	</form>
		    </div>
		    		    	     <hr class="featurette-divider"> 
		    
		    <div> 
		  		<form action="checkBook.do" method="post">
		  			  <input type="text" name="rbookSeq" value="1">
				      <button type="submit" class="btn btn-primary">예약정보 확인하러 가기</button>
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
