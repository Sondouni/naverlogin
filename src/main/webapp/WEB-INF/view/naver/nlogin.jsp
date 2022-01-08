<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="ko">
<head>
    <link rel="shortcut icon" href="#">

    <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>


    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <div id="naver_id_login" >
        <a id="naverIdLogin_loginButton">

            <img src="https://static.nid.naver.com/oauth/big_g.PNG?version=js-2.0.0" width="100%" height="auto" style="max-width:400px;max-height:60px"/>
        </a>
    </div>
    <!--
    <script type="text/javascript">
        var naverLogin = new naver.LoginWithNaverId(
            {
                clientId: "CU4oIqnKlO1XPT8Z1wwf",
                callBackUrl:"http://localhost:8090/naver/ncallback",
                isPopup:false,
                loginButton:{color:"green",type:3,height:60}
            }
        );
        naverLogin.init();
    </script>
    -->
    <script type="text/javascript">
        var naver_id_login = new naver_id_login("CU4oIqnKlO1XPT8Z1wwf", "http://localhost:8090/naver/ncallback");
        var state = naver_id_login.getUniqState();
        naver_id_login.setButton("green", 2,100);
        naver_id_login.setDomain("YOUR_SERVICE_URL");
        naver_id_login.setState(state);
        naver_id_login.setPopup();
        naver_id_login.init_naver_id_login();
    </script>
</body>
</html>