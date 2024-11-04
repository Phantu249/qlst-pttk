package models;
import java.sql.Date;

public class NhanVien754 extends NguoiDung754 {
    // Constructor mặc định
    public NhanVien754() {}

    // Constructor với tất cả thuộc tính
    public NhanVien754(int id, String ten, String username, String password, Date ngaySinh, String diaChi, String email, String sdt, String vaiTro) {
        super(id, ten, username, password, ngaySinh, diaChi, email, sdt, vaiTro); // Gọi constructor của lớp cha
    }

}
