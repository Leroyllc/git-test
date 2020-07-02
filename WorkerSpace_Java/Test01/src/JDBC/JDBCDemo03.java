package JDBC;

import java.sql.*;

public class JDBCDemo03 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "update stu set name = '阿猫' where id = 6";
            conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
            statement = conn.createStatement();
            int count = statement.executeUpdate(sql);
            if(count > 0) System.out.println("修改成功");
            else System.out.println("修改失败");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
