package dao;

import models.NVKho754;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NVKho754DAO extends DAO {
    public NVKho754DAO() {
        super();
    }

    public boolean getNhanVienById(NVKho754 nvk) {
        try {
            String query = "SELECT * FROM tblNguoiDung754 WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, nvk.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nvk.setTen(rs.getString("ten"));
                nvk.setDiaChi(rs.getString("diaChi"));
                nvk.setSdt(rs.getString("sdt"));
                nvk.setEmail(rs.getString("email"));
                nvk.setNgaySinh(rs.getDate("ngaySinh"));
                nvk.setVaiTro(rs.getString("vaiTro"));
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
