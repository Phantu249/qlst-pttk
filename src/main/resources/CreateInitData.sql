-- --Create table tblSieuThi754
-- INSERT INTO tblSieuThi754 (ten, diaChi, moTa)
-- VALUES ('Siêu thị điện máy 754', '123 Đường ABC, Quận 1, TP.HCM', 'Siêu thị chuyên cung cấp điện máy và thiết bị điện tử.');

BEGIN TRANSACTION;
-- Tạo tài khoản cho nhân viên quản lý
INSERT INTO tblNguoiDung754 (ten, username, password, ngaySinh, diaChi, email, sdt, vaiTro)
VALUES ('Nguyễn Văn A', 'quanly', '1', '1985-01-01 00:00:00', '456 Đường DEF, Quận 1, TP.HCM', 'nva@example.com', '0123456789', 'QUAN_lY');

-- Tạo tài khoản cho nhân viên kho
INSERT INTO tblNguoiDung754 (ten, username, password, ngaySinh, diaChi, email, sdt, vaiTro)
VALUES ('Trần Thị B', 'kho', '1', '1990-02-02 00:00:00', '789 Đường GHI, Quận 2, TP.HCM', 'nvb@example.com', '0987654321', 'KHO');

-- Tạo tài khoản cho nhân viên bán hàng
INSERT INTO tblNguoiDung754 (ten, username, password, ngaySinh, diaChi, email, sdt, vaiTro)
VALUES ('Lê Văn C', 'banhang', '1', '1995-03-03 00:00:00', '321 Đường JKL, Quận 3, TP.HCM', 'nvc@example.com', '0112233445', 'BAN_HANG');

-- Tạo tài khoản cho nhân viên giao hàng
INSERT INTO tblNguoiDung754 (ten, username, password, ngaySinh, diaChi, email, sdt, vaiTro)
VALUES ('Phạm Văn D', 'giaohang', '1', '1992-04-04 00:00:00', '654 Đường MNO, Quận 4, TP.HCM', 'nvd@example.com', '0223344556', 'GIAO_HANG');

-- Tạo tài khoản cho nhân viên giao hàng
INSERT INTO tblNguoiDung754 (ten, username, password, ngaySinh, diaChi, email, sdt, vaiTro)
VALUES ('Nguyễn Văn E', 'giaohang2', '1', '1993-05-05 00:00:00', '987 Đường PQR, Quận 5, TP.HCM', '@example.com', '0334455667', 'GIAO_HANG');

-- Tạo tài khoản cho khách hàng
INSERT INTO tblNguoiDung754 (ten, username, password, ngaySinh, diaChi, email, sdt, vaiTro)
VALUES ('Phan Văn Tú', 'tuphan', 'tuphan', '2003-09-24 00:00:00', 'Song Liễu, Thuận Thành, Bắc Ninh', 'pvtu@example.com', '0999999999', 'KHACH_HANG');

INSERT INTO tblNguoiDung754 (ten, username, password, ngaySinh, diaChi, email, sdt, vaiTro)
VALUES ('Nguyễn Thị Hương', 'huongnguyen', 'huongnguyen', '2000-01-01 00:00:00', 'Hà Nội', 'nth@example.com', '0888888888', 'KHACH_HANG');

COMMIT;


-- Transaction để tạo nhà cung cấp
BEGIN TRANSACTION;
INSERT INTO tblNhaCungCap754 (ten, diaChi, sdt)
VALUES ('Công ty TNHH ABC', '789 Đường QRS, Quận 5, TP.HCM', '0333444555');

INSERT INTO tblNhaCungCap754 (ten, diaChi, sdt)
VALUES ('Công ty TNHH XYZ', '321 Đường TUV, Quận 6, TP.HCM', '0445566778');
COMMIT;

-- Transaction để tạo mặt hàng
BEGIN TRANSACTION;
INSERT INTO tblMatHang754 (ten, moTa, gia, idNhaCC)
VALUES ('Tivi LED 50 inch', 'Tivi LED chất lượng cao', 5000000.0, (SELECT id FROM tblNhaCungCap754 WHERE ten = 'Công ty TNHH ABC'));

INSERT INTO tblMatHang754 (ten, moTa, gia, idNhaCC)
VALUES ('Tủ lạnh Samsung 500L', 'Tủ lạnh tiết kiệm điện, dung tích lớn', 7000000.0, (SELECT id FROM tblNhaCungCap754 WHERE ten = 'Công ty TNHH ABC'));

INSERT INTO tblMatHang754 (ten, moTa, gia, idNhaCC)
VALUES ('Máy giặt LG 8kg', 'Máy giặt cửa trước', 8000000.0, (SELECT id FROM tblNhaCungCap754 WHERE ten = 'Công ty TNHH XYZ'));
COMMIT;

