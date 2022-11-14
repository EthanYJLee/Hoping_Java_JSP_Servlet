<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>호스트 이미지 업로드</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/style.css"> 


</head>

<body>

	<%-- nav include --%>
<%@ include file = "hnav1.jsp" %>


	<div class="box container mymcontainer">
		<div style="margin-bottom: 20px; font-weight: 500; font-size: 25px;">이미지 업로드</div>
		<br>
		이미지 파일을 선택하세요: <br>
		<br>
		<form action="fileUpload.jsp" method="post" enctype="multipart/form-data">
			<input type="file" name="file" size="50" /> 
			<br> 
			<input type="submit" value="Upload File" />
		</form>
	</div>
</body>
</html>