<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <br><span
    style="
    font-weight: bold; 
    font-size: 1.5em;
    line-height: 1.0em; 
    color: navy;
    font-family: sans-serif;
    ">    
    <숙소를 등록해주세요></span>
    <span
    style="
    font-weight: bold; 
    font-size: 1.1em;
    line-height: 1.0em; 
    color: brown;
    font-family: sans-serif;
    "></span>
      <span
    style="
    font-size: 1em;
    line-height: 1.0em; 
    color: black;
    font-family: sans-serif;
    ">    
     장소 검색 - 위치 클릭 - 주소 확인 및 상세주소 입력 - 하단 제출 버튼 클릭
      <br><br></span>
</html>
<html>
<head>
    <meta charset="utf-8">
    <title>숙소를 소개해주세요</title>
    
     <style>
    .wrap {position: absolute;left: 0;bottom: 40px;width: 288px;height: 132px;margin-left: -144px;text-align: left;overflow: hidden;font-size: 12px;font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;line-height: 1.5;}
    .wrap * {padding: 0;margin: 0;}
    .wrap .info {width: 286px;height: 100px;border-radius: 5px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
    .wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
    .info .title {padding: 5px 0 0 10px;height: 30px;background: #eee;border-bottom: 1px solid #ddd;font-size: 18px;font-weight: bold;}
    .info .close {position: absolute;top: 10px;right: 10px;color: #888;width: 17px;height: 17px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');}
    .info .close:hover {cursor: pointer;}
    .info .body {position: relative;overflow: hidden;}
    .info .desc {position: relative;margin: 13px 0 0 90px;height: 75px;}
    .desc .ellipsis {overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
    .desc .jibun {font-size: 11px;color: #888;margin-top: -2px;}
    .info .img {position: absolute;top: 6px;left: 5px;width: 73px;height: 50px;border: 1px solid #ddd;color: #888;overflow: hidden;}
    .info:after {content: '';position: absolute;margin-left: -12px;left: 50%;bottom: 0;width: 22px;height: 12px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
    .info .link {color: #5085BB;}
</style>
    
</head>
<body>


    
    <div class="map_wrap">
        




<div id="menu_wrap" class="bg_white">
    <div class="option">
        <div>
            <form onsubmit="searchPlaces(); return false;">
                <input type="text" value="" id="keyword" size="30"> 
                <button type="submit">검색하기</button> 
            </form>
        </div>
    </div>
    <hr>
    <ul id="placesList"></ul>
    <div id="pagination"></div>
</div>

<div id="map" style="width:100%;height:75vh;"></div>


<p id="result"></p>


<script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=505cf085825f2efd695b0d736063264e&libraries=services"></script>
<script>
// 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

var mapContainer = document.getElementById('map'), // 지도의 중심좌표
mapOption = { 
    center: new kakao.maps.LatLng(37.49476472521851, 127.03004016038628), // 지도의 중심좌표
    level: 2 // 지도의 확대 레벨
}; 


// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
var mapTypeControl = new kakao.maps.MapTypeControl();

// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);



// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng;
        
    document.getElementById("hostlongitude").value = latlng.getLat();
    document.getElementById("hostlatitude").value = latlng.getLng();
    
});



// 지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {
    searchDetailAddrFromCoords(mouseEvent.latLng, function(result2, status) {
        if (status === kakao.maps.services.Status.OK) {
            var detailAddr = !!result2[0].road_address ? '<div>도로명주소 : ' + result2[0].road_address.address_name + '</div>' : '';
            detailAddr += '<div>지번 주소 : ' + result2[0].address.address_name + '</div>';
            
            var hostaddress = result2[0].address.address_name;
            
            var content = '<div class="bAddr">' +
                            detailAddr + 
                        '</div>';

            // 마커를 클릭한 위치에 표시합니다 
            marker.setPosition(mouseEvent.latLng);
            marker.setMap(map);

            // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
            infowindow.setContent(content);
            infowindow.open(map, marker);
            
            document.getElementById("hostaddress").value = hostaddress;
        }   
    });
});

    function searchAddrFromCoords(coords, callback) {
    // 좌표로 행정동 주소 정보를 요청합니다
    geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);         
}

function searchDetailAddrFromCoords(coords, callback) {
    // 좌표로 법정동 상세 주소 정보를 요청합니다
    geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
}




// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places(); 



// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

// 키워드로 장소를 검색합니다
searchPlaces();

// 키워드 검색을 요청하는 함수입니다
function searchPlaces() {

    var keyword = document.getElementById('keyword').value;

    if (!keyword.replace(/^\s+|\s+$/g, '')) {
        alert('장소를 입력해주세요!');
        return false;
    }

    // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
    ps.keywordSearch( keyword, placesSearchCB); 
}



// 키워드 검색 완료 시 호출되는 콜백함수 입니다
function placesSearchCB (data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        var bounds = new kakao.maps.LatLngBounds();

        for (var i=0; i<data.length; i++) {
            displayMarker(data[i]);    
            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
        }       

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
        map.setBounds(bounds);
    } 
}

// 지도에 마커를 표시하는 함수입니다
function displayMarker(place) {
    
    // 마커를 생성하고 지도에 표시합니다
    var marker = new kakao.maps.Marker({
        map: map,
        position: new kakao.maps.LatLng(place.y, place.x) 
    });

    // 마커에 클릭이벤트를 등록합니다
    kakao.maps.event.addListener(marker, 'click', function() {
        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
        infowindow.open(map, marker);
    });
}

//지도에 마커를 표시합니다 
var marker = new kakao.maps.Marker({
    map: map, 
});
// 지도에 마커2를 표시합니다 
var marker2 = new kakao.maps.Marker({
    map: map, 
    position: new kakao.maps.LatLng(37.49476472521851, 127.03004016038628)
});
// 지도에 마커3를 표시합니다 
var marker3 = new kakao.maps.Marker({
    map: map, 
    position: new kakao.maps.LatLng(37.49406134624257, 127.03229018383784)
});

// 커스텀 오버레이에 표시할 컨텐츠 입니다
// 커스텀 오버레이는 아래와 같이 사용자가 자유롭게 컨텐츠를 구성하고 이벤트를 제어할 수 있기 때문에
// 별도의 이벤트 메소드를 제공하지 않습니다 
var content = '<div class="wrap">' + 
            '    <div class="info">' + 
            '        <div class="title">' + 
            '            더조은 캠핑장' + 
            '            <div class="close" onclick="closeOverlay()" title="닫기"></div>' + 
            '        </div>' + 
            '        <div class="body">' + 
            '            <div class="img">' +
            '                <img src="https://cfile181.uf.daum.net/image/250649365602043421936D" width="73" height="50">' +
            '           </div>' + 
            '            <div class="desc">' + 
            '                <div class="ellipsis">125,000원~220,000원</div>' + 
            '                <div class="jibun ellipsis">빌딩 옥상에서 즐기는 도시 캠핑</div>' + 
            '            </div>' + 
            '        </div>' + 
            '    </div>' +    
            '</div>';
var content2 = '<div class="wrap">' + 
            '    <div class="info">' + 
            '        <div class="title">' + 
            '            무궁화 캠핑장' + 
            '            <div class="close" onclick="closeOverlay()" title="닫기"></div>' + 
            '        </div>' + 
            '        <div class="body">' + 
            '            <div class="img">' +
            '                <img src="https://cfile181.uf.daum.net/image/250649365602043421936D" width="73" height="50">' +
            '           </div>' + 
            '            <div class="desc">' + 
            '                <div class="ellipsis">80,000원~120,000원</div>' + 
            '                <div class="jibun ellipsis">공원, 숲 근처</div>' + 
            '            </div>' + 
            '        </div>' + 
            '    </div>' +    
            '</div>';

// 마커 위에 커스텀오버레이를 표시합니다
// 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
var overlay = new kakao.maps.CustomOverlay({
    content: content,
    map: map,
    position: marker2.getPosition()       
});
var overlay2 = new kakao.maps.CustomOverlay({
    content: content2,
    map: map,
    position: marker3.getPosition()       
});

// 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
kakao.maps.event.addListener(marker, 'click', function() {
    overlay.setMap(map);
});

// 커스텀 오버레이를 닫기 위해 호출되는 함수입니다 
function closeOverlay() {
    overlay.setMap(null);     
}



</script>

<form action="HostCampReg.jsp" method="post" >
<input type="hidden" value="" id="hostlongitude" name="hostlongitude">
<input type="hidden" value="" id="hostlatitude" name="hostlatitude">
주소 : <input type="text" value="숙소의 위치를 지도에서 클릭해주세요!!" id="hostaddress" name="hostaddress" >
<input type="submit">

</form>
</body>
</html>