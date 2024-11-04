<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.HoaDonTrucTuyen754DAO" %>
<%@ page import="models.HoaDonTrucTuyen754" %>
<%@ page import="models.NVGiaoHang754" %>
<%@ page import="models.NguoiDung754" %><%--
  Created by IntelliJ IDEA.
  User: loinh
  Date: 11/3/2024
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    NguoiDung754 user = (NguoiDung754) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("login");
        return;
    }

    if (!user.getVaitro().equals("KHO")) {
        response.sendRedirect("/");
        return;
    }
%>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Duyệt Đơn và Xuất Kho</title>
    <link rel="stylesheet" href="css/order-processing.css">
</head>
<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null) {
%>
    <script>
        alert("<%= errorMessage %>");
    </script>
<%
    }
%>
<body>
<%@ include file="header.jsp" %>
<div class="dd-container">
    <div class="dd-header">
        <h1>Duyệt Đơn và Xuất Kho</h1>
    </div>
    <main>
        <section class="order-list">
            <h2>Danh Sách Đơn Chưa Xuất</h2>
            <table>
                <thead>
                <tr>
                    <th>Mã Đơn</th>
                    <th>Khách Hàng</th>
                    <th>Ngày Đặt</th>
                    <th>Tổng Tiền</th>
                    <th>Trạng Thái</th>
                    <th>Hành Động</th>
                </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<HoaDonTrucTuyen754> listHD = null;
                    listHD = (ArrayList<HoaDonTrucTuyen754>) request.getAttribute("listHD");
                    if (listHD != null) {
                        for (HoaDonTrucTuyen754 hd : listHD) {
                %>
                <tr>
                    <td><%=hd.getId()%></td>
                    <td><%=hd.getNguoiDat().getTen()%></td>
                    <td><%=hd.getNgayDat()%></td>
                    <%@ page import="java.text.DecimalFormat" %>

                    <%
                        DecimalFormat formatter = new DecimalFormat("#,##0");
                        String formattedAmount = formatter.format(hd.getTongTien());
                    %>

                    <td><%= formattedAmount %> ₫</td>
                    <td>Chưa duyệt</td>
                    <td><button class="btn-process" onclick="window.location.href='chon-nv-trang-thai?idHD=<%=hd.getId()%>'">Xử lý</button></td>
                </tr>
                <%}
                    }
                %>
                </tbody>
            </table>
        </section>
    </main>
    <button onclick="history.back()" style="
                float: right;
                margin-top: 10px;
                background-color: #4CAF50;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                font-size: 16px;
                transition: background-color 0.3s ease;">
        Quay lại
    </button>
</div>
</body>
</html>
