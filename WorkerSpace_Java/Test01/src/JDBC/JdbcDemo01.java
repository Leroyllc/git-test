package JDBC;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo01 {
    public static void main(String[] args) throws Exception {

        //1.导入驱动jar包 要注意add as libraries
        //2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
        //4.定义sql语句
        String sql = "insert into stu value(1,'张三','男',1)";
        //5.获取执行sql的对象 Statement
        Statement st = conn.createStatement();
        //6.执行sql语句
        boolean execute = st.execute(sql);
        //7.处理结果
        System.out.println(execute);
        //8.释放资源
        st.close();
        conn.close();
    }
}
