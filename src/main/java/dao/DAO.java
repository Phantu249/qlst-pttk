package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;

public class DAO {
    public static Connection con;

    public DAO(){
        if(con == null){
            String dbUrl = "jdbc:sqlite:D:/Code/Project/QLST.db"; // Đường dẫn đến file SQLite
            String dbClass = "org.sqlite.JDBC";

            try {
                Class.forName(dbClass);
                con = DriverManager.getConnection(dbUrl);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
