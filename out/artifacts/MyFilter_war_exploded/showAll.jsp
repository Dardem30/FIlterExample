<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: УВД
  Date: 01.05.2017
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>Id</td>
        <td>name</td>
        <td>lastname</td>
    </tr>
    <c:forEach items="${list}" var="list">
        <tr>
            <th>${list.employeeId}</th>
            <th>${list.firstname}</th>
            <th>${list.lastname}</th>
        </tr>
    </c:forEach>
</table>
<form method="post" action="/out">
    <input type="submit" name="exit" value="выход">
</form>
</body>
</html>
