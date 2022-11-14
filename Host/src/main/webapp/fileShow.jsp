<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호스트 정보 확인페이지</title>

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



<%-- nav --%>
	<%@ include file="hnav1.jsp"%>
 
 
 
	<div class="box container mymcontainer">
	<div style="margin-bottom: 20px; font-weight: 500; font-size: 25px;">호스트 사진확인</div>

	<form action="fileView.do" method="get" enctype="multipart/form-data">
		
		<table border="0">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="hId" size="20" value="${fileView.hId}"></td>
			</tr>
			<tr>
				<td>소개</td>
				<td><input type="text" name="hSummary" size="20" value="${fileView.hSummary}"></td>
			</tr>
			<tr>
				<td>사진</td>
				<td><img src="./images/${fileView.hImage}" style="width:200px; height:400px;"></td>
			</tr>
			<tr>
				<td colspan="2"><a href="HostRegMapApi.jsp">캠핑장 등록하기</a></td>
			</tr>
		</table>
	</form>
</body>
</html>