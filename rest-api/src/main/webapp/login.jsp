<%--
  Created by IntelliJ IDEA.
  User: yasithsandesh
  Date: 2025-06-02
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<div class="container">
    <h2>Login Account</h2>
    <form id="loginForm">
        <input type="text" name="username" placeholder="Username" required><br>
        <input type="password" name="password" placeholder="Password" required><br>
        <button type="submit">Login Account</button>
        <button class="btn" onclick="btnOnClick(false)">Create</button>
    </form>
</div>
<script src="js/auth.js"></script>
</body>
</html>
