package dao;

import models.HoaDonTrucTuyen754;
import models.KhachHang754;
import models.NVKho754;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HoaDonTrucTuyen754DAO extends DAO {
    public HoaDonTrucTuyen754DAO() {
        super();
    }

    public ArrayList<HoaDonTrucTuyen754> getDonChuaXuat() {
        // Code here
        ArrayList<HoaDonTrucTuyen754> list = new ArrayList<HoaDonTrucTuyen754>();
        try {
            String query = "SELECT * FROM tblHoaDonTrucTuyen754 WHERE trangThai = 'CHUA_DUYET'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonTrucTuyen754 hd = new HoaDonTrucTuyen754();
                hd.setId(rs.getInt("id"));
                hd.setNgayDat(rs.getDate("ngayDat"));
                hd.setTongTien(rs.getFloat("tongGia"));
                hd.setTrangThai(rs.getString("trangThai"));
                KhachHang754 kh = new KhachHang754();
                kh.setMaKH(rs.getInt("maKH"));
                if (new KhachHang754DAO().getKhachHangByMaKH(kh)) {
                    hd.setNguoiDat(kh);
                }
                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean updateDonHang(int orderId, int idNVGiaoHang, String trangThai, NVKho754 nvk) {
        try {
            String query =  "UPDATE tblHoaDonTrucTuyen754 SET maNVGiaoHang = ?, trangThai = ?," +
                            " ngayXuat = CURRENT_TIMESTAMP, maNVKho = " +
                            "(SELECT tblNhanVien754.maNV " +
                            "FROM tblNhanVien754 " +
                            "INNER JOIN tblNguoiDung754 ON tblNhanVien754.idNguoiDung = tblNguoiDung754.id " +
                            "WHERE tblNguoiDung754.id = ?) " +
                            "WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idNVGiaoHang); // maNVGiaoHang
            ps.setString(2, trangThai); // trangThai
            ps.setInt(3, nvk.getId()); // idNguoiDung từ đối tượng NVKho754
            ps.setInt(4, orderId); // id của hóa đơn

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
