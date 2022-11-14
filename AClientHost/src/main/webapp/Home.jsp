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

#redheart {
  position: absolute;
  top: 20px;
  left : 15px; 
	
  width: 50px;
  height: 50px;
  visibility: hidden;
 
}

#btn2{

 position: absolute;
  top: 25px;
  left : 15px; 
  background-color: rgba(0,0,0,0);
  border-color: rgba(0,0,0,0);
  color: red;
  font-weight: bolder;
}


#if {
	width: 0px;
	height: 0px;
	border: 0px;
}

</style>

</head>
<body>
<!-- Header -->
 <%@ include file = "Nav.jsp" %>
<!-- Header End -->
<%-- 카드 --%>
<div class="box container mymcontainer">
	<div class="row">

		<c:forEach items="${RegCamp}" var="dto">
		  <div class="col-md">
		    <div class="card mycard">
		    <a href="detailView.do?regSeq=${dto.regSeq}">
		      <img src="./images/${dto.regImage2}" class="card-img-top myimage" alt="...">
		    </a> 
			 <!-- 22-11-14 호식
			 		현석씨 AddWish 버튼 추가 및 세션값이 있을때만 나오도록 추가 
			 -->
					<% if (session.getAttribute("CID") != null) { %>
					<div>
					
					<div>
					  
					  <input type='image' src="images/redheart.png"  
					 	 value='wish_Heart' id='redheart'   />
					    <%--사진 왼쪽상단에 빨간색 하트가 hidden으로 숨겨져 있다가 wish버튼 클릭시 visibility가 visible로 변하면서 사진이 보임 --%>
					</div>
					
					<div>
					
					<form action="count.do"  method="get" target="param">
					
					<input type="hidden" name="regSeq"	value="${dto.regSeq}" >
					<input type="hidden" name="host_hSeq" value="${dto.host_hSeq}">
					<input type="hidden" name="cId"	value=<%=session.getAttribute("CID") %> >
					 <input type="submit" id="btn2" value="wish" onclick='toggleBtn1()'/>
					  
					</form>
					</div>
					
					<iframe id="if" name="param"></iframe> 
					<%--submit해도 창이 바뀌지 않고 데이터만 넘겨주기 위해 보이지 않는 ifram을 삽입함--%>
					</div>
					
					<% } %>
			<!-- AddWish End  ----------------------- -->
		    
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

<!-- Foot -->
<%@ include file = "Foot.jsp" %>
<!-- Foot End -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript">

function toggleBtn1() {
	  
	  const redheart = document.getElementById('redheart');
	  
	  if(redheart.style.visibility !== 'visible') {
		  
		  redheart.style.visibility = 'visible'
	  }
	  else {
		  
		  redheart.style.visibility = 'hidden'
	  }
	  
	}
</script>

</body>
</html>