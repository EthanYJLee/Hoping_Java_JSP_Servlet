<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 상세</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/yjstyle.css">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap-responsive.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script
	src="https://https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.js"></script>
<style type="text/css">
<
style type ="text /css ">.mybtns {
	border: 0 solid black;
	transition: background-color .5s;
	border-radius: 15px;
}

.mybtns:hover {
	background-color: #E94560;
}
</style>

</head>
<body>

	<%-- nav --%>
	<%@ include file="hnav1.jsp"%>



	<%-- 상세정보 --%>
	<div class="container myscontainer">
		<h4>문의 상세</h4>
		<br>
		<div class="row myhdrow">
			<div class="col-6 mydtitle">문의번호 ${askDetail.aSeq}</div>

			<div class="card col-md-6" style="border: 0px solid black;">
				<div class="myhdth">캠핑장 번호 ${askDetail.aRegSeq}</div>
			</div>

			<div class="card col-md-6" style="border: 0px solid black;">
				<div class="myhdth">문의날짜 ${askDetail.aTime}</div>
			</div>

			<div class="card col-md-6" style="border: 0px solid black;">
				<div class="myhdth">이름 ${askDetail.aCId}</div>
			</div>
		</div>
		<div class="row myhdrow">
			<div class="card col-md-6" style="border: 0px solid black;">
				<div class="myhdth">문의제목</div>
				<div class="myhdtd">${askDetail.aTitle}</div>
			</div>
			<br>
			<br></br>
			</br>
			<div class="row myhdrow">
				<div class="card col-md-6" style="border: 0px solid black;">
					<div class="myhdth">문의내용</div>
					<div class="myhdtd">${askDetail.aContent}</div>
				</div>
			</div>
		</div>
	</div>



	<br>
	<br>
	<br>
	<%-- 상세정보 --%>
	<form action="aComment.do" method="get">
	
	<input type="hidden" name="acTitle" size="20"
					value="${askDetail.aTitle}%>" >
		<div class="container myscontainer">
			<h4>문의 답변</h4>
			<br>
			<div class="row">
			<div class="col-6 mydtitle">문의번호 <input type="text" name="ask_aSeq" size="20"
					value="${askDetail.aSeq}"></div>

			<div class="card col-md-6" style="border: 0px solid black;">
				<div class="myhdth">캠핑장 번호 ${askDetail.aRegSeq}</div>
			</div>
			</div>
			
			<div class="row myhdrow">
				<div class="card col-md-6" style="border: 0px solid black;">
					<div class="myhdth">
						호스트
						<input type="text" name="host_hSeq" size="20"
					value="<%=session.getAttribute("HSEQ")%>" ></div>
				</div>

			</div>
			<div class="row myhdrow">
				<div class="card col-md-6" style="border: 0px solid black;">
					<div class="myhdth">문의제목</div>
					<div class="myhdtd">${askDetail.aTitle}</div>
				</div>
				<br>
				<br></br>
				</br>
				<div class="row myhdrow">
					<div class="card col-md-6" style="border: 0px solid black;">
						<div class="myhdth">
							문의답변
							<textarea name="acContent" rows="10" cols="50"></textarea>
						</div>
					</div>
				</div>
				<div class="d-flex flex-row-reverse">
					<div class="p-2">
						<input type="submit"
							style="border-radius: 15px; width: 70px;"
							class="btn mybtns btn-secondary" value="등록">
					</div>
				</div>
			</div>
		
		</div>
		</form>




</body>
</html>