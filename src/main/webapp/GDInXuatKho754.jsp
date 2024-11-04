<%@ page import="models.NguoiDung754" %>
<%@ page import="models.HoaDonTrucTuyen754" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.MatHang754" %>
<%@ page import="models.ChiTietHangTrucTuyen754" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: loinh
  Date: 11/5/2024
  Time: 1:39 AM
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
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Invoice Details</title>
    <link rel="stylesheet" href="css/inhoadon.css">
</head>
<body>
<%@ include file="header.jsp" %>
<div class="inv-container">
    <div class="inv-card">
        <header class="inv-header">
            <h1 class="inv-title">Chi Tiết hóa đơn</h1>
        </header>
        <%
            HoaDonTrucTuyen754 hd = (HoaDonTrucTuyen754) request.getAttribute("hd");
            if (hd == null) {
                response.sendRedirect("duyet-don");
                return;
            }
        %>
        <main class="inv-main">
            <section class="inv-info">
                <div class="inv-info-group">
                    <p><strong>ID:</strong> <%=hd.getId()%></p>
                </div>
                <div class="inv-info-group">
                    <p><strong>Ngày đặt:</strong> <%=hd.getNgayDat()%></p>
                    <p><strong>Ngày xuất:</strong> <%=hd.getNgayXuat()%></p>
                </div>
            </section>

            <section class="inv-customer">
                <h2 class="inv-section-title">Thông tin người nhận</h2>
                <p>Họ và tên: <%=hd.getNguoiDat().getTen()%></p>
                <p>Địa chỉ: <%=hd.getNguoiDat().getDiaChi()%></p>
                <p>Số điện thoại: <%=hd.getNguoiDat().getSdt()%></p>
            </section>

            <section class="inv-staff">
                <div class="inv-info-group">
                    <p><strong>Nhân viên kho:</strong> <%=hd.getNguoiDuyetDon().getTen()%></p>
                </div>
                <div class="inv-info-group">
                    <p><strong>Nhân viên giao hàng:</strong> <%=hd.getNVGiaoHang().getTen()%></p>
                </div>
            </section>

            <section class="inv-items">
                <h2 class="inv-section-title">Danh sách mặt hàng</h2>
                <table class="inv-table">
                    <thead>
                    <tr>
                        <th>Tên</th>
                        <th>Số lượng</th>
                        <th>Đơn giá</th>
                        <th>Tổng</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        DecimalFormat formatter = new DecimalFormat("#,##0");
                        ArrayList<ChiTietHangTrucTuyen754> listMH = (ArrayList<ChiTietHangTrucTuyen754>) request.getAttribute("listCTH");
                        if (listMH != null && !listMH.isEmpty()) {
                            for (ChiTietHangTrucTuyen754 cth : listMH) {
                    %>
                    <tr>
                        <td><%=cth.getMatHang().getTen()%></td>
                        <td><%=cth.getSoLuong()%></td>
                        <%

                            String donGia = formatter.format(cth.getGia());
                            String tong = formatter.format(cth.getGia()*cth.getSoLuong());
                        %>
                        <td><%=donGia%> đ</td>
                        <td><%=tong%> đ</td>
                    </tr>
                    <%
                            }
                        }
                    %>
                    </tbody>
                    <tfoot>
                    <tr>
                        <%
                            String tongTien = formatter.format(hd.getTongTien());
                        %>
                        <td colspan="3"><strong>Tổng cộng</strong></td>
                        <td><strong><%=tongTien%> đ</strong></td>
                    </tr>
                    </tfoot>
                </table>
            </section>
        </main>
        <footer class="inv-footer">
            <button id="inv-printButton" class="inv-button">In hóa đơn</button>
        </footer>
    </div>
</div>
<script>
    document.getElementById('inv-printButton').addEventListener('click', function() {
        window.print();
    });
</script>
</body>
</html>