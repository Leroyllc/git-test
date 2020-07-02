package cn.service;

import cn.domain.Account;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountService {

    /**
     * 查询所有
     * @return
     */
    public List<Account> findAll();

    /**
     * 保存账户信息
     * @param account
     */
    public void saveAccount(Account account);
}
