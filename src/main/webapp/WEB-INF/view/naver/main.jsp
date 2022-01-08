<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    로그인 성공!

    <div>로그인 한 사람 id</div>
    <div>${sessionScope.loginUser.uid}</div>
    <div>로그인 한 사람 이름</div>
    <div>${sessionScope.loginUser.nm}</div>
    <div>로그인 한 사람 이메일</div>
    <div>${sessionScope.loginUser.email}</div>
    <div>메세지</div>
    <div>${sessionScope.msg}</div>

    <input type="button" value="api 호출" id="apiBtn">
    <script>
        const apiBtnElem = document.querySelector('#apiBtn');
        apiBtnElem.addEventListener('click',function (e){

            var script = document.createElement('script');
            script.src = '//www.daegufood.go.kr/kor/api/tasty.html?mode=json&addr=중구/jsonp?callback=myCallback';
            document.getElementsByTagName('head')[0].appendChild(script);
            function myCallback(data){ console.log(data) }


            const headers = new Headers({
                'Content-Type': 'text/xml',
            });
            /*
            fetch('https://www.daegufood.go.kr/kor/api/tasty.html?mode=json&addr=중구',headers)
               .then(function (res){
                   return res.join();
               }).then(function (data){
                    console.log(data);
           });


            // test();
*/

        });
        function test () {
            var script = document.createElement("script");
            script.type = "text/javascript";
            script.src = 'https://www.daegufood.go.kr/kor/api/tasty.html?mode=json&addr=중구';
            document.getElementsByTagName('head').appendChild(script);
        }
        function callback ( data ) {
            console.log(data);
        }





    </script>
</body>
</html>