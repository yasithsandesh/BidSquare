<%--
  Created by IntelliJ IDEA.
  User: yasithsandesh
  Date: 2025-06-02
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="css/home.css">
    <link rel="stylesheet" href="css/product.css">
</head>
<body class="homeBody">
<%

    if(request.getSession().getAttribute("user") == null){
        response.sendRedirect("login.jsp");
    }

%>
<%@include file="component/header.jsp"%>
<div class="content">
    <h1>All Products</h1>
    <span id="userInput">${sessionScope.user.id}</span>
    <div id="product-list" class="product-container">
        <!-- Products will be loaded here -->
    </div>
</div>
<script src="js/product.js"></script>
</body>
</html>
