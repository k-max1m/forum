<%--
  Created by IntelliJ IDEA.
  User: студент11
  Date: 13.11.2020
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form method="post" action="/registration">
    <input type="text" placeholder="firstName" name="firstName">
    <input type="text" placeholder="lastName"name="lastName">
    <input type="text" placeholder="login" name="login">
    <input type="password" placeholder="password" name="password">
    <input type="password" placeholder="repeat password" name="repeat">
    <input type="hidden" name="roleId" value="2">
    <input type="submit" placeholder="Add">
</form>

</form>
</body>
</html>
