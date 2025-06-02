<%--
  Created by IntelliJ IDEA.
  User: yasithsandesh
  Date: 2025-06-02
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<div class="container">
    <h2>Create Account</h2>
    <form id="createUserForm">
        <input type="text" name="username" placeholder="Username" required><br>
        <input type="password" name="password" placeholder="Password" required><br>
        <button type="submit">Create Account</button>
        <button class="btn" onclick="btnOnClick(true)">Login</button>
    </form>
</div>
<script src="js/auth.js"></script>
</body>
</html>
