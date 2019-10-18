<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
<nav class="top-menu">
    <ul class="menu-main">
        <c:choose>
            <c:when test="${isLogin eq 1}">
                <li class="left-item"><a href="/logout" class="logout">Logout</a></li>
            </c:when>
            <c:otherwise>
                <li class="left-item"><a href="/login" class="login">login</a></li>
            </c:otherwise>
        </c:choose>


    </ul>
    <div class="box">Система управления студентами и их успеваемостью</div>
</nav>
<div class="boxSite">

    <span>
        <a href="/students" class="students">Студенты</a>
    </span>
    <span>
        <a href="/disciplines" class="disciplines">Дисциплины</a>
    </span>
    <span>
        <a href="/semestrs" class="semestrs">Семестры</a>
    </span>
</div>
</body>
</html>