<%--
  Created by IntelliJ IDEA.
  User: kocic
  Date: 26.08.2024
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="locale.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Страница Пользователя</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .container {
            width: 500px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        label {
            display: block;
            margin-top: 10px;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"],
        input[type="tel"],
        input[type="number"],
        select {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        input[type="file"] {
            margin-top: 5px;
        }

        img {
            max-width: 200px;
            max-height: 200px;
            margin-top: 10px;
        }
    </style>
</head>

<body class="w3-light-gray">
    <form action="${pageContext.request.contextPath}/profile" method="post" enctype="multipart/form-data">
    <div class="w3-teal w3-opacity container">
        <h1><fmt:message key="page.profile" /> </h1>

    <label> <fmt:message key="page.user_name"/>:
    <input type="text"  name="name"  сlass="w3-input w3-animate-input w3-border w3-round-large"  value="${sessionScope.profile.getUser_name()}" required>
    </label>

    <label><fmt:message key="page.surname"/>:
    <input type="text" name="surname" сlass="w3-input w3-animate-input w3-border w3-round-large" value="${sessionScope.profile.getSurname()}" >
    </label>

    <label><fmt:message key="page.password"/>:
    <input type="password" name="password" сlass="w3-input w3-animate-input w3-border w3-round-large" value="${sessionScope.profile.getUser_password()}" required>
    </label>

    <label><fmt:message key="page.email" />:
    <input type="email"  name="email" сlass="w3-input w3-animate-input w3-border w3-round-large" value="${sessionScope.profile.getEmail()}" required>
    </label>

    <label><fmt:message key="page.address"/>:
    <input type="text" name="address" сlass="w3-input w3-animate-input w3-border w3-round-large" value="${sessionScope.profile.getAddress()}" >
    </label>

    <label><fmt:message key="page.phone"/>:
    <input type="tel" id="phone" name="phone" сlass="w3-input w3-animate-input w3-border w3-round-large" value="${sessionScope.profile.getPhone()}" >
    </label>

    <label><fmt:message key="page.balance"/>:
    <input type="number" name="balance" сlass="w3-input w3-animate-input w3-border w3-round-large" value="${sessionScope.profile.getBalance()}" readonly>
    </label>

    <label><fmt:message key="page.birthday" />:<br>
    <input type="date" name="birthday" сlass="w3-input w3-animate-input w3-border w3-round-large" value="${sessionScope.profile.getBirthday()}" required >
    </label>

    <label for="gender"><fmt:message key="page.gender"/>:
    <select name="gender" id="gender">
        <c:forEach var="gender"  items="${requestScope.genders}">
            <option value="${gender}" name="gender">${gender}</option>
        </c:forEach>
    </select>
    </label>
    </div><br>
        <button type="submit" class="w3-btn w3-teal w3-opacity w3-round-large w3-display-position" style="margin-right:280px; position: absolute; right: 100px;"><fmt:message key="page.save"/> </button>

        <c:if test="${requestScope.update!=null}">
            <font color="#006400" style="margin-left:385px">${requestScope.update}</font>
        </c:if>

        <c:if test="${requestScope.errors!=null}">
            <c:forEach var="error" items="${requestScope.errors}">
                <font color="red" style="margin-left:385px">${error}</font>
                <br>
            </c:forEach>
        </c:if>
 </form>

    <a href="/main">
        <button class="w3-button w3-display-position w3-round-xlarge w3-teal w3-opacity" style="margin-top: -18px;width: 110px;height: 40px" >
            <fmt:message key="page.back" />
        </button>
    </a>


</body>
</html>
