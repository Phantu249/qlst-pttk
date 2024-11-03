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
            String query =  "SELECT nd.*, gh.trangThai, gh.maNV\n" +
                            "FROM tblNguoiDung754 nd\n" +
                            "JOIN tblNhanVien754 nv ON nd.id = nv.idNguoiDung\n" +
                            "JOIN tblNVGiaoHang754 gh ON nv.maNV = gh.maNV\n" +
                            "WHERE gh.trangThai LIKE '%RANH%';\n";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NVGiaoHang754 nv = new NVGiaoHang754();
                nv.setId(rs.getInt("id"));
                nv.setTen(rs.getString("ten"));
                nv.setSdt(rs.getString("sdt"));
                nv.setTrangThai(rs.getString("trangThai"));
                nv.setMaNV(rs.getInt("maNV"));
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        return null;
    }
        return list;
    }
}
