package cn.service;

import cn.domain.Account;

/**
 * 账户的业务层接口
 */
public interface AccountService {
    /**
     * 根据ID查询账户信息
     * @param id
     * @return
     */
    Account findAccountById(int id);

    /**
     * 转账
     * @param sourceName    转出账户名称
     * @param targetName    转入名称
     * @param money         金额
     */
    void transfer(String sourceName, String targetName, float money);
}
