<%--
  Created by IntelliJ IDEA.
  User: студент11
  Date: 13.11.2020
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/editRole">
    <table>
        <tr>
            <th>User</th>
            <th>Role</th>
        </tr>
        <tr>
            <c:forEach var="user" items="${users}">
                <td>${user}</td>
                <td>
                    <select>
                        <c:forEach var="role" items="${roles}">
                            <option>${role}</option>
                        </c:forEach>
                    </select>
                </td>
            </c:forEach>
        </tr>
    </table>
    <input type="submit" value="Edit">
</form>
</body>
</html>
