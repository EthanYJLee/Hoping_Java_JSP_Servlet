<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 하기</title>
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
	
	<!-- 22-11-11 호식 -
				예진씨가 기본틀 작성.
				Controller, command 연결 및 기능구현 
				
	--> 

<%@ include file = "Nav2.jsp" %>

	
	<main>
	<div  class="container-md d-flex justify-content-center">
		<form action="" method="post">
					
			<table style="margin-bottom: 25px;">
					<tr><td colspan="2"><h4 style="margin: 15px 0px 30px 0px;"> 문의 내용 입력하기</h4></td></tr>
					<tr>
						<td style="padding-right: 15px" colspan="2">${regName} 캠핑장 </td>
					</tr>
					<tr>
						<td style="padding-right: 15px">제목</td><td><input class="form-control" type="text"></td>
					</tr>
						<tr>
						<td style="padding-right: 15px">작성자</td><td>${cId} </td>
					</tr>
						<tr>
						<td style="padding-right: 15px">받는사람 </td><td>${hostSeq} </td>
					</tr>
					<tr>
						<td style="padding-right: 15px">문의 내용</td>
						<td><div class="form-floating">
	  						<textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 300px; width:400px;"></textarea>
	 						<label for="floatingTextarea2">Comments</label></div>
						</td>
				</tr>
				<tr><td></td><td>
					<input type="hidden" name="host_seq" name="host_seq" value ="<%-- ${ host _seq 가지고 올거임 } --%>">
					<button type="submit" style="border-radius: 15px; width:100px;" class=" btn btn-secondary">완료</button>
				</td></tr>
			</table>
		</form>
		</div>
	</main>
<%@ include file = "Foot.jsp" %>

</body>
</html>