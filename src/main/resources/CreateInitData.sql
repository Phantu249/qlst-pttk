--Create table tblSieuThi754
INSERT INTO tblSieuThi754 (ten, diachi, mota)
VALUES ('Siêu thị điện máy 754', '123 Đường ABC, Quận 1, TP.HCM', 'Siêu thị chuyên cung cấp điện máy và thiết bị điện tử.');


-- Tạo tài khoản cho nhân viên quản lý
INSERT INTO tblNguoiDung754 (ten, username, password, ngaysinh, diachi, email, sdt, vaitro)
VALUES ('Nguyễn Văn A', 'nvA', 'password123', '1985-01-01', '456 Đường DEF, Quận 1, TP.HCM', 'nva@example.com', '0123456789', 'Nhân viên');

-- Tạo tài khoản cho nhân viên kho
INSERT INTO tblNguoiDung754 (ten, username, password, ngaysinh, diachi, email, sdt, vaitro)
VALUES ('Trần Thị B', 'nvB', 'password123', '1990-02-02', '789 Đường GHI, Quận 2, TP.HCM', 'nvb@example.com', '0987654321', 'Nhân viên');

-- Tạo tài khoản cho nhân viên bán hàng
INSERT INTO tblNguoiDung754 (ten, username, password, ngaysinh, diachi, email, sdt, vaitro)
VALUES ('Lê Văn C', 'nvC', 'password123', '1995-03-03', '321 Đường JKL, Quận 3, TP.HCM', 'nvc@example.com', '0112233445', 'Nhân viên');

-- Tạo tài khoản cho nhân viên giao hàng
INSERT INTO tblNguoiDung754 (ten, username, password, ngaysinh, diachi, email, sdt, vaitro)
VALUES ('Phạm Văn D', 'nvD', 'password123', '1992-04-04', '654 Đường MNO, Quận 4, TP.HCM', 'nvd@example.com', '0223344556', 'Nhân viên');

-- Tạo tài khoản cho khách hàng
INSERT INTO tblNguoiDung754 (ten, username, password, ngaysinh, diachi, email, sdt, vaitro)
VALUES ('Phan Văn Tú', 'tuphan', 'tuphan', '2003-09-24', 'Song Liễu, Thuận Thành, Bắc Ninh', 'pvtu@example.com', '0999999999', 'Khách hàng');

INSERT INTO tblNguoiDung754 (ten, username, password, ngaysinh, diachi, email, sdt, vaitro)
VALUES ('Nguyễn Thị Hương', 'huongnguyen', 'huongnguyen', '2000-01-01', 'Hà Nội', 'nth@example.com', '0888888888', 'Khách hàng');

-- Nhân viên quản lý
INSERT INTO tblNhanVien754 (vitri, idNguoiDung, idSieuThi)
VALUES ('Quản lý', 1, 1);

-- Nhân viên kho
INSERT INTO tblNhanVien754 (vitri, idNguoiDung, idSieuThi)
VALUES ('Kho', 2, 1);

-- Nhân viên bán hàng
INSERT INTO tblNhanVien754 (vitri, idNguoiDung, idSieuThi)
VALUES ('Bán hàng', 3, 1);

-- Nhân viên giao hàng
INSERT INTO tblNhanVien754 (vitri, idNguoiDung, idSieuThi)
VALUES ('Giao hàng', 4, 1);

-- Khách hàng
INSERT INTO tblKhachHang754 (idNguoiDung)
VALUES (5);


-- Tạp nhà cung cấp
INSERT INTO tblNhaCungCap754 (ten, diachi, sdt)
VALUES ('Công ty TNHH ABC', '789 Đường QRS, Quận 5, TP.HCM', '0333444555');

INSERT INTO tblNhaCungCap754 (ten, diachi, sdt)
VALUES ('Công ty TNHH XYZ', '321 Đường TUV, Quận 6, TP.HCM', '0445566778');


-- Tạo mặt hàng
INSERT INTO tblMatHang754 (ten, mota, gia, idNhaCC, idSieuThi)
VALUES ('Tivi LED 50 inch', 'Tivi LED chất lượng cao', 5000000.0, 1, 1);

INSERT INTO tblMatHang754 (ten, mota, gia, idNhaCC, idSieuThi)
VALUES ('Tủ lạnh Samsung 500L', 'Tủ lạnh tiết kiệm điện, dung tích lớn', 7000000.0, 1, 1);

INSERT INTO tblMatHang754 (ten, mota, gia, idNhaCC, idSieuThi)
VALUES ('Máy giặt LG 8kg', 'Máy giặt cửa trước', 8000000.0, 2, 1);

-- Tạo hóa đơn nhập
INSERT INTO tblHoaDonNhap754 (maNV)
VALUES (2);  -- Nhân viên kho có maNV = 2

-- Tạo chi tiết hóa đơn nhập
INSERT INTO tblChiTietHangNhap754 (soluong, gia, idHoaDon, idMatHang)
VALUES (10, 4000000.0, 1, 1);  -- 10 cái Tivi LED

INSERT INTO tblChiTietHangNhap754 (soluong, gia, idHoaDon, idMatHang)
VALUES (5, 5000000.0 ,1, 2);   -- 5 cái Tủ lạnh

INSERT INTO tblChiTietHangNhap754 (soluong, gia, idHoaDon, idMatHang)
VALUES (8, 6000000.0, 1, 3);   -- 8 cái Máy giặt


--DELETE FROM ten_bang WHERE id > 0; -- Xóa tất cả bản ghi
--DELETE FROM sqlite_sequence WHERE name='ten_bang'; -- Đặt lại ID tự động tăng về 1
