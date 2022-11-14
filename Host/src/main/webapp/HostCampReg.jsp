<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑장 상세정보 등록</title>
<% String hostadresss = request.getParameter("hostaddress"); %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>


<%-- nav include   22.11.14 호식 수정 --%>
<%@ include file = "hnav1.jsp" %>

<main style="margin: 20px">

<br> <br>
<form action="regcamp.do" method="get">
<h5>캠핑장의 장소적 특성을 선택해 주세요.</h5>
<input type="checkbox" class="btn-check" name="RBnearsea" id="option1"  autocomplete="off">
<label class="btn btn-outline-primary" for="option1">바다 근처</label>

<input type="checkbox" class="btn-check" name="RBnearseas" id="option2" autocomplete="off">
<label class="btn btn-outline-primary" for="option2">계곡 근처</label>

<input type="checkbox" class="btn-check" name="RBnearforest" id="option3" autocomplete="off">
<label class="btn btn-outline-primary" for="option3">숲 근처</label>

<input type="checkbox" class="btn-check" name="RBnearmountain" id="option4" autocomplete="off">
<label class="btn btn-outline-primary" for="option4">산 근처</label> <br> <br>

<h5>캠핑장의 카테고리를 선택해 주세요.</h5>
<input type="radio" class="btn-check" name="regCategory" id="option5" value="아파트"  autocomplete="off">
<label class="btn btn-outline-primary" for="option5" >아파트</label>

<input type="radio" class="btn-check" name="regCategory" id="option6"value="주택" autocomplete="off">
<label class="btn btn-outline-primary" for="option6">주택</label>

<input type="radio" class="btn-check" name="regCategory" id="option7" value="별채" autocomplete="off">
<label class="btn btn-outline-primary" for="option7" >별채</label>

<input type="radio" class="btn-check" name="regCategory" id="option8" value="독특한 숙소" autocomplete="off">
<label class="btn btn-outline-primary" for="option8">독특한 숙소</label> <br> <br>

<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label" ><h5>캠핑장을 잘 설명하는 키워드는 무엇인가요?</h5></label>
  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="key_index"></textarea>
</div>

<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label" ><h5>캠프 이름을 정해주세요.</h5></label>
  <textarea class="form-control" id="exampleFormControlTextarea1" rows="1" name="regName"></textarea>
</div>

<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label" ><h5>캠핑장 연락처를 입력하세요.</h5></label>
  <textarea class="form-control" id="exampleFormControlTextarea1" rows="1" name="regTel"></textarea>
</div>

<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label" ><h5>캠핑장에 대한 간단한 설명을 입력하세요.</h5></label>
  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="regSummary"></textarea>


<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label" ><h5>캠핑장 주소</h5></label>
  <textarea class="form-control-plaintext" id="exampleFormControlTextarea1" name="regStreetaddress" rows="1" ><%=hostadresss%></textarea>
</div>

<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label" ><h5>캠핑장 상세주소</h5></label>
  <textarea class="form-control" id="exampleFormControlTextarea1" rows="1" name="regDetailaddress" ></textarea>
</div> <br>

<button type="submit" class="btn btn-primary">제출</button>


</form>
</main>
<%-- Footer include   22.11.14 호식 수정 --%>
<%@ include file = "Foot.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>