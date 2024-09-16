<%--
  Created by IntelliJ IDEA.
  User: kocic
  Date: 31.08.2024
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">

<div class="w3-container w3-blue-grey w3-opacity w3-left-align">
    <h1>Admin page</h1>
</div>

<div class="w3-container w3-center">
    <div class="w3-bar w3-padding-large w3-padding-24">
        <form method="get">
        <button formaction="/listUsers" class="w3-btn w3-light-blue w3-round-large">List Users</button>
        <button formaction="/addProduct" class="w3-btn w3-green w3-round-large">Add product</button>
        </form>
    </div>
</div>

<form action="/adminLogout" method="post">
    <div>
        <button  type="submit" class="w3-button w3-padding-16 w3-display-bottomright w3-panel w3-round-xxlarge w3-container w3-blue-grey w3-opacity" style="width: 120px">Выход</button>
    </div>
</form>

</body>
</html>
