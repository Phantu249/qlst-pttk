package servlet;

import dao.NguoiDung754DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.NguoiDung754;

import java.io.IOException;

@WebServlet("/login")
public class DangNhapServlet754 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("view/nguoidung/GDChinh754.jsp");
            return;
        }
        request.getRequestDispatcher("view/nguoidung/GDDangNhap754.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        NguoiDung754 user = new NguoiDung754();
        user.setUsername(username);
        user.setPassword(password);
        try {
            NguoiDung754DAO dao = new NguoiDung754DAO();
            if (dao.kiemTraDangNhap(user)) {
                // Nếu đăng nhập thành công
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("view/nguoidung/GDChinh754.jsp");
            } else {
                // Nếu đăng nhập thất bại
                request.setAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng.");
                request.getRequestDispatcher("view/nguoidung/GDDangNhap754.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
