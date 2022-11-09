<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	
	

	String agree = request.getParameter("agree");
	String disagree = request.getParameter("disagree");
	
	if(agree.equals("agree")){
	RequestDispatcher dispatcher = request.getRequestDispatcher("TermsAgree.jsp");
   	dispatcher.forward(request, response);
	}else{
   	
	RequestDispatcher dispatcher1 = request.getRequestDispatcher("HostTermsAD.jsp");
   	dispatcher1.forward(request, response);
	
	}

%>
</body>
</html>