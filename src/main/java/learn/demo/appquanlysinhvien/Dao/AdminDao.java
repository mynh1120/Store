package learn.demo.appquanlysinhvien.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import learn.demo.appquanlysinhvien.Helper.DatabaseHelper;
import learn.demo.appquanlysinhvien.model.Admin;

/**
 *
 * @author Ngô Duy Minh
 */
public class AdminDao {
        public Admin checkLogin(String username, String password) throws Exception{
            String sql = "select username, password from admin" 
                    + " where username=? and password = ?"; 
            try (
                        Connection con = DatabaseHelper.openConnection();
                        PreparedStatement pstmt = con.prepareStatement(sql)
                    )   {
                pstmt.setString(1, username); // 1 là dấu hỏi 1
                pstmt.setString(2, password); // 2 ứng với dấu hỏi 2
                
                try(ResultSet rs = pstmt.executeQuery();){
                        if (rs.next())  {
                            Admin ad = new Admin();
                            ad.setUsername(username);
//                            ad.setRole(rs.getString("role"));
                            return ad;
                        }
                }           
       }
             return null; // nếu đăng nhập không thành công trả về null
}
}
    

