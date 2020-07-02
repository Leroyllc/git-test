package cn.service;

import cn.dao.AccountDao;
import cn.domain.Account;
import org.springframework.stereotype.Service;

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

    public void transfer(String sourceName, String targetName, Float money);
}
