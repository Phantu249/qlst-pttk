package dao;

import models.NVGiaoHang754;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NVGiaoHang754DAO extends DAO {
    public NVGiaoHang754DAO() {
        super();
    }

    public ArrayList<NVGiaoHang754> getNVGiaoHangRanh() {
        // Code here
        ArrayList<NVGiaoHang754> list = new ArrayList<NVGiaoHang754>();
        try {
            String query =  "SELECT nd.*, nv.trangThai FROM tblNguoiDung754 nd JOIN tblNVGiaoHang754 nv ON nd.id = nv.maNV WHERE nv.trangThai = 'RANH'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NVGiaoHang754 nv = new NVGiaoHang754();
                nv.setId(rs.getInt("id"));
                nv.setTen(rs.getString("ten"));
                nv.setSdt(rs.getString("sdt"));
                nv.setTrangThai(rs.getString("trangThai"));
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        return null;
    }
        return list;
    }
}
