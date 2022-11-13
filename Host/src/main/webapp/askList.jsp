<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<head>
<meta charset="UTF-8">
<title>문의리스트</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">


<link rel="stylesheet" href="Host.css">
<style type="text/css">


</style>



<script type="text/javascript">
    $(document).ready(function () {
            $.datepicker.setDefaults($.datepicker.regional['ko']); 
            $( "#startDate" ).datepicker({
                 changeMonth: true, 
                 changeYear: true,
                 nextText: '다음 달',
                 prevText: '이전 달', 
                 dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
                 dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
                 monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                 monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                 dateFormat: "yy-mm-dd",
                 maxDate: 0,                       // 선택할수있는 최소날짜, ( 0 : 오늘 이후 날짜 선택 불가)
                 onClose: function( selectedDate ) {    
                      //시작일(startDate) datepicker가 닫힐때
                      //종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
                     $("#endDate").datepicker( "option", "minDate", selectedDate );
                 }    
 
            });
            $( "#endDate" ).datepicker({
                 changeMonth: true, 
                 changeYear: true,
                 nextText: '다음 달',
                 prevText: '이전 달', 
                 dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
                 dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
                 monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                 monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                 dateFormat: "yy-mm-dd",
                 maxDate: 0,                       // 선택할수있는 최대날짜, ( 0 : 오늘 이후 날짜 선택 불가)
                 onClose: function( selectedDate ) {    
                     // 종료일(endDate) datepicker가 닫힐때
                     // 시작일(startDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 시작일로 지정
                     $("#startDate").datepicker( "option", "maxDate", selectedDate );
                 }    
 
            });    
    });
</script>

</head>
<body>

<%-- nav --%>
	<%@ include file = "hnav1.jsp" %>
 
  <%--search바 --%>
<div class="container myscontainer">
	<div class="row myhtitle">
		<div><b>예약 관리</b></div>
	</div>
	<div class="row">
		<%-- 콤보박스 --%>
		<select class="col-1 form-select form-select-sm" aria-label=".form-select-sm example">
		  <option selected>캠핑장 이름</option>
		  <option value="1">아이디</option>
		  <option value="2">캠핑장 번호</option>
		  <option value="3">답변완료</option>
		  <option value="4">답변미완료</option>
		</select>
		
		<%-- 달력입니당. --%>
		<form class="col-10" action="">
			<div class="row">
			<div class="col-4" autocomplete="off">
					<div class="input-group input-daterange">
						<input name="startDate" value="start" type="text" style="background-color: white; border-radius: 13px; height: 33px; font-size: 13px;" class="mydinput form-control" placeholder="Start" readonly>
						<input name="endDate" type="text" style="border-radius: 13px; height: 33px; font-size: 13px;" class="secondary form-control" placeholder="End" readonly>
					</div>
			</div>
			<%-- search --%>
			<div class="col-7" role="search">
				<input name="strSearch" style="width: 450px;" type="search" class="mysearch " aria-label="Search">
			</div>
			<button type="submit" class="text-decoration-none col-1" style="background-color:transparent; border: 0px solid black;">
				<svg class="mysvg" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
					  <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
				</svg>
			</button>
	        </div>
	    </form>
        </div>
	</div>

<%-- 테이블 --%>
<div class="container">
	<div class="card myhcard" style="border-radius: 20px;">
		<table>
			<tr class="myhtr">
				<td class="myth">문의번호</td><td class="myth">작성자ID</td><td class="myth">제목</td><td class="myth">작성날짜</td><td class="myth">답변여부</td>
			</tr>
			<%-- 예약 내역 list for문 돌리기 --%>
			<c:forEach items="${list}" var="dto">
				
				<tr class="myhtr">
					<td class="mytd">${dto.aSeq}</td>
					<td class="mytd">${dto.aCId}</td>
					<td class="mytd"><a href="askDetail.do?aSeq=${dto.aSeq}">${dto.aTitle}</a></td>
					<td class="mytd">${dto.aTime}</td>
					<td class="mytd">${dto.aRegSeq}</td>
					
				
				</tr>
			</c:forEach>
		</table>	  
	</div>
</div>
 
</body>
</html>