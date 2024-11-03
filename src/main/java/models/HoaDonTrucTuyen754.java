package models;

import java.sql.Date;

public class HoaDonTrucTuyen754 {
    private int id;
    private Date ngayDat;
    private KhachHang754 nguoiDat;
    private Date ngayXuat;
    private NVKho754 nguoiDuyetDon;
    private String trangThai;
    private float tongTien;
    private NVGiaoHang754 NVGiaoHang;

    public HoaDonTrucTuyen754() {}

    public HoaDonTrucTuyen754(int id, Date ngayDat, KhachHang754 nguoiDat, Date ngayXuat, NVKho754 nguoiDuyetDon, String trangThai, float tongTien, NVGiaoHang754 NVGiaoHang) {
        this.id = id;
        this.ngayDat = ngayDat;
        this.nguoiDat = nguoiDat;
        this.ngayXuat = ngayXuat;
        this.nguoiDuyetDon = nguoiDuyetDon;
        this.trangThai = trangThai;
        this.tongTien = tongTien;
        this.NVGiaoHang = NVGiaoHang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public KhachHang754 getNguoiDat() {
        return nguoiDat;
    }

    public void setNguoiDat(KhachHang754 nguoiDat) {
        this.nguoiDat = nguoiDat;
    }

    public Date getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public NVKho754 getNguoiDuyetDon() {
        return nguoiDuyetDon;
    }

    public void setNguoiDuyetDon(NVKho754 nguoiDuyetDon) {
        this.nguoiDuyetDon = nguoiDuyetDon;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public NVGiaoHang754 getNVGiaoHang() {
        return NVGiaoHang;
    }

    public void setNVGiaoHang(NVGiaoHang754 NVGiaoHang) {
        this.NVGiaoHang = NVGiaoHang;
    }
}
