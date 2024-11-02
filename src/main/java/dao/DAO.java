package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;

public class DAO {
    public static Connection con;

    public DAO(){
        if(con == null){
            // Thay đổi dbUrl để trỏ đến file SQLite
            String dbUrl = "jdbc:sqlite:" + Objects.requireNonNull(getClass().getClassLoader().getResource("QLST.db")).getPath(); // Đường dẫn đến file SQLite
            String dbClass = "org.sqlite.JDBC"; // Đảm bảo sử dụng driver cho SQLite

            try {
                Class.forName(dbClass);
                con = DriverManager.getConnection(dbUrl);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
