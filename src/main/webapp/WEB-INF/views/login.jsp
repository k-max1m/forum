<%--
  Created by IntelliJ IDEA.
  User: студент11
  Date: 13.11.2020
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" method="post">
    <input type="text" name="userName" placeholder="Логин">
    <input type="password" name="password" placeholder="Пароль">
    <input type="submit" value="Войти">
</form>
<a href="/registration">Registration</a>

</body>
</html>
