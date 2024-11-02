package models;

public class MatHang754 {
    private int id;
    private String ten;
    private float gia;
    private int soLuong;
    private int idNhaCC;

    public MatHang754() {
    }

    public MatHang754(int id , String ten, int gia, int soLuong, int idNhaCC) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.soLuong = soLuong;
        this.idNhaCC = idNhaCC;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getIdNhaCC() {
        return idNhaCC;
    }

    public void setIdNhaCC(int idNhaCC) {
        this.idNhaCC = idNhaCC;
    }
}
