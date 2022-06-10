<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/9/2022
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Register</h1>
<form action="/register" method="post">
  <div>
    Username <input type="text" name="username">
  </div>
  <div>
    Password <input type="password" name="password">
  </div>
  <div>
    ConfirmPassword <input type="password" name="confirmPassword">
  </div>
  <div>
    <input type="submit" value="Register">
    <input type="submit" value="Reset">
  </div>
</form>
</body>
</html>
