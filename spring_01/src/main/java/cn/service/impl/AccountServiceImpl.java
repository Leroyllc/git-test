package cn.service.impl;

import cn.dao.AccountDao;
import cn.dao.impl.AccountImpl;
import cn.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao = new AccountImpl();

    public void saveAccount(){
        accountDao.saveAccount();
    }
}
