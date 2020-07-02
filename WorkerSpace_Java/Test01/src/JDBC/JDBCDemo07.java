package JDBC;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo07 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        List<Student> list = null;
        Student s = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from stu";
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            list = new ArrayList<Student>();
            while(rs.next()){
                s = new Student(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getInt(4));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,statement,rs);
        }
        System.out.println(list);
    }
}
