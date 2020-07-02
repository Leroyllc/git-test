package JDBC;

import java.sql.*;

public class JDBCDemo05 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "select * from stu";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root", "root");
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            while(rs.next()){
                //获取数据
                int id = rs.getInt(1);
                String name = rs.getNString("name");
                String sex = rs.getString(3);
                int cls = rs.getInt("class");

                System.out.println("id:"+id+" name:"+name+" sex:"+sex+" class:"+cls);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

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
