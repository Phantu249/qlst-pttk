<%@ page import="models.NguoiDung754" %>
<%@ page import="models.NVGiaoHang754" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.HoaDonTrucTuyen754" %><%--
  Created by IntelliJ IDEA.
  User: loinh
  Date: 11/5/2024
  Time: 1:03 AM
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
<html>
<head>
    <title>Chọn NV & Trạng Thái</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/order-processing.css">
</head>
<%@ include file="header.jsp" %>
<%
    HoaDonTrucTuyen754 hd = (HoaDonTrucTuyen754) request.getAttribute("hd");
    if (hd == null) {
        response.sendRedirect("duyet-don");
        return;
    }
%>
<body>
<div class="dd-container">
<main>
    <section id="process-form" >
        <h2>Xử Lý Đơn Hàng <span id="order-id"><%=hd.getId()%></span></h2>
        <form id="order-process-form" action="chon-nv-trang-thai" method="post">
            <%--            Thêm input này để gửi mã đơn hàng--%>
            <input type="hidden" name="orderId" id="order-id-input" value="<%=hd.getId()%>">
            <div class="form-group">
                <label for="delivery-staff">Chọn Nhân Viên Giao Hàng:</label>
                <select id="delivery-staff" name="idNVGiaoHang" required>
                    <option value="">-- Chọn nhân viên --</option>
                    <%
                        ArrayList<NVGiaoHang754> listNV = null;
                        listNV = (ArrayList<NVGiaoHang754>) request.getAttribute("listNV");
                        if (listNV != null) {
                            for (NVGiaoHang754 nv : listNV) {
                    %>
                    <option value="<%=nv.getId()%>"><%=nv.getTen()%></option>
                    <%
                            }
                        }
                    %>
                </select>
            </div>
            <div class="form-group">
                <label for="status">Cập Nhật Trạng Thái:</label>
                <select id="status" name="trangThai" required>
                    <option value="">-- Chọn trạng thái --</option>
                    <option value="DA_DUYET">Đã duyệt</option>
                    <option value="CHUA_DUYET">Chưa duyệt</option>
                </select>
            </div>
            <div class="form-actions">
                <button type="submit" class="btn-submit">Cập Nhật</button>
            </div>
        </form>
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