BEGIN TRANSACTION ;
INSERT INTO tblHinhAnh754 (maMatHang, path)
VALUES (1, 'https://cdn11.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture//Apro/Apro_product_33194/google-tivi-xia_main_747_1020.png.webp');

INSERT INTO tblHinhAnh754 (maMatHang, path)
VALUES (1, 'https://cdn11.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture//Apro/Apro_product_33194/google-tivi-xia_multi_0_496_1020.png.webp');

INSERT INTO tblHinhAnh754 (maMatHang, path)
VALUES (1, 'https://cdn11.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture//Apro/Apro_product_33194/google-tivi-xia_multi_1_536_1020.png.webp');

INSERT INTO tblHinhAnh754 (maMatHang, path)
VALUES (2, 'https://cdn.tgdd.vn/Products/Images/1943/236996/samsung-rf48a4010m9-sv-1-1-700x467.jpg');

INSERT INTO tblHinhAnh754 (maMatHang, path)
VALUES (2, 'https://cdn.tgdd.vn/Products/Images/1943/236996/samsung-rf48a4010m9-sv-2-1-700x467.jpg');

INSERT INTO tblHinhAnh754 (maMatHang, path)
VALUES (2, 'https://cdn.tgdd.vn/Products/Images/1943/236996/samsung-rf48a4010m9-sv-5-1-700x467.jpg');

INSERT INTO tblHinhAnh754 (maMatHang, path)
VALUES (3, 'https://cdn.tgdd.vn/Products/Images/1944/316766/toshiba-inverter-10-kg-tw-t21bu110uwv-mg-1-1-700x467.jpg');

INSERT INTO tblHinhAnh754 (maMatHang, path)
VALUES (3, 'https://cdn.tgdd.vn/Products/Images/1944/316766/toshiba-inverter-10-kg-tw-t21bu110uwv-mg-2-1-700x467.jpg');

INSERT INTO tblHinhAnh754 (maMatHang, path)
VALUES (3, 'https://cdn.tgdd.vn/Products/Images/1944/316766/toshiba-inverter-10-kg-tw-t21bu110uwv-mg-3-1-700x467.jpg');

COMMIT ;

-- Transaction để tạo hóa đơn nhập và chi tiết hóa đơn nhập
-- Tạo hóa đơn nhập
INSERT INTO tblHoaDonNhap754 (maNV)
VALUES ((SELECT tblNguoiDung754.id FROM tblNguoiDung754 WHERE tblNguoiDung754.vaiTro = 'KHO'));


BEGIN TRANSACTION ;
-- Tạo chi tiết hóa đơn nhập
INSERT INTO tblChiTietHangNhap754 (soluong, gia, idHoaDon, idMatHang)
VALUES (10, 4000000.0, 1, (SELECT id FROM tblMatHang754 WHERE ten = 'Tivi LED 50 inch'));

INSERT INTO tblChiTietHangNhap754 (soluong, gia, idHoaDon, idMatHang)
VALUES (5, 5000000.0, 1, (SELECT id FROM tblMatHang754 WHERE ten = 'Tủ lạnh Samsung 500L'));

INSERT INTO tblChiTietHangNhap754 (soluong, gia, idHoaDon, idMatHang)
VALUES (8, 6000000.0, 1, (SELECT id FROM tblMatHang754 WHERE ten = 'Máy giặt LG 8kg'));

COMMIT ;

-- DELETE FROM tblChiTietHangTrucTuyen754 WHERE id > 0; -- Xóa tất cả bản ghi
-- DELETE FROM sqlite_sequence WHERE name='tblChiTietHangTrucTuyen754'; -- Đặt lại ID tự động tăng về 1


-- Tao hoa don truc tuyen
BEGIN TRANSACTION ;
INSERT INTO tblHoaDonTrucTuyen754 (maKH)
VALUES ((SELECT tblNguoiDung754.id FROM tblNguoiDung754 WHERE tblNguoiDung754.vaiTro ='KHACH_HANG'));

INSERT INTO tblChiTietHangTrucTuyen754 (soluong, gia, idHoaDon, idMatHang)
VALUES (2, 5000000.0, last_insert_rowid(), (SELECT id FROM tblMatHang754 WHERE ten = 'Tivi LED 50 inch'));

COMMIT ;

-- Tao hoa don truc tuyen
BEGIN TRANSACTION ;
INSERT INTO tblHoaDonTrucTuyen754 (maKH)
VALUES ((SELECT tblNguoiDung754.id FROM tblNguoiDung754 WHERE tblNguoiDung754.vaiTro ='KHACH_HANG' AND tblNguoiDung754.username = 'huongnguyen'));

INSERT INTO tblChiTietHangTrucTuyen754 (soluong, gia, idHoaDon, idMatHang)
VALUES (1, 6000000.0, last_insert_rowid(), (SELECT id FROM tblMatHang754 WHERE ten = 'Tủ lạnh Samsung 500L'));

COMMIT ;

