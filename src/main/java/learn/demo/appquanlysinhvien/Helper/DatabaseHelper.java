package learn.demo.appquanlysinhvien.Helper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Ngô Duy Minh
 */
public class DatabaseHelper {
            public static Connection openConnection() throws Exception{
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    String connectionUrl = "jdbc:sqlserver://localhost:1433;database=AppQuanLySinhVien;"
    + "encrypt = true; trustServerCertificate = true; sslProtocol = TLSv1.2";
    String username = "sa";
    String password = "123456";
    Connection con = DriverManager.getConnection(connectionUrl, username, password);
    
    return con;
    }
    
}
