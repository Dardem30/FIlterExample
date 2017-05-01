<%--
  Created by IntelliJ IDEA.
  User: УВД
  Date: 30.04.2017
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="/login">
    <input type="text" name="employeeId">
    <input type="text" name="firstname">
    <input type="text" name="lastname">
    <input type="submit" name="add" value="add">
    <input type="submit" name="showAll" value="showAll">
</form>
<form method="post" action="/out">
    <input type="submit" name="exit" value="выход">
</form>
</body>
</html>
