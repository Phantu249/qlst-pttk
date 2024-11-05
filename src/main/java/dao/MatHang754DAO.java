package dao;

import models.HinhAnh754;
import models.MatHang754;
import models.NhaCungCap754;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MatHang754DAO extends DAO754 {
    public MatHang754DAO() {
        super();
    }

    public ArrayList<MatHang754> getAllMatHangByName(String name) {
        // Code here
        ArrayList<MatHang754> list = new ArrayList<MatHang754>();
        try {
            String query = "SELECT id, ten, gia, soLuong FROM tblMatHang754 WHERE ten LIKE ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MatHang754 mh = new MatHang754();
                mh.setId(rs.getInt("id"));
                mh.setTen(rs.getString("ten"));
                mh.setGia(rs.getFloat("gia"));
                mh.setSoLuong(rs.getInt("soLuong"));

                HinhAnh754DAO haDAO = new HinhAnh754DAO();
                ArrayList<HinhAnh754> images = haDAO.getAllHinhAnhByMaMatHang(mh);
                if (images != null) {
                    mh.setImages(images.toArray(new HinhAnh754[images.size()]));
                }
                list.add(mh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public MatHang754 getChiTietMatHangById(int id) {
        // Code here
        try {
            String query = "SELECT * FROM tblMatHang754 WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                MatHang754 mh = new MatHang754();
                int mhId = rs.getInt("id");
                mh.setId(mhId);
                mh.setTen(rs.getString("ten"));
                mh.setGia(rs.getFloat("gia"));
                mh.setSoLuong(rs.getInt("soLuong"));
                mh.setMoTa(rs.getString("moTa"));

                int idNhaCC = rs.getInt("idNhaCC");
                NhaCungCap754DAO nccDAO = new NhaCungCap754DAO();
                NhaCungCap754 ncc = new NhaCungCap754();
                ncc.setId(idNhaCC);
                if (nccDAO.getNhaCungCapById(ncc)) {
                    mh.setNhaCC(ncc);
                }

                HinhAnh754DAO haDAO = new HinhAnh754DAO();
                ArrayList<HinhAnh754> images = haDAO.getAllHinhAnhByMaMatHang(mh);
                if (images != null) {
                    mh.setImages(images.toArray(new HinhAnh754[images.size()]));
                }

                return mh;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
