<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.2/examples/navbar-fixed/">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<style type="text/css">
@import
	url('https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800')
	;

@import
	url('https://fonts.googleapis.com/css2?family=Ubuntu&display=swap');
</style>

<script src="js/jquery-3.6.0.min.js"></script>

<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
	function sample4_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var roadAddr = data.roadAddress; // 도로명 주소 변수
						var extraRoadAddr = ''; // 참고 항목 변수

						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
							extraRoadAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if (data.buildingName !== '' && data.apartment === 'Y') {
							extraRoadAddr += (extraRoadAddr !== '' ? ', '
									+ data.buildingName : data.buildingName);
						}
						// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
						if (extraRoadAddr !== '') {
							extraRoadAddr = ' (' + extraRoadAddr + ')';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample4_postcode').value = data.zonecode;
						document.getElementById("sample4_roadAddress").value = roadAddr;
						document.getElementById("sample4_jibunAddress").value = data.jibunAddress;

						// 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
						if (roadAddr !== '') {
							document.getElementById("sample4_extraAddress").value = extraRoadAddr;
						} else {
							document.getElementById("sample4_extraAddress").value = '';
						}

						var guideTextBox = document.getElementById("guide");
						// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
						if (data.autoRoadAddress) {
							var expRoadAddr = data.autoRoadAddress
									+ extraRoadAddr;
							guideTextBox.innerHTML = '(예상 도로명 주소 : '
									+ expRoadAddr + ')';
							guideTextBox.style.display = 'block';

						} else if (data.autoJibunAddress) {
							var expJibunAddr = data.autoJibunAddress;
							guideTextBox.innerHTML = '(예상 지번 주소 : '
									+ expJibunAddr + ')';
							guideTextBox.style.display = 'block';
						} else {
							guideTextBox.innerHTML = '';
							guideTextBox.style.display = 'none';
						}
					}
				}).open();
	}
</script>

<!-- 성연씨가 작업해주신 정규식  -->
</head>
<script type="text/javascript">
	function checkMember() {

		var regExpcId = /^[a-zA-Z0-9]*$/
		var regExpcName = /^[가-힣]*$/
		var regExpcPw = /^[a-zA-Z0-9]*$/
		var regExpcPw2 = /^[a-zA-Z0-9]*$/
		var regExpcPhone = /^\d{3}-\d{3,4}-\d{4}$/
		var regExpcEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i

		var form = document.Member

		var cId = form.cId.value
		var cName = form.cName.value
		var cPw = form.cPw.value
		var cPw2 = form.cPw2.value
		var cPhone = form.cPhone.value
		var cEmail = form.cEmail.value

		if (!regExpcId.test(cId)) {
			alert("아이디는 숫자와 영문으로만 작성해주세요.")
			form.cId.select()
			return false
		}
		if (cId == "") {
			alert("아이디를 입력해주세요.")
			return false
		}
		if (cId == "") {
			alert("공백입니다 입력해주세요.")
			return false
		}

		if (!regExpcName.test(cName)) {
			alert("이름은 한글으로만 입력해 주세요.")
			form.cName.select()
			return false
		}
		if (cName == "") {
			alert("이름을 입력해주세요.")
			return false
		}

		if (!regExpcPw.test(cPw)) {
			alert("비밀번호는 영문과 숫자만으로 입력해 주세요.")
			form.cPw.select()
			return false
		}
		if (cPw == "") {
			alert("비밀번호를 입력해주세요.")
			return false
		}
		if (!regExpcPw2.test(cPw2)) {
			alert("비밀번호는 영문과 숫자만으로 입력해 주세요.")
			form.cPw2.select()
			return false
		}
		if (cPw2 == "") {
			alert("비밀번호를 입력해주세요.")
			return false
		}

		if (cPw != cPw2) {
			alert("비밀번호가 일치하지 않습니다.")
			return false
		}

		if (!regExpcPhone.test(cPhone)) {
			alert("전화번호 형식으로 입력해주세요.")
			form.cPhone.select()
			return false
		}
		if (cPhone == "") {
			alert("전화번호를 입력해주세요.")
			return false
		}

		if (!regExpcEmail.test(cEmail)) {
			alert("이메일 형식으로 입력해주세요.")
			form.cEmail.select()
			return false
		}
		if (cEmail == "") {
			alert("이메일을 입력해주세요.")
			return false
		}

		form.submit()
	}
