package models;
import java.sql.Date;

public class NVGiaoHang754 extends NhanVien754 {
    private String trangThai;

    public NVGiaoHang754() {}

    public NVGiaoHang754(String trangThai) {
        this.trangThai = trangThai;
    }

    public NVGiaoHang754(int maNV) {
        super(maNV);
    }

    public NVGiaoHang754(int maNV, String trangThai) {
        super(maNV);
        this.trangThai = trangThai;
    }

    public NVGiaoHang754(int maNV, int id, String ten, String username, String password, Date ngaySinh, String diaChi, String email, String sdt, String vaiTro) {
        super(maNV, id, ten, username, password, ngaySinh, diaChi, email, sdt, vaiTro);
    }

    public NVGiaoHang754(int maNV, int id, String ten, String username, String password, Date ngaySinh, String diaChi, String email, String sdt, String vaiTro, String trangThai) {
        super(maNV, id, ten, username, password, ngaySinh, diaChi, email, sdt, vaiTro);
        this.trangThai = trangThai;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
