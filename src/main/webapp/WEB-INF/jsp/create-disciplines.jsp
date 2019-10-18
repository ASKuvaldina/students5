<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <li class="right-item"><a href="javascript:history.back()" title="Вернуться на предыдущую страницу">Назад</a></li>
    </ul>
    <div class="box">Система управления студентами и их успеваемостью</div>
</nav>
<div class="boxSite">
    <h2>Для того, чтобы создать новую дисциплину, заполните все поля и нажмите кнопку "Создать"</h2>
    <p><label for="nameDiscipline">Название</label>
    <form action="/create-disciplines" method="post">
        <input type="text" id="nameDiscipline" name="secondName" placeholder="Введите дисциплину" required autofocus></p>


        <input type="submit" value="Создать" class="buttonModify">
    </form>
</div>
</body>
</html>
