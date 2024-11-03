package dao;

import models.KhachHang754;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class KhachHang754DAO extends DAO {
    public KhachHang754DAO() {
        super();
    }

    public boolean getKhachHangByMaKH(KhachHang754 kh) {
        // Code here
        try {
            String query =  "SELECT nd.*\n" +
                            "FROM tblNguoiDung754 nd\n" +
                            "JOIN tblKhachHang754 kh ON nd.id = kh.idNguoiDung\n" +
                            "WHERE kh.maKH = ?;\n";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, kh.getMaKH());
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
