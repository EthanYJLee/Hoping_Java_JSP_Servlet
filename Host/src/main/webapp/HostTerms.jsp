<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호스트 약관동의</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/style.css"> 

</head>
<body>
<%-- nav include   22.11.14 호식 수정 --%>
<%@ include file = "hnav1.jsp" %>

	<div class="box container mymcontainer">
		<form action="termsAD.do" method="get">
			<table width="160" height="650">

<main class="form-signin w-50 m-auto">
	<!-- <div align="center"> -->
		<form action="termsAD.do" method="get">
			<table>
				<tr>
					<td width="100%" height="50%" align="center">
						<p align="left">
						<div style="margin-bottom: 20px; font-weight: 500; font-size: 25px;">
						<b> Hoping 호스트 이용 약관</b></div><br>
						 <textarea rows="20" cols="100">
Hoping을 이용해주셔서 감사합니다.

본 이용 약관(이하 '약관')은 Hoping 웹사이트, 애플리케이션 및 기타 Hoping 제공 서비스(총칭하여 'Hoping 플랫폼') 이용에 관한 사용자의 권리에 적용되는 회원님과 Hoping 사이의 구속력 있는 법적 계약입니다. 

본 약관에서 사용되는 'Hoping' 또는 '당사'라는 용어는 회원님이 계약을 체결하고 있는 Hoping 주체(부속서 1에 명시)를 지칭합니다.

Hoping 플랫폼은 사용자('회원')가 서비스를 게시, 제공, 검색, 예약할 수 있는 온라인 공간을 제공합니다. 서비스를 게시하고 제공하는 회원은 '호스트'이며, 서비스를 검색, 예약 또는 사용하는 회원은 '게스트'입니다. 

호스트는 숙소('숙소'), 액티비티, 투어, 행사('체험'), 다양한 여행 및 기타 서비스(총칭하여 '호스트 서비스', 제공되는 개별 호스트 서비스는 '리스팅')를 제공합니다. 

Hoping 플랫폼의 여러 기능에 액세스하고 이를 이용하려면 계정을 등록해야 하며 계정 정보를 정확하게 유지해야 합니다. 

Hoping 플랫폼 제공자로서 당사는 그 어떠한 리스팅, 호스트 서비스나 여행 서비스도 소유, 통제, 제공, 관리하지 않습니다. 호스트와 게스트 사이에 직접 체결된 계약에 있어 Hoping은 계약 당사자가 아니며, 부동산 중개업체나 여행사 또는 보험사 역시 아닙니다. 

Hoping은 결제 서비스 약관('결제 약관')에 명시된 경우를 제외하고는 회원의 대리인 역할을 하지 않습니다. 

Hoping의 역할은 제16조에 자세히 규정되어 있습니다.

Hoping은 당사의 개인정보 수집 및 사용 방식을 설명하는개인정보 처리방침, Hoping 결제 주체(총칭하여 'Hoping Payments')가 회원에게 제공하는 결제 서비스에 적용되는 결제 약관 등 본 약관을 보완하는 기타 약관 및 정책을 유지합니다.

호스트 서비스에 적용되는 모든 법규, 규정, 제3자와의 계약을 이해하고 준수할 책임은 호스트에게 있습니다.

   </textarea> <br> 개인정보 수집 및 이용에 동의합니다.
					</td>
				</tr>
				<tr>
					<td align="center" valign="top"><input type="radio"
						name="agree" value="agree" checked="checked">동의 함 &nbsp;&nbsp;&nbsp; <input
						type="radio" name="agree" value="disagree">동의 하지 않음 <br>
						<br> <input type="submit" value="확인"></td>
				</tr>
			</table>
		</form>
</main>	
	
</body>
</html>