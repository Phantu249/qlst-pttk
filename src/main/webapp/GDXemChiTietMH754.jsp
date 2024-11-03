<%@ page import="models.MatHang754" %><%--
  Created by IntelliJ IDEA.
  User: loinh
  Date: 11/3/2024
  Time: 9:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="KiemTraDangNhap754.jsp"%>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi tiết sản phẩm</title>
    <link rel="stylesheet" href="css/product-detail.css">
</head>
<%
    // Hiển thị thông tin sản phẩm
    MatHang754 matHang = (MatHang754) request.getAttribute("mh");
    if (matHang == null) {
        response.sendRedirect("tim-kiem-mat-hang");
        return;
    }
%>
<body>
<%@ include file="header.jsp" %>
<div class="container">
    <header>
        <h1>Chi tiết sản phẩm</h1>
    </header>
    <main class="product-detail">
        <div class="product-images">
            <div class="main-image">
                <%
                    if (matHang.getImages().length != 0 && matHang.getImages() != null) {
                %>
                        <img src="<%=matHang.getImages()[0]%>" alt="main image" id="main-image">
                <%
                    } else {
                %>
                        <img src="https://picsum.photos/200/200" alt="main image" id="main-image">
                <%
                    }
                %>
            </div>
            <div class="thumbnail-images">
            <%
            for (int i = 0; i < matHang.getImages().length; i++) {
            %>
                <img src="<%=matHang.getImages()[i]%>" alt="thumbnail image" onclick="changeImage(this.src)">
            <%
            }
            %>
            </div>
        </div>
        <div class="product-info">
            <h2><%=matHang.getTen()%></h2>
            <p class="price"><%=matHang.getGia()%> ₫</p>
            <div class="quantity">
                <label for="quantity">Số lượng:</label>
                <input type="number" id="quantity" name="quantity" value="1" min="1" max="<%=matHang.getSoLuong()%>">
            </div>
            <p>Còn lại: <%=matHang.getSoLuong()%></p>
            <button class="add-to-cart">Thêm vào giỏ hàng</button>
            <div class="product-description">
                <h3>Mô tả sản phẩm</h3>
                <p><%=matHang.getMoTa()%></p>
            </div>
            <div class="product-supplier">
                <h3>Nhà cung cấp</h3>
                <p><%=matHang.getNhaCC().getTen()%></p>
            </div>
        </div>
    </main>
</div>
<script>
    function changeImage(src) {
        document.getElementById('main-image').src = src;
    }
</script>
</body>
</html>
