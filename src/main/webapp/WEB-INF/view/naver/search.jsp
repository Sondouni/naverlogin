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
<div>
    <form action="/naver/search" method="get" id="searchFrm">
        <div>
            <input type="search" name="searchText" />">
            <input type="submit" value="search">
        </div>
    </form>
    <c:if test="${requestScope.data!=null}">
        <c:forEach var="item" items="${requestScope.data}">
            <form action="/naver/map" method="get">
                <div>
                    <input type="text" name="title" readonly value="${item.title}">
                    <input type="text" name="mapx" readonly value="${item.mapx}">
                    <input type="text" name="mapy" readonly value="${item.mapy}">
                </div>
                <input type="submit" value="지도에서 보기">
            </form>
        </c:forEach>
    </c:if>
</div>
</body>
</html>