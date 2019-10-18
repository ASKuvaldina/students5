<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../../resources/css/style.css">
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
    <form action="/modify-discipline" method="post">

        <h2>Для того, чтобы модифицировать дисциплину, введите новое значение поля и нажмите кнопку "Создать"</h2>
        <p><label for="nameDisc">Название</label>
            <input type="text" id="nameDisc" name="nameDisc" placeholder="${discipline.discipline}" required
                   autofocus></p>


        <input type="hidden" name="discId" value="${discipline.id}">
        <button class="buttonModify">Применить</button>
    </form>
</div>

</body>
</html>
