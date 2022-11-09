<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

.myhcard{
	border-radius: 20px;
	padding: 15px;
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

.mytdtext{
	font-size: 14px;
}

.mysn{
	color: #E94560;
}

</style>

</head>

<body>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<%-- nav --%>
<%@ include file = "Nav.jsp" %>

<%-- 카드 --%>


<div class="box container mymcontainer">
	<div style="margin-bottom: 20px; font-weight: 500; font-size: 25px;">밸리 캠프</div>
	
	<div class="row row-cols-1 row-cols-md-2 g-4">
	
	      <img class="col-md" style="height:300px; border-radius:20px;" src="https://a0.muscache.com/im/pictures/7fde1672-2160-4593-90cd-00bd75da732a.jpg?im_w=1200" alt="...">
	  
	  <div class="col-md">
	  <a href="#" class="link-dark" style="text-decoration: none;">
	    <div class="card myhcard h-100">
	      <div class="card-body ">
	        <h5 class="card-title myctitle">캠핑장 정보 수정</h5>
	      </div>
	    </div>
	    </a>
	  </div>
	  <div class="col-md">
	  <a href="#" class="link-dark" style="text-decoration: none;">
	    <div class="card myhcard h-100">
	      <div class="card-body">
	        <h5 class="card-title myctitle">예약 현황</h5>
	        <hr>
	      	<table class="container">
	      		<tr><td class="col-6 mytdtext">신규예약</td><td class="col-6 mytdtext"><span class="mysn">n</span>건</td></tr>
	      		<tr><td class="col-6 mytdtext">신규예약</td><td class="col-6 mytdtext"><span class="mysn">n</span>건</td></tr>
	      		<tr><td class="col-6 mytdtext">신규예약</td><td class="col-6 mytdtext"><span class="mysn">n</span>건</td></tr>
	      	</table>
	      
	      </div>
	      
	    </div>
	    </a>
	  </div>
	  <div class="col-md">
	  <a href="#" class="link-dark" style="text-decoration: none;">
	    <div class="card myhcard h-100">
	      <div class="card-body">
	        <h5 class="card-title myctitle">문의 현황</h5>
	      <hr>
	      <table class="container">
	      		<tr><td class="col-6 mytdtext">총 문의 개수</td><td class="col-6 mytdtext"><span class="mysn">n</span>건</td></tr>
	      		<tr><td class="col-6 mytdtext">답변 미완료</td><td class="col-6 mytdtext"><span class="mysn">n</span>건</td></tr>
	      		<tr><td class="col-6 mytdtext">답변 완료</td><td class="col-6 mytdtext"><span class="mysn">n</span>건</td></tr>
	      	</table>
	      </div>
	    </div>
	    </a>
	  </div>
	  <div class="col-md">
	  <a href="#" class="link-dark" style="text-decoration: none;">
	    <div class="card myhcard h-100">
	      <div class="card-body">
	        <h5 class="card-title myctitle">월별 수입 및 예약건</h5>
	        <canvas id="myChart" width="400" height="400"></canvas>
	      </div>
	    </div>
	    </a>
	  </div>
	  <div class="col-md">
	  <a href="#" class="link-dark" style="text-decoration: none;">
	    <div class="card myhcard h-100">
	      <div class="card-body">
	        <h5 class="card-title myctitle">후기 현황</h5>
	        <hr>
	        <table class="container">
	      		<tr><td class="col-6 mytdtext">총 후기 개수</td><td class="col-6 mytdtext"><span class="mysn">n</span>건</td></tr>
	      	</table>
	      </div>
	    </div>
	    </a>
	  </div>
	  
	</div>
</div>




<script>
const ctx = document.getElementById('myChart').getContext('2d');
const myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [{
            label: '# of Votes',
            data: [12, 19, 3, 5, 2, 3],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
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









<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>