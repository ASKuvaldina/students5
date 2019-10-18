<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../../resources/css/style.css">
    <link rel="stylesheet" href="../../resources/lib/jquery-ui-1.12.1/jquery-ui-1.12.1/jquery-ui.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="../../resources/lib/jquery-ui-1.12.1/jquery-ui-1.12.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker({ //id=date
                showOn: "button",
                buttonImage: "images/calendar.gif",
                buttonImageOnly: true,
                buttonText: "Select date"
            });
        } );
    </script>
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
    <h2>Для создания студента заполните все поля и нажмите кнопку "Создать"</h2>
    <form action="/create-students" method="post">
    <p><label for="secondName">Фамилия</label>
        <input type="text" id="secondName" name="surname" placeholder="Введите фамилию" required autofocus></p>
    <p><label for="name">Имя</label>
        <input type="text" id="name" name="name" placeholder="Введите имя" required></p>
    <p><label for="group">Группа</label>
        <input type="text" id="group" name="group" required></p>
    <p><label for="datepicker">Дата поступления</label>
        <input type="text" id="datepicker" name="date" required></p>


    <input type="submit" value="Создать" class="buttonModify">
    </form>
</div>
</body>
</html>
