<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="date" value="<%=new Date()%>"/>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>매출 / 예약 통계 상세페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link rel="stylesheet" href="css/Design.css">
<link rel="stylesheet" href="css/HostCard.css">
<link rel="stylesheet" href="css/TableCenter.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/carousel.css">


<script src="https://cdn.jsdelivr.net/npm/chart.js@3.9.1/dist/chart.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
      * {
        margin: 0;
        padding: 0;
        font-family: sans-serif;
      }
      .chartMenu {
        width: 100vw;
        height: 40px;
        background: #1A1A1A;
        color: rgba(255, 26, 104, 1);
      }
      .chartMenu p {
        padding: 10px;
        font-size: 20px;
      }
      .chartCard {
        width: 100vw;
        height: calc(100vh - 40px);
        background: rgba(255, 255, 255, 0.15);
        display: flex;
        align-items: center;
        justify-content: center;
      }
      .chartBox {
        width: 700px;
        padding: 20px;
        border-radius: 20px;
        border: solid 3px rgba(10, 10, 10, 1);
        background: white;
      }
    </style>
  </head>
<body>
<%-- nav include --%>
<%@ include file = "hnav2.jsp" %>

    <div class="chartMenu">
		현재시각 : <fmt:formatDate value="${date}" type="both"/>
    </div>
    <div class="chartCard">
      <div class="chartBox">
        <canvas id="myChart"></canvas>
        <input onchange="filterData()" type="date" id="startdate" value="${MINDATE}">
		<input onchange="filterData()" type="date" id="enddate" value="${MAXDATE}">
      </div>
    </div>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>
    // setup 

    const dates = [];
    <c:forEach items="${STATLIST}" var="list">
    dates.push('${list.boDate}');
    </c:forEach>
    const datapoints = [];
    <c:forEach items="${STATLIST}" var="list">
    datapoints.push('${list.boPrice}');
    </c:forEach>
    const datapoints2 = [];
    <c:forEach items="${STATLIST}" var="list">
    datapoints2.push('${list.boGroup}');
    </c:forEach>
    
    const data = {
    		  labels: dates,
    		  datasets: [
    		    {
    		      label: '매출',
    		      data: datapoints,
    		      borderColor: 'rgba(200, 26, 50, 1)',
    		      backgroundColor: 'rgba(120, 26, 104, 0.2)',
    		      yAxisID: 'y',
    		    },
    		    {
    		      label: '예약건수',
    		      data: datapoints2,
    		      borderColor: 'rgba(75, 100, 220, 1)',
    		      backgroundColor: 'rgba(120, 26, 104, 0.2)',
    		      yAxisID: 'y1',
    		    }
    		  ]
    		};

    // config 
    const config = {
    		type: 'line',
    		  data: data,
    		  options: {
    		    responsive: true,
    		    interaction: {
    		      mode: 'index',
    		      intersect: false,
    		    },
    		    stacked: false,
    		    plugins: {
    		      title: {
    		        display: true,
    		        text: '매출/예약건수 통계'
    		      }
    		    },
    		    scales: {
    		      y: {
    		        type: 'linear',
    		        display: true,
    		        position: 'left',
    		      },
    		      y1: {
    		        type: 'linear',
    		        display: true,
    		        position: 'right',

    		        // grid line settings
    		        grid: {
    		          drawOnChartArea: false, // only want the grid lines for one axis to show up
    		        },
    		      },
    		    }
    		  },
    		};

    // render init block
    const myChart = new Chart(
      document.getElementById('myChart'),
      config
    );
    
    function filterData(){
    	const dates2 = [...dates];
    	console.log(dates2);
    	const startdate = document.getElementById('startdate');
    	const enddate = document.getElementById('enddate');
    	
    	// get the index number in array
    	const indexstartdate = dates2.indexOf(startdate.value);
    	const indexenddate = dates2.indexOf(enddate.value);
    	// console.log(indexstartdate);
    	
    	// slice array showing only selected section
    	const filterDate = dates2.slice(indexstartdate, indexenddate + 1);
    	
    	// replace the labels in the chart
    	myChart.config.data.labels = filterDate;
    	
    	// datapoints
    	const datapoints3 = [...datapoints];
    	const datapoints4 = [...datapoints2];
    	const filterDatapoints = datapoints3.slice(indexstartdate, indexenddate + 1);
    	const filterDatapoints2 = datapoints4.slice(indexstartdate, indexenddate + 1);
    	
    	myChart.config.data.datasets[[0],[0]].data = filterDatapoints, filterDatapoints2;
    		
    	myChart.update();
    }

    
    </script>

  </body>
</html>