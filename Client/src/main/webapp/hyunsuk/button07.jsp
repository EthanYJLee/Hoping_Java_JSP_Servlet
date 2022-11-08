<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style>
/* iframe을 숨기기 위한 css*/
#if {
	width: 0px;
	height: 0px;
	border: 0px;
}
</style>
</head>
<body>


	<form action="button03.jsp" method="get" target="param">

		<input class="click" type="image" id="wish_heart"
			src="images/emptyheart.png" name="click_action" value=""
			onclick="insert.call( this )">

	</form>

	<iframe id="if" name="param"></iframe>



	<!-- value값에 입력이 드러오면 insert가 실행되게, delete가 들어오면 delete가 실행되게 -->



	<script type="text/javascript">
	
	
	 let click = document.querySelector(".click");

	 
	  click.addEventListener("click", function() {
		  
		  var image = document.getElementById('wish_heart');
			
			if (image.src.match("images/emptyheart.png")) {
				image.src = "images/redheart.png";

				this.setAttribute("src", "images/redheart.png");
				

			}else if(image.src.match("images/redheart.png")) {
				image.src = "images/emptyheart.png";

				this.setAttribute("src", "images/emptyheart.png");
			}
	    
	  })

</script>



</body>
</html>