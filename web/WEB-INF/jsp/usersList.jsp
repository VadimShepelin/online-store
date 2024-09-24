<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kocic
  Date: 02.09.2024
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Список пользователей</title>
    <link rel="stylesheet" href="../../css/usersList.css">
</head>
<body>

<h1>Список пользователей</h1>

<table>
    <thead>
    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Пароль</th>
        <th>Почта</th>
        <th>Телефон</th>
        <th>Баланс</th>
        <th>Черный список</th>
        <th>История заказов</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${requestScope.allUsers}">
        <tr>
            <td>${user.getUser_name()}</td>
            <td>${user.getSurname()}</td>
            <td>${user.getUser_password()}</td>
            <td>${user.getEmail()}</td>
            <td>${user.getPhone()}</td>
            <td>${user.getBalance()} ₽</td>

                <td>
                    <input type="checkbox"
                           name="blacklisted"
                           value="false"
                           id="blacklistCheckbox"
                        ${user.getIs_blacklisted() == 'True' ? 'checked' : ''}
                           onclick="updateCheckboxValue(${user.getUsers_id()})">
                </td>


            <td><button class="order-history-button" onclick="goToUsersOrdersHistory(${user.getUsers_id()})">Перейти к истории заказов</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<form action="/admin" method="get">
    <td><button type="submit" class="logout-button w3-button">Назад</button></td>
</form>


<script>
    function goToUsersOrdersHistory(userId) {
        window.location.href = '/ordersHistoryAdmin?userId=' + userId;
    }
</script>

<script>
    function updateCheckboxValue(userId) {
        const checkbox = document.getElementById('blacklistCheckbox');

        checkbox.value = checkbox.checked ? 'true' : 'false';

        window.location.href = '/usersList?userId=' + userId+"&value="+checkbox.value;
    }
</script>

</body>
</html>