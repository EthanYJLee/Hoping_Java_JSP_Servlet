<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호스트 매출/예약 통계 상세 페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css">
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

<link rel="stylesheet" href="css/Design.css">
<link rel="stylesheet" href="css/HostCard.css">
<link rel="stylesheet" href="css/TableCenter.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/carousel.css">

<script src="https://cdn.jsdelivr.net/npm/chart.js@3.9.1/dist/chart.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
</head>





<body>
<%-- nav include --%>
<%@ include file = "hnav2.jsp" %>



<div class="container py-4">
<nav class="navbar navbar-expand-md bg-light">
	<div class="container-fluid">
		<h2 class="display-9 fw-bold">매출/예약통계 상세조회</h2>
		<a class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
		<select id="selectCamp" name="selectCamp" onchange="changeCampSelect()">
			<option value="">캠핑장을 선택해주세요</option>
			<c:forEach var="list" items="${host_regName_list}">
			<option value="${list}"<c:if test ="${user.selectedList eq list}">selected="selected"</c:if>>${list}</option>
			</c:forEach>
		</select>
		</a>
	</div>
</nav>
</div>



<div class="row align-center-items-md-stretch py-3 justify-content-center">
	<div class="col-md-4">
		<div class="h-100 p-5 bg-light border rounded-3">

<canvas id="dailyProfitChart" width="150" height="60"></canvas>
<script>
// 차트를 그럴 영역을 dom요소로 가져온다.
var chartArea = document.getElementById('dailyProfitChart').getContext('2d');
// 차트를 생성한다. 
var mpdata = [];
<c:forEach items="${dailyProfit}" var="dp">
mpdata.push('${dailyProfit}');
</c:forEach>
var dailyProfitChart = new Chart(chartArea, {

    // ②차트의 데이터(Object)
    data: {
        // ③x축에 들어갈 이름들(Array)
        labels: ['1', '2', '3', '4', '5', '6', '7'],
        // ④실제 차트에 표시할 데이터들(Array), dataset객체들을 담고 있다.
        datasets: [{
        	type: 'line',
            // ⑤dataset의 이름(String)
            label: '일별 매출',
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
<canvas id="dailyReserveChart" width="150" height="60"></canvas>
			<script>
var chartArea = document.getElementById('dailyReserveChart').getContext('2d');
var mrdata = [];
<c:forEach items="${mr}" var="mr">
mrdata.push('${mr}');
</c:forEach>
var dailyReserveChart = new Chart(chartArea, {

    data: {
        labels: ['1', '2', '3', '4', '5', '6', '7'],
        datasets: [{
        	type: 'line',
            label: '일별 예약',
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


</div>
</div>
<div class="col-md-4">
		<div class="h-100 p-5 bg-light border rounded-3">

<canvas id="weeklyProfitChart" width="150" height="60"></canvas>
<script>
// 차트를 그럴 영역을 dom요소로 가져온다.
var chartArea = document.getElementById('weeklyProfitChart').getContext('2d');
// 차트를 생성한다. 
var mpdata = [];
<c:forEach items="${mp}" var="mp">
mpdata.push('${mp}');
</c:forEach>
var weeklyProfitChart = new Chart(chartArea, {

    // ②차트의 데이터(Object)
    data: {
        // ③x축에 들어갈 이름들(Array)
        labels: ['1', '2', '3', '4'],
        // ④실제 차트에 표시할 데이터들(Array), dataset객체들을 담고 있다.
        datasets: [{
        	type: 'line',
            // ⑤dataset의 이름(String)
            label: '주별 매출',
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
<canvas id="weeklyReserveChart" width="150" height="60"></canvas>
			<script>
var chartArea = document.getElementById('weeklyReserveChart').getContext('2d');
var mrdata = [];
<c:forEach items="${mr}" var="mr">
mrdata.push('${mr}');
</c:forEach>
var weeklyReserveChart = new Chart(chartArea, {

    data: {
        labels: ['1', '2', '3', '4'],
        datasets: [{
        	type: 'line',
            label: '주별 예약',
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


</div>
</div>
<div class="col-md-4">
		<div class="h-100 p-5 bg-light border rounded-3">

<canvas id="monthlyProfitChart" width="150" height="60"></canvas>
<script>
// 차트를 그럴 영역을 dom요소로 가져온다.
var chartArea = document.getElementById('monthlyProfitChart').getContext('2d');
// 차트를 생성한다. 
var mpdata = [];
<c:forEach items="${mp}" var="mp">
mpdata.push('${mp}');
</c:forEach>
var monthlyProfitChart = new Chart(chartArea, {

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
<canvas id="monthlyReserveChart" width="150" height="60"></canvas>
			<script>
var chartArea = document.getElementById('monthlyReserveChart').getContext('2d');
var mrdata = [];
<c:forEach items="${mr}" var="mr">
mrdata.push('${mr}');
</c:forEach>
var monthlyReserveChart = new Chart(chartArea, {

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


</div>
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
</body>
</html>