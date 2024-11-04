<%@ page import="java.util.ArrayList" %>
<%@ page import="models.MatHang754" %><%--
  Created by IntelliJ IDEA.
  User: loinh
  Date: 11/3/2024
  Time: 7:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="KiemTraDangNhap754.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tìm kiếm sản phẩm</title>
    <link rel="stylesheet" href="css/search.css">
</head>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
    <h1>Tìm kiếm sản phẩm</h1>
    <form id="search-form" action="tim-kiem-mat-hang" method="get">
        <input type="text" id="search-input" name="name" placeholder="Nhập tên sản phẩm...">
        <button type="submit">Tìm kiếm</button>
    </form>
    <div class="product-grid">
        <%
            // Hiển thị danh sách sản phẩm
            ArrayList<MatHang754> danhSachMatHang = null;
            danhSachMatHang = (ArrayList<MatHang754>) request.getAttribute("listMH");
            if (danhSachMatHang != null && !danhSachMatHang.isEmpty()) {
                for (MatHang754 mh : danhSachMatHang) {
        %>
                    <div class="product-card">
                        <%
                            if (mh.getImages() != null && mh.getImages().length != 0) {
                        %>
                        <img src="<%=mh.getImages()[0].getPath()%>" alt="mat hang">
                        <%
                        } else {
                        %>
                        <img src="https://picsum.photos/200/200" alt="mat hang">
                        <%
                            }
                        %>
                        <h3><%=mh.getTen()%></h3>
                        <%@ page import="java.text.DecimalFormat" %>

                        <%
                            DecimalFormat formatter = new DecimalFormat("#,##0");
                            String formattedAmount = formatter.format(mh.getGia());
                        %>
                        <p class="price"><%=formattedAmount%> ₫</p>
                        <button class="view-details" onclick="window.location.href='mat-hang?id=<%= mh.getId() %>'" >Xem chi tiết</button>
                    <%--                        <button class="view-details" ><a href="mat-hang?id=<%= mh.getId() %>">Xem chi tiết</a>--%>
                    </div>
        <%
                }
            }
            else if (request.getAttribute("errorMessage") != null) {
        %>
                <p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
        <%
                }
        %>
    </div>
</div>
</body>
</html>
