package cn.dao.impl;

import cn.dao.AccountDao;
import cn.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements AccountDao {
    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public List<Account> findAll() {
        try {
            return runner.query("select * from Account", new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Account findById(int id) {
        try {
            return runner.query("select * from Account where id = ?",
                    new BeanHandler<Account>(Account.class), id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }


    public void addAccount(Account account) {
        try {
            runner.insert("insert into Account(name,money) values(?,?)",
                    new BeanHandler<Account>(Account.class), account.getName(), account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update("update Account set name = ?, money = ? where id = ?", account.getName(), account.getMoney(),account.getId());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void deleteAccount(int id) {
        try {
            runner.execute("delete from Account where id = ?",
                    new BeanHandler<Account>(Account.class), id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
