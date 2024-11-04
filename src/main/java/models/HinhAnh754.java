package models;

public class HinhAnh754 {
    private int id;
    private String path;
    private int maMatHang;

    public HinhAnh754() {
    }

    public HinhAnh754(int id, String path, int maMatHang) {
        this.id = id;
        this.path = path;
        this.maMatHang = maMatHang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getMaMatHang() {
        return maMatHang;
    }

    public void setMaMatHang(int maMatHang) {
        this.maMatHang = maMatHang;
    }
}
