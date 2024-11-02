package models;
import java.sql.Date;

public class KhachHang754 extends NguoiDung754 {
    private int maKH;

    // Constructor mặc định
    public KhachHang754() {}

    // Constructor KhachHang754
    public KhachHang754(int maKH) {
        this.maKH = maKH;
    }

    // Constructor với tất cả thuộc tính
    public KhachHang754(int maKH, int id, String ten, String username, String password, Date ngaysinh, String diachi, String email, String sdt, String vaitro) {
        super(id, ten, username, password, ngaysinh, diachi, email, sdt, "Khách hàng"); // Gọi constructor của lớp cha
        this.maKH = maKH;
    }

    // Getters và Setters
    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }
}

