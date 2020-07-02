package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo02 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.定义sql
            String sql = "insert into stu value(6,'阿飞','女',2)";
            //3.获取执行对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root","root");
            //4.获取执行sql的对象
            statement = conn.createStatement();
            //5.执行sql
            int count = statement.executeUpdate(sql);
            //6.处理结果
            System.out.println(count);
            if(count > 0) System.out.println("添加成功");
            else System.out.println("添加失败");
        } catch (Exception e) {
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
