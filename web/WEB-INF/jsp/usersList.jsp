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
            background-color:#4caf50;
            color: white;
        }
        td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
            background-color: #ffffff;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
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
            background-color: #388e3c;
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
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>Иван</td>
        <td>Иванов</td>
        <td>password123</td>
        <td>ivan@example.com</td>
        <td>+7 123 456 78 90</td>
        <td>1000.00 ₽</td>
        <td><input type="checkbox"></td>
    </tr>
    <tr>
        <td>Мария</td>
        <td>Петрова</td>
        <td>mypassword</td>
        <td>maria@example.com</td>
        <td>+7 987 654 32 10</td>
        <td>1500.50 ₽</td>
        <td><input type="checkbox"></td>
    </tr>

    </tbody>
</table>

<button class="back-button" onclick="window.history.back();">Назад</button>

</body>
</html>