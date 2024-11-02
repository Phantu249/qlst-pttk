package models;
import java.sql.Date;

public class NhanVien754 extends NguoiDung754 {
    private int maNV;
    private String viTri;

    // Constructor mặc định
    public NhanVien754() {}

    // Constructor NhanVien754
    public NhanVien754(int maNV, String vitri) {
        this.maNV = maNV;
        this.viTri = vitri;
    }

    // Constructor với tất cả thuộc tính
    public NhanVien754(int maNV, String viTri, int id, String ten, String username, String password, Date ngaySinh, String diaChi, String email, String sdt, String vaiTro) {
        super(id, ten, username, password, ngaySinh, diaChi, email, sdt, vaiTro); // Gọi constructor của lớp cha
        this.maNV = maNV;
        this.viTri = viTri;
    }

    // Getters và Setters

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

}
