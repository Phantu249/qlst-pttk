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

@WebServlet("/duyet-don")
public class DuyetDonServlet754 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HoaDonTrucTuyen754DAO hdDAO = new HoaDonTrucTuyen754DAO();
        ArrayList<HoaDonTrucTuyen754> list = hdDAO.getDonChuaXuat();
        if (list != null && !list.isEmpty()) {
            request.setAttribute("listHD", list);
        } else {
            request.setAttribute("errorMessage", "Không có đơn hàng nào cần duyệt.");
        }

        request.getRequestDispatcher("GDDuyetDon754.jsp").forward(request, response);
    }
}
