--Trigger tự động cập nhật số lượng mặt hàng trong kho khi có hóa đơn nhập
CREATE TRIGGER IF NOT EXISTS trg_UpdateStockOnNhap
    AFTER INSERT ON tblChiTietHangNhap754
    FOR EACH ROW
BEGIN
    UPDATE tblMatHang754
    SET soLuong = soLuong + NEW.soLuong
    WHERE id = NEW.idMatHang;
END;

-- Trigger tự động giảm số lượng mặt hàng khi có hóa đơn bán trực tiếp
CREATE TRIGGER IF NOT EXISTS trg_UpdateStockOnBanTrucTiep
    AFTER INSERT ON tblChiTietHangTrucTiep754
    FOR EACH ROW
BEGIN
    UPDATE tblMatHang754
    SET soLuong = soLuong - NEW.soLuong
    WHERE id = NEW.idMatHang;
END;

-- Trigger tự động giảm số lượng mặt hàng khi có hóa đơn bán trực tuyến
CREATE TRIGGER IF NOT EXISTS trg_UpdateStockOnBanTrucTuyen
    AFTER INSERT ON tblChiTietHangTrucTiep754
    FOR EACH ROW
BEGIN
    UPDATE tblMatHang754
    SET soLuong = soLuong - NEW.soLuong
    WHERE id = NEW.idMatHang;
END;

--Trigger tự động xóa chi tiết hóa đơn khi hóa đơn bị xóa
CREATE TRIGGER IF NOT EXISTS trg_DeleteCTHDOnDeleteHD
    AFTER DELETE ON tblHoaDonTrucTiep754
    FOR EACH ROW
BEGIN
    DELETE FROM tblChiTietHangTrucTiep754
    WHERE idHoaDon = OLD.id;
END;

-- Trigger tự động xóa chi tiết hóa đơn nhập khi hóa đơn nhập bị xóa
CREATE TRIGGER IF NOT EXISTS trg_DeleteCTHNOnDeleteHN
    AFTER DELETE ON tblHoaDonNhap754
    FOR EACH ROW
BEGIN
    DELETE FROM tblChiTietHangNhap754
    WHERE idHoaDon = OLD.id;
END;


-- Trigger tự động cập nhật tổng giá của hóa đơn nhập khi có chi tiết hóa đơn nhập mới
CREATE TRIGGER IF NOT EXISTS update_tonggia_insert
    AFTER INSERT ON tblChiTietHangNhap754
    FOR EACH ROW
BEGIN
    UPDATE tblHoaDonNhap754
    SET tongGia = (SELECT SUM(soLuong * gia)
                   FROM tblChiTietHangNhap754
                   WHERE idHoaDon = NEW.idHoaDon)
    WHERE id = NEW.idHoaDon;
END;

-- Trigger tự động cập nhật tổng giá của hóa đơn nhập khi xóa chi tiết hóa đơn nhập
CREATE TRIGGER IF NOT EXISTS update_tonggia_delete
    AFTER DELETE ON tblChiTietHangNhap754
    FOR EACH ROW
BEGIN
    UPDATE tblHoaDonNhap754
    SET tongGia = (SELECT SUM(soLuong * gia)
                   FROM tblChiTietHangNhap754
                   WHERE idHoaDon = OLD.idHoaDon)
    WHERE id = OLD.idHoaDon;
END;

-- Trigger tự động tạo khách hàng
CREATE TRIGGER IF NOT EXISTS trg_CreateKhachHang
    AFTER INSERT ON tblNguoiDung754
    FOR EACH ROW
    WHEN NEW.vaiTro = 'KHACH_HANG'
BEGIN
    INSERT INTO tblKhachHang754 (idNguoiDung)
    VALUES (NEW.id);
END;

