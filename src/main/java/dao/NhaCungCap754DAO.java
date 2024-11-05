package dao;

import models.NhaCungCap754;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NhaCungCap754DAO extends DAO754 {
    public NhaCungCap754DAO() {
        super();
    }

    public boolean getNhaCungCapById(NhaCungCap754 ncc) {
        // Code here
        try {
            String query = "SELECT ten, diaChi, sdt FROM tblNhaCungCap754 WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, ncc.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ncc.setTen(rs.getString("ten"));
                ncc.setDiaChi(rs.getString("diaChi"));
                ncc.setSdt(rs.getString("sdt"));

                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
