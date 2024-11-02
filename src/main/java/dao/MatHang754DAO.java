package dao;

import models.MatHang754;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MatHang754DAO extends DAO {
    public MatHang754DAO() {
        super();
    }

    public ArrayList<MatHang754> getAllMatHang() {
        // Code here
        ArrayList<MatHang754> list = new ArrayList<MatHang754>();
        try {
            String query = "SELECT * FROM tblMatHang754";
//            CallableStatement cs = con.prepareCall(query);
            ResultSet rs = con.createStatement().executeQuery(query);
            while (rs.next()) {
                MatHang754 mh = new MatHang754();
                mh.setId(rs.getInt("id"));
                mh.setTen(rs.getString("ten"));
                mh.setGia(rs.getFloat("gia"));
                mh.setSoLuong(rs.getInt("soLuong"));
                mh.setIdNhaCC(rs.getInt("idNhaCC"));
                list.add(mh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
