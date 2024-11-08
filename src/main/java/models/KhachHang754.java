package models;
import java.sql.Date;

public class KhachHang754 extends NguoiDung754 {
    private GioHang754 gioHang;
    // Constructor mặc định
    public KhachHang754() {
        this.gioHang = new GioHang754();
    }


    // Constructor với tất cả thuộc tính
    public KhachHang754(int idGH, int id, String ten, String username, String password, Date ngaysinh, String diachi, String email, String sdt, String vaitro) {
        super(id, ten, username, password, ngaysinh, diachi, email, sdt, "Khách hàng"); // Gọi constructor của lớp cha
        this.gioHang = new GioHang754(idGH);
    }

    // Getter và Setter
    public GioHang754 getGioHang() {
        return gioHang;
    }

    public void setGioHang(GioHang754 gioHang) {
        this.gioHang = gioHang;
    }
}

