<%--
  Created by IntelliJ IDEA.
  User: kocic
  Date: 03.09.2024
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="overflow: hidden">
<%@include file="locale.jsp"%>
<head>
    <meta charset="UTF-8">
    <title>Books for you!</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="../../css/category.css">
</head>
<body class="w3-light-gray">

<div  class="w3-container w3-teal w3-opacity w3-left-align">
    <h1><fmt:message key="page.online_store_name"/> </h1>
</div>

<div class="sidebar">
    <h2><fmt:message key="page.books_category"/> </h2>
    <div class="category" ><a href="${pageContext.request.contextPath}/category?categoryId=1"><fmt:message key="page.computer"/></a></div>
    <div class="category"><a href="${pageContext.request.contextPath}/category?categoryId=2"><fmt:message key="page.fiction"/></a></div>
    <div class="category"><a href="${pageContext.request.contextPath}/category?categoryId=3"><fmt:message key="page.science" /> </a></div>
    <div class="category"><a href="${pageContext.request.contextPath}/category?categoryId=4"><fmt:message key="page.languages"/> </a></div>
    <div class="category"><a href="${pageContext.request.contextPath}/category?categoryId=5"><fmt:message key="page.childrens_literature"/> </a></div>
    <div class="category"><a href="${pageContext.request.contextPath}/category?categoryId=6"><fmt:message key="page.sport"/> </a></div>
    <div class="category"><a href="${pageContext.request.contextPath}/category?categoryId=7"><fmt:message key="page.school_textbooks"/> </a></div>
    <div class="category"><a href="${pageContext.request.contextPath}/category?categoryId=8"><fmt:message key="page.memoirs"/> </a></div>
</div>
<div style="margin-left: 260px; display: flex; flex-wrap: wrap; gap: 17px; height: calc(100vh - 130px); overflow-y: auto;">
    <c:forEach var="product" items="${requestScope.productList}">
        <div class="product-container">
        <a href="${pageContext.request.contextPath}/productDetails?id=${product.getProduct_id()}" style="text-decoration: none">
            <div class="product-card">
                <img src="/images/${product.getImage()}" alt="Название товара">
                <p class="w3-left-align">
                    <font color="#006400" size="4">${product.getNew_price()}₽&nbsp</font>
                    <font size="3"><s style="color: #999999">${product.getOld_price()}₽&nbsp</s></font>
                    <font color="red" size="3">-${product.getDiscount()}%</font><br>
                    <font color="black" class="book-title" size="3">${product.getProduct_name()}</font>
                </p>
            </div>
        </a>

        </div><br>
    </c:forEach>
</div>

<form action="/logout"  method="post" class="fixed-button-form">
    <div>
        <button class="fixed-button" style="width: 150px"><fmt:message key="page.exit" /> </button>
    </div>
</form>


<form action="/basket" method="get" class="w3-display-topright" style="margin-right: 92px;">
    <button class="w3-button" alt="image ex">
        <img src="${pageContext.request.contextPath}/images/application_images/Basket.png" alt="No image" width="30px" height="30px">
    </button>
</form>

<form action="/ordersHistory" method="get" class="w3-display-topright" style="margin-right: 47px">
    <button class="w3-button" alt="image ex">
        <img src="${pageContext.request.contextPath}/images/application_images/history.png" alt="No image" style="width: 30px;height: 30px" >
    </button>
</form>

<form action="/profile" method="get">
    <button class="w3-button w3-display-topright" alt="image ex">
        <img src="${pageContext.request.contextPath}/images/application_images/Icon.png" alt="No image" style="width: 30px;height: 30px" >
    </button>


</form>


<form action="/replenishment" method="get" class="w3-display-topright" style="margin-right: 137px">
    <button class="w3-button" alt="image ex">
        <img src="${pageContext.request.contextPath}/images/application_images/wallet.png" alt="No image" style="width: 30px;height: 30px" >
    </button>
</form>

</body>
</html>
