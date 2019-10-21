<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">

	<link rel="stylesheet" href="../../resources/css/style_log.css">
</head>
<body>

    <div id="login-form">
        <h1>Авторизация на сайте</h1>

        <fieldset>
            <form action="/login" method="post">
                <label for="login">Введите логин</label>
                <input type="text" id="login" name="login" required value="Логин" onBlur="if(this.value=='')this.value='Логин'" onFocus="if(this.value=='Логин')this.value='' ">
                <label for="password">Введите пароль</label>
                <input type="password"  id="password" name="password" required value="Пароль" onBlur="if(this.value=='')this.value='Пароль'" onFocus="if(this.value=='Пароль')this.value='' ">
                <label for="role">Введите роль</label>
                <select name="role" id="role">
                    <option value="admin">Администратор</option>
                    <option value="student">Студент</option>
                </select>
                <input type="submit" value="ВОЙТИ">
                <c:if test="${error eq 1}">
                    <p>Пользователь не найден!</p>
                </c:if>
                <footer class="clearfix">
                    <p><span class="info">?</span><a href="#">Забыли пароль?</a></p>
                </footer>
            </form>
        </fieldset>

    </div>
</body>
</html>