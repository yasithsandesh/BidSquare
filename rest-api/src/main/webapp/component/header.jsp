<%--
  Created by IntelliJ IDEA.
  User: yasithsandesh
  Date: 2025-06-02
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="main-header">
    <div class="logo">BID SQUARE</div>
    <nav class="nav-links">
        <a>${sessionScope.user.username}</a>
        <a href="product.jsp">Add Products</a>
        <a href="notifications.jsp">Notifications</a>
    </nav>
</header>