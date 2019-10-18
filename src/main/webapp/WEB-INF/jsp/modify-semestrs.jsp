<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../../resources/css/style.css">
    <script src="../../resources/js/functions.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<nav class="top-menu">
    <ul class="menu-main">
        <li class="left-item"><a href="#">Logout</a></li>
        <li class="right-item"><a href="../../index.jsp" class="first">На главную</a></li>
        <li class="right-item"><a href="javascript:history.back()" title="Вернуться на предыдущую страницу">Назад</a>
        </li>
    </ul>
    <div class="box">Система управления студентами и их успеваемостью</div>
</nav>
<div class="boxSite">
    <form action="/modify-semestrs" method="post">
    <h2>Для изменения семестра заполните следующие данные и нажмите кнопку "Модифицировать"</h2>


        <p><label for="duration">Длительность (в неделях)</label>
            <input type="text" id="duration" name="duration" placeholder="Введите длительность" required autofocus>
        </p>
        <p><label for="selectDiscipline">Дисциплины в семестре</label>
            <select name="selectDiscipline" id="selectDiscipline" multiple="multiple">
                <c:forEach items="${disciplines}" var="d">
                    <option value="${d.id}" onclick="choiseDisc()">${d.discipline}</option>
                </c:forEach>
            </select>
        </p>
        <input type="hidden" name="idSem" value="${semestr.id}">
        <input type="submit" value="Модифицировать" class="buttonModify">
    </form>
</div>
</body>
</html>
