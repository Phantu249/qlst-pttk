package dao;

import models.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HoaDonTrucTuyen754DAO extends DAO754 {
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
                kh.setId(rs.getInt("maKH"));
                if (new KhachHang754DAO().getKhachHangById(kh)) {
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
                            " ngayXuat = CURRENT_TIMESTAMP, maNVKho = ? WHERE id = ?";

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

    public boolean getHoaDonById(HoaDonTrucTuyen754 hd) {
        try {
            String query = "SELECT * FROM tblHoaDonTrucTuyen754 WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, hd.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hd.setNgayXuat(rs.getDate("ngayXuat"));
                NVKho754 nvk = new NVKho754();
                nvk.setId(rs.getInt("maNVKho"));
                if (new NVKho754DAO().getNhanVienById(nvk)) {
                    hd.setNguoiDuyetDon(nvk);
                }

                NVGiaoHang754 nvgh = new NVGiaoHang754();
                nvgh.setId(rs.getInt("maNVGiaoHang"));
                if (new NVGiaoHang754DAO().getNhanVienById(nvgh)) {
                    hd.setNVGiaoHang(nvgh);
                }

                hd.setNgayDat(rs.getDate("ngayDat"));
                hd.setTongTien(rs.getFloat("tongGia"));
                hd.setTrangThai(rs.getString("trangThai"));
                KhachHang754 kh = new KhachHang754();
                kh.setId(rs.getInt("maKH"));
                if (new KhachHang754DAO().getKhachHangById(kh)) {
                    hd.setNguoiDat(kh);
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
