<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Review</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">

<link rel="stylesheet" type="text/css" href="hyunsuk/css/star.css">


<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800'); 
@import url('https://fonts.googleapis.com/css2?family=Ubuntu&display=swap');

body{
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


.mytitle{
	font-family: 'Ubuntu', sans-serif;
	color: #E94560;
	font-size: 20px;	
	font-weight: bold;
}

.mysvg{
	margin-right: 5px;
	color: #E94560;
}

.mycard{
	border: 0px solid black;
	margin-bottom: 20px;
}


.mycbody{
	padding: 20px 0 0 0;
}

.myimage {
	border-radius: 15px;
	width: 250px;
	height: 250px;
}

.myctitle{
	font-size: 15px;
	font-weight: 600;
}

.myctext{
	font-weight:100;
	color: gray;
	
}

.mymcontainer{
	margin-bottom: 50px;
}
</style>

</head>
<body>
<%@ include file = "Nav.jsp" %>


	<form action="star03.jsp"> <!--  write.do 로 넘겨줘야함 -->

	<div class="star-rating" align="center">
		<input type="radio" id="5-stars" name="rating" value="5" onclick='getstar(event)'/> <label
			for="5-stars" class="star pr-4">★</label> 
			<input type="radio"
			id="4-stars" name="rating" value="4" onclick='getstar(event)' /> <label for="4-stars"
			class="star">★</label> 
			<input type="radio" id="3-stars" name="rating"
			value="3" onclick='getstar(event)'/> <label for="3-stars" class="star">★</label> 
			<input	type="radio" id="2-stars" name="rating" value="2" onclick='getstar(event)'/> 
			<label	for="2-stars" class="star">★</label> 
			<input type="radio" id="1-star"	name="rating" value="1" onclick='getstar(event)' />
			 <label for="1-star" class="star">★</label>
	</div>
	<br>

	<h2>후기</h2>
	<br>

	<div>

		<textarea rows="10" cols="50" maxlength="300"></textarea>

	</div>



	<input type="submit" id="submit"  value="작성완료"  onclick= "submit_event();"> <br>

	<div id='result'></div><br>
	
	</form>



	<script type="text/javascript">


 function submit_event() {
	 
	 var selected = false;
	 
    var radios = document.getElementsByName('rating');
    
    for (var radio of radios)
    	
    {
        if (radio.type === 'radio' && radio.checked)
        {
        	
              alert('후기 작성 감사합니다.');
            selected = true;
            
        }
    }
 
    if (!selected) {
        alert('별점을 선택해주세요.');
    }
}


function getstar(event) {
	  document.getElementById('result').innerText = 
	    event.target.value;
	 	}


</script>





<%@ include file = "Foot.jsp" %>














</body>
</html>