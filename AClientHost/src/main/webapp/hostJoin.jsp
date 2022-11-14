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
	
	
	<!--  22-11-15 hosik text field 없애고 td에서 바로 보여줌.
		form 값은 hidden으로 처리 --> 
	
	<form action="insert.do" method="post">
	<input type="hidden" name="hId" value="${mypage.cId}">
	<input type="hidden" name="hImage" value="${mypage.cImage}">
	<input type="hidden" name="cEmail" value="${mypage.cEmail}" >
	<input type="hidden" name="cPhone"  value="${mypage.cPhone}" >
	<input type="hidden" name="cId"  value="${mypage.cId}">
		<table border="0">
			<tr>
				<td style="width: 80px;">아이디</td>
				<td>${mypage.cId}</td>
			</tr>
			
			<tr>
				<td>전화번호</td>
				<td>${mypage.cPhone}</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${mypage.cEmail}</td>
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