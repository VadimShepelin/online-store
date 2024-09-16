<%--
  Created by IntelliJ IDEA.
  User: kocic
  Date: 24.08.2024
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
    .sidebar {
        width: 250px;
        background-color: #f4f4f4;
        padding: 15px;
        position: fixed;
        height: 100%;
        overflow-y: auto;
    }
    .sidebar h2 {
        font-size: 1.5em;
        margin-bottom: 10px;
    }
    .category {
        margin: 10px 0;
    }
    .category a {
        text-decoration: none;
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

<div style="margin-left: 270px; padding: 15px;">
    <h1><fmt:message key="page.hello"/> </h1>
    <p><fmt:message key="page.select_category"/> </p>
</div>

<form action="/logout" method="post">
    <div>
        <button class="w3-button w3-padding-16 w3-display-bottomright w3-panel w3-round-xxlarge w3-container w3-teal w3-opacity" style="width: 150px"><fmt:message key="page.exit" /> </button>
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