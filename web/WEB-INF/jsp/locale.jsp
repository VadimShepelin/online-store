<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<fmt:setLocale value="${sessionScope.lang != null
                            ? sessionScope.lang
                            : 'ru_RU'}"/>
<fmt:setBundle basename="translations" />

<fmt:setBundle basename="translations" />
<form action="${pageContext.request.contextPath}/locale" method="post" enctype="multipart/form-data">
    <button  class="w3-teal w3-opacity w3-round-large w3-button " type="submit" name="locale" value="ru_RU" >RU</button>
    <button class="w3-teal  w3-opacity w3-round-large w3-button" type="submit"  name="locale" value="en_US">EN</button>
    <button  class="w3-teal  w3-opacity w3-round-large w3-button" type="submit" name="locale" value="cn_CN" >CN</button>
</form>

</body>
</html>
