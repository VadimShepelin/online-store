<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kocic
  Date: 02.09.2024
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Список пользователей</title>
<html lang="ru">
<head>
<style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #ffffff;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th {
            border: 1px solid #4caf50;
            padding: 8px;
            text-align: left;
            background-color: #4caf50;
            color: white;
        }
        td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
            background-color: #ffffff;
        }
        .back-button {
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #4caf50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        .back-button:hover {
            background-color: #388e3c; /* Темно-зеленый цвет при наведении на кнопку */
        }
        .order-history-button {
            padding: 5px 10px;
            background-color: #4caf50;; /* Синий цвет для кнопки истории заказов */
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .order-history-button:hover {
            background-color: forestgreen; /* Темно-синий цвет при наведении */
        }
    </style>
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
        <th>История заказов</th> <!-- Новый заголовок для кнопки -->
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
                           onclick="updateCheckboxValue(${user.getUsers_id()})"><!-- Hidden input for checkbox state -->
                </td>


            <td><button class="order-history-button" onclick="goToOrderHistory(${user.getUsers_id()})">Перейти к истории заказов</button></td> <!-- Кнопка для перехода -->
        </tr>
    </c:forEach>
    </tbody>
</table>

<button class="back-button" onclick="window.history.back();">Назад</button>

<script>
    function goToUsersList(userId) {
        window.location.href = '/ordersHistoryAdmin?userId=' + userId; // Переход к истории заказов
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