<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호스트 정보수정</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">

<link rel="stylesheet" href="css/yjstyle.css">

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




</head>
<body>

<%-- nav --%>
	<%@ include file="hnav1.jsp"%>
 
 <main class="form-signin w-50 m-auto" style="margin: 20px">
	<div class="box container mymcontainer">
	<div style="margin-bottom: 20px; font-weight: 500; font-size: 25px;">호스트 정보수정</div>
	
	
	<form action="modify.do" method="get" enctype="multipart/form-data">
	
	
		<table border="0">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="cId" size="20" value="${hInfo.hId}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="cName" size="20" value="${hInfo.cName}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="cPhone" size="50" value="${hInfo.cPhone}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="cEmail" size="50" value="${hInfo.cEmail}" readonly="readonly"></td>
			</tr>

			<tr>
				<td>자기소개</td>
				<td><textarea name="hSummary" rows="10" cols="50">${hInfo.hSummary}</textarea></td>
			</tr>
			<tr>
				<td>사진</td>
				<td><img src="./images/${hInfo.hImage}" style="width:200px; height:400px;"></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="수정">
			</tr>
			
		
		</table>
	
	</form>
	
	</div>
	</main>
</body>
</html>