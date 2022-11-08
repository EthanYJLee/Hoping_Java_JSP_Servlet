<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<link rel="stylesheet" type="text/css" href="css/star.css">

<body>

	<form action="star03.jsp">

	<div class="star-rating">
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

</body>
</html>