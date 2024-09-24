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
    <link rel="stylesheet" href="../../css/replenishment.css">
    <title>Пополнение баланса</title>
</head>


<body>
<div class="container">
    <h2><fmt:message key="page.balance_replenishment"/></h2>
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
        <div class="amount-option"><fmt:message key="page.own_amount"/>
            <label><br>
                <input type="number" onclick="toggleRadio(this)" name="customAmount" placeholder="<fmt:message key="page.your_amount"/>" min="100">
            </label>
        </div>
        <button class="button" type="submit"><fmt:message key="page.replenish"/></button>
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

<script>
    function toggleRadio(radio) {
        const selectedRadio = document.querySelector('input[name="amount"]:checked');

        if (selectedRadio) {
            selectedRadio.checked = false;
        }
        radio.checked = true;
    }
</script>

</body>
</html>
