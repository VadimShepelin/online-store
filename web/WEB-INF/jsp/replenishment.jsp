<%--
  Created by IntelliJ IDEA.
  User: kocic
  Date: 09.09.2024
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="locale.jsp"%>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Пополнение баланса</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 400px;
            margin: auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .button {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        h2 {
            text-align: center;
        }
        .amount-option {
            margin: 10px 0;
        }

        button {
            background-color: #28a745;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #218838;
        }
    </style>
</head>


<body>
<div class="container">
    <h2>Пополнение баланса</h2>
    <form id="rechargeForm" action="/replenishment" method="post" enctype="multipart/form-data">
        <div class="amount-option">
            <label>
                <input type="radio"  name="amount" value="100" onclick="toggleRadio(this)"> 100 ₽
            </label>
        </div>
        <div class="amount-option">
            <label>
                <input type="radio" name="amount" value="500" onclick="toggleRadio(this)"> 500 ₽
            </label>
        </div>
        <div class="amount-option">
            <label>
                <input type="radio" name="amount" value="1000" onclick="toggleRadio(this)"> 1000 ₽
            </label>
        </div>
        <div class="amount-option">
            <label>
                <input type="radio" name="amount" value="10000" onclick="toggleRadio(this)"> 10000 ₽
            </label>
        </div>
        <div class="amount-option">Своя сумма:
            <label><br>
                <input type="number" onclick="toggleRadio(this)" name="customAmount" placeholder="Введите свою сумму" min="100">
            </label>
        </div>
        <button class="button" type="submit">Пополнить</button>
    </form>

    <c:if test="${requestScope.error!=null}">
        <font color="red">${requestScope.error}</font>
    </c:if>

    <c:if test="${requestScope.success!=null}">
        <font color="#006400">${requestScope.success}</font>
    </c:if>
</div>

<form action="/main" method="get" enctype="multipart/form-data">
    <button class="w3-button w3-padding-16 w3-display-bottomleft w3-panel w3-round-xxlarge w3-container w3-teal w3-opacity" style="width: 130px" >Назад</button>
</form>

<script>
    function toggleRadio(radio) {
        // Проверяем, есть ли уже выбранная радиокнопка
        const selectedRadio = document.querySelector('input[name="amount"]:checked');

        // Если выбранная радиокнопка существует
        // то снимаем с нее галочку и устанавливаем галочку на текущую
        if (selectedRadio) {
            selectedRadio.checked = false;
        }
        radio.checked = true;
    }
</script>

</body>
</html>