</script>








</head>
<body>
	<!-- Header Start -->
	<%@ include file="Nav2.jsp"%>
	<!-- Header End -->
	<!-- Main Start -->
	<main>
		<div class="container-md d-flex justify-content-center">
			<div class="row">
				<div class="col">
					<br> <br> &nbsp;&nbsp;&nbsp;
					<h2>회원가입</h2>
					&nbsp;&nbsp;&nbsp;
				</div>
				
				
				
				<form name="Member" action="Clientwrite.do" method="post">
							<script src="http://code.jquery.com/jquery-latest.min.js"></script>

					<div class="input_id">아이디 &nbsp;&nbsp;
							<input type="text" name="cId" class="cId" placeholder="ex ) camp12" required="required">
							<font id="checkId" size="2"></font>
					</div>
					
							
					<div class="content_title">비밀번호
						<input type="password" name="cPw" id="password_1" class="pw" placeholder="ex) ld1397">
					</div>
					<div class="content_title">비밀번호 확인
						<input type="password" name="cPw2" id="password_2" class="pw"
								placeholder="ex) ld1397"> <span id="alert-success"
								style="display: none;">비밀번호가 일치합니다.</span> <span id="alert-danger"
								style="display: none; color: #d92742; font-weight:;">비밀번호가
								일치하지 않습니다.</span>
					</div>
						
					<div class="content_title">이름
						<input type="text" id="cName" name="cName" placeholder="ex) 이도">
					</div>
			
					<div class="content_title">전화번호
						<input type="text" id="cPhone" name="cPhone" placeholder="ex) 010-1234-5678">
					</div>
			
					<div class="content_title">이메일
						<input type="email" name="cEmail" placeholder="ex) luck@naver.com">
					</div>	
						
					<div class="content_title">주소</div>
					<div>
						<input type="text" name="zonecode"id="sample4_postcode" placeholder="우편번호">
						<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
					</div>	
					<div>
						
						<input type="text" id="sample4_roadAddress" placeholder="도로명주소"  name="address"><br>
						<input type="text" id="sample4_jibunAddress" placeholder="빌딩이름" name="buildingAddress">
						<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="detailAddress">
					
					
					</div>	
					<br> <br> <input type="button" value="회원가입" class="btn btn-primary"
						onclick="checkMember()" style="WIDTH: 210pt; HEIGHT: 40pt">
					<br> <a href="ClientLoginView.jsp">로그인 페이지로 가기</a>
				</form>

			</div>
			<!-- DIV row End -->
		</div>
		<!-- DIV row End -->
		</div>
		<!-- DIV container End -->
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
		
	<script>
		$('.pw').focusout(function() {
			var pwd1 = $("#password_1").val();
			var pwd2 = $("#password_2").val();

			if (pwd1 != '' && pwd2 == '') {
				null;
			} else if (pwd1 != "" || pwd2 != "") {
				if (pwd1 == pwd2) {
					$("#alert-success").css('display', 'inline-block');
					$("#alert-danger").css('display', 'none');
				} else {
					/* alert("비밀번호가 일치하지 않습니다. 비밀번호를 재확인해주세요"); */
					$("#alert-success").css('display', 'none');
					$("#alert-danger").css('display', 'inline-block');
				}
			}
		});
	</script>
	<!--  <script src = "js/jquery-3.6.0.min.js"></script> -->
	<script>
		$('.cId').focusout(function() {
			let cId = $('.cId').val(); // input_id에 입력되는 값

			$.ajax({
				url : "./IdCheckService",
				type : "post",
				data : {
					cId : cId
				},
				dataType : 'json',
				success : function(result) {
					if (result == 0) {
						$("#checkId").html('중복된 아이디입니다.');
						$("#checkId").attr('color', 'red');
						$(':text:not([id=cName]):not([id=cPhone])').val('');
						alert("중복된 아이디입니다. 다시 입력해주세요.")

					} else {
						$("#checkId").html('중복되지 않은 아이디입니다.');
						$("#checkId").attr('color', 'green');
					}
				},
				error : function() {
					alert("서버요청실패");
				}
			})

		})
	</script>
		
	<!-- Foot -->
	<%@ include file="Foot.jsp"%>
	<!-- Foot End -->
</body>


</head>
</html>