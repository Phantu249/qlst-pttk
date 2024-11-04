package models;

import java.sql.Date;

public class NVKho754 extends NhanVien754 {
    public NVKho754() {}

    public NVKho754(int id, String ten, String username, String password, Date ngaySinh, String diaChi, String email, String sdt, String vaiTro) {
        super(id, ten, username, password, ngaySinh, diaChi, email, sdt, vaiTro);
    }
}
