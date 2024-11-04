package servlet;

import dao.ChiTietHangTrucTuyen754DAO;
import dao.HoaDonTrucTuyen754DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.ChiTietHangTrucTuyen754;
import models.HoaDonTrucTuyen754;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/in-xuat-kho")
public class InXuatKho754 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idHD = Integer.parseInt(request.getParameter("idHD"));
        HoaDonTrucTuyen754DAO hdDAO = new HoaDonTrucTuyen754DAO();
        HoaDonTrucTuyen754 hd = new HoaDonTrucTuyen754();
        hd.setId(idHD);
        if (hdDAO.getHoaDonById(hd)) {
            request.setAttribute("hd", hd);
            ChiTietHangTrucTuyen754DAO cthDAO = new ChiTietHangTrucTuyen754DAO();
            ArrayList<ChiTietHangTrucTuyen754> listCTH = cthDAO.getChiTietHangByHoaDon(hd);
            if (listCTH != null && !listCTH.isEmpty()) {
                request.setAttribute("listCTH", listCTH);
            }
            request.getRequestDispatcher("GDInXuatKho754.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Không tìm thấy hóa đơn.");
            request.getRequestDispatcher("GDDuyetDon754.jsp").forward(request, response);
        }
    }
}
