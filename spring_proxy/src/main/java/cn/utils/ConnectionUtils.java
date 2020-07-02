package cn.utils;

import com.mchange.v2.c3p0.DataSources;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接的工具类 用于从数据源中获取一个连接，并实现和线程的绑定
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new InheritableThreadLocal<Connection>();

    @Autowired
    private DataSource dataSource = null;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     */
    public Connection getThreadConnection() {
        try {
            //1.先从ThreadLocal上获取
            Connection conn = tl.get();
            //2.判断当前线程上是否有连接
            if (conn == null) {
                //3.从数据源中获取一个连接，并且存入ThreadLocal中
                conn = dataSource.getConnection();
            }
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //让连接和线程解绑
    public void removeConnection(){
        tl.remove();
    }
}