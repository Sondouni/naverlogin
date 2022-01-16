<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
<span id="latitude"></span>|<span id="longitude"></span> |<img id="wicon" src="">| <span id="tempr"></span>
<script>
    function showLocation(event) {
        var latitude = event.coords.latitude
        var longitude = event.coords.longitude
        document.querySelector("#latitude").textContent = latitude
        document.querySelector("#longitude").textContent = longitude


        let apiKey = "f359860a151ee1a83132eab18cdcac7e"
        let weatherUrl = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude
            + "&lon=" + longitude
            + "&appid=" + apiKey;


        fetch(weatherUrl).then(function (res){
            return res.json();
        }).then(function (data){
            console.log(data)
            let icon = data.weather[0].icon
            let iconUrl = "http://openweathermap.org/img/wn/" + icon + "@2x.png"
            let img = document.querySelector("#wicon")
            img.src = iconUrl
            document.querySelector("#tempr").textContent = (data.main.temp) + "(" + (data.main.temp - 273) + ")" // 현재 온도
        }).catch((error) => {
            console.log(error)
        })
    }

    function showError(event) {
        alert("위치 정보를 얻을 수 없습니다.")
    }

    window.addEventListener('load', () => {
        if(window.navigator.geolocation) {
            window.navigator.geolocation.getCurrentPosition(showLocation,showError)
        }

    })
</script>
</body>
</html>