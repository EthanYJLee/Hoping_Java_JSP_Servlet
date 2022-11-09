<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">

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

<!-- Header -->
 <%@ include file = "Nav.jsp" %>
<!-- Header End -->


<main>




	<form autocomplete="off">
			<div class="col-4 col-11" style="margin-right: 0px;">
				<div class="input-group input-daterange">
					<input type="text" style="background-color: white; border-radius: 13px; height: 33px; font-size: 13px;" class="mydinput form-control" placeholder="Start" readonly>
					<input type="text" style="border-radius: 13px; height: 33px; font-size: 13px;" class="secondary form-control" placeholder="End" readonly>
				</div>
			</div>
		</form>



<div class="box container mymcontainer">
	<div class="row">
		<table>
			<tr>
				<td>roSeq</td>
				<td>roNum</td>
				<td>roPrice</td>
				<td>roMax</td>
				<td>roOccupied</td>
				<td>regcamp_regSeq</td>
				<td>regcamp_host_hSeq</td>
			<tr>
		<c:forEach items="${SelectDateDto}" var="dto">
			<tr>
				<td>${dto.roSeq}</td>
				<td>${dto.roNum}</td>
				<td>${dto.roPrice}</td>
				<td>${dto.roMax}</td>	
				<td>${dto.roOccupied}</td>	
				<td>${dto.regcamp_regSeq}</td>	
				<td>${dto.regcamp_host_hSeq}</td>	
			<tr>
		</c:forEach>
		</table>
</div>
</div>


</main>

<!-- Foot -->
<%@ include file = "foot.jsp" %>
<!-- Foot End -->


<script type="text/javascript">
$(document).ready(function(){
	
	$('.input-daterange').datepicker({
	    format: 'yyyy-mm-dd',
	    autoclose: true
	});

});
</script>

</body>
</html>