<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../../resources/css/style.css">
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
    <form action="/progress-student" method="get">
        <div class="table">
            <div class="tableName">Отображена успеваемость для следующего студента:</div>
            <div class="table-row">
                <div class="table-cellH secondName" style="height: auto">Фамилия</div>
                <div class="table-cellH name" style="height: auto">Имя</div>
                <div class="table-cellH group" style="height: auto">Группа</div>
                <div class="table-cellH date" style="height: auto">Дата поступления</div>
            </div>
            <div class="table-row">
                <div class="table-cell">${student.surname}</div>
                <div class="table-cell">${student.name}</div>
                <div class="table-cell">${student.group}</div>
                <div class="table-cell"><f:formatDate value="${student.date}" pattern="dd/MM/yyyy"></f:formatDate></div>
            </div>
        </div>

        <div class="firstRow">
            <div class="table">
                <div class="table-row">
                    <div class="table-cellH group">Дисциплина</div>
                    <div class="table-cellH date">Оценка</div>
                </div>
                <c:forEach items="${marks}" var="mark">
                    <div class="table-row">
                        <div class="table-cell">${mark.discipline.discipline}</div>
                        <div class="table-cell">${mark.mark}</div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <div class="secondRow">
            <span>Выбрать семестр</span>

            <select name="semestrs">
                <c:forEach items="${semestrs}" var="sem">
                    <option value="${sem.id}">${sem.semestr}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Выбрать">

            <p>Средняя оценка за семестр: 4.8 балла</p>
        </div>
    </form>
</div>

</body>
</html>
