package dao;
import java.sql.Connection;
import java.sql.DriverManager;

public class DAO754 {
    public static Connection con;

    public DAO754(){
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
