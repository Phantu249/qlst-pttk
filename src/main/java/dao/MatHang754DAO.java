package dao;

import models.MatHang754;
import models.NhaCungCap754;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MatHang754DAO extends DAO {
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

                String queryImages = "SELECT duongDan FROM tblHinhAnh754 WHERE maMatHang = ? limit 1;";
                PreparedStatement psImages = con.prepareStatement(queryImages);
                psImages.setInt(1, mh.getId());
                ResultSet rsImages = psImages.executeQuery();
                if (rsImages.next()) {
                    mh.setImages(new String[]{rsImages.getString("duongDan")});
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

                String queryImages = "SELECT duongDan FROM tblHinhAnh754 WHERE maMatHang = ?";
                PreparedStatement psImages = con.prepareStatement(queryImages);
                psImages.setInt(1, mhId);
                ResultSet rsImages = psImages.executeQuery();
                ArrayList<String> images = new ArrayList<String>();
                while (rsImages.next()) {
                    images.add(rsImages.getString("duongDan"));
                }
                mh.setImages(images.toArray(new String[images.size()]));
                return mh;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
