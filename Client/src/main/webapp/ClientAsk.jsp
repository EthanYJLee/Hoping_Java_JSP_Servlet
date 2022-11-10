<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/navbar-fixed/">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" 
	 rel="stylesheet" >
<link href="css/style.css" rel="stylesheet" >
<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800'); 
@import url('https://fonts.googleapis.com/css2?family=Ubuntu&display=swap');
</style>
</head>
<body>

<%@ include file = "Nav2.jsp" %>

<form class="container">
	<div class="row ">
		<div class="col-2"></div>
		<div class="col-8 ">
			<h4 style="margin: 15px 0px 30px 0px;">문의 내용 입력하기</h4>
			<table style="margin-bottom: 25px;">
				<tr>
					<td style="padding-right: 15px">제목</td><td><input class="form-control" type="text"></td>
				</tr>
				<tr>
					<td style="padding-right: 15px">문의 내용</td>
					<td>
						<div class="form-floating">
	  						<textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 300px; width:400px;"></textarea>
	 						<label for="floatingTextarea2">Comments</label>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div class="col-2"></div>
	</div>
	<div class="row justify-content-end">
		<div class="col-5">
			<button type="submit" style="border-radius: 15px; width:100px;" class=" btn btn-secondary">완료</button>
		</div>
	</div>
</form>


</body>
</html>