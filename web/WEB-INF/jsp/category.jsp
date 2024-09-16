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
</head>
<body class="w3-light-gray">
<div  class="w3-container w3-teal w3-opacity w3-left-align">
    <h1><fmt:message key="page.online_store_name"/> </h1>
</div>


<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
    }
    .product-card {
        background: #dddddd;
        border: 1px solid #e0e0e0;
        border-radius: 8px;
        padding: 10px;
        text-align: center;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        width: 220px;
        height: 260px;
        margin-top: 10px;
    }
    .fixed-button-form {
        position: fixed;
        bottom: 30px;
        right: 160px;
        z-index: 1000;
    }
    .fixed-button {
        padding: 15px 20px;
        position: absolute;
        bottom: -35px;
        left: -24px;
        background-color: teal;
        opacity: 0.63;
        color: white;
        border: none;
        border-radius: 20px;
        cursor: pointer;
        overflow-scrolling: auto;

    }

    .fixed-button:hover {
        background-color: darkgrey;
    }
    .product-card img {
        width: 85%;
        height: 70%;
        border-radius: 8px;
        margin-right: 10px;
    }
    .product-card h2 {
        font-size: 20px;
        margin: 10px 0;
        color: #333;
    }
    .product-card p {
        font-size: 18px;
        color: #28a745;
        margin: 5px 0;
        overflow: hidden;
        text-overflow: ellipsis;
    }
    .book-title {
        display: -webkit-box;
        -webkit-line-clamp: 2;
        -webkit-box-orient: vertical;
        overflow: hidden;
        text-overflow: ellipsis;
        font-size: 14px;
    }
    .product-container {
        display: flex;
        flex-wrap: wrap;
        gap: 15px; /* Отступ между карточками */
        justify-content: center; /* Ц
        grентрирование карточек */
    }
    .product-card  {
        color: #999;
    }
    .sidebar {
        width: 250px;
        background-color: #f4f4f4;
        padding: 15px;
        position: absolute;
        height: 100%;
        margin-bottom: -10px;
    }
        .sidebar h2 {
            font-size: 1.5em;
            margin-bottom: -4px; /* Уменьшите нижний отступ */
            margin-top: -5px; /* Поднимите заголовок вверх */
        }
    .category {
        margin: 10px;
    }
    .category a {
        text-decoration:none;
        color: #333;
        padding: 8px 10px;
        display: block;
        border-radius: 4px;
        transition: background-color 0.3s;
    }
    .category a:hover {
        background-color: #ddd;
    }
</style>
</head>

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


<form action="/basket" method="get" class="w3-display-topright" style="margin-right: 47px;">
    <button class="w3-button" alt="image ex">
        <img src="${pageContext.request.contextPath}/images/application_images/Basket.png" alt="No image" width="30px" height="30px">
    </button>
</form>

<form action="/profile" method="get">
    <button class="w3-button w3-display-topright" alt="image ex">
        <img src="${pageContext.request.contextPath}/images/application_images/Icon.png" alt="No image" style="width: 30px;height: 30px" >
    </button>
</form>

<form action="/replenishment" method="get" class="w3-display-topright" style="margin-right: 91px">
    <button class="w3-button" alt="image ex">
        <img src="${pageContext.request.contextPath}/images/application_images/wallet.png" alt="No image" style="width: 30px;height: 30px" >
    </button>
</form>

</body>
</html>
