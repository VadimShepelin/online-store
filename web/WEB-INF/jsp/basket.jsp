<%--
  Created by IntelliJ IDEA.
  User: kocic
  Date: 07.09.2024
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="locale.jsp"%>

<!DOCTYPE html>
<html lang="ru">
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="../../css/basket.css">
    <script src="../../js/basket.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Корзина товаров</title>
</head>
<body>
<div class="cart">
    <h1><fmt:message key="page.basket"/></h1>
    <form action="/basket" method="post" enctype="multipart/form-data" onsubmit="return updateInputPrice()">
    <c:forEach var="product" items="${sessionScope.basketList}">
        <div class="cart-item" data-price="${product.getNew_price()}">
            <img src="images/${product.getImage()}" alt="Image Error">
            <h3>${product.getProduct_name()}</h3>
            <span class="price" id="new_price"  style="color: green">${product.getNew_price()} ₽</span>&nbsp;&nbsp;
            <label>
                <input type="number" name="count${product.getProduct_id()}" value="1" min="1" class="quantity" onchange="updatePrice(this)">
            </label>
        </div>
    </c:forEach>


        <input type="hidden" name="totalPrice" id="totalPriceInput" value="0">
        <div class="total" ><fmt:message key="page.summary"/><span id="totalPrice"></span></div>
        <button class="checkout-button" onclick="checkout()"><fmt:message key="page.place_an_order"/></button>
        <button formaction="/deleteBasket" class="delete-button w3-right-align"  onclick="checkout()"><fmt:message key="page.delete_products"/></button>
    </form>

    <c:if test="${requestScope.error!=null}">
        <font color="red">${requestScope.error}</font>
    </c:if>

    <c:if test="${requestScope.success!=null}">
        <font color="#006400">${requestScope.success}</font>
    </c:if>


</div>

<form action="/main" method="get" enctype="multipart/form-data">
    <button class="w3-button w3-padding-16 w3-display-bottomleft w3-panel w3-round-xxlarge w3-container w3-teal w3-opacity" style="width: 130px" ><fmt:message key="page.back"/></button>
</form>

</body>
</html>
