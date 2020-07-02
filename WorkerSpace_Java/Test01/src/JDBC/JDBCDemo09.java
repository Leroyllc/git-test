package JDBC;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCDemo09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账号：");
        String username, pwd;
        username = sc.next();
        System.out.println("请输入密码：");
        pwd = sc.next();
        if (new JDBCDemo09().login(username, pwd)) {
            System.out.println("登录成功");
        } else System.out.println("登录失败");
    }


    /**
     * 登录方法
     */
    public boolean login(String username, String pwd) {
        if (username == null || pwd == null) {
            return false;
        }
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //获取连接
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "select * from user where username = ? and password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, pwd);
            rs = pstmt.executeQuery();
           /* while (rs.next()){
                if(username == rs.getString(1)||
                        pwd == rs.getString(2))
                    return true;
            }*/

            conn.commit();
            return rs.next();
        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }

        return false;
    }

}
