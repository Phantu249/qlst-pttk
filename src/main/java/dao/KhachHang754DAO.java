package dao;

import models.KhachHang754;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class KhachHang754DAO extends DAO {
    public KhachHang754DAO() {
        super();
    }

    public boolean getKhachHangById(KhachHang754 kh) {
        // Code here
        try {
            String query =  "SELECT  * FROM tblNguoiDung754 WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, kh.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                kh.setTen(rs.getString("ten"));
                kh.setDiaChi(rs.getString("diaChi"));
                kh.setSdt(rs.getString("sdt"));
                kh.setEmail(rs.getString("email"));
                kh.setNgaySinh(rs.getDate("ngaySinh"));
                kh.setVaiTro(rs.getString("vaiTro"));
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
    }
        return false;
    }
}
