<%--
  Created by IntelliJ IDEA.
  User: yasithsandesh
  Date: 2025-06-02
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<div class="container">
    <h2>Create Product</h2>
    <form id="productForm">
        <input type="text" name="name" placeholder="Product Name" required><br>
        <input type="number" name="price" placeholder="Starting Price" required><br>
        <input type="text" name="url" placeholder="URL" required><br>
        <textarea name="description" placeholder="Product Description" rows="4" cols="50" required></textarea><br>
        <button type="submit">Submit</button>
    </form>
</div>

<script src="js/product.js"></script>
</body>
</html>
