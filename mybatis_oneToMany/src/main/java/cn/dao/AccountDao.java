package cn.dao;

import cn.domain.Account;
import cn.domain.AccountUser;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有用户账户
     * @return
     */
    List<AccountUser> findAllAccount();
}
