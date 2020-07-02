package cn.dao;

import cn.domain.Account;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();

    /**
     * 根据用户id查询账户
     * @return
     */
    List<Account> findAccountById();
}
