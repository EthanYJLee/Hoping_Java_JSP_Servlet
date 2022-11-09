<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



</head>
<body>


<p>아래 이미지를 클릭하면 사진이 바뀜!</p>
<img  src="images/noheart.png" id="wish_heart" onclick="changeimage()">




<script>
function changeimage() {
    var image = document.getElementById('wish_heart');
    if (image.src.match("images/noheart.png")) {
        image.src = "images/redheart.png";
        
        
           
        
    } else {
        image.src = "images/noheart.png";
     
        
        
    }
}
</script>

</body>
</html>