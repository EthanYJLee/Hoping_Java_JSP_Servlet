<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail View - ${DetailView.regName}</title>
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
    function daum_zipcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수
                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }
                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                //document.getElementById("uzip1").value = data.postcode1; //6자리 우편번호 사용
                //document.getElementById("uzip2").value = data.postcode2; //6자리 우편번호 사용
                document.getElementById("customerPostcode").value = data.zonecode; //5자리 기초구역번호 사용
                document.getElementById("customerAddress").value = fullAddr;
                document.getElementById("buildingName").value = extraAddr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("cutomerAddressDetail");
                
            }
        }).open();
    }
</script>	

<!-- 성연씨가 작업해주신 정규식  -->
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
				
				<form name="Member" action="Clientwrite.do" method="post">
					<table>
						<tr>
							<th >아이디</th>
							<td><!-- <input type="text" name="cId" class="input_id"> -->
							<script src="http://code.jquery.com/jquery-latest.min.js"></script>
						
							<input type="text" name="cId" class="cId" placeholder="ex ) camp12" required="required">
							<font id="checkId" size="2"></font>
							
							</td>
						</tr>

						<tr>
							<th>비밀번호</th>
							<td>	
								<input type="password" name="cPw" id="password_1" class="pw"
									placeholder="ex) ld1397">
							</td>
						</tr>

						<tr>
							<th>비밀번호 확인</th>
							<td>
								<input type="password" name="cPw2" id="password_2" class="pw" placeholder="ex) ld1397"> 
								<span id="alert-success" style="display: none;">
									<font size="2">비밀번호가 일치합니다.</font>
								</span> 
								<span id="alert-danger" style="display: none; font-weight:;">
								<font size="2" color="#d92742">비밀번호가 일치하지 않습니다.</font>
								</span>
							</td>
						</tr>
						<tr>
							<th>이름</th>
							<td><input type="text" name="cName" size="40" placeholder= "한글로 이름을 작성해 주세요"></td>
						</tr>
						<tr>
							<th>전화번호</th>
							<th><input type="text" name="cPhone" size="40"placeholder="000-0000-0000"></th>
						</tr>
						<tr>
							<th>이메일</th>
							<td><input type="text" name="cEmail" size="40" placeholder= "example@example.com / E-mail 형식으로 작성해주세요 "></td>
						</tr>

						<tr>
							<th>주소</th>
							<td><input type="text" id="customerPostcode"
								placeholder="우편번호" name="zonecode"> <input type="button"
								onclick="daum_zipcode()" value="우편번호 찾기"><br>
								<input type="text" id="customerAddress" placeholder="도로명주소" name="address"><br>
								<input type="text" id="buildingName" placeholder="빌딩이름" name="buildingAddress">
								<input type="text" id="cutomerAddressDetail" placeholder="상세주소" name="detailAddress"></td>
						</tr>
						<tr>
							<td colspan="2">
								<div class="container-md d-flex justify-content-center">
									<input type="button" value="회원가입"  class="btn btn-primary"
								onclick="checkMember()" style="WIDTH: 210pt; HEIGHT: 40pt">
								</div>
							</td>
						</tr>
					</table>
				</form>
				</div>
			</div>
		</div>
		<!-- DIV row End -->
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
	<!-- <script>
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
	</script> -->
	<script>
		//아이디 중복확인 함수
		$('.cId').focusout(function() {
			let cId = $('.cId').val(); // input_id에 입력되는 값

			$.ajax({
				url : "./IdCheckService", //요청할 url
				type : "post",
				data : {cId : cId},  //불러올 데이터
				dataType : 'json',
				success : function(result) {
					if (result == 0) {
						$("#checkId").html('사용할 수 없는 아이디입니다.');
						$("#checkId").attr('color', 'red');
						$(':text:not([id=cName]):not([id=cPhone])').val(''); //텍스트가 지워지는걸 제외
						/* alert("중복된 아이디입니다. 다시 입력해주세요.") */

					} else {
						$("#checkId").html('사용 가능한 아이디입니다.');
						$("#checkId").attr('color', 'green');
					}
				},
				error : function() {
					alert("서버요청실패");
				}
			})

		})
	</script>
	
	
	
	<script>
		// 공백 사용 못 하게하는 함수
		function noSpaceForm(obj) {
			var str_space = /\s/; // 공백 체크
			if (str_space.exec(obj.value)) { // 공백 체크
				alert("해당 항목에는 공백을 사용할 수 없습니다.\n\n공백 제거됩니다.");
				obj.focus();
				obj.value = obj.value.replace(' ', ''); // 공백제거
				return false;
			}
		}
	</script>
		
	<!-- Foot -->
	<%@ include file="Foot.jsp"%>
	<!-- Foot End -->
</body>


</head>
</html>