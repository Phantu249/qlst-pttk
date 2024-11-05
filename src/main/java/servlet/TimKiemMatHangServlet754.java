package servlet;

import dao.MatHang754DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.MatHang754;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/tim-kiem-mat-hang")
public class TimKiemMatHangServlet754 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenMatHang = request.getParameter("name");
        if (tenMatHang == null || tenMatHang.isEmpty()) {
            request.getRequestDispatcher("view/khachhang/GDTimKiemMatHang754.jsp").forward(request, response);
            return;
        }
        try {
            MatHang754DAO mhDAO = new MatHang754DAO();
            ArrayList<MatHang754> list = mhDAO.getAllMatHangByName(tenMatHang);
            if (list.isEmpty()) {
                request.setAttribute("errorMessage", "Không tìm thấy mặt hàng nào.");
                request.getRequestDispatcher("view/khachhang/GDTimKiemMatHang754.jsp").forward(request, response);
                return;
            }
            request.setAttribute("listMH", list);
            request.getRequestDispatcher("view/khachhang/GDTimKiemMatHang754.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
