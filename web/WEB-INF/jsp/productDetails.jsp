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
    <link rel="stylesheet" href="../../css/productDetails.css">
    <title>Подробности о товаре</title>
</head>
<body class="w3-light-grey">

<div class="product-container ">
    <h2 class="header"><fmt:message key="page.product_details"/></h2><br>

    <img src="/images/${requestScope.product.getImage()}" alt="Название товара" class="product-image" style="margin-left: 85px"  height="400px">
    <br>
    <b class="size"><fmt:message key="page.name"/></b>
    <h1 class="product-title">${requestScope.product.getProduct_name()}</h1>

    <b class="size"><fmt:message key="page.description"/></b>
    <p class="product-description">${requestScope.product.getDescription()}</p>

    <p class="product-price"><fmt:message key="page.price"/>${requestScope.product.getNew_price()} ₽</p>

    <form action="/productDetails" method="post" enctype="multipart/form-data">
        <button type="submit" value="${requestScope.product.getProduct_id()}" name="id"  class="w3-button w3-round w3-panel w3-blue w3-padding-16"><fmt:message key="page.add_to_basket"/></button>
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
