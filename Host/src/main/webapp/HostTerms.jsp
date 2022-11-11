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

<style type="text/css">
@import
	url('https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800')
	;

@import
	url('https://fonts.googleapis.com/css2?family=Ubuntu&display=swap');

body {
	font-family: 'Nanum Gothic';
}

.mybtn {
	transition: background-color .5s;
	border-radius: 15px;
}

.mybtn:hover {
	border: 0 solid black;
	background-color: #E94560;
}

.myscontainer {
	margin-bottom: 25px;
}

.mysearch {
	border-radius: 15px;
	border: 0.5px solid #808080;
	box-shadow: 1px 1px 3px 2px #E6E6E6;
	height: 33px;
	width: 500px;
}

.mytitle {
	font-family: 'Ubuntu', sans-serif;
	color: #E94560;
	font-size: 20px;
	font-weight: bold;
}

.mysvg {
	margin-right: 5px;
	color: #E94560;
}

.mycard {
	border: 0px solid black;
	margin-bottom: 20px;
}

.mycbody {
	padding: 20px 0 0 0;
}

.myimage {
	border-radius: 15px;
	width: 250px;
	height: 250px;
}

.myctitle {
	font-size: 15px;
	font-weight: 600;
}

.myctext {
	font-weight: 100;
	color: gray;
}

.mymcontainer {
	margin-bottom: 50px;
}
</style>


</head>
<body>

	<%-- nav --%>
	<div class="container">
		<header
			class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
			<a href="/"
				class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
				<svg class="mysvg" xmlns="http://www.w3.org/2000/svg" width="28"
					height="28" fill="currentColor" class="bi bi-house-heart"
					viewBox="0 0 16 16">
	  <path
						d="M8 6.982C9.664 5.309 13.825 8.236 8 12 2.175 8.236 6.336 5.309 8 6.982Z" />
	  <path
						d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.707L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.646a.5.5 0 0 0 .708-.707L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5ZM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5 5 5Z" />
	</svg> <span class="mytitle"><b>Hoping</b></span>
			</a>

			<ul class="nav nav-pills">
				<li class="nav-item" style="font-size: 14px;"><a href="#"
					class="link-dark nav-link">호스트 모드</a></li>

				<li class="nav-item"><svg class="dropdown-toggle"
						data-bs-toggle="dropdown" aria-expanded="false"
						xmlns="http://www.w3.org/2000/svg" width="28" height="28"
						fill="currentColor" class="bi bi-person-lines-fill"
						viewBox="0 0 16 16">
				<path
							d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm-5 6s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zM11 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5zm.5 2.5a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1h-4zm2 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2zm0 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2z" />
			</a>
			<ul class="dropdown-menu">
		    <li><a class="dropdown-item" href="#">Action</a></li>
		    <li><a class="dropdown-item" href="#">Another action</a></li>
		    <li><a class="dropdown-item" href="#">Something else here</a></li>
		  </ul>
		</li>
			</ul>
		</header>
	</div>



	<div class="box container mymcontainer">
		<form action="termsAD.do" method="get">
			<table width="160" height="650">

				<tr>
					<td width="100%" height="50%" align="center">
						<p align="left">
						<div
							style="margin-bottom: 20px; font-weight: 500; font-size: 25px;">Hoping
							호스트 이용 약관</div>
						</p> <br> <textarea rows="20" cols="100">
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
						name="agree" value="agree">동의 함 &nbsp;&nbsp;&nbsp; <input
						type="radio" name="agree" value="disagree">동의 하지 않음 <br>
						<br> <input type="submit" value="확인"></td>
				</tr>
			</table>

		</form>
	</div>
	
	
	
</body>
</html>