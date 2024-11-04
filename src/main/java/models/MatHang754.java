package models;

public class MatHang754 {
    private int id;
    private String ten;
    private float gia;
    private int soLuong;
    private String moTa;
    private HinhAnh754[] images;
    private NhaCungCap754 NhaCC;

    public MatHang754() {
    }

    public MatHang754(int id , String ten, int gia, int soLuong, String moTa, NhaCungCap754 NhaCC, HinhAnh754[] images) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.soLuong = soLuong;
        this.moTa = moTa;
        this.NhaCC = NhaCC;
        this.images = images;
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

    public NhaCungCap754 getNhaCC() {
        return NhaCC;
    }

    public void setNhaCC(NhaCungCap754 NhaCC) {
        this.NhaCC = NhaCC;
    }

    public HinhAnh754[] getImages() {
        return images;
    }

    public void setImages(HinhAnh754[] images) {
        this.images = images;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
