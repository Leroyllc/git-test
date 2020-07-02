package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo06 {
    public static void main(String[] args) {
        List<Student> list = new JDBCDemo06().findAll();
        System.out.println(list);
        System.out.println(list.size());
    }
    /**
     * 查询所有Student对象
     * @return
     */
    public List<Student> findAll(){
        List<Student> list = null;
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        Student s = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "select * from stu";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            list = new ArrayList<>();
            while(rs.next()){
                s = new Student(rs.getInt(1),rs.getString(2),
                        rs.getString("sex"),rs.getInt("class"));
                list.add(s);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return list;
        }
    }
}
