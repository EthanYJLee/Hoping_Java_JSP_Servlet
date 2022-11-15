<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호스트 통합 메인 페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link rel="stylesheet" href="css/Design.css">
<link rel="stylesheet" href="css/HostCard.css">
<link rel="stylesheet" href="css/TableCenter.css">
<link rel="stylesheet" href="css/HostStyle.css">
<link rel="stylesheet" href="css/carousel.css">


<script src="https://cdn.jsdelivr.net/npm/chart.js@3.9.1/dist/chart.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

</head>

<body>

<%-- nav include --%>
<%@ include file = "hnav2.jsp" %>

<main>



<div class="container py-4">




<div class="p-3 mb-4 bg-light rounded-3">
	<div class="container-fluid py-3">
		<h2 class="display-7 fw-bold">나의 캠핑장 정보</h2><br><br>
		<div class="row">
			<c:forEach var="camplist" items="${host_camp_thumbnail}">
			<div class="col"><div class="card mx-auto" style="width: 14rem;">
				<img src="./images/${camplist.regImage1}" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">${camplist.regName}</h5>
					<p class="card-text">${camplist.regDetailaddress}</p>
					<a href="host_modify_camp.do?regSeq=${camplist.regSeq}" class="btn btn-primary">캠핑장 정보 수정</a>
				</div>
			</div></div>
			</c:forEach>
		</div>
	</div>
</div>





<div class="row align-items-md-stretch py-3">
	<div class="col-md-6">
		<div class="h-100 p-5 bg-light border rounded-3">
			<h2>오늘 예약현황</h2>
			<br>
			<p>신규예약 : ${nr}</p>
			<p>오늘 체크인 예정 : ${todayIn}</p>
			<p>오늘 체크아웃 예정 : ${todayOut}</p>
			<div class="form-row float-right">
			<button type="button" class="btn text-secondary" onclick="location.href='bookList.do'">상세보기</button>
			</div>
		</div>
	</div>
	<div class="col-md-6">
		<div class="h-100 p-5 bg-light border rounded-3">
			<h2>오늘 문의현황</h2>
			<br>
			<p>신규문의 : ${tq}</p>
			<p>답변 완료 : ${trq}</p>
			<p>답변 미완료 : ${tnrq}</p>
			<div class="form-row float-right">
			<button type="button" class="btn text-secondary" onclick="location.href='askList.do'">상세보기</button>
			</div>
		</div>
	</div>
</div>

<div class="row align-items-md-stretch py-3">
	<div class="col-md-6">
		<div class="h-100 p-5 bg-light border rounded-3">
			<h2>월별 매출 및 예약건</h2>
			<br>
<canvas id="profitChart" width="150" height="60"></canvas>
<script>
// 차트를 그럴 영역을 dom요소로 가져온다.
var chartArea = document.getElementById('profitChart').getContext('2d');
// 차트를 생성한다. 
var mpdata = [];
<c:forEach items="${mp}" var="mp">
mpdata.push('${mp}');
</c:forEach>
var profitChart = new Chart(chartArea, {

    // ②차트의 데이터(Object)
    data: {
        // ③x축에 들어갈 이름들(Array)
        labels: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
        // ④실제 차트에 표시할 데이터들(Array), dataset객체들을 담고 있다.
        datasets: [{
        	type: 'line',
            // ⑤dataset의 이름(String)
            label: '월별 매출',
            // ⑥dataset값(Array)
            data: mpdata,
            // ⑦dataset의 배경색(rgba값을 String으로 표현)
            backgroundColor: 'rgba(255, 99, 132, 0.2)',
            // ⑧dataset의 선 색(rgba값을 String으로 표현)
            borderColor: 'rgba(255, 99, 132, 1)',
            // ⑨dataset의 선 두께(Number)
            borderWidth: 1
        }]
    },
    // ⑩차트의 설정(Object)
    options: {
        // ⑪축에 관한 설정(Object)
        scales: {
            // ⑫y축에 대한 설정(Object)
            y: {
                // ⑬시작을 0부터 하게끔 설정(최소값이 0보다 크더라도)(boolean)
                beginAtZero: true
            }
        }
    }
});
</script>
<canvas id="reserveChart" width="150" height="60"></canvas>
			<script>
var chartArea = document.getElementById('reserveChart').getContext('2d');
var mrdata = [];
<c:forEach items="${mr}" var="mr">
mrdata.push('${mr}');
</c:forEach>
var reserveChart = new Chart(chartArea, {

    data: {
        labels: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
        datasets: [{
        	type: 'line',
            label: '월별 예약',
            data: mrdata,
            backgroundColor: 'rgba(255, 99, 132, 0.2)',
            borderColor: 'rgba(255, 99, 132, 1)',
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});
</script>
<div class="form-row float-right">
	<button type="button" class="btn text-secondary" onclick="location.href='detail_stat_view.do'">상세보기</button>
</div>



		</div>
	</div>
	<div class="col-md-6">
		<div class="h-100 p-5 bg-light border rounded-3">
			<h2>오늘 후기현황</h2>
			<br>
			<p>신규후기 : ${tr}</p>
			<p>답변 완료 : ${trr}</p>
			<p>답변 미완료 : ${tnrr}</p>
			<%@ include file = "HostMyStar.jsp" %>
			<p></p>
			<div class="form-row float-right">
			<button type="button" class="btn text-secondary">상세보기</button>
			</div>
		</div>
	</div>
</div>
</div>

</main>










<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>