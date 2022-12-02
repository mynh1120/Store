package learn.demo.appquanlysinhvien.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import learn.demo.appquanlysinhvien.Helper.DatabaseHelper;
import learn.demo.appquanlysinhvien.model.Student;

/**
 *
 * @author Ngô Duy Minh
 */
public class StudentDao {
    public boolean insert (Student stud) throws Exception {
        String sql = "insert into student(id, fullname, email, phonenumber, sex, address) values(?,?,?,?,?,?)";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, stud.getId());
            pstmt.setString(2, stud.getFullname());
            pstmt.setString(3, stud.getEmail());
            pstmt.setString(4, stud.getPhoneNumber());
            pstmt.setInt(5, stud.getSex());
            pstmt.setString(6, stud.getAddress());
//            if (stud.getImage() != null)    {
//                Blob image = new SerialBlod(stud.getImage());
//                pstmt.setBlod(7, image);
//            }   else {
//                Blod image = null;
//                pstmt.setBlod(7, image);
//            }           
            return pstmt.executeUpdate() > 0;
        }
    }
public boolean update (Student stud) throws Exception {
    String sql = "update student set fullname=?, email=?, phonenumber=?, sex=?, address=? " + " where id = ?";
    try (
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1, stud.getFullname());
            pstmt.setString(2, stud.getEmail());
            pstmt.setString(3, stud.getPhoneNumber());
            pstmt.setInt(4, stud.getSex());
            pstmt.setString(5, stud.getAddress());
            pstmt.setString(6, stud.getId());
            
            return pstmt.executeUpdate() > 0;
    }    
}
     public boolean delete (String Id) throws Exception {
        String sql = "delete from student where id = ?";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, Id);
            
            return pstmt.executeUpdate() > 0;
        }
}
     public Student findById (String Id) throws Exception {
        String sql = "select * from student where id = ?";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, Id);
            try (ResultSet rs = pstmt.executeQuery();)  {
                    
            if (rs.next())  {
                Student stud = new Student();
                stud.setId(rs.getString("id"));
                stud.setFullname(rs.getString("fullname"));
                stud.setEmail(rs.getString("email"));
                stud.setPhoneNumber(rs.getString("phonenumber"));
                stud.setSex(rs.getInt("sex"));
                stud.setAddress(rs.getString("address"));
                return stud;
            }
            }
            return null;
        }
     }
        public List <Student> findAll () throws Exception {
            String sql = "select * from student";
            try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            try(ResultSet rs = pstmt.executeQuery();)   {
                List<Student> list = new ArrayList<>();
                while (rs.next())   {                    
                    Student stud = new Student();
                    stud.setId(rs.getString("id"));
                    stud.setFullname(rs.getString("fullname"));
                    stud.setEmail(rs.getString("email"));
                    stud.setPhoneNumber(rs.getString("phonenumber"));
                    stud.setSex(rs.getInt("sex"));
                    stud.setAddress(rs.getString("address"));
                    list.add(stud);
            }
                return list;
            }           
        }
    }
    
}
