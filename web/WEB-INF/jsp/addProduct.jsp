<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kocic
  Date: 01.09.2024
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Добавление товара</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .btn-with-margin {
            gap: 10px;
        }
        h1 {
            text-align: center;
        }
        form {
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            margin: auto;
        }
        label {
            display: block;
            margin-bottom: 10px;
        }
        input[type="text"],
        input[type="number"],
        input[type="file"],
        textarea,
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }
        button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

<form id="productForm" action="${pageContext.request.contextPath}/addProduct" method="post" enctype="multipart/form-data">

    <h1>Добавление товара</h1>
    <label for="image">Изображение товара:
        <input type="file" id="image" name="image" required>
    </label>

    <label for="name">Название товара:</label>
    <input type="text" id="name" name="name" required>

    <label for="price">Цена товара:</label>
    <input type="number" id="price" name="price" step="0.01" required>

    <label for="discount">Скидка (%):</label>
    <input type="text" id="discount" name="discount" pattern="\d+" title="Введите целое число" placeholder="Введите скидку (0-100)" required>

    <label for="description">Описание товара:</label>
    <textarea id="description" name="description" rows="4" required></textarea>

    <label for="stock">Количество в наличии:</label>
    <input type="number" id="stock" name="stock" required>

    <label for="category">Категория товара:</label>
    <select id="category" name="category" required>
        <option disabled selected>Выберите категорию</option>
        <option value="1">Компьютеры</option>
        <option value="2">Художественная литература</option>
        <option value="3">Наука</option>
        <option value="4">Иностранные языки</option>
        <option value="5">Детская литература</option>
        <option value="6">Спорт и отдых</option>
        <option value="7">Школьные учебники</option>
        <option value="8">Мемуары</option>
    </select>

    <button type="submit" class="btn-with-margin">Добавить товар</button><br><br>

    <c:if test="${requestScope.success!=null}">
    <font color="#006400" >${requestScope.success}</font>
    </c:if>

    <c:if test="${requestScope.fail!=null}">
    <font color="red">${requestScope.fail}</font>
    </c:if>
</form>

<a href="/admin">
    <button class="w3-button w3-padding-16 w3-display-bottomleft w3-left-align w3-panel w3-green w3-opacity" style="width: 140px; height: 40px; margin-left: -7px">Назад</button>
</a>

</body>
</html>