package cn.factory;

import cn.service.AccountService;
import cn.service.impl.AccountServiceImpl;

public class InstanceFactory {
    public AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
