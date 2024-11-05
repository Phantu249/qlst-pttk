package dao;

import models.ChiTietHangTrucTuyen754;
import models.HoaDonTrucTuyen754;
import models.MatHang754;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ChiTietHangTrucTuyen754DAO extends DAO754 {
    public ChiTietHangTrucTuyen754DAO() {
        super();
    }

    public ArrayList<ChiTietHangTrucTuyen754> getChiTietHangByHoaDon(HoaDonTrucTuyen754 hd) {
        ArrayList<ChiTietHangTrucTuyen754> list = new ArrayList<ChiTietHangTrucTuyen754>();
        try {
            String query = "SELECT * FROM tblChiTietHangTrucTuyen754 WHERE idHoaDon = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, hd.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietHangTrucTuyen754 cth = new ChiTietHangTrucTuyen754();
                cth.setId(rs.getInt("id"));
                cth.setSoLuong(rs.getInt("soLuong"));
                cth.setGia(rs.getFloat("gia"));
                cth.setHoaDon(hd);

                MatHang754DAO mhDAO = new MatHang754DAO();
                MatHang754 mh = mhDAO.getChiTietMatHangById(rs.getInt("idMatHang"));
                cth.setMatHang(mh);

                list.add(cth);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }
}
