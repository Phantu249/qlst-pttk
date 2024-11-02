-- -- Bảng tblSieuThi754
-- CREATE TABLE IF NOT EXISTS tblSieuThi754 (
--                                              id INTEGER PRIMARY KEY AUTOINCREMENT,
--                                              ten VARCHAR(255) DEFAULT 'Siêu thị điện máy',
--                                              diaChi VARCHAR(255),
--                                              moTa VARCHAR(255)
-- );

-- Bảng tblNguoiDung754
CREATE TABLE IF NOT EXISTS tblNguoiDung754 (
                                               id INTEGER PRIMARY KEY AUTOINCREMENT,
                                               ten VARCHAR(255),
                                               username VARCHAR(255),
                                               password VARCHAR(255),
                                               ngaySinh DATE DEFAULT CURRENT_TIMESTAMP,
                                               diaChi VARCHAR(255),
                                               email VARCHAR(255),
                                               sdt VARCHAR(255),
                                               vaiTro VARCHAR(255)
);

-- Bảng tblKhachHang754
CREATE TABLE IF NOT EXISTS tblKhachHang754 (
                                               maKH INTEGER PRIMARY KEY AUTOINCREMENT,
                                               idNguoiDung INTEGER,
                                               FOREIGN KEY (idNguoiDung) REFERENCES tblNguoiDung754(id) ON DELETE CASCADE
);

-- Bảng tblNhanVien754
CREATE TABLE IF NOT EXISTS tblNhanVien754 (
                                              maNV INTEGER PRIMARY KEY AUTOINCREMENT,
                                              viTri VARCHAR(255),
                                              idNguoiDung INTEGER,
--                                               idSieuThi INTEGER,
--                                               FOREIGN KEY (idSieuThi) REFERENCES tblSieuThi754(id) ON DELETE CASCADE,
                                              FOREIGN KEY (idNguoiDung) REFERENCES tblNguoiDung754(id) ON DELETE CASCADE
);

-- Bảng tblNVGiaoHang754
CREATE TABLE IF NOT EXISTS tblNVGiaoHang754 (
                                                maNV INTEGER PRIMARY KEY,
                                                trangThai VARCHAR(255),
                                                FOREIGN KEY (maNV) REFERENCES tblNhanVien754(maNV) ON DELETE CASCADE
);

-- Bảng tblHoaDonNhap754
CREATE TABLE IF NOT EXISTS tblHoaDonNhap754 (
                                                id INTEGER PRIMARY KEY AUTOINCREMENT,
                                                ngayNhap DATE DEFAULT CURRENT_TIMESTAMP,
                                                tongGia FLOAT DEFAULT 0,
                                                maNV INTEGER,
                                                FOREIGN KEY (maNV) REFERENCES tblNhanVien754(maNV) ON DELETE SET NULL
);
-- Bảng tblHoaDonTrucTiep754
CREATE TABLE IF NOT EXISTS tblHoaDonTrucTiep754 (
                                                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                                                    ngayMua DATE DEFAULT CURRENT_TIMESTAMP,
                                                    tongGia FLOAT DEFAULT 0,
                                                    maNV INTEGER,
                                                    FOREIGN KEY (maNV) REFERENCES tblNhanVien754(maNV) ON DELETE SET NULL
);

-- Bảng tblHoaDonTrucTuyen754
CREATE TABLE IF NOT EXISTS tblHoaDonTrucTuyen754 (
                                                     id INTEGER PRIMARY KEY AUTOINCREMENT,
                                                     ngayXuat DATE DEFAULT CURRENT_TIMESTAMP,
                                                     tongGia FLOAT DEFAULT 0,
                                                     maKH INTEGER,
                                                     maNVKho INTEGER DEFAULT NULL,
                                                     maNVGiaoHang INTEGER DEFAULT NULL,
                                                     trangThai VARCHAR(255) DEFAULT 'chua duyet',
                                                     idGioHang INTEGER,
                                                     FOREIGN KEY (maKH) REFERENCES tblKhachHang754(maKH) ON DELETE SET NULL,
                                                     FOREIGN KEY (maNVKho) REFERENCES tblNhanVien754(maNV) ON DELETE SET NULL,
                                                     FOREIGN KEY (maNVGiaoHang) REFERENCES tblNhanVien754(maNV) ON DELETE SET NULL,
                                                     FOREIGN KEY (idGioHang) REFERENCES tblGioHang754(id) ON DELETE CASCADE
);

