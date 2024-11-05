package dao;

import models.NguoiDung754;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NguoiDung754DAO extends DAO754 {
    public NguoiDung754DAO() {
        super();
    }

    public boolean kiemTraDangNhap(NguoiDung754 user) {
        try {
            String query = "SELECT * FROM tblNguoiDung754 WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setTen(rs.getString("ten"));
                user.setNgaySinh(rs.getDate("ngaySinh"));
                user.setDiaChi(rs.getString("diaChi"));
                user.setEmail(rs.getString("email"));
                user.setSdt(rs.getString("sdt"));
                user.setVaiTro(rs.getString("vaiTro"));
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
