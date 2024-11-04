package models;
import java.sql.Date;

public class KhachHang754 extends NguoiDung754 {
    // Constructor mặc định
    public KhachHang754() {}

    // Constructor với tất cả thuộc tính
    public KhachHang754(int id, String ten, String username, String password, Date ngaysinh, String diachi, String email, String sdt, String vaitro) {
        super(id, ten, username, password, ngaysinh, diachi, email, sdt, "Khách hàng"); // Gọi constructor của lớp cha
    }
}