-- Bảng tblGioHang754
CREATE TABLE IF NOT EXISTS tblGioHang754 (
                                             id INTEGER PRIMARY KEY AUTOINCREMENT,
                                             maKH INTEGER,
                                             FOREIGN KEY (maKH) REFERENCES tblKhachHang754(maKH) ON DELETE CASCADE
);

-- Bảng tblMatHang754
CREATE TABLE IF NOT EXISTS tblMatHang754 (
                                             id INTEGER PRIMARY KEY AUTOINCREMENT,
                                             ten VARCHAR(255),
                                             moTa VARCHAR(255),
                                             gia FLOAT,
                                             soLuong INTEGER DEFAULT 0,
                                             idNhaCC INTEGER,
--                                              idSieuThi INTEGER,
--                                              FOREIGN KEY (idSieuThi) REFERENCES tblSieuThi754(id) ON DELETE CASCADE,
                                             FOREIGN KEY (idNhaCC) REFERENCES tblNhaCungCap754(id) ON DELETE SET NULL
);

-- Bảng tblHinhAnh754
CREATE TABLE tblHinhAnh754 (
                               id INTEGER PRIMARY KEY AUTOINCREMENT,
                               maMatHang INTEGER,
                               duongDan VARCHAR(255),
                               FOREIGN KEY (maMatHang) REFERENCES tblMatHang754(id) ON DELETE CASCADE
);

-- Bảng tblChiTietHangTrucTiep754
CREATE TABLE IF NOT EXISTS tblChiTietHangTrucTiep754 (
                                                         id INTEGER PRIMARY KEY AUTOINCREMENT,
                                                         soLuong INTEGER,
                                                         gia FLOAT,
                                                         idHoaDon INTEGER,
                                                         idMatHang INTEGER,
                                                         FOREIGN KEY (idHoaDon) REFERENCES tblHoaDonTrucTiep754(id) ON DELETE CASCADE,
                                                         FOREIGN KEY (idMatHang) REFERENCES tblMatHang754(id) ON DELETE RESTRICT
);

-- Bảng tblChiTietHangNhap754
CREATE TABLE IF NOT EXISTS tblChiTietHangNhap754 (
                                                     id INTEGER PRIMARY KEY AUTOINCREMENT,
                                                     soLuong INTEGER,
                                                     gia FLOAT,
                                                     idHoaDon INTEGER,
                                                     idMatHang INTEGER,
                                                     FOREIGN KEY (idHoaDon) REFERENCES tblHoaDonNhap754(id) ON DELETE CASCADE,
                                                     FOREIGN KEY (idMatHang) REFERENCES tblMatHang754(id) ON DELETE RESTRICT
);

-- Bảng tblChiTietHangTrucTuyen754
CREATE TABLE IF NOT EXISTS tblChiTietHangTrucTuyen754 (
                                                          id INTEGER PRIMARY KEY AUTOINCREMENT,
                                                          soLuong INTEGER,
                                                          gia FLOAT,
                                                          idMatHang INTEGER,
                                                          idGioHang INTEGER,
                                                          FOREIGN KEY (idMatHang) REFERENCES tblMatHang754(id) ON DELETE CASCADE,
                                                          FOREIGN KEY (idGioHang) REFERENCES tblGioHang754(id) ON DELETE CASCADE
);
-- Bảng tblNhaCungCap754
CREATE TABLE IF NOT EXISTS tblNhaCungCap754 (
                                                id INTEGER PRIMARY KEY AUTOINCREMENT,
                                                ten VARCHAR(255),
                                                diaChi VARCHAR(255),
                                                sdt VARCHAR(255)
);
