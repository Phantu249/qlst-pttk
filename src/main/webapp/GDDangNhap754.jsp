<%--
  Created by IntelliJ IDEA.
  User: loinh
  Date: 11/2/2024
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="login-container">
    <h2>Đăng nhập vào hệ thống</h2>
    <%-- Hiển thị thông báo lỗi nếu có --%>
    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
    %>
    <div class="error-message">
        <p style="color: red;"><%= errorMessage %></p>
    </div>
    <%
        }
    %>
    <form action="login" method="post">
        <div class="input-group">
            <label for="username">Tên đăng nhập</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="input-group">
            <label for="password">Mật khẩu</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit">Đăng nhập</button>
    </form>
</div>
</body>
</html>

