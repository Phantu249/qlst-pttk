package servlet;

import dao.MatHang754DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.MatHang754;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/mat-hang")
public class XemChiTietMHServlet754 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null || id.isEmpty()) {
            response.sendRedirect("GDTimKiemMatHang754.jsp");
            return;
        }
        try {
            MatHang754DAO mhDAO = new MatHang754DAO();
            MatHang754 mh = mhDAO.getChiTietMatHangById(Integer.parseInt(id));
            if (mh == null) {
                request.setAttribute("errorMessage", "Không tìm thấy mặt hàng nào.");
                request.getRequestDispatcher("GDTimKiemMatHang754.jsp").forward(request, response);
                return;
            }
            request.setAttribute("mh", mh);
            request.getRequestDispatcher("GDXemChiTietMH754.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
