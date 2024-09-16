<%--
  Created by IntelliJ IDEA.
  User: kocic
  Date: 13.08.2024
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title></title>
</head>
<body class="w3-light-gray">
<%@ include file="locale.jsp"%>
<form action="${pageContext.request.contextPath}/registration" method="post" enctype="multipart/form-data" >

    <div class="w3-center w3-teal w3-opacity" style="margin-top: -10px">
        <h2><fmt:message key="page.registration" /> </h2>
    </div>

    <label for="nameId"><fmt:message key="page.user_name" />
        <input type="text" name="name" id="nameId" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%" required>
    </label><br>


    <label for="emailId"><fmt:message key="page.email" />
        <input type="email" name="email" id="emailId" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%" required>
    </label><br>

    <label for="passwordId"><fmt:message key="page.password" />
        <input type="password" name="password" id="passwordId" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%" required>
    </label><br>

    <label for="birthdayId"><fmt:message key="page.birthday" />
        <input type="date" name="birthday" id="birthdayId" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%" required>
    </label><br>

    <div><fmt:message key="page.gender" />
        <c:forEach var="gender"  items="${requestScope.genders}">
            <label>
                <input type="radio" name="gender" value="${gender}">
            </label>${gender}
        </c:forEach>
    </div><br>

    <button type="submit" class="w3-btn w3-teal w3-opacity w3-round-large w3-margin-bottom"> <fmt:message key="page.send"> </button></fmt:message>

    <a href="/login" style="margin-left: 5px">
        <button type="button" class="w3-btn w3-teal w3-opacity w3-round-large w3-margin-bottom"><fmt:message key="page.login"></fmt:message></button>
    </a><br><br>

    <c:if test="${requestScope.errors!=null}">
            <c:forEach var="error" items="${requestScope.errors}">
                <font color="red">${error}</font>
                <br>
            </c:forEach>
    </c:if>

</form>
</body>
</html>