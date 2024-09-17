<%--
  Created by IntelliJ IDEA.
  User: kocic
  Date: 16.09.2024
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="locale.jsp"%>

<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>История заказов</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        .logout-button {
            margin-top: 20px;
            width: 110px;
            height: 43px;
            display: inline-block;
            padding: 10px 20px;
            background-color: teal;
            opacity: 0.50;/* Красный цвет */
            color: white;
            border: none;
            border-radius: 5px;
            text-decoration: none; /* Убираем подчеркивание */
        }
        .logout-button:hover {
            background-color: #d32f2f; /* Темнее при наведении */
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: teal;
            color: white;
            opacity: 0.53;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>

<h1>История заказов</h1>

<table>
    <thead>
    <tr>
        <th>Номер заказа</th>
        <th>Дата заказа</th>
        <th>Количество товара</th>
        <th>Сумма заказа (₽)</th>
    </tr>
    </thead>
    <tbody>
    <!-- Пример данных о заказах -->
    <c:forEach var="order" items="${requestScope.orders}">
        <tr>
            <td>${order.getOrder_number()}</td>
            <td>${order.getOrder_date()}</td>
            <td>${order.getQuantity()}</td>
            <td>${order.getPrice()}</td>
        </tr>
    </c:forEach>
    <!-- Добавьте дополнительные заказы здесь -->
    </tbody>

</table>

<form action="/main" method="get">
    <td><button type="submit" class="logout-button w3-button">Назад</button></td>
</form>

</body>
</html>