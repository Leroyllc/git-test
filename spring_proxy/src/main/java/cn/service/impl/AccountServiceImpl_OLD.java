package cn.service.impl;

import cn.dao.AccountDao;
import cn.domain.Account;
import cn.service.AccountService;
import cn.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户的业务层实现类
 */

public class AccountServiceImpl_OLD implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private TransactionManager tm;


    public void setTm(TransactionManager tm) {
        this.tm = tm;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
        try {
            //1.开启事务
            tm.beginTransaction();
            //2.执行事务
            List<Account> accounts = accountDao.findAll();
            //3.提交事务
            tm.commitTransaction();
            //4.返回结果
            return accounts;
        } catch (Exception e) {
            //5.回滚事务
            tm.rollbackTransaction();
            throw new RuntimeException(e);
        } finally {
            //6.释放连接
            tm.releaseTransaction();
        }
    }

    public Account findById(int id) {
        try {
            //1.开启事务
            tm.beginTransaction();
            //2.执行事务
            Account account = accountDao.findById(id);
            //3.提交事务
            tm.commitTransaction();
            //4.返回结果
            return account;

        } catch (Exception e) {
            //5.回滚事务
            tm.rollbackTransaction();
            throw new RuntimeException(e);
        } finally {
            //6.释放连接
            tm.releaseTransaction();
        }
    }

    public void addAccount(Account account) {
        try {
            //1.开启事务
            tm.beginTransaction();
            //2.执行事务
            accountDao.addAccount(account);
            //3.提交事务
            tm.commitTransaction();
        } catch (Exception e) {
            //4.回滚事务
            tm.rollbackTransaction();
            throw new RuntimeException(e);
        } finally {
            //5.释放连接
            tm.releaseTransaction();
        }
    }

    public void updateAccount(Account account) {
        try {
            //1.开启事务
            tm.beginTransaction();
            //2.执行事务
            accountDao.updateAccount(account);
            //3.提交事务
            tm.commitTransaction();
        } catch (Exception e) {
            //4.回滚事务
            tm.rollbackTransaction();
            throw new RuntimeException(e);
        } finally {
            //5.释放连接
            tm.releaseTransaction();
        }
    }

    public void deleteAccount(int id) {
        try {
            //1.开启事务
            tm.beginTransaction();
            //2.执行事务
            accountDao.deleteAccount(id);
            //3.提交事务
            tm.commitTransaction();
        } catch (Exception e) {
            //4.回滚事务
            tm.rollbackTransaction();
            throw new RuntimeException(e);
        } finally {
            //5.释放连接
            tm.releaseTransaction();
        }
    }

    /**
     * 转账
     *
     * @param sourceName
     * @param targetName
     * @param money
     */
    public void transfer(String sourceName, String targetName, Float money) {
        try{
            tm.beginTransaction();
            Account source = accountDao.findAccountByName(sourceName);
            Account target = accountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney() - money);
            target.setMoney(target.getMoney() + money);
            accountDao.updateAccount(source);

            accountDao.updateAccount(target);
            tm.commitTransaction();
        }catch (Exception e) {
            tm.rollbackTransaction();
            e.printStackTrace();
            System.out.println("事务已回滚");
        }finally {
            tm.releaseTransaction();
        }
    }
}
