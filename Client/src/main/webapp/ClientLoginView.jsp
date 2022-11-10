<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
 

<body>
<div align="center">
<main class="form-signin w-100 m-auto">
  <form action="login.do" method="post">
    <h1 class="h3 mb-3 fw-normal">로그인</h1>

    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" name="cId" placeholder="ID">
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" name="cPw" placeholder="PW">
    </div>

    <div class="checkbox mb-3">
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">로그인</button>
  	<div class="links">
  	
            <a href="ClientSignupView.jsp">회원가입</a>
            <a href="#">아이디 찾기</a>
            <a href="#">비밀번호 찾기</a>


        </div>
	  
  </form>
</main>


</div>
</body>
</head>
</html>