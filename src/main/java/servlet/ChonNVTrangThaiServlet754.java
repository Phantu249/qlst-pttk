package servlet;

import dao.HoaDonTrucTuyen754DAO;
import dao.NVGiaoHang754DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import models.HoaDonTrucTuyen754;
import models.NVGiaoHang754;
import models.NVKho754;
import models.NguoiDung754;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/chon-nv-trang-thai")
public class ChonNVTrangThaiServlet754 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idHDStr = request.getParameter("idHD");
        if (idHDStr == null) {
            request.setAttribute("errorMessage", "Không tìm thấy hóa đơn.");
            request.getRequestDispatcher("GDDuyetDon754.jsp").forward(request, response);
            return;
        }
        int idHD = Integer.parseInt(idHDStr);
        HoaDonTrucTuyen754 hd = new HoaDonTrucTuyen754();
        hd.setId(idHD);

        request.setAttribute("hd", hd);

        NVGiaoHang754DAO nvDAO = new NVGiaoHang754DAO();
        ArrayList<NVGiaoHang754> listNV = nvDAO.getNVGiaoHangRanh();
        if (listNV != null && !listNV.isEmpty()) {
            request.setAttribute("listNV", listNV);
        }

        request.getRequestDispatcher("GDChonNVTrangThai754.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        int idNVGiaoHang = Integer.parseInt(request.getParameter("idNVGiaoHang"));
        String trangThai = request.getParameter("trangThai");
        NVKho754 nvk = new NVKho754();
        NguoiDung754 user = (NguoiDung754) request.getSession().getAttribute("user");
        if (user == null) {
            request.setAttribute("errorMessage", "Vui lòng đăng nhập.");
            request.getRequestDispatcher("GDDangNhap754.jsp").forward(request, response);
            return;
        }
        nvk.setId(user.getId());

        HoaDonTrucTuyen754DAO hdDAO = new HoaDonTrucTuyen754DAO();
        if (hdDAO.updateDonHang(orderId, idNVGiaoHang, trangThai, nvk)) {
            if (trangThai.equals("DA_DUYET")) {
                response.sendRedirect("in-xuat-kho?idHD=" + orderId);
            } else {
                response.sendRedirect("duyet-don");
            }
        } else {
            request.setAttribute("errorMessage", "Duyệt đơn hàng thất bại.");
            request.getRequestDispatcher("GDDuyetDon754.jsp").forward(request, response);
        }
    }
}
