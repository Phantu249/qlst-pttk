package models;

public class NhaCungCap754 {
    private int id;
    private String ten;
    private String diaChi;
    private String sdt;

    // Constructor mặc định
    public NhaCungCap754() {}

    // Constructor với tất cả thuộc tính
    public NhaCungCap754(int id, String ten, String diaChi, String sdt) {
        this.id = id;
        this.ten = ten;
        this.diaChi = diaChi;
        this.sdt = sdt;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
