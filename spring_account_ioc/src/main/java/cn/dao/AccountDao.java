package cn.dao;

import cn.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface AccountDao{
    /**
     * 查询所有
     * @return
     */
    public List<Account> findAll();

    /**
     * 查询一个
     * @param id
     * @return
     */
    public Account findById(int id);

    /**
     * 添加
     * @param account
     */
    public void addAccount(Account account);

    /**
     * 更新
     * @param account
     */
    public void updateAccount(Account account);

    /**
     * 删除
     * @param id
     */
    public void deleteAccount(int id);
}
