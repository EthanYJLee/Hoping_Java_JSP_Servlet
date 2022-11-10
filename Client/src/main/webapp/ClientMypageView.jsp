<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page import = "java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<script type="text/javascript">
</script>
<body>
	<div align="center">
		<h1>마이페이지</h1>
		<form action="ClientModify.do" method="post">
		<table>
		<tr><td> ID :</td> <td><input type="text" size="15" name="cId" value="${mypageview.cId}" readonly="readonly" ><br></td></tr> 
		<tr><td> 전화번호 :</td> <td><input type="text" size="15" name="cPhone" value="${mypageview.cPhone}"><br></td></tr> 
		<tr><td> 이메일 :</td> <td><input type="text" size="15" name="cEmail" value="${mypageview.cEmail}"><br></td></tr> 
		<tr><td> 비밀번호 :</td> <td><input type="password" size="15" name="cPw" value="${mypageview.cPw }"><br></td></tr> 
		<tr><td></td><td><input type="submit" value="수정">
		<a href="ClientDelete.do?cId=${mypageview.cId}" type="submit" class="btn btn-primary">탈퇴</a>
		<a href="ClientMainView.jsp">메인</a>
		
		</table>
		</form>
			
	</div>

</body>
</html>