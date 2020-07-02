package cn.service;

import cn.dao.AccountDao;
import cn.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface AccountService {

    public List<Account> findAll();

    public Account findById(int id);

    public void addAccount(Account account);

    public void updateAccount(Account account);

    public void deleteAccount(int id);
}
