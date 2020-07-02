package cn.utils;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

/**
 * 和事务管理相关的工具类，它包含了开启事务，提交事务，回滚事务和释放事务
 */
public class TransactionManager {
    @Autowired
    private ConnectionUtils cu;

    public void setCu(ConnectionUtils cu) {
        this.cu = cu;
    }

    /**
     *  开启事务
     */
    public void beginTransaction(){
        try {
            cu.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *  提交
     */
    public void commitTransaction(){
        try {
            cu.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚
     */
    public void rollbackTransaction(){
        try {
            cu.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放
     */
    public void releaseTransaction(){
        try {
            cu.getThreadConnection().close();
            cu.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
