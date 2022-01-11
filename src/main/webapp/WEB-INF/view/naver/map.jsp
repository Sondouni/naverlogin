<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko" style="width: 100%; height: 100%;">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>간단한 지도 표시하기</title>
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=hqo2iaad0i"></script>
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=hqo2iaad0i&submodules=panorama,geocoder"></script>

</head>
<body style="width: 100%; height: 100%;">
    <div id="map" style="width: 500px; height: 500px;"></div>
    <form id="searchMap">
        <input type="text" name="title" readonly value="${requestScope.search.title}">
        <input type="text" name="mapx" readonly value="${requestScope.search.mapx}">
        <input type="text" name="mapy" readonly value="${requestScope.search.mapy}">
    </form>
    <script>
        var searchMapElem = document.querySelector('#searchMap');
        console.log(searchMapElem.mapx.value);
        console.log(searchMapElem.mapy.value);
        console.log(searchMapElem.title.value);
        var tm128 = new naver.maps.Point(searchMapElem.mapx.value, searchMapElem.mapy.value);
        var latLng = naver.maps.TransCoord.fromTM128ToLatLng(tm128);
        console.log(latLng);
/*
        var tm128 = new naver.maps.Point(searchMapElem.mapx.value, searchMapElem.mapy.value);
        var latLng = naver.maps.TransCoord.fromTM128ToLatLng(tm128);
        console.log(latLng);


        var mapOptions = {
            center: new naver.maps.LatLng(latLng.y,latLng.x),
            zoom: 18
        };

        var map = new naver.maps.Map('map', mapOptions);
 */
        var map = new naver.maps.Map('map', {
            // 얻은 좌표를 지도의 중심으로 설정합니다.
            center: new naver.maps.LatLng(latLng.y,latLng.x),
            // 지도의 줌 레벨을 변경합니다.
            zoom: 18,
            mapTypeId: naver.maps.MapTypeId.NORMAL
        });

        var infowindow = new naver.maps.InfoWindow();

        function onSuccessGeolocation(title) {
            console.log(title);
            infowindow.setContent('<div style="padding:20px;">' +title+' 위치' + '</div>');
            infowindow.open(map, map.center);
            console.log('Coordinates: ' + map.center.toString());
        }
        onSuccessGeolocation(searchMapElem.title.value);
    </script>
</body>
</html>