package cn.service.impl;

import cn.dao.AccountDao;
import cn.dao.impl.AccountImpl;
import cn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    public void saveAccount(){
        accountDao.saveAccount();
    }
}
