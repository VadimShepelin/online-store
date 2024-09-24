<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kocic
  Date: 31.08.2024
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="../../css/adminLogin.css">
</head>
<body  class="w3-light-grey">
<div class="login-container" >
    <h2>Вход в админ-панель</h2>
    <form action="/adminLogin" method="post" enctype="multipart/form-data" style="width: 350px;height: 220px">
        <div class="form-group">
            <label for="name">Имя админа:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="password">Пароль:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit" class="btn">Войти</button>
    </form>

    <c:if test="${requestScope.error!=null}">
        <font color="red">${requestScope.error}</font>
    </c:if>
</div>
</body>
</html>