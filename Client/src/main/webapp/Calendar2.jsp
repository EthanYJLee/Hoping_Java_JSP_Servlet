<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Hoping Camp</title>
<link rel="stylesheet" href="css/style.css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap-responsive.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script src="https://https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.js"></script>

</head>
<body>
<%-- nav --%>
<!-- Header -->
 <%@ include file = "Nav2.jsp" %>
<!-- Header End -->
<%--search바 --%>
<div class="container myscontainer">
	<div class="row myhtitle">
		<div><b>캠핑장을 이용하실 날짜를 선택해 주세요</b></div>
	</div>
	<div class="d-flex align-items-center justify-content-center justify-content-lg-center">
		<%-- 달력입니당. --%>
		<%-- <form autocomplete="off">--%>
		<form action="bookingdatecheck.do"class="col-12 col-lg-auto mb-4 mb-lg-0 me-lg-4" role="search">
			<div class="col-4 col-11" style="margin-right: 0px;">
				<div class="input-group input-daterange">
					<input type="text" name="startdate" style="background-color: white; border-radius: 13px; height: 33px; font-size: 13px;" class="mydinput form-control" placeholder="Start" readonly>
					<input type="text" name="stopdate" style="border-radius: 13px; height: 33px; font-size: 13px;" class="secondary form-control" placeholder="End" readonly>
			<label for="btnSubmit">
				<svg class="mysvg" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
					  <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
				</svg>
			</label>
		<input type="submit" id="btnSubmit" style="display:none;" />
        </form>
        
				</div>
			</div>
        
        
        
        
	</div>
</div>

<%-- 테이블 --%>
<div class="container">
	<div class="card myhcard" style="border-radius: 20px;">
		<table>
			<tr class="myhtr">
				<td class="myth">캠핑장 이름</td><td class="myth">사이트 넘버</td><td class="myth">카테고리</td><td class="myth">사이트 가격</td><td class="myth">최대수용 인원</td>
			</tr>
			<c:forEach items="${Camp}" var="dto">
			<tr class="myhtr">
				<td class="mytd">${dto.regName}</td><td class="mytd">${dto.roNum}</td><td class="mytd">${dto.regCategory}</td><td class="mytd"><fmt:formatNumber value="${dto.roPrice}" pattern="#,###"/>원</td><td class="mytd">${dto.roMax}명</td>
			<%--	<td class="mytd">${dto.regName}</td><td class="mytd"><a href="pay.do?roNum=${dto.roNum}">${dto.roNum}</a></td><td class="mytd">${dto.regCategory}</td><td class="mytd"><fmt:formatNumber value="${dto.roPrice}" pattern="#,###"/>원</td>><td class="mytd">${dto.roMax}명</td> --%>

			</tr>
			</c:forEach>
		</table>	  
	</div>
</div>
    

<script type="text/javascript">
$(document).ready(function(){
	
	$('.input-daterange').datepicker({
	    format: 'yyyy-mm-dd',
	    autoclose: true
	});

});
</script>

  
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
<!-- Foot -->
<%@ include file = "Foot.jsp" %>
<!-- Foot End -->
</body>
</html>
