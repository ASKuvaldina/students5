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


    <div class="firstRow">
        <div class="table">
            <div class="table-row">
                <div class="table-cellH checkbox"></div>
                <div class="table-cellH secondName">Наименование дисциплины</div>
            </div>

            <c:forEach items="${disciplines}" var="d">
                <div class="table-row">
                    <div class="table-cell checkbox">

                        <input type="checkbox" value="${d.id}">

                    </div>
                    <div class="table-cell">${d.discipline}</div>
                </div>
            </c:forEach>
        </div>
    </div>

    <div class="secondRow">
        <div class="admin-bottom">

            <form action="/create-disciplines" method="get">
                <input type="submit" value="Создать дисциплину" class="buttonModify">
            </form>

                <input type="submit" onclick="modifingDisciplines()" value="Модифицировать дисциплину" class="buttonModify">
            <form action="/modify-discipline" id="modifDiscForm">
                <input type="hidden" name="idModifDisc" id="idModifDisc">
            </form>

            <input type="submit" onclick="deleteDiscipline()" value="Удалить дисциплины" class="buttonModify">
            <form action="/delete-discipline" method="get" id="deleteDiscForm">
                <input type="hidden" name="idsDeleteDisc" id="idsDeleteDisc">
            </form>
        </div>
    </div>
</div>
</body>
</html>
