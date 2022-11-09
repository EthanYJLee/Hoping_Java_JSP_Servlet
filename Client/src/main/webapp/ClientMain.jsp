<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>메인페이지 입니다</h2><br>
<%-- <%=request.getAttribute("cId")%>님 환영합니다<br> --%>

<%=session.getAttribute("cId")%> 님 환영합니다!
<form action="mypageView.do" method="post">
<input type="submit" value="마이페이지">
<a href="logout.jsp">로그아웃</a>
</form>

</body>
</html>