<%--
  Created by IntelliJ IDEA.
  User: kocic
  Date: 14.08.2024
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
</head>
<%@ include file="locale.jsp"%>

<body class="w3-light-gray">
<form action="/login" method="post" enctype="multipart/form-data" class="w3-selection w3-light-grey w3-padding">
    <div class="w3-center w3-teal w3-opacity" style="margin-top: -10px">
        <h2><fmt:message key="page.login" /> </h2>
    </div><br>
    
    <label><fmt:message key="page.email" />
    <input type="text" name="email" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%" required><br />
    </label>
    <label><fmt:message key="page.password" />
        <input type="password" name="password" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%" required><br />
    </label>
    <button type="submit" class="w3-btn w3-teal w3-opacity w3-round-large w3-margin-bottom"><fmt:message key="page.send"/> </button>

    <a href="/registration">
        <button type="button" class="w3-btn w3-teal w3-opacity w3-round-large" style="margin-top:  -14px"><fmt:message key="page.registration"></fmt:message></button>
    </a><br>

    <c:if test="${requestScope.error!=null}">
       <font color="red">${requestScope.error}</font>
    </c:if>

</form>
</body>
</html>
