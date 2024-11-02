package models;

import java.sql.Date;

public class NguoiDung754 {
    private int id;
    private String ten;
    private String username;
    private String password;
    private Date ngaySinh;
    private String diaChi;
    private String email;
    private String sdt;
    private String vaiTro;

    // Constructor mặc định
    public NguoiDung754() {}

    // Constructor với tất cả thuộc tính
    public NguoiDung754(int id, String ten, String username, String password, Date ngaySinh, String diaChi, String email, String sdt, String vaiTro) {
        this.id = id;
        this.ten = ten;
        this.username = username;
        this.password = password;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.email = email;
        this.sdt = sdt;
        this.vaiTro = vaiTro;
    }

    // Getters và Setters

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getVaitro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }
}
