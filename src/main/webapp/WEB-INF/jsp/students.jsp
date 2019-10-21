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
    <script src="../../resources/js/functions.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<nav class="top-menu">
    <ul class="menu-main">
        <li class="left-item"><a href="/logout">Logout</a></li>
        <li class="right-item"><a href="/" class="first">На главную</a></li>
        <li class="right-item"><a href="javascript:history.back()" title="Вернуться на предыдущую страницу">Назад</a></li>
    </ul>
    <div class="box">Система управления студентами и их успеваемостью</div>
</nav>


<div class="boxSite">
    <div class="firstRow">
        <form action="/progress-student" id="ProgStudForm">
            <input type="submit" onclick="progressStudent()" value="Просмотреть успеваемость студента" class="buttonModify">

            <input type="hidden" name="idProgStud" id="idProgStud">
        </form>
<c:if test="${role eq 'admin'}">
        <form action="/create-students" method="get">
            <input type="submit" value="Создать студента" class="buttonModify">
        </form>

            <input type="submit" onclick="modifingStudent()" value="Модифицировать студента" class="buttonModify">
        <form action="/modify-student" id="modifStudForm">
            <input type="hidden" name="idModifStud" id="idModifStud" >
        </form>

        <input type="submit"  value="Удалить студента" onclick="deleteStudent()" class="buttonModify">
        <form action="/delete-student"  method="get" id="deleteStudForm">
            <input type="hidden" name="idsDeleteStud" id="idsDeleteStud" >
        </form>
</c:if>
    </div>
    <div class="secondRow">
        <div class="tableName">Список студентов</div>
        <div class="table">
            <div class="table-row">
                <div class="table-cellH checkbox"></div>
                <div class="table-cellH secondName">Фамилия</div>
                <div class="table-cellH name">Имя</div>
                <div class="table-cellH group">Группа</div>
                <div class="table-cellH date">Дата поступления</div>
            </div>
            <c:forEach items="${students}" var="s">
                <div class="table-row">
                    <div class="table-cell">
                            <input type="checkbox" value="${s.id}">
                    </div>
                    <div class="table-cell">${s.surname}</div>
                    <div class="table-cell">${s.name}</div>
                    <div class="table-cell">${s.group}</div>
                    <div class="table-cell">${s.date}</div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
