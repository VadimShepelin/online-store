<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kocic
  Date: 22.09.2024
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../css/ordersHistoryAdmin.css">
    <title>История заказов</title>
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
    <c:forEach var="order" items="${requestScope.orders}">
        <tr>
            <td>${order.getOrder_number()}</td>
            <td>${order.getOrder_date()}</td>
            <td>${order.getQuantity()}</td>
            <td>${order.getPrice()}</td>
        </tr>
    </c:forEach>
    </tbody>

</table>

<form action="/usersList" method="get">
    <td><button type="submit" class="logout-button w3-button">Назад</button></td>
</form>
</body>
</html>

