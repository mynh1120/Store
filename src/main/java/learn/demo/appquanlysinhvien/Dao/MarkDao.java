package learn.demo.appquanlysinhvien.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import learn.demo.appquanlysinhvien.Helper.DatabaseHelper;
import learn.demo.appquanlysinhvien.model.Mark;

/**
 *
 * @author Ngô Duy Minh
 */
public class MarkDao {
        public boolean insert(Mark mk)  throws Exception    {
        String sql = "insert into mark (ID, Fullname, English, PE, Informatics) values (?,?,?,?,?)";
                try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                    pstmt.setString(1, mk.getID());
                    pstmt.setString(2, mk.getFullname());
                    pstmt.setFloat(3, mk.getEnglish());
                    pstmt.setFloat(4, mk.getPE());
                    pstmt.setFloat(5, mk.getInformatics());
                    
                    return pstmt.executeUpdate() > 0;
                }
    }
    public boolean update(Mark mk)  throws Exception    {
        String sql = "update mark" + "set English=?, PE=?, Informatics=?" + "where id=?" ;
                try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                    pstmt.setString(5, mk.getID());
                    pstmt.setFloat(1, mk.getEnglish());
                    pstmt.setFloat(2, mk.getPE());
                    pstmt.setFloat(3, mk.getInformatics());
                  //  pstmt.setString(4, mk.getFullname());
                    
                    return pstmt.executeUpdate() > 0;
    }
}
    public boolean deleteById(String Id)  throws Exception    {
        String sql = "delete from mark" + "where id=?" ;
                try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                    pstmt.setString(1, Id);
                    
                    return pstmt.executeUpdate() > 0;
    }
}
      public Mark findById(String Id)  throws Exception    {
        String sql = "select * from mark where id=?" ;
                try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                    pstmt.setString(1, Id);
                    
                    try(ResultSet rs = pstmt.executeQuery();)   {
                        if(rs.next())   {
                            Mark mk = new Mark();
                            mk.setID(rs.getString("ID"));
                            mk.setFullname(rs.getString("Fullname"));
                            mk.setEnglish(rs.getFloat("English"));
                            mk.setInformatics(rs.getFloat("Informatics"));
                            mk.setPE(rs.getFloat("PE"));
                            
                            return mk;
                        }
                    }                   
                    return null;
    }
}
      public List<Mark> findAll()  throws Exception    {
        String sql = "select * from mark" ;
                try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){                   
                    try(ResultSet rs = pstmt.executeQuery();)   {
                        List<Mark> list = new ArrayList<>();
                        while (rs.next())   {
                            Mark mk = new Mark();
                            mk.setID(rs.getString("ID"));
                            mk.setFullname(rs.getString("Fullname"));
                            mk.setEnglish(rs.getFloat("English"));
                            mk.setInformatics(rs.getFloat("Informatics"));
                            mk.setPE(rs.getFloat("PE"));
                            list.add(mk);
                        }
                        return list;
                    }
    }
}
          public List<Mark> findTop(int top)  throws Exception    {
        String sql = "select top "+ top +" *,(English + PE + Informatics)/3 as Average"+
                                "from Mark order by Average desc" ;
                try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){                   
                    try(ResultSet rs = pstmt.executeQuery();)   {
                        List<Mark> list = new ArrayList<>();
                        while (rs.next())   {
                            Mark mk = new Mark();
                            mk.setID(rs.getString("ID"));
                            mk.setFullname(rs.getString("Fullname"));
                            mk.setEnglish(rs.getFloat("English"));
                            mk.setInformatics(rs.getFloat("Informatics"));
                            mk.setPE(rs.getFloat("PE"));
                            list.add(mk);
                        }
                    return list;
                    }                   
            }
}    
    
}
