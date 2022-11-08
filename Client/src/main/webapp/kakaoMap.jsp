<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- 카카오맵 API include 써서 사용하는 용 입니다  -->
		    	
		    <div>
		    <h4> 위치</h4>
		    
		    </div>
		    
		      <!-- 카카오맵 시작  -->	
		     <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8d20a512bea587bcc64da4d1d6a184b3&libraries=services"></script>
			<div>${DetailView.regDetailaddress}</div>
		    <div id="map" class="container" style="width:700px;height:500px;">
			    <script>
			    
			    /* 2022-11-8 Hosik -
			    변수에 DB에서 regcamp 데이터를 가져와서 사용합니다.
			   include 사용해서 불러올께 DetailView Command를 거치면은 regcamp regSeq Number로 해당 주소로 사용가능
			   대신 DB에 주소 입력할때 정확하게 입력하셔야 찾을 수 있어요~ 주소 이상하면 alert 나옴~  */
			    
			    
			     var regName =' ${DetailView.regName}';  // DB에서 불러오는 캠핑장이름 값 
			     var con1 = '<div style="width:150px;text-align:center;padding:6px 0;">'
			     var con2 = '</div>'
			     var address = '${DetailView.regDetailaddress}'; // 디비에서 불러오는 캠핑장주소, 정확해야지 map API가 찾아낼 수 있음 
				    var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
				    mapOption = {
				        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
				        level: 5 // 지도의 확대 레벨
				    };  
	
					// 지도를 생성합니다    
					var map = new kakao.maps.Map(mapContainer, mapOption); 
		
					// 주소-좌표 변환 객체를 생성합니다
					var geocoder = new kakao.maps.services.Geocoder();
		
					// 주소로 좌표를 검색합니다
					geocoder.addressSearch(address, function(result, status) {
	
				    // 정상적으로 검색이 완료됐으면 
				     if (status === kakao.maps.services.Status.OK) {

					        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		
					        // 결과값으로 받은 위치를 마커로 표시합니다
					        var marker = new kakao.maps.Marker({
					            map: map,
					            position: coords
					        });
		
					        // 인포윈도우로 장소에 대한 설명을 표시합니다
					        var infowindow = new kakao.maps.InfoWindow({
					            content: con1+regName+con2
					            	// 변수값으로 넣어야 되서 앞뒤로도 변수가 들어가 있음,  고정값으로 넣을꺼면 con1 과 con2 사이에 걍 값 넣어주면 댐 
					        });
					        infowindow.open(map, marker);
		
					        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
					        map.setCenter(coords);
					    } 
 //	>>>>>>>>>>>>>>>>>     error check용 else 가 있습니드아!!!!!! 나중에 여기 꼭 처리 하셔야 되요!!!!! <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Need Check
				     else{
					    	alert('주소가 정확하지 않아요!');
					    }
					});    
				</script>
		    </div>  <!-- 카카오맵 끝 -->
</body>
</html>