package dao;

import models.HinhAnh754;
import models.MatHang754;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HinhAnh754DAO extends DAO754 {
    public HinhAnh754DAO() {
        super();
    }

    public ArrayList<HinhAnh754> getAllHinhAnhByMaMatHang(MatHang754 mh) {
        // Code here
        ArrayList<HinhAnh754> list = new ArrayList<HinhAnh754>();
        try {
            String query = "SELECT * FROM tblHinhAnh754 WHERE maMatHang = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, mh.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HinhAnh754 ha = new HinhAnh754();
                ha.setId(rs.getInt("id"));
                ha.setPath(rs.getString("path"));
                list.add(ha);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
