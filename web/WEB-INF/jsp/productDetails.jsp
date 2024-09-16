<%--
  Created by IntelliJ IDEA.
  User: kocic
  Date: 05.09.2024
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="locale.jsp"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>Подробности о товаре</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
        }
        .product-container {
            max-width: 600px;
            flex-wrap: wrap;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        .header {
            font-size: 30px;
            color: teal;
            margin-left: 180px;
        }
        .size{
            font-size: 20px;
        }
        .product-image {
            width: 70%;
            border-radius: 8px;
        }
        .product-title {
            font-size: 24px;
        }
        .product-description {
            font-size: 16px;
            margin: 10px 0;
        }
        .product-price {
            font-size: 20px;
            color: #e74c3c;
            margin: 10px 0;
        }
    </style>
</head>
<body class="w3-light-grey">

<div class="product-container ">
    <h2 class="header">Детали товара</h2><br>

    <img src="/images/${requestScope.product.getImage()}" alt="Название товара" class="product-image" style="margin-left: 85px"  height="400px">
    <br>
    <b class="size">Название:</b>
    <h1 class="product-title">${requestScope.product.getProduct_name()}</h1>

    <b class="size">Описание:</b>
    <p class="product-description">${requestScope.product.getDescription()}</p>

    <p class="product-price">Цена: ${requestScope.product.getNew_price()} ₽</p>

    <form action="/productDetails" method="post" enctype="multipart/form-data">
        <button type="submit" value="${requestScope.product.getProduct_id()}" name="id"  class="w3-button w3-round w3-panel w3-blue w3-padding-16">Добавить в корзину</button>
    </form>

    <c:if test="${requestScope.error!=null}">
        <font color="red">${requestScope.error}</font>
    </c:if>

    <c:if test="${requestScope.success!=null}">
        <font color="#006400">${requestScope.success}</font>
    </c:if>
</div>

<form action="/main" method="get" enctype="multipart/form-data">
    <button class="w3-button w3-display-position w3-round-xlarge w3-teal w3-opacity" style="margin-top: -35px;margin-right: 30px;width: 110px;height: 40px" >
        <fmt:message key="page.back" />
    </button>
</form>



</body>
</html>
