package models;

import java.sql.Date;

public class ChiTietHangTrucTuyen754 {
    private int id;
    private int soLuong;
    private float gia;
    private MatHang754 matHang;
    private HoaDonTrucTuyen754 hoaDon;

    public ChiTietHangTrucTuyen754() {}

    public ChiTietHangTrucTuyen754(int id, int soLuong, float gia, MatHang754 matHang, HoaDonTrucTuyen754 hoaDon) {
        this.id = id;
        this.soLuong = soLuong;
        this.gia = gia;
        this.matHang = matHang;
        this.hoaDon = hoaDon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public MatHang754 getMatHang() {
        return matHang;
    }

    public void setMatHang(MatHang754 matHang) {
        this.matHang = matHang;
    }

    public HoaDonTrucTuyen754 getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDonTrucTuyen754 hoaDon) {
        this.hoaDon = hoaDon;
    }
}
