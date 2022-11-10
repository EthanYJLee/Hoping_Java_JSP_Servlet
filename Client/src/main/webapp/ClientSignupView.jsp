<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.util.function.Function"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<script type="text/javascript">
function checkMember(){
		
/* 		var regExpcId = /^[a-z|A-Z]/
 */		
		var regExpcId = /^[a-z|A-Z]/
		var regExpcName = /^[가-힣]*$/
		var regExpcPw = /^[a-zA-Z0-9]*$/
 		/* var regExpcPw = /^[0-9]*$/ */
		var regExpcPhone = /^\d{3}-\d{3,4}-\d{4}$/
		var regExpcEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i
		
		var form = document.Member
		
		var cId = form.cId.value
		var cName = form.cName.value
		var cPw = form.cPw.value
		var cPhone = form.cPhone.value
		var cEmail = form.cEmail.value
		
		if(!regExpcId.test(cId)){
			alert("아이디는 문자로 시작해 주세요")
			form.cId.select()
			return false
		}
		
		if(!regExpcName.test(cName)){
			alert("이름은 한글만으로 입력해 주세요")
			form.cName.select()
			return false
		}
		
		if(!regExpcPw.test(cPw)){
			alert("비밀번호는 영문과 숫자만으로 입력해 주세요")
			form.cPw.select()
			return false
		}
		
		if(!regExpcPhone.test(cPhone)){
			alert("연락처 입력을 확인해 주세요")
			form.cPhone.select()
			return false
		}
		
		if(!regExpcEmail.test(cEmail)){
			alert("이메일 입력을 확인해 주세요")
			form.cEmail.select()
			return false
		}

		form.submit()
	}
</script>
<body>
<div style="text-align: center;">
<br><br>
	&nbsp;&nbsp;&nbsp;<h2>회원가입</h2>&nbsp;&nbsp;&nbsp;
</div>
<form name="Member" action="Clientwrite.do" method="post">
	<div class="input_id">
		<p>아이디</p>
	      <input type = "text" name = "cId" class = "input_id">
		<font id = "checkId" size = "2"></font>
	</div>
	<div>
	     <p>비밀번호</p>
		<input type="password" name="cPw" size="40">
	</div>
	<div>
		<p>이름</p>
	     <input type="text" name="cName" size="40">
	</div>
	<div>
	     <p>전화번호</p>
	      <input type="text" name="cPhone" size="40">
	</div>
	<div>
	      <p>이메일</p>
	      <input type="text" name="cEmail" size="40">
	</div>
	<br>
	<div>
<!-- 	      <input type="submit" value="회원가입하기" style="WIDTH: 210pt; HEIGHT: 20pt"><br>		 --><br>
		<input type="button" value="회원가입" onclick="checkMember()" style="WIDTH: 210pt; HEIGHT: 20pt">


	      <a href="ClientLoginView.jsp">로그인 페이지로 가기</a>
	</div>

	</form>
	<script src = "js/jquery-3.6.0.min.js"></script>
	
<script>
	$('.input_cId').focusout(function(){
		let cId = $('.input_cId').val(); // input_id에 입력되는 값
		
		var form = document.Member
		
		$.ajax({
			url : "Checkid_Command",
			type : "post",
			data : {cId: cId},
			dataType : 'json',
			success : function(result){
				if(result == 0){
					$("#checkId").html('사용할 수 없는 아이디입니다.');
					$("#checkId").attr('color','red');
				} else{
					$("#checkId").html('사용할 수 있는 아이디입니다.');
					$("#checkId").attr('color','green');
				} 
			},
			error : function(){
				alert("서버요청실패");
			}
		})
		 
	})
 </script>

</body>
</html>