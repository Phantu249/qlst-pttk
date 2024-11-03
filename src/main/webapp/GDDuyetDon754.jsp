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
<div class="container">
    <header>
        <h1>Duyệt Đơn và Xuất Kho</h1>
    </header>
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
                    <td><%=(double)hd.getTongTien()%> ₫</td>
                    <td>Chưa xuất</td>
                    <td><button class="btn-process" onclick="showProcessForm(<%=hd.getId()%>)">Xử lý</button></td>
                </tr>
                <%}
                    }
                %>
                </tbody>
            </table>
        </section>
        <section id="process-form" class="hidden">
            <h2>Xử Lý Đơn Hàng <span id="order-id"></span></h2>
            <form id="order-process-form" action="duyet-don" method="post">
<%--            Thêm input này để gửi mã đơn hàng--%>
                <input type="hidden" name="orderId" id="order-id-input">
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
                        <option value="<%=nv.getMaNV()%>"><%=nv.getTen()%></option>
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
                    <button type="submit" class="btn-submit">Cập Nhật & In Hóa Đơn</button>
                    <button type="button" class="btn-cancel" onclick="hideProcessForm()">Hủy</button>
                </div>
            </form>
        </section>
    </main>
</div>
<script>
    function showProcessForm(orderId) {
        document.getElementById("order-id").textContent = orderId;
        document.getElementById("order-id-input").value = orderId;
        document.getElementById("process-form").classList.remove("hidden");
    }

    function hideProcessForm() {
        document.getElementById('process-form').classList.add('hidden');
    }

    // document.getElementById('order-process-form').addEventListener('submit', function(e) {
    //     e.preventDefault();
    //     alert('Đơn hàng đã được cập nhật và in hóa đơn.');
    //     hideProcessForm();
    // });
</script>
</body>
</html>
