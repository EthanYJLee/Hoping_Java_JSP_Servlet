<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호스트 마이페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">

<link href="css/style.css" rel="stylesheet" >



</head>
<body>

<%-- nav include   22.11.14 호식 수정 --%>
<%@ include file = "hnav1.jsp" %>
<%-- nav include End --%>

<main class="form-signin w-50 m-auto" style="margin: 20px">
<div class="container">
	<div class="box container mymcontainer">

	<div style="margin-bottom: 20px; font-weight: 500; font-size: 25px;">호스트 정보등록</div>
	
	
	<form action="insert.do" method="post">
	<input type="hidden" name="hId" value="${mypage.cId}">
	<input type="hidden" name="hImage" value="${mypage.cImage}">
	
		<table border="0">
			<tr>
				<td style="width: 80px;">아이디</td>
				<td><input type="text" name="cId" size="20" value="${mypage.cId}"></td>
			</tr>
			
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="cPhone" size="50" value="${mypage.cPhone}"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="cEmail" size="50" value="${mypage.cEmail}"></td>
			</tr>

			<tr>
				<td>자기소개</td>
				<td><textarea name="hSummary" rows="10" cols="50"></textarea></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="등록">
			</tr>
			
		
		</table>
	
	</form>
	</div>
	</div>
	</main>
</body>
</html>