<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호스트 정보 확인페이지</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/style.css"> 


</head>
<body>



<%-- nav --%>

<div class="container">
<%-- nav include   22.11.14 호식 수정 --%>
<%@ include file = "hnav1.jsp" %>

 </div>

 
 
 
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
				<td><textarea name="hSummary" rows="10" cols="50">${fileView.hSummary}</textarea></td>
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
	</div>
</body>
</html>